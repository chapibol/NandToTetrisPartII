package coursera.algorithms.week1;

public class KaratsubaMultiplication {

    public static void main(String[] args){

        long x = 245524552455L;
        long y = 245524552455L;
        System.out.println("Java's Multiplication product: "  + (x * y));
        System.out.println("My multiplication product: " + multiply(x, y));
    }


    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static long multiply(long x, long y){
        String xStr = x + "";
        String yStr = y + "";
        int n = Math.max(xStr.length(), yStr.length());

        if(xStr.length() < yStr.length()){ // making sure the smaller digit number gets padded with preceding 0s
            xStr = String.format("%0" + n + "d", x);
        }
        if(yStr.length() < xStr.length()){
            yStr = String.format("%0" + n + "d", y); // making sure the smaller digit number gets padded with preceding 0s
        }

        if(n == 1){
            return x * y;
        }

        int middleX = getMiddleIndex(n);
        long a = Long.parseLong(xStr.substring(0, middleX)); // get first half of x
        long b = Long.parseLong(xStr.substring(middleX)); // get second half of x
        long c = Long.parseLong(yStr.substring(0, middleX)); // get the first half of y
        long d = Long.parseLong(yStr.substring(middleX)); // get the second half of y

        long acResult = multiply(a, c);
        long bcResult = multiply(b, d);
        long aPlusBTimesCPlusD = multiply(a + b, c + d);
        long adPlusBcByGaussTrick = (aPlusBTimesCPlusD - acResult) - bcResult;

        return (long)(Math.pow(10, n) * acResult + Math.pow(10, n / 2) * adPlusBcByGaussTrick + bcResult);
    }

    /**
     * Gets the middle index if n is even, splits the digits in half + 1 for the first half.
     * @param n the number of digits
     * @return int
     */
    private static int getMiddleIndex(int n){
        return n % 2 == 0 ? n / 2 : (n / 2) + 1;
    }

}