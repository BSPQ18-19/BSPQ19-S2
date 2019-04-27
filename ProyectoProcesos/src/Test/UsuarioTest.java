import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario u;
	
	
	@Before
	public void setUp() {
			
		u= new Usuario("victormartin@opendeusto.es","victor1234",false);
	}
		
	@Test
	public void TestGetEmail() {
		
		assertEquals("victormartin@opendeusto.es", u.getEmail());
	}
	
	@Test
	public void TestGetContrasenya() {
		
		assertEquals("victor1234",u.getContrasenya());
	}
	
	@Test
	public void TestSetEmail() {
		
		u.setEmail("victor@opendeusto.es");
		assertEquals("victor@opendeusto.es",u.getEmail());
	}
	
	@Test
	public void TestSetContrasenya() {
		
		u.setContrasenya("martin21");
		asserEquals("martin21",u.getContrasenya());
		
	}
	
	@Test
	public void TestIsAdmin() {
	
		assertTrue(false,u.isAdmin());
	}
	
	@Test
	public void TestSetIsAdmin() {
		
		u.setAdmin(false);
		assertTrue(false,u.isAdmin());
	
	}
}
