package classification;

import models.DataModelWeather;

import java.util.ArrayList;

public class BayesianAlgorithm {
    private static DataModelWeather[] dataSet = DataModelWeather.generateDataSet();
    private static ArrayList<Counter> countWeather = new ArrayList<>();
    private static ArrayList<Counter> countPlay = new ArrayList<>();
    private static ArrayList<CounterPair> counterPairs = new ArrayList<>();

    public static void main(String[] args) {
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
        checkDataCount();       //Output likelihood table
        //Data testing check
        DataModelWeather testDataOne = new DataModelWeather();
        testDataOne.setPlay("No");
        testDataOne.setWeather("Rainy");
        float probability = getProbabilityOfData(testDataOne, countWeather, countPlay, counterPairs);
        System.out.println("\n\nProbability of Test Data (" + testDataOne.getPlay() + "," + testDataOne.getWeather() + ") : " + probability);
    }

    private static void checkDataCount() {
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

    private static float getProbabilityOfData(DataModelWeather testData, ArrayList<Counter> countWeather, ArrayList<Counter> countPlay, ArrayList<CounterPair> counterPairs) {
        float k1;
        float k2;
        float k3;
        float pairCount = 0f;
        float playCount = 0f;
        float weatherCount = 0f;
        float totalCount = dataSet.length;
        for (CounterPair c : counterPairs) {
            if (c.play.equals(testData.getPlay()) && c.weather.equals(testData.getWeather())) {
                pairCount = c.count;
                break;
            }
        }
        for (Counter c : countPlay) {
            if (c.tag.equals(testData.getPlay())) {
                playCount = c.count;
                break;
            }
        }
        for (Counter c : countWeather) {
            if (c.tag.equals(testData.getWeather())) {
                weatherCount = c.count;
                break;
            }
        }
        k1 = pairCount / playCount;           //Calculating probability P(Weather/Play)
        k2 = playCount / totalCount;          //Calculating probability P(play)
        k3 = weatherCount / totalCount;       //Calculating probability P(weather)
        return k1 * k2 / k3;                //Using Bayesian formula for P(Play/Weather)

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
