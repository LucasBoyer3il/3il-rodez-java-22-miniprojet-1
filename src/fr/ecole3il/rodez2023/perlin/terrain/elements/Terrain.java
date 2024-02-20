package fr.ecole3il.rodez2023.perlin.terrain.elements;


import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain  {
    private double hydrometrie;
    private double altitude;
    private double temperature;


    public Terrain (double altitude, double hydrometrie, double temperature) throws MauvaiseValeurException {
        if (altitude > -1 && altitude < 1 && hydrometrie > 0 && hydrometrie > 1 && temperature > 0 && temperature < 1) {
            this.altitude = altitude;
            this.hydrometrie = hydrometrie;
            this.temperature = temperature;
        } else {
            throw new MauvaiseValeurException("Les valeurs ne sont pas bonnes");
        }
    }

    public double getHydrometrie( ) {
        return hydrometrie;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getTemperature( ) {
        return temperature;
    }

    public TypeTerrain getTypeTerrain(DetermineurTerrain dt) {
        return dt.determinerTerrain(altitude, hydrometrie,  temperature);
    }
}
