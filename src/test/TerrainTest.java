package test;

import fr.ecole3il.rodez2023.perlin.Utils;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import org.junit.Test;

import static org.junit.Assert.*;

public class TerrainTest {

    @Test
    public void testConstructeurTerrain() {

        Terrain resultat = new Terrain(-0.5,0.5,1);
        assertEquals(-0.5,resultat.getAltitude(), 0);
        assertEquals(0.5, resultat.getHydrometrie(), 0);
        assertEquals(1, resultat.getTemperature(), 0);

    }

}
