package clustering;

import models.DataModel;

import java.util.ArrayList;
import java.util.HashMap;

import static models.DataModel.generateDataSet;

public class DBSCANAlgorithm {

    private static final int MIN_PTS = 5;
    private static final int EPS = 10;
    private static DataModel[] dataSet = generateDataSet();
    private static HashMap<Integer, ArrayList<DataModel>> clusters = new HashMap<>();
    private static int clusterPosition = 0;

    public static void main(String[] args) {
        for (DataModel value : dataSet) {
            if (!value.isVisited) {
                value.isVisited = true;
                ArrayList<DataModel> spherePoints = regionQuery(value);
                if (spherePoints.size() >= MIN_PTS) {
                    clusters.put(clusterPosition, new ArrayList<>());
                    expandCluster(value, spherePoints);
                    clusterPosition++;
                }
            }
        }
        for (int i = 0; i < clusterPosition; i++) {
            ArrayList<DataModel> cluster = clusters.get(i);
            System.out.println("");
            System.out.println("Cluster " + i + ":");
            for (DataModel dataModel : cluster) {
                System.out.print("(" + dataModel.getX() + "," + dataModel.getY() + ")");
            }
        }
    }

    private static void expandCluster(DataModel value, ArrayList<DataModel> spherePoints) {
        ArrayList<DataModel> cluster = clusters.get(clusterPosition);
        if (!value.isIncluded) {
            cluster.add(value);
            value.isIncluded = true;
        }
        for (DataModel dataModel : spherePoints) {
            if (!dataModel.isVisited) {
                dataModel.isVisited = true;
                ArrayList<DataModel> newSpherePoints = regionQuery(dataModel);
                if (newSpherePoints.size() >= MIN_PTS) {
                    expandCluster(value, newSpherePoints);
                } else {
                    if (!dataModel.isIncluded) {
                        cluster.add(dataModel);
                        dataModel.isIncluded = true;
                    }
                }
            }
        }
    }

    private static ArrayList<DataModel> regionQuery(DataModel dataModel) {
        ArrayList<DataModel> list = new ArrayList<>();
        for (DataModel value : dataSet) {
            int distance = DataModel.calculateDistance(value, dataModel);
            if (distance <= EPS) {
                list.add(value);
            }
        }
        return list;
    }


}
