package project7;

import java.util.TreeMap;

public class VMTranslator {

    public static void main(String [] args){

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Mapping string values to int keys
        // using put() method
        treeMap.put(25, "Welcomes");
        treeMap.put(20, "Geeks");
        treeMap.put(15, "4");
        treeMap.put(10, "Geeks");
        treeMap.put(30, "You");

        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + treeMap);
        System.out.println("TreeMap's first entry: " + treeMap.firstEntry().getValue());
    }

    public static int maxMirror(int[] nums) {
        int maxMirrorCount = 0;// 3
        // 1, 1, 1
        for(int i = 0; i < nums.length - 1; i++){
            int leftIndex = i;// 3
            int tempMaxSoFar = 0;// 3
            for(int rightIndex = nums.length - 1; rightIndex >= 0 && leftIndex < nums.length; rightIndex--){
                // rightIndex = -1
                if(nums[leftIndex] == nums[rightIndex]){// 1 == 1
                    leftIndex++;
                    tempMaxSoFar++;
                }else{
                    tempMaxSoFar = 0;//reset temp max
                }

                if (tempMaxSoFar > maxMirrorCount){// true
                    maxMirrorCount = tempMaxSoFar;
                }
            }

        }
        return maxMirrorCount;
    }

    public static int[] squareUp(int n) {
        int [] result = new int [n * n];
        int group = 1;
        int value = 1;

        for(int i = 0 ; i < n ; i += n){
            for(int j = (group * n) - 1; j >= i; j--){
                if(value <= group){
                    result[j] = value++;
                }else{
                    result[j] = 0;
                }
            }
            value = 1;
            group++;
        }
        return result;
    }

    public static String notReplace(String str) {
        StringBuilder strCollector = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            char nextCurrentChar = i + 1 < str.length() ? str.charAt(i + 1): Character.MIN_VALUE;
            if(("" + currentChar + nextCurrentChar).equals("is")){
                if(isValid(i, str)){
                    strCollector.append("is not");
                    i++;
                }else{
                    strCollector.append(currentChar + "");
                }
            }else{
                strCollector.append(currentChar + "");
            }
        }
        return strCollector.toString();
    }

    public static  boolean isValid(int i, String str){
        // left side is valid if i is at the beginning of the str, meaning there are no characters preceding the "is"
        // string so left side is valid by deafult, if i is greater than 0 then that means that there is a character before the "is"
        // string so we need to check that it is not a letter for this left side to be valid.
        boolean leftSideValid = (i == 0 || (i > 0 && !Character.isLetter(str.charAt(i - 1))));
        // right side is valid if the last index of the "is" string is at the end of the string meaning there are no more characters
        // after i + 1 then the right side of the "is" substring is valid. Other-wise if there are more characters to the right of the "is" string
        // we need to check that it is not a letter.
        boolean rightSideValid = (i + 1 == str.length() - 1 || (i + 1 < str.length() - 1) && !Character.isLetter(str.charAt(i + 2)));
        return leftSideValid && rightSideValid;
    }

    public static void xMethod(int n) {
        if (n > 0) {
            xMethod(n - 1);
            System.out.print(n + " ");
        }
    }

    public static String reverse(String source){
        if(source.length() == 1 || source.isEmpty()){
            return source;
        }
        return reverse(source.substring(1)) + source.charAt(0); // keep concatening the left most char to the previous call's return string
    }


    /**
     * square(6) -> 2 * 32 = return 64 as final result!
     *  square(5) -> 2 * 16 = return 32
     *   square(4) -> 2 * 8 = return 16
     *    square(3) -> 2 * 4 = return 8
     *     square(2) -> 2 * 2 = return 4
     *      square(1) -> 2 * 1 = return 2
     *       square(0) -> return 1
     */
}
