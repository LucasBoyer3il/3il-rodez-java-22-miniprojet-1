package test;

import static org.junit.Assert.*;

import fr.ecole3il.rodez2023.perlin.Utils;
import org.junit.Test;


public class UtilsTest {

    @Test
    public void testMelanger() {
        int[] entree = {1, 2, 3, 4, 5};
        long seed = 123;
        int[] resultat = Utils.melanger(entree, seed);
        assertNotEquals(entree, resultat);
    }
}
