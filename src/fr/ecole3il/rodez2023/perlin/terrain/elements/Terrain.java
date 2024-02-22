package fr.ecole3il.rodez2023.perlin.terrain.elements;


import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain {
    private double hydrometrie;
    private double altitude;
    private double temperature;


    /**
     * Création d'un terrain suivant plusieurs règles de possibilitées.
     * @param altitude
     * @param hydrometrie
     * @param temperature
     * @throws MauvaiseValeurException Si une des valeurs n'est pas comprise dans les possibilitées
     */
    public Terrain (double altitude, double hydrometrie, double temperature) throws MauvaiseValeurException {
        if (altitude < -1.0 || altitude > 1.0) {
            throw new MauvaiseValeurException("Les valeurs d'altitude ne sont pas bonnes");
        } else if (hydrometrie < 0.0 || hydrometrie > 1.0 ){
            throw new MauvaiseValeurException("Les valeurs d'hydrometrie ne sont pas bonnes");
            } else if (temperature < 0.0 || temperature > 1.0) {
            throw new MauvaiseValeurException("Les valeurs de températures ne sont pas bonnes");
            } else {
            this.altitude = altitude;
            this.hydrometrie = hydrometrie;
            this.temperature = temperature;
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
