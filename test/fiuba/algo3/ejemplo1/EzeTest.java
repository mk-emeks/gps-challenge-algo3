package fiuba.algo3.ejemplo1;

import junit.framework.Assert;
import org.junit.Test;


public class EzeTest {

    @Test
    public void testDevolverMiNombreComoStrig(){
        Eze referenciaAEze = new Eze();

        Assert.assertEquals("Eze", referenciaAEze.devolverMiNombre() );

    }

    @Test
    public void testConNombreEquivocado() {
        Eze referenciaAEze = new Eze();

        Assert.assertNotSame("Pedro", referenciaAEze.devolverMiNombre());
    }

}