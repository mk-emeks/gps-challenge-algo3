package fiuba.algo3.ejemplo1;

import junit.framework.Assert;
import org.junit.Test;

public class EduTest {

    @Test
    public void testdeberiaDevolverComoNombreEdu(){
        Edu humano = new Edu();
        Assert.assertEquals("Edu", humano.devolverMiNombre());

    }
}
