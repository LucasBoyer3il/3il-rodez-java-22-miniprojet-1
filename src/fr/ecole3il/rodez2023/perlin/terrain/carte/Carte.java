package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

public class Carte {
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] carte;
    private GenerateurCarte generateurCarte;

    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.generateurCarte = generateurCarte;
        this.carte = generateurCarte.genererCarte(largeur, hauteur);
    }

    public Carte(String donneesCarte) {
        String[] chaineCoupee = donneesCarte.split("\n");
        nom = chaineCoupee[0];
        largeur = Integer.parseInt(chaineCoupee[1]);
        hauteur = Integer.parseInt(chaineCoupee[2]);
        /*terrains = new Terrain[largeur][hauteur];
        //lignes
        for (int i = 3 ; i < chaineCoupee[i].length() ; i++) {
            //colonnes
            for (int j = 0 ; j < chaineCoupee[j].length() ; j = j + 14) {
                //TODO : implémenter le signe négatif
                double altitude = Double.parseDouble(chaineCoupee[j].substring(j, j + 4));
                double hydrometrie = Double.parseDouble(chaineCoupee[j].substring(j + 5, j + 9));
                double temperature = Double.parseDouble(chaineCoupee[j].substring(j + 10, j + 14));
                terrains[i][j] = new Terrain(altitude, hydrometrie, temperature);
            }
        }*/
    }

    public String getNom() {
        return nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Terrain getTerrain(int x, int y) throws TerrainInexistantException{
        if (x > largeur || y > hauteur) {
            throw new TerrainInexistantException("Valeur hors de la carte.");
        }
        return carte[x][y];
    }
}