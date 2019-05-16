

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.deusto.client.VRegistro
import es.deusto.server.IServer;
import es.deusto.client.Client;


public class RegistrarUsuarioTest {

	private ControllerRegistro crs;

	@Mock
	private ServiceLocator rsl;
	@Mock
	private IServer server;
	
	private String[] args = {"",""};
	private String nombre;
	private String pass;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void constructorTest() {
		try {
			assertNotNull(new RegistrarUsuarioTest());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void registroBienTest() {
	try {
		rut = new RegistrarUsuarioTest(args);
		
		when(rsl.getService()).thenReturn(server);
		when(rsl.getService().registro(nombre, pass)).thenReturn(true);
		
			assertTrue(rut.registro(nombre, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
	}
	}
}