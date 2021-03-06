package models;

public class DataModelWeather {
    private String weather;
    private String play;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public static DataModelWeather[] generateDataSet() {
        String[] WEATHER = {"Rainy", "Sunny", "Overcast", "Overcast", "Sunny", "Rainy", "Sunny", "Sunny", "Overcast", "Overcast", "Overcast", "Overcast", "Rainy", "Overcast", "Sunny", "Overcast", "Sunny", "Sunny", "Sunny", "Rainy", "Sunny", "Sunny", "Rainy", "Sunny", "Sunny", "Overcast", "Sunny", "Rainy", "Sunny", "Sunny", "Overcast", "Sunny", "Sunny", "Rainy", "Sunny", "Overcast", "Sunny", "Sunny", "Sunny", "Overcast", "Sunny", "Overcast", "Sunny", "Sunny", "Rainy", "Rainy", "Sunny", "Sunny", "Rainy", "Rainy", "Overcast", "Overcast", "Overcast", "Overcast", "Overcast", "Sunny", "Rainy", "Overcast", "Rainy", "Sunny", "Sunny", "Rainy", "Overcast", "Sunny", "Sunny", "Rainy", "Rainy", "Sunny", "Rainy", "Sunny", "Rainy", "Overcast", "Sunny", "Sunny", "Rainy", "Sunny", "Rainy", "Sunny", "Overcast", "Sunny", "Overcast", "Sunny", "Rainy", "Overcast", "Sunny", "Overcast", "Sunny", "Rainy", "Sunny", "Rainy", "Overcast", "Overcast", "Overcast", "Overcast", "Rainy", "Overcast", "Overcast", "Sunny", "Sunny", "Sunny"};
        String[] PLAY = {"No", "No", "No", "Yes", "No", "No", "Yes", "Yes", "No", "Yes", "Yes", "Yes", "Yes", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No", "Yes", "No", "Yes", "Yes", "No", "No", "Yes", "Yes", "Yes", "No", "Yes", "Yes", "No", "No", "No", "Yes", "Yes", "Yes", "No", "No", "No", "Yes", "Yes", "No", "Yes", "No", "No", "No", "Yes", "Yes", "Yes", "Yes", "No", "No", "Yes", "No", "No", "No", "Yes", "No", "Yes", "No", "No", "No", "Yes", "No", "No", "Yes", "Yes", "No", "No", "Yes", "No", "Yes", "Yes", "Yes", "No", "Yes", "No", "Yes", "No", "Yes", "Yes", "Yes", "Yes", "No", "Yes", "Yes", "No", "Yes", "Yes", "Yes", "Yes", "No", "No", "Yes", "Yes", "No", "Yes", "Yes"};
//        String[] WEATHER = {"Sunny","Overcast","Rainy","Sunny","Sunny","Overcast","Rainy","Rainy","Sunny","Rainy","Sunny","Overcast","Overcast","Rainy"};
//        String[] PLAY = {"No","Yes","Yes","Yes","Yes","Yes","No","No","Yes","Yes","No","Yes","Yes","No"};
        DataModelWeather[] dataSet = new DataModelWeather[WEATHER.length];
        for (int i = 0; i < WEATHER.length; i++) {
            DataModelWeather data = new DataModelWeather();
            data.setWeather(WEATHER[i]);
            data.setPlay(PLAY[i]);
            dataSet[i] = data;
        }
        return dataSet;
    }
}
