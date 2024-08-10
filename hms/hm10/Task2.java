public class Task2 {
    public static void main(String[] args) {
        // задание: 2

        int a = 3;
       intresult3 = 2 * a;
        System.out.println("Example1: " + result3);

        // ------------------------------

        // a = x
        double result4 = Math.sin(Math.toRadians(a) * a);
        System.out.println("Example2: " + result4);

        // ------------------------------------------

        double result5 = Math.pow(a, 2);
        System.out.println("Example3: " + result5);

        // ------------------------------

        double result6 = Math.sqrt(a);
        System.out.println("Example4: " + result6);
        // ----------------------------------------

        int n = -2;

        double result7 = Math.abs(n);
        System.out.println("Example5: " + result7);
        // ----------------------------------------

        // a = y
        double result8 = 5 * Math.cos(Math.toDegrees(a)) * a;
        System.out.println("Example6: " + result8);
        // ----------------------------------------------------

        double result9 = -7.5 * Math.pow(a, 2);
        System.out.println("Example7: " + result9);
        // ---------------------------------------------------

        // a = x

        double result10 = 3 * Math.sqrt(a);
        System.out.println("Example8: " + result10);
        // ---------------------------------------------------

        int c = 2;
        int b = 3;

        double result11 = Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(b))
                + Math.cos(Math.toRadians(c)) * Math.sin(Math.toRadians(b));
        System.out.println("Example9: " + result11);

        // ---------------------------------------------------

        double result12 = a * Math.sqrt(2 * b);
        System.out.println("Example10: " + result12);

        // ---------------------------------------------------
        int  alpha = a;
        int  betta = b;

        double result13 = 3 * Math.pow(Math.sin(Math.toRadians(a)), 2) * Math.pow(Math.cos(Math.toRadians(b)), 3);
        System.out.println("Example11: " + result13);

        // ---------------------------------------------------
        // a = x
        // b = y

        double result14 = -5 * Math.sqrt(a + Math.sqrt(b));
        System.out.println("Example12: " + result14);

        // ---------------------------------------------------

    }
    
}
