package fiuba.algo3.ejemplo1;

import junit.framework.Assert;
import org.junit.Test;


public class MirkoTest {

    @Test
    public void testDevolverMiNombreComoStrig(){
        Mirko referenciaAMirko = new Mirko();

        Assert.assertEquals("Mirko", referenciaAMirko.devolverMiNombre() );

    }

}
