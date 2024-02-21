package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurPerlin extends GenerateurCarte {

    public GenerateurPerlin(long graine) {
        super(graine);
    }

    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        BruitPerlin2D bruitPerlin = new BruitPerlin2D(this.getGraine(),1);
        double hydrometrie = Math.abs(bruitPerlin.bruit2D((double) i /largeur, (double) j /hauteur));
        double temperature = Math.abs(2 * bruitPerlin.bruit2D((double) i /largeur, (double) j /hauteur));
        double altitude = 2 * temperature;

        Terrain terrain = null;
        try {
            terrain = new Terrain(altitude, hydrometrie, temperature);
        } catch (MauvaiseValeurException e) {
            e.printStackTrace();
        }
        return terrain;
    }

}
