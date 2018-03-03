package clustering;

import java.util.ArrayList;
import java.util.HashMap;

public class KMeansAlgorithm {

    private static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    public static void main(String args[]) {
        int[] dataSet = {1, 2, 5, 6, 2, 4, 1, 5, 8, 12, 5, 4, 5, 6, 3, 32, 65, 1, 2, 15, 12, 11, 5, 12, 12, 15, 20, 213, 13, 51, 3, 213, 1, 1320, 51, 1};
        int k = 7; //Changeable value of number of clusters formed.
        int[] mean = new int[k];
        int[] beforeMean = new int[k];
        for (int i = 0; i < k; i++) {
            mean[i] = dataSet[i];
            beforeMean[i] = 0;
        }
        HashMap<Integer, ArrayList<Integer>> clusters = new HashMap<>();
        for (int i = 0; i < k; i++) {
            clusters.put(i, new ArrayList<>());
        }
        while (true) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (mean[i] != beforeMean[i]) {
                    count++;
                }
            }
            if (count == 0) {
                break;
            } else {
                for (int i = 0; i < k; i++) {
                    beforeMean[i] = mean[i];
                    clusters.get(i).clear();
                }
            }
            int[] difference = new int[k];
            for (int value : dataSet) {
                for (int i = 0; i < k; i++) {
                    difference[i] = Math.abs(mean[i] - value);
                }
                int index = getLeastDifference(difference);
                clusters.get(index).add(value);
            }
            for (int i = 0; i < k; i++) {
                ArrayList<Integer> insideCluster = clusters.get(i);
                try{
                    mean[i] = sum(insideCluster) / insideCluster.size();
                }catch (ArithmeticException e){
                    mean[i] = 0;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println("");
            System.out.println("Cluster " + i + ":");
            ArrayList<Integer> cluster = clusters.get(i);
            for (Integer integer : cluster) {
                System.out.print(" " + integer);
            }
        }
    }

    private static int getLeastDifference(int[] difference) {
        int index = 0;
        int size = difference.length;
        int least = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (difference[i] < least) {
                index = i;
                least = difference[i];
            }
        }
        return index;
    }
}
