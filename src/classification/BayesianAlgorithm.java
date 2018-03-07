package classification;

import models.DataModelWeather;

import java.util.ArrayList;

public class BayesianAlgorithm {
    private static DataModelWeather[] dataSet = DataModelWeather.generateDataSet();

    public static void main(String[] args) {
        ArrayList<Counter> countWeather = new ArrayList<>();
        ArrayList<Counter> countPlay = new ArrayList<>();
        ArrayList<CounterPair> counterPairs = new ArrayList<>();
        for (DataModelWeather dataModel : dataSet) {
            //start counting weather
            int count = 0;
            for (Counter c : countWeather) {
                if (dataModel.getWeather().equals(c.tag)) {
                    c.count++;
                } else {
                    count++;
                }
            }
            if (count != countWeather.size() - 1) {
                Counter c = new Counter();
                c.tag = dataModel.getWeather();
                c.count = 1;
                countWeather.add(c);
            }
            //start counting play
            count = 0;
            for (Counter c : countPlay) {
                if (dataModel.getPlay().equals(c.tag)) {
                    c.count++;
                } else {
                    count++;
                }
            }
            if (count != countPlay.size() - 1) {
                Counter c = new Counter();
                c.tag = dataModel.getPlay();
                c.count = 1;
                countPlay.add(c);
            }

            //start counting pairs
            count = 0;
            for (CounterPair c : counterPairs) {
                if (dataModel.getPlay().equals(c.play) && dataModel.getWeather().equals(c.weather)) {
                    c.count++;
                } else {
                    count++;
                }
            }
            if (count != counterPairs.size() - 1) {
                CounterPair c = new CounterPair();
                c.weather = dataModel.getWeather();
                c.play = dataModel.getPlay();
                c.count = 1;
                counterPairs.add(c);
            }
        }
        System.out.println("Weather");
        for (Counter c : countWeather) {
            System.out.println(c.tag + " --> " + c.count);
        }
        System.out.println("");
        System.out.println("Play");
        for (Counter c : countPlay) {
            System.out.println(c.tag + " --> " + c.count);
        }
        System.out.println("");
        System.out.println("Pairs");
        for (CounterPair c : counterPairs) {
            System.out.println("(" + c.weather + "," + c.play + ") ---> " + c.count);
        }
    }

    static class Counter {
        String tag;
        int count;
    }

    static class CounterPair {
        String weather;
        String play;
        int count;
    }
}
