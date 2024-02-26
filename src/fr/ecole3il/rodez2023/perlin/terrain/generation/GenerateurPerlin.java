package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurPerlin extends GenerateurCarte {
    private BruitPerlin2D hydrometrie;
    private BruitPerlin2D temperature;
    private BruitPerlin2D altitude;

    public GenerateurPerlin(long graine) {
        super(graine);
        this.hydrometrie = new BruitPerlin2D(graine, 1);
        this.temperature = new BruitPerlin2D(2 * graine, 0.5);
        this.altitude = new BruitPerlin2D(4 * graine, 0.5);}


    /**


     Méthode pour générer un terrain en utilisant le bruit de Perlin à une position spécifique dans la carte.
     @param i L'indice de la colonne.
     @param j L'indice de la ligne.
     @param largeur La largeur de la carte.
     @param hauteur La hauteur de la carte.
     @return Le terrain généré.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double x = (double) i / largeur;
        double y = (double) j / hauteur;
        double hydrometrieVal = Math.abs(hydrometrie.bruit2D(x, y));
        double temperatureVal = Math.abs(temperature.bruit2D(x, y));
        double altitudeVal = altitude.bruit2D(x, y);
        return new Terrain(altitudeVal, temperatureVal, hydrometrieVal );}

}