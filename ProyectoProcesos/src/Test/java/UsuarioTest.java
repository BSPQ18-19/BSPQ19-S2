import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import es.deusto.server.jdo.Usuario;

import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

//@RunWith(ContiPerfSuiteRunner.class)
//@SuiteClasses(MyApplicationTest.class)

//@PerfTest(invocations = 5)
//@Required(max = 1200, average = 250)

@RunWith(MockitoJUnitRunner.class)

public class UsuarioTest {

	private Usuario u;
	
	// If you use the EmptyReportModule, the report is not generated
	//@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
//	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	@Before
	public void setUp() {
			
		u= new Usuario("victormartin@opendeusto.es","victor1234",false);
	}
		
	@Test
  //  @PerfTest(invocations = 1000, threads = 20)
   // @Required(max = 120, average = 30)
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
