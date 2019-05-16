package es.deusto.testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//borrarcarreratest
public class BorrarCarreraTest {
	private BorrarCarreraTest bct;

	@Mock
	private ServiceLocator rsl;
	@Mock
	private IServer server;
	
	private String[] args = {"",""};
	private String cod;
	private String nombreC;
	private String fecha;
	private String lugar;
	private double precio;
	private double premio;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void constructorTest() {
		try {
			assertNotNull(new BorrarCarreraTest());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void BorrarCarreraBienTest() {
	try {
		bct = new BorrarCarreraTest(args);
		
		when(rsl.getService()).thenReturn(server);
		when(rsl.getService().borrar(cod, nombreC, fecha, lugar, precio, premio)).thenReturn(true);
		
			assertTrue(rut.borrar(cod, nombreC, fecha, lugar, precio, premio));
		} catch (RemoteException e) {
			e.printStackTrace();
	}
}