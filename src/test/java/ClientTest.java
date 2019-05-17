//junit
//import static org.junit.Assert.assertEquals;
//
//import java.rmi.RemoteException;
//
//import org.junit.Test;
//
//import es.deusto.server.IServer;
//import es.deusto.server.jdo.Usuario;
//
//public class ClientTest {
//	static IServer server;
//	
//	@Test
//	public void testRegistrarUsuario() {
//		
//		Usuario user = null;
//		try {
//			user = server.registrarUsuario("prueba", "prueba", false);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			user = server.comprobarUsuario("prueba", "prueba");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals(user, user);
//	}
//
//}
