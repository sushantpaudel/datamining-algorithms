package classification;

import models.DataModelWeather;

import java.util.ArrayList;

public class BayesianAlgorithm {
    private static DataModelWeather[] dataSet = DataModelWeather.generateDataSet();

    public static void main(String[] args) {
        ArrayList<Integer> counter = new ArrayList<>();
        ArrayList<String> dataWeather = new ArrayList<>();
        ArrayList<String> dataPlay = new ArrayList<>();
        int countDataWeather = 0;
        int countPlay = 0;
        for (DataModelWeather dataModelWeather : dataSet) {
            int countP;
            for (int i = 0; i < countDataWeather; i++) {
                if (dataModelWeather.getWeather().equals(dataWeather.get(i))) {

                }
            }
        }
    }
}
