package coursera.algorithms.week2;

public class NumberOfInversionsProblem {

    public static void main(String [] args ){

        int [] numbers = {2, 1, 4, 3, 10, 0};

        mergeSort(numbers);

    }

    /**
     *
     * [2], [1], [4], [3], [10], [0]
     *
     * leftStart = 0   rightEnd = 3
     *
     * middle = 1
     *
     */

    public static void mergeSort(int [] array){
        mergeSort(array, new int [array.length] ,0, array.length - 1);
    }

    public static void mergeSort(int [] array, int [] temp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd)
            return;

        int middle = (leftStart + rightEnd) / 2; //
        mergeSort(array, temp, leftStart, middle); // left half
        mergeSort(array, temp, middle + 1, rightEnd); // right half
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    public static void mergeHalves(int [] array, int [] temp, int leftStart, int rightEnd){
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            }else{
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd  - right + 1);
        System.arraycopy(temp ,leftStart, array, leftStart, size);
    }



    /**
     * Method that will return the number of inversions in an array numbers
     * @param a the array to search the inversions in
     * @param n the length of this array
     * @return number of inversions
     */
    public static int sortAndCount(int [] a, int n){
        if(n == 1){
            return 0;
        }else{
            int x = 0; // number of inversions in first half
            int y = 0; // number of inversions in second half
            int [] b = new int[n/2];
            int [] c = new int[n/2];
            return 1;
        }
    }


}
