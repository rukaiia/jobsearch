public class Task2 {
    public static void main(String[] args) {
        System.out.println("Привет, я Java. А ты?");
        System.out.print("А я ");
        String name = System.console().readLine();
        System.out.println("Привет, " + name + " " + "сколько вам лет?");
        System.out.print(" мне ");
        String age = System.console().readLine();
        System.out.println("круто," + " В каком городе вы живете живете?");
        System.out.print("я живу ");
        String place = System.console().readLine();


    }

}
