package clustering;

import models.DataModel;

import static models.DataModel.generateDataSet;

public class DBSCANAlgorithm {

    private static final int MIN_PTS = 5;
    private static final int EPS = 1;

    public static void main(String[] args) {
        DataModel[] dataSet = generateDataSet();

    }

}
