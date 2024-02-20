package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitAleatoire;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurAleatoire extends GenerateurCarte {

    public GenerateurAleatoire(long graine) {
        super(graine);
    }

    public Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        BruitAleatoire bruitAleatoire = new BruitAleatoire(this.getGraine(), 1.0);
        double altitdude = bruitAleatoire.bruit2D(0.0,0.0);
        double hydrometrie = bruitAleatoire.bruit2D(0.0,0.0);
        double temperature = bruitAleatoire.bruit2D(0.0,0.0);

        return new Terrain(altitdude, hydrometrie, temperature);
    }
}
