package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public class VisualiseurTerrain {
    private Carte carte;
    private DetermineurTerrain dt;
    private double altitudeAffichee;
    private double hydrometrieAffichee;
    private double temperatureAffichee;

    public VisualiseurTerrain(DetermineurTerrain dt, Carte carte) {
        this.carte = carte;
        this.dt = dt;
    }

    public AltitudeAffichee getAltitudeAffichee(int x, int y) {
        AltitudeAffichee reponse;
        altitudeAffichee = carte.getTerrain(x, y).getAltitude();
        if (altitudeAffichee < 0) {
            reponse = AltitudeAffichee.FONDMARIN;
        } else if (altitudeAffichee > 0 && altitudeAffichee < 0.33) {
            reponse = AltitudeAffichee.BASSE;
        } else if (altitudeAffichee > 0.33 && altitudeAffichee < 0.66) {
            reponse = AltitudeAffichee.MOYENE;
        } else {
            reponse = AltitudeAffichee.ELEVEE;
        }
        return reponse;
    }

    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) {
        HydrometrieAffichee reponse;
        hydrometrieAffichee = carte.getTerrain(x, y).getHydrometrie();
        if (hydrometrieAffichee < 0.33) {
            reponse = HydrometrieAffichee.SEC;
        } else if (hydrometrieAffichee > 0.33 && hydrometrieAffichee < 0.66) {
            reponse = HydrometrieAffichee.MOYEN;
        } else {
            reponse = HydrometrieAffichee.HUMIDE;
        }
        return reponse;
    }

    public TemperatureAffichee getTemperatureAffichee(int x, int y) {
        TemperatureAffichee reponse;
        temperatureAffichee = carte.getTerrain(x, y).getHydrometrie();
        if (temperatureAffichee < 0.33) {
            reponse = TemperatureAffichee.FROID;
        } else if (temperatureAffichee > 0.33 && temperatureAffichee < 0.66) {
            reponse = TemperatureAffichee.TEMPERE;
        } else {
            reponse = TemperatureAffichee.CHAUD;
        }
        return reponse;
    }

    public TypeTerrain getTypeTerrain(int x, int y) {
        return dt.determinerTerrain(carte.getTerrain(x, y).getAltitude(), carte.getTerrain(x, y).getHydrometrie(), carte.getTerrain(x, y).getTemperature());
    }
}