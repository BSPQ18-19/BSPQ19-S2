package es.deusto.client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import es.deusto.server.jdo.Carrera;
import es.deusto.server.jdo.Usuario;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class VentanaVer extends JFrame {
	public VentanaVer() {
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ArrayList<Carrera> ListaCarreras;
	
public VentanaVer(ArrayList<Carrera> ListaCarreras,Usuario u ) {
		
		this.ListaCarreras = ListaCarreras;
		
		try {
			ListaCarreras = Client.server.listaCarreras();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{ 615,15};
		gridBagLayout.rowHeights = new int[]{ 427, 85};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 800);
		
		System.out.println(ListaCarreras.size());
		
		int i=0;
		for (Carrera v: ListaCarreras) {
			
			
			JPanel carrera = new JPanel();
			GridBagLayout gbl_pFlight = new GridBagLayout();
			gbl_pFlight.columnWidths = new int[]{96, 0, 198, 124, 205, 0};
			gbl_pFlight.rowHeights = new int[]{16, 0, 16, 16, 16, 16, 16, 16, 0, 16, 0};
			gbl_pFlight.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pFlight.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			carrera.setLayout(gbl_pFlight);
			
			GridBagConstraints gbc_pFlights = new GridBagConstraints();
			gbc_pFlights.anchor = GridBagConstraints.NORTH;
			gbc_pFlights.insets = new Insets(0, 0, 5, 5);
			gbc_pFlights.fill = GridBagConstraints.HORIZONTAL;
			gbc_pFlights.gridx = 0;
			gbc_pFlights.gridy = i;
			
			JLabel lblnm = new JLabel("Codigo" + v.getCod());
			lblnm.setBounds(12, 139, 78, 16);
			GridBagConstraints gbc_codigo = new GridBagConstraints();
			gbc_codigo.fill = GridBagConstraints.BOTH;
			gbc_codigo.insets = new Insets(0, 0, 5, 5);
			gbc_codigo.gridx = 0;
			gbc_codigo.gridy = 0;
			carrera.add(lblnm, gbc_codigo);
			
			
			JLabel lblnombre = new JLabel("Nombre" + v.getNombreC());
			lblnombre.setBounds(12, 139, 78, 16);
			GridBagConstraints gbc_lblnombre = new GridBagConstraints();
			gbc_lblnombre.fill = GridBagConstraints.BOTH;
			gbc_lblnombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblnombre.gridx = 0;
			gbc_lblnombre.gridy = 1;
			carrera.add(lblnombre, gbc_lblnombre);
			
			
			JLabel lblfecha = new JLabel("Fecha "+v.getFecha());
			lblfecha.setBounds(12, 52, 111, 33);
			GridBagConstraints gbc_lblfecha = new GridBagConstraints();
			gbc_lblfecha.fill = GridBagConstraints.BOTH;
			gbc_lblfecha.insets = new Insets(0, 0, 5, 5);
			gbc_lblfecha.gridx = 1;
			gbc_lblfecha.gridy = 1;
			carrera.add(lblfecha, gbc_lblfecha);
			
			
			JLabel lbllugar = new JLabel("Lugar" + v.getLugar());
			lbllugar.setBounds(12, 97, 133, 25);
			GridBagConstraints gbc_lbllugar = new GridBagConstraints();
			gbc_lbllugar.fill = GridBagConstraints.BOTH;
			gbc_lbllugar.insets = new Insets(0, 0, 5, 5);
			gbc_lbllugar.gridx = 1;
			gbc_lbllugar.gridy = 2;
			carrera.add(lbllugar, gbc_lbllugar);
			
			
			JLabel lblprecio = new JLabel("Precio" + v.getPrecio());
			lblprecio.setBounds(12, 139, 78, 16);
			GridBagConstraints gbc_lprecio = new GridBagConstraints();
			gbc_lprecio.fill = GridBagConstraints.BOTH;
			gbc_lprecio.insets = new Insets(0, 0, 5, 5);
			gbc_lprecio.gridx = 2;
			gbc_lprecio.gridy = 1;
			carrera.add(lblprecio, gbc_lprecio);
			
			
			JLabel lblpremio = new JLabel("Premio" + v.getPremio());
			lblprecio.setBounds(12, 100, 100, 28);
			GridBagConstraints gbc_lblpremio = new GridBagConstraints();
			gbc_lblpremio.fill = GridBagConstraints.BOTH;
			gbc_lblpremio.insets = new Insets(0, 0, 5, 5);
			gbc_lblpremio.gridx = 2;
			gbc_lblpremio.gridy = 1;
			carrera.add(lblprecio, gbc_lblpremio);
			
			JButton btnVolver = new JButton("Volver ");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					if (u.isAdmin() == true) {
						VentanaAdmin b = new VentanaAdmin();
						b.setVisible(true);
					}
					else {
					VentanaMenu a = new VentanaMenu();
					a.setVisible(true);
					}
				}
			});
			btnVolver.setBounds(307, 217, 117, 29);
			carrera.add(btnVolver);
			
			
			i++;
			getContentPane().add(carrera, gbc_pFlights);
			
		}
}
	}