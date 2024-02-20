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
        carte = new Terrain[largeur][hauteur];
        //lignes
        int x = 0;
        int y = 0;
        for (int i = 1 ; i < hauteur; i++) {
            //colonnes
            String[] chaineCoupeeColonnes = chaineCoupee[i + 3].split(" ");
            for (int j = 0 ; j < chaineCoupeeColonnes.length ; j++){
                double altitude = Double.parseDouble(chaineCoupeeColonnes[0]);
                double hydrometrie = Double.parseDouble(chaineCoupeeColonnes[1]);
                double temperature = Double.parseDouble(chaineCoupeeColonnes[2]);
                carte[x][y] = new Terrain(altitude, hydrometrie, temperature);
                if (y == largeur - 1) {
                    x++;
                    y = 0;
                } else {
                    y++;
                }

            }
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

    public Terrain getTerrain(int x, int y) throws TerrainInexistantException{
        if (x > largeur || y > hauteur) {
            throw new TerrainInexistantException("Valeur hors de la carte.");
        }
        return carte[x][y];
    }
}