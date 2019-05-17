import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import es.deusto.server.jdo.Usuario;

import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

import es.deusto.server.jdo.Usuario;

public class UsuarioTest {

	private Usuario u;
	
	@Before
	public void setUp() {
			
		u= new Usuario("victormartin@opendeusto.es","victor1234",true);
	}
		
	@Test
	public void TestGetEmail() {
		
		assertEquals("victormartin@opendeusto.es", u.getEmail());
	}
	
	@Test
	public void TestGetContrasenya() {
		
		assertEquals("victor1234",u.getContrasenya());
	}
	
	/*
	@Test
	public void TestIsAdmin() {
	
		assertTrue(true,u.isAdmin());
	}
	*/
}
