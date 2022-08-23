package algoexpert.arrays;

public class WaterfallStream {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public double[] waterfallStreams(double[][] array, int source) {
        double[] rowAbove = array[0].clone();
        rowAbove[source] = -1;

        for (int row = 1; row < array.length; row++) {// i = row mistake. I was checking against the column length instead of rows
            double[] currentRow = array[row].clone();

            for (int col = 0; col < rowAbove.length; col++) { // j = column
                double valueAbove = rowAbove[col];

                boolean hasWaterAbove = valueAbove < 0;
                boolean hasBlock = currentRow[col] == 1.0;

                if (!hasWaterAbove) continue;

                if (!hasBlock) {
                    currentRow[col] += valueAbove;
                    continue;
                }

                double splitWater = valueAbove / 2;

                // iterate left to flow water into currentRow
                int left = col;
                while (left - 1 >= 0) { // flow water to the left
                    left--;
                    if (rowAbove[left] == 1.0) {
                        break;
                    }

                    if (currentRow[left] != 1.0) {
                        currentRow[left] += splitWater;
                        break;
                    }
                }
                // flow water to the right
                int right = col;
                while (right + 1 < rowAbove.length) { // do the plus one check to not go here if we are past the wall
                    right++;
                    if (rowAbove[right] == 1.0) { // if there is wall on the right so water can't flow no more
                        break;
                    }
                    if (currentRow[right] != 1.0) {
                        currentRow[right] += splitWater;
                        break;
                    }
                }
            }
            rowAbove = currentRow;
        }

        double[] result = new double[rowAbove.length];
        for (int i = 0; i < rowAbove.length; i++) {
            result[i] = toPercentage(rowAbove[i]);
        }

        return result;
    }

    public static double toPercentage(double num) {
        if (num == 0) {
            return num;
        } else {
            return num * (-100);
        }
    }
}