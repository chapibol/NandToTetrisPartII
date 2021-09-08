package kindle.exercises;

public class RecursionChapter {

    public static void main (String [] args){
        int base = 3;
        int power = 10;
        System.out.println(base + " to the " + power + " power: " + powerOf(12, base));
        System.out.println("Sum of : " + nSum(21));
    }


    /**
     * 18.6
     * n = 5
     * nSum(5)--> returns 5 + 10 = 15
     *      nSum(4)--> returns 4 + 6 = 10
     *           nSum(3)--> returns 3 + 3 = 6
     *                 nSum(2)--> returns 2 + 1 = 3
     *                      nSum(1)--> returns 1
     */
    public static int nSum(int n){
        if(n == 1) return 1;
        return n + nSum(n - 1);
    }

    /**
     * 18.4 and 18.5 exercises
     *
     * n = 3
     *
     * method(3)-->  returns 2 * 4 = 8
     *        method(2)--> returns 2 * 2 = 4
     *                 method(1)-->   returns 2 * 1 = 2
     *                         method(0)-->  returns 1
     */
    public static int powerOf(int n, int base){
        if(n == 0) return 1;
        return base * powerOf(n - 1, base);
    }

    public static int xMethod(int n){
        if(n == 1)
            return 1;
        else
            return n + xMethod(n - 1);
    }

    /**
     * This method reverses an initial integer. ex. 1234567 will be printed as 7654321
     * @param n
     */
    public static void xMethod2(int n) {
        if (n > 0) {
            System.out.print(n % 10);
            xMethod2(n / 10);
        }
    }
}