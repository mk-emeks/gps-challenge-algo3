package fiuba.algo3.ejemplo1;

import junit.framework.Assert;
import org.junit.Test;

public class HolaTp2Test {
	@Test
	public void deberiaSaludarAlGrupo() {
		HolaTp2 saludo = new HolaTp2();
		Assert.assertEquals("Eduardo les manda saludos", saludo.saludarAlGrupo());
	}
}