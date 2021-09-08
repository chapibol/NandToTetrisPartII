package coursera.algorithms.week1;

public class KaratsubaMultiplication {

    public static void main(String[] args){
        String x = "123";
        String y = "204";

    }

    public static String multiply(String a, String b){
        if(a.length() == 1 && b.length() == 1)
            return "" + Integer.parseInt(a) * Integer.parseInt(b);

        return multiply(a.substring(0, a.length() / 2), b.substring(0, b.length() / 2));
    }

}