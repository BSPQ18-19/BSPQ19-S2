import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.server.jdo.Carrera;


public class CarreraTest {
	
	private Carrera c;
	
	@Before
	public void setUp() {
		
		c = new Carrera("01","Carrera Santurtzi-Bilbao","10/06/2019","Bizkaia",10,1000);
		
	}
	
	@Test
	public void testGetCod() {
		
		assertEquals("01",c.getCod());
		
	}
	
	@Test 
	public void testGetNombre() {
		
		assertEquals("Carrera Santurtzi-Bilbao",c.getNombreC());
		
	}
	
	@Test
	public void testGetFecha() {
		
		assertEquals("10/06/2019", c.getFecha());
		
	}
	
	@Test
	public void testGetLugar() {
		
		assertEquals("Bizkaia",c.getLugar());
		
	}
	
	@Test
	public void testGetPrecio() {
		
		assertEquals(10, c.getPrecio());
		
	}
	
	@Test 
	public void testGetPremio() {
		
		assertEquals(1000, c.getPremio());
	}

}
