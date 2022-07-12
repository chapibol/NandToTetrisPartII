package project7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VMTranslator {

    public static void main(String [] args){
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        String [] reqs = new String [] {"gym", "pool", "school", "store"};
        Map<String, Boolean> block0 = new HashMap<>();
        block0.put("gym", true);
        block0.put("pool", false);
        block0.put("school", true);
        block0.put("store", false);

        Map<String, Boolean> block1 = new HashMap<>();
        block1.put("gym", false);
        block1.put("pool", false);
        block1.put("school", false);
        block1.put("store", false);

        Map<String, Boolean> block2 = new HashMap<>();
        block2.put("gym", false);
        block2.put("pool", false);
        block2.put("school", true);
        block2.put("store", false);

        Map<String, Boolean> block3 = new HashMap<>();
        block3.put("gym", false);
        block3.put("pool", false);
        block3.put("school", false);
        block3.put("store", false);

        Map<String, Boolean> block4 = new HashMap<>();
        block4.put("gym", false);
        block4.put("pool", false);
        block4.put("school", false);
        block4.put("store", true);

        Map<String, Boolean> block5 = new HashMap<>();
        block5.put("gym", true);
        block5.put("pool", false);
        block5.put("school", false);
        block5.put("store", false);

        Map<String, Boolean> block6 = new HashMap<>();
        block6.put("gym", false);
        block6.put("pool", false);
        block6.put("school", false);
        block6.put("store", false);

        Map<String, Boolean> block7 = new HashMap<>();
        block7.put("gym", false);
        block7.put("pool", false);
        block7.put("school", false);
        block7.put("store", false);

        Map<String, Boolean> block8 = new HashMap<>();
        block8.put("gym", false);
        block8.put("pool", false);
        block8.put("school", false);
        block8.put("store", false);

        Map<String, Boolean> block9 = new HashMap<>();
        block9.put("gym", false);
        block9.put("pool", false);
        block9.put("school", true);
        block9.put("store", false);

        Map<String, Boolean> block10 = new HashMap<>();
        block10.put("gym", false);
        block10.put("pool", true);
        block10.put("school", false);
        block10.put("store", false);

        blocks.add(0, block0);
        blocks.add(1, block1);
        blocks.add(2, block2);
        blocks.add(3, block3);
        blocks.add(4, block4);
        blocks.add(5, block5);
        blocks.add(6, block6);
        blocks.add(7, block7);
        blocks.add(8, block8);
        blocks.add(9, block9);
        blocks.add(10, block10);

        int [] primitiveIntArray = new int [blocks.size()];
        Map<String, int []> mindDistancesToRes = new HashMap<>();

        Stream.of(reqs).forEach(req -> {
            int [] minDistances = mapToIntArray(req, 2);
            mindDistancesToRes.put(req, minDistances);
        });

        List<int []> minDistances = mindDistancesToRes.values().stream().collect(Collectors.toList());

        System.out.println("mindDistancesToRes: " );
        minDistances.forEach(distanceArray -> System.out.println(Arrays.toString(distanceArray)));

        System.out.println("primitiveIntArray is: " + Arrays.toString(primitiveIntArray));
        System.out.println("Most efficient block is block: " + apartmentHunting(blocks, reqs));
    }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int [] maxDistanceAtBlocks = new int [blocks.size()];
        Arrays.fill(maxDistanceAtBlocks, Integer.MIN_VALUE);

        for (int i = 0; i < blocks.size(); i++){
            for(String req: reqs){
                int closestReqDistance = Integer.MAX_VALUE;
                for(int j = 0 ; j < blocks.size(); j++){
                    if(blocks.get(j).get(req)){
                        closestReqDistance = Math.min(closestReqDistance, distanceBetween(i, j));
                    }
                }
                maxDistanceAtBlocks[i] = Math.max(maxDistanceAtBlocks[i], closestReqDistance);
            }
        }
        return findMinIndex(maxDistanceAtBlocks);
    }

    public static int [] mapToIntArray(String req, int b){
        return new int [] {b};
    }
    public static int distanceBetween(int a, int b){
        return Math.abs(a - b);
    }

    public static int findMinIndex(int [] array){
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] < minValue){
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
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
