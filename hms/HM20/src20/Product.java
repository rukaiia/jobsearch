import java.time.LocalDate;
import java.util.Random;

abstract class Product {
    private String name;
    private LocalDate producedOn;
    private LocalDate expiryDate;

    public Product(String name, int shelfLife) {
        this.name = name;
        int daysAgo = new Random().nextInt(200) + 1;
        this.producedOn = LocalDate.now().minusDays(daysAgo);
        this.expiryDate = this.producedOn.plusDays(shelfLife);
    }

    public boolean isFresh() {
        return LocalDate.now().isBefore(expiryDate);
    }

    public String getName() {
        return name;
    }

    public LocalDate getProducedOn() {
        return producedOn;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
