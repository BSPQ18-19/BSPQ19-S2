
import static org.junit.Assert.*;


import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.deusto.server.IServer;



import es.deusto.client.Client;
public class RegistroTest {
	
	private String email = "prueba";
	private String password = "prueba";
	
	private Client registroUsuario;

	@Mock
	private IServer server;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void registrarUsuario() {
		try {
			
			server.registrarUsuario(email, password, false);
			assertEquals(email,"prueba");
			assertEquals(password,"prueba");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
