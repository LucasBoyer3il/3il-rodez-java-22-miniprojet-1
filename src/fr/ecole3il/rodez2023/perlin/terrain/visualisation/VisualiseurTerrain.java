package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;

public class VisualiseurTerrain {
    private Carte carte;
    private DetermineurTerrain dt;
    private AltitudeAffichee altitudeAffichee;
    private HydrometrieAffichee hydrometrieAffichee;
    private TemperatureAffichee temperatureAffichee;

    public VisualiseurTerrain(DetermineurTerrain dt, Carte carte) {
        this.carte = carte;
        this.dt = dt;
    }

    public AltitudeAffichee getAltitudeAffichee(int x, int y) {
        return altitudeAffichee;
    }

    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) {
        return hydrometrieAffichee;
    }

    public TemperatureAffichee getTemperatureAffichee(int x, int y) {
        return temperatureAffichee;
    }
}