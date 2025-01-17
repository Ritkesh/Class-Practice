package com.company;

public class DistanceCalculator {

    public static final double EARTH_RADIUS_KM = 6371.0; // Earth's radius in kilometers

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Haversine formula
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS_KM * c;
        return distance;
    }

    public static void main(String[] args) {
        double lat1 = 30.4883108; // Latitude of point 1 (New York City)
        double lon1 = 79.2034937; // Longitude of point 1 (New York City)

        double lat2 = 30.4843294; // Latitude of point 2 (Los Angeles)
        double lon2 = 79.2092215; // Longitude of point 2 (Los Angeles)

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Distance between the two points: " + distance + " kilometers");
    }
}