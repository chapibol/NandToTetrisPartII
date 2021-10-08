package coursera.algorithms.week2;


public class NumberOfInversionsProblem {

    public static void main(String [] args ){

        int [] numbers = {6,5,4, 3, 2, 1 }; // number of inversions here is (2, 1), (3, 1) answer should be 2 3 + 2

        System.out.println("Number of Inversions: " + sortAndCount(numbers));


    }

    /**
     * [6], [5], [4], [3], [2], [1]
     *  0    1    2    3    4    5
     * Method that will return the number of inversions in an array numbers
     * @param a the array to search the inversions in
     * @return number of inversions
     */
    public static int sortAndCount(int [] a){
        return sortAndCount(a, 0, new int[a.length], 0, a.length - 1);
    }

    public static int sortAndCount(int [] a, int n, int [] temp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd){ // n == 1 &&
            return 0;
        }else{
            int middle = (leftStart + rightEnd) / 2;

            n += sortAndCount(a, n, temp, leftStart, middle);
            n += sortAndCount(a, n, temp,  middle + 1, rightEnd);

           return mergeAndCountSplitInversions(a, n, temp, leftStart, rightEnd);
        }
    }

    public static int mergeAndCountSplitInversions(int [] a, int n, int [] temp, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int leftIndex = leftStart;
        int rightIndex = rightStart;

        int size = rightEnd - leftStart + 1;

        for(int k = leftStart; k < rightEnd; k++){
            if(rightIndex > rightEnd){ // if right is exhausted then just copy over remaining elements from left
                if(leftIndex <= leftEnd){
                    temp[k]  = a[leftIndex++];
                }
            }else if(leftIndex <= leftEnd){
                if(a[leftIndex] <= a[rightIndex]){
                    temp[k] = a[leftIndex++];
                }else{
                    n += (leftEnd - leftIndex) + 1; // add up the remaining elements in first half of the array as those are inversions.
                    temp[k] = a[rightIndex++];
                }
            }
        }
        System.arraycopy(temp, leftStart, a, leftStart, size);

        return n;
    }

    /**
     *
     * [2], [1], [4]
     *  0    1    2
     * 3rd recursive call leftStart = 0   rightEnd = 1
     *
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

        int middle = (leftStart + rightEnd) / 2; // middle
        mergeSort(array, temp, leftStart, middle); // left half
        mergeSort(array, temp, middle + 1, rightEnd); // right half
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    public static void mergeHalves(int [] array, int [] temp, int leftStart, int rightEnd){
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;// incrementing because we are representing the size not the pointers

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            }else{ // this would expose an inversion btws
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);// copying over the remaining elements from the left half
        System.arraycopy(array, right, temp, index, rightEnd  - right + 1);
        System.arraycopy(temp , leftStart, array, leftStart, size);
    }






}
