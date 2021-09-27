package coursera.algorithms.week1;

import java.math.BigInteger;

public class KaratsubaMultiplication {

    public static void main(String[] args){

        BigInteger x = new BigInteger("134");
        BigInteger y = new BigInteger("4");

        System.out.println("Java's BigInteger Multiplication product: "  + x.multiply(y));

        System.out.println("My multiplication product: " + multiply(x, y));
    }


    /**
     * 134 * 46, not working correctly
     * @param x
     * @param y
     * @return
     */
    public static BigInteger multiply(BigInteger x, BigInteger y){
        String xStr = x.toString();
        String yStr = y.toString();
        int n = Math.max(xStr.length(), yStr.length());

        if(xStr.length() < yStr.length()){ // making sure the smaller digit number gets padded with preceding 0s
            xStr = String.format("%0" + n + "d", x);
        }
        if(yStr.length() < xStr.length()){
            yStr = String.format("%0" + n + "d", y); // making sure the smaller digit number gets padded with preceding 0s
        }

        if(n == 1){
            return x.multiply(y);
        }

        int middleIndex = getMiddleIndex(n);
        BigInteger a = new BigInteger(xStr.substring(0, middleIndex)); // get first half of x
        BigInteger b = new BigInteger(xStr.substring(middleIndex)); // get second half of x
        BigInteger c = new BigInteger(yStr.substring(0, middleIndex)); // get the first half of y
        BigInteger d = new BigInteger(yStr.substring(middleIndex)); // get the second half of y

        BigInteger acResult = multiply(a, c);
        BigInteger bdResult = multiply(b, d);
        BigInteger aPlusBTimesCPlusD = multiply(a.add(b) , c.add(d));
        BigInteger adPlusBcByGaussTrick = aPlusBTimesCPlusD.subtract(acResult).subtract(bdResult);


        // Since the a and b parts of the number str are being given more digits when splitting an odd number of digits number we need to shift acResult by 10 ^ n -1
        BigInteger acShifted = acResult.multiply(tenRaisedTo(n % 2 == 0 ? n : n - 1));
        BigInteger gaussTrickShifted = adPlusBcByGaussTrick.multiply(tenRaisedTo(n / 2));

        return acShifted.add(gaussTrickShifted).add(bdResult);
    }

    private static BigInteger tenRaisedTo(int exponent){
        return new BigInteger("10").pow(exponent);
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