import static org.junit.Assert.*;

import es.deusto.server.jdo.Patrocinadores;

import org.junit.Before;
import org.junit.Test;

public class PatrocinadoresTest {
	
	private Patrocinadores p;
	
	@Before
	public void setUp() {
		
		p = new Patrocinadores("01","ejemplo1",100);
		
	}
	
	@Test
	public void testGetCodPatrocinador() {
		
		assertEquals("01",p.getCodPatrocinador());
		
	}
	
	@Test
	public void testGetNombre() {
		
		assertEquals("ejemplo1",p.getNombre());
		
	}
	
	@Test
	public void testGetContribucion() {
		
		assertEquals(100,p.getContribucion(),100);
		
	}

}
