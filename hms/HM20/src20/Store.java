import java.util.Random;

class Store {
    private Product[] products = new Product[20];

    public void fillStore() {
        Random random = new Random();
        for (int i = 0; i < products.length; i++) {
            int randomProduct = random.nextInt(5);
            switch (randomProduct) {
                case 0:
                    products[i] = new Milk();
                    break;
                case 1:
                    products[i] = new Salt();
                    break;
                case 2:
                    products[i] = new Fish();
                    break;
                case 3:
                    products[i] = new Corn();
                    break;
                case 4:
                    products[i] = new Stew();
                    break;
            }
        }
    }

    public void placeProduct(Product product) {
        Random random = new Random();
        boolean inIcebox = random.nextBoolean();
        if (inIcebox) {
            System.out.print("Icebox");
        } else {
            System.out.print("Showcase");
        }
    }

    public void doIns() {
        System.out.println("Product\t\tStorage place\tS. life days\tProduced on\t\tFresh");
        System.out.println("------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.printf("%-10s", product.getName());
            placeProduct(product);

            System.out.printf("\t\t\t\t%-13s\t\t%-13s\t\t%s%n", product.getExpiryDate().toEpochDay() - product.getProducedOn().toEpochDay(), product.getProducedOn(), product.isFresh());
        }
    }
}