package fiuba.algo3.ejemplo1;

import junit.framework.Assert;
import org.junit.Test;


public class EzeTest {

    @Test
    public void testDevolverMiNombreComoStrig(){
        Eze referenciaAMirko = new Eze();

        Assert.assertEquals("Eze", referenciaAMirko.devolverMiNombre() );

    }

}