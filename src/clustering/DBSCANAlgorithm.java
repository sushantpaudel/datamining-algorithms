package clustering;

import models.DataModelXY;

import java.util.ArrayList;
import java.util.HashMap;

import static models.DataModelXY.generateDataSet;

public class DBSCANAlgorithm {

    private static final int MIN_PTS = 5;
    private static final int EPS = 10;
    private static DataModelXY[] dataSet = generateDataSet();
    private static HashMap<Integer, ArrayList<DataModelXY>> clusters = new HashMap<>();
    private static int clusterPosition = 0;

    public static void main(String[] args) {
        for (DataModelXY value : dataSet) {
            if (!value.isVisited) {
                value.isVisited = true;
                ArrayList<DataModelXY> spherePoints = regionQuery(value);
                if (spherePoints.size() >= MIN_PTS) {
                    clusters.put(clusterPosition, new ArrayList<>());
                    expandCluster(value, spherePoints);
                    clusterPosition++;
                }
            }
        }
        for (int i = 0; i < clusterPosition; i++) {
            ArrayList<DataModelXY> cluster = clusters.get(i);
            System.out.println("");
            System.out.println("Cluster " + i + ":");
            for (DataModelXY dataModelXY : cluster) {
                System.out.print("(" + dataModelXY.getX() + "," + dataModelXY.getY() + ")");
            }
        }
    }

    private static void expandCluster(DataModelXY value, ArrayList<DataModelXY> spherePoints) {
        ArrayList<DataModelXY> cluster = clusters.get(clusterPosition);
        if (!value.isIncluded) {
            cluster.add(value);
            value.isIncluded = true;
        }
        for (DataModelXY dataModelXY : spherePoints) {
            if (!dataModelXY.isVisited) {
                dataModelXY.isVisited = true;
                ArrayList<DataModelXY> newSpherePoints = regionQuery(dataModelXY);
                if (newSpherePoints.size() >= MIN_PTS) {
                    expandCluster(value, newSpherePoints);
                } else {
                    if (!dataModelXY.isIncluded) {
                        cluster.add(dataModelXY);
                        dataModelXY.isIncluded = true;
                    }
                }
            }
        }
    }

    private static ArrayList<DataModelXY> regionQuery(DataModelXY dataModelXY) {
        ArrayList<DataModelXY> list = new ArrayList<>();
        for (DataModelXY value : dataSet) {
            int distance = DataModelXY.calculateDistance(value, dataModelXY);
            if (distance <= EPS) {
                list.add(value);
            }
        }
        return list;
    }


}
