package models;

public class DataModel {
    private int x;
    private int y;
    public boolean isVisited;
    public boolean isIncluded;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static DataModel[] generateDataSet() {
        DataModel[] dataSet = new DataModel[100];
        int[] data = {48, 15, 54, 60, 50, 15, 82, 78, 31, 11, 69, 53, 86, 32, 97, 60, 95, 0, 32, 35, 11, 98, 47, 89, 85, 46, 79, 78, 80, 62, 45, 60, 61, 40, 36, 29, 64, 2, 99, 85, 87, 19, 79, 68, 88, 48, 8, 44, 36, 92, 50, 38, 62, 13, 98, 32, 78, 21, 26, 78, 31, 38, 54, 48, 2, 68, 82, 59, 6, 34, 32, 95, 42, 70, 79, 52, 9, 61, 98, 51, 33, 71, 36, 30, 67, 14, 16, 45, 35, 90, 59, 9, 51, 11, 9, 34, 27, 42, 65, 2, 12, 56, 18, 38, 48, 94, 67, 28, 22, 68, 46, 30, 79, 77, 42, 86, 79, 90, 32, 13, 48, 20, 14, 45, 41, 84, 65, 25, 33, 29, 84, 51, 11, 37, 27, 23, 37, 34, 17, 19, 46, 81, 29, 76, 81, 83, 84, 58, 15, 28, 18, 95, 17, 62, 56, 15, 55, 22, 89, 81, 5, 6, 28, 47, 73, 47, 65, 14, 66, 81, 3, 84, 28, 82, 84, 44, 34, 44, 60, 13, 57, 38, 56, 26, 45, 49, 38, 86, 88, 96, 20, 31, 93, 99, 29, 72, 92, 85, 59, 16};
        int j = 0;
        System.out.println("Data added:");
        for (int i = 0; i < 100; i++) {
            DataModel model = new DataModel();
            model.setX(data[j]);
            j++;
            model.setY(data[j]);
            dataSet[i] = model;
            System.out.print("(" + dataSet[i].getX() + "," + dataSet[i].getY() + ")");
        }
        System.out.println("");
        return dataSet;
    }

    public static int calculateDistance(DataModel modelOne, DataModel modelTwo) {
        int x = modelOne.getX() - modelTwo.getX();
        int y = modelOne.getY() - modelTwo.getY();
        float finalValue = (float) Math.pow(x * x + y * y, 0.5);
        return (int) finalValue;
    }

}
