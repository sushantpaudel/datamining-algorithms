package classification;

public class NearestNeighbourAlgorithm {

    public static void main(String[] args) {
        int k = 20; // no Of nearest neighbour, can be changed
        int inputData = 5;
        int[] dataSet = {1, 2, 5, 6, 2, 4, 1, 5, 8, 12, 5, 4, 5, 6, 3, 32, 65, 1, 2, 15, 12, 11, 5, 12, 12, 15, 20, 213, 13, 51, 3, 213, 1, 1320, 51, 1};
        int length = dataSet.length;
        int[] distances = new int[length];
        for (int i = 0; i < length; i++) {
            distances[i] = Math.abs(dataSet[i] - inputData);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (distances[i] < distances[j]) {
                    int temp = distances[j];
                    distances[j] = distances[i];
                    distances[i] = temp;
                    temp = dataSet[j];
                    dataSet[j] = dataSet[i];
                    dataSet[i] = temp;

                }
            }
        }
        System.out.println("Nearest neighbours are:: ");
        for (int i = 0; i < k; i++) {
            System.out.print(dataSet[i] + " ");
        }
    }
}
