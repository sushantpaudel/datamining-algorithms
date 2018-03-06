package classification;

import models.DataModelXY;

public class NearestNeighbourAlgorithm {

    public static void main(String[] args) {
        int k = 10; // no Of nearest neighbour, can be changed
        DataModelXY inputData = new DataModelXY();
        inputData.setX(20);
        inputData.setY(30);
        DataModelXY[] dataSet = DataModelXY.generateDataSet();
        int length = dataSet.length;
        int[] distances = new int[length];
        for (int i = 0; i < length; i++) {
            distances[i] = DataModelXY.calculateDistance(dataSet[i], inputData);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (distances[i] < distances[j]) {
                    int temp = distances[j];
                    distances[j] = distances[i];
                    distances[i] = temp;
                    DataModelXY tempData = dataSet[j];
                    dataSet[j] = dataSet[i];
                    dataSet[i] = tempData;
                }
            }
        }
        System.out.println();
        System.out.println("Nearest neighbours are:: ");
        for (int i = 0; i < k; i++) {
            System.out.print("(" + dataSet[i].getX() + "," + dataSet[i].getY() + ")");
        }
    }
}
