package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.model.common.LocationDetail;
import com.dalhousie.bloodDonation.model.common.LocationName;
import com.dalhousie.bloodDonation.repos.common.LocationRepository;

import java.util.List;
import java.util.stream.Collectors;

import static com.dalhousie.bloodDonation.constants.BloodDonationConstants.DIRECTION_SYM;

public class LocationServiceImpl implements LocationService {

    private List<LocationName> locationNames;
    private float[][] graph = new float[][]{};
    private final LocationRepository locationRepository;
    private StringBuffer[] path;
    private float[] dist;

    public LocationServiceImpl() {
        locationRepository = new LocationRepository();
    }

    // Reference:  https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
    private int minDistance(float[] dist, Boolean[] sptSet) {
        float min = Float.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < dist.length; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    void dijkstra(int src) {
        int size = this.locationNames.size();
        Boolean[] sptSet = new Boolean[size];

        for (int i = 0; i < size; i++) {
            dist[i] = Float.MAX_VALUE;
            path[i] = new StringBuffer(this.locationNames.get(src).getName());
            sptSet[i] = false;
        }
        dist[src] = 0;

        for (int count = 0; count < size - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < size; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    path[v] = new StringBuffer(path[u] + DIRECTION_SYM + this.locationNames.get(v).getName());
                }
            }
        }
    }

    @Override
    public String getShortestPath(String pinCode1, String pinCode2) {
        initGraph();
        int src = 0;
        int dest = 0;
        for (int i = 0; i < this.locationNames.size(); i++) {
            if (this.locationNames.get(i).getPinCode().equalsIgnoreCase(pinCode1)) {
                src = i;
            }
            if (this.locationNames.get(i).getPinCode().equalsIgnoreCase(pinCode2)) {
                dest = i;
            }
        }
        dijkstra(src);
        return this.path[dest].toString();
    }

    @Override
    public float getDistanceInMeters(String pinCode1, String pinCode2) {
        initGraph();
        int src = 0;
        int dest = 0;
        for (int i = 0; i < this.locationNames.size(); i++) {
            if (this.locationNames.get(i).getPinCode().equalsIgnoreCase(pinCode1)) {
                src = i;
            }
            if (this.locationNames.get(i).getPinCode().equalsIgnoreCase(pinCode2)) {
                dest = i;
            }
        }
        dijkstra(src);
        return this.dist[dest];
    }

    private void initGraph() {
        List<LocationDetail> locationDetails = locationRepository.getAllRecordsLocationDistance();
        this.locationNames = locationRepository.getAllRecordsLocationName();
        int size = this.locationNames.size();
        this.graph = new float[size][size];
        for (int i = 0; i < this.locationNames.size(); i++) {
            for (int j = 0; j < this.locationNames.size(); j++) {
                String pinCode1 = this.locationNames.get(i).getPinCode();
                String pinCode2 = this.locationNames.get(j).getPinCode();
                LocationDetail locationDetail = locationDetails.stream()
                        .filter(x ->
                                x.getPinCode1().equalsIgnoreCase(pinCode1)
                                        &&
                                        x.getPinCode2().equalsIgnoreCase(pinCode2)
                        ).collect(Collectors.toList()).get(0);
                this.graph[i][j] = locationDetail.getDistance();
            }
        }
        this.path = new StringBuffer[size];
        this.dist = new float[size];
    }
}
