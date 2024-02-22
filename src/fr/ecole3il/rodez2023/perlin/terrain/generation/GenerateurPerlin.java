package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurPerlin extends GenerateurCarte {

    public GenerateurPerlin(long graine) {
        super(graine);
    }

    /**
     * Génération d'une case de la carte grâce au bruit de perlin
     * @param i        La position verticale dans la carte.
     * @param j        La position horizontale dans la carte.
     * @param largeur  La largeur totale de la carte.
     * @param hauteur  La hauteur totale de la carte.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        BruitPerlin2D bruitPerlinHydro = new BruitPerlin2D(getGraine(),1);
        BruitPerlin2D bruitPerlinTemp = new BruitPerlin2D(2 * getGraine(),1);
        BruitPerlin2D bruitPerlinAlt = new BruitPerlin2D(bruitPerlinTemp.getGraine() * 2,1);
        double x = (double) i/largeur;
        double y = (double) j/hauteur;
        double hydrometrie = bruitPerlinHydro.bruit2D(x,y);
        double temperature = bruitPerlinTemp.bruit2D(x,y);
        double altitude = bruitPerlinAlt.bruit2D(x,y);

        Terrain terrain = null;
        try {
            return new Terrain(altitude,Math.abs(hydrometrie),Math.abs(temperature));
        } catch (MauvaiseValeurException e) {
            e.printStackTrace();
        }
        return terrain;
    }

}
