package com.company;
import java.util.*;


class Location {
    String name;
    double latitude;
    double longitude;

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

class NearestLocationsComparator implements Comparator<Location> {
    double referenceLatitude;
    double referenceLongitude;

    public NearestLocationsComparator(double referenceLatitude, double referenceLongitude) {
        this.referenceLatitude = referenceLatitude;
        this.referenceLongitude = referenceLongitude;
    }

    @Override
    public int compare(Location loc1, Location loc2) {
        double dist1 = distance(loc1.latitude, loc1.longitude, referenceLatitude, referenceLongitude);
        double dist2 = distance(loc2.latitude, loc2.longitude, referenceLatitude, referenceLongitude);
        return Double.compare(dist1, dist2);
    }

    // Haversine formula to calculate distance between two coordinates
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371; // in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
}

public class NearestLocationsFinder {
    public static void main(String[] args) {
        // Sample locations
        Location[] locations = {
                new Location("Location A", 42.7749, -70.4194),
                new Location("Location B", 34.0522, -118.2437),
                new Location("Location C", 40.7128, -74.0060),
                // Add more locations as needed
        };

        double targetLatitude = 37.7749; // Sample latitude
        double targetLongitude = -122.4194; // Sample longitude
        int k = 10; // Number of nearest locations to find

        PriorityQueue<Location> pq = new PriorityQueue<>(new NearestLocationsComparator(targetLatitude, targetLongitude));

        for (Location loc : locations) {
            pq.offer(loc);
            if (pq.size() > k) {
                pq.poll(); // Remove the farthest location
            }
        }

        System.out.println("Nearest " + k + " locations from the given location:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().name);
        }
    }
}
