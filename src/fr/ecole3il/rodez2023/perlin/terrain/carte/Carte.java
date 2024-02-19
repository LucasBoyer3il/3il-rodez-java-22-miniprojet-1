package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

public class Carte {
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] carte;
    private GenerateurCarte generateurCarte;
    private String donneesCarte;

    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.generateurCarte = generateurCarte;
    }

    public Carte(String donneesCarte) {
        String[] chaineCoupee = donneesCarte.split("\n");
        largeur = Integer.valueOf(chaineCoupee[1]);
        hauteur = Integer.valueOf(chaineCoupee[2]);
        carte = new Terrain[largeur][hauteur];
        //lignes
        for (int i = 0 ; i < chaineCoupee[i].length() ; i++) {
            //colonnes
            for (int j = 0 ; j < chaineCoupee[j].length() ; j++) {
                carte[i][j] = new Terrain(j, j, j); }
        }
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

    public Terrain getTerrain(int x, int y) {
        //lever une TerrainInexistantException si la case sort de la carte
        return carte[x][y];
    }
}