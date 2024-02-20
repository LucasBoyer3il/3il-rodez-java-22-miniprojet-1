package fr.ecole3il.rodez2023.perlin.terrain.elements;

import java.awt.image.BufferedImage;

import fr.ecole3il.rodez2023.perlin.Utils;

public enum TypeTerrain {
    COLLINES("hills.png"),
    DESERT("desert.png"),
    FORET_CONIFÈRES("coniferous_forest.png"),
    FORET_FEUILLUS("deciduous_forest.png"),
    MARAIS("marsh.png"),
    MONTAGNE("mountain.png"),
    OCEAN("ocean.png"),
    PLAINE("plain.png"),
    TOUNDRA("tundra.png");

    private String nom;

    TypeTerrain(String nom) {
        this.nom = nom;
    }

    public BufferedImage getImage() {
        return Utils.chargerTuile(nom);
    }

    public String toString() {
        return nom.substring(0, nom.length() - 4);
    }
}
