package es.deusto.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.server.jdo.Usuario;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	
	public VentanaMenu(Client client, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuAdministrador = new JLabel("Menu ");
		lblMenuAdministrador.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblMenuAdministrador.setBounds(163, 31, 183, 29);
		contentPane.add(lblMenuAdministrador);
		
		JButton btnVerCarrera = new JButton("Ver Carreras");
		btnVerCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnVerCarrera.setBounds(121, 105, 176, 29);
		contentPane.add(btnVerCarrera);
		btnVerCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				VentanaVer vv;
				vv = new VentanaVer(client,user);
				vv.setVisible(true);
				VentanaMenu.this.setVisible(false);
			
			}
		});
		
		JButton btnIncribirse = new JButton("Incribirse");
		btnIncribirse.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnIncribirse.setBounds(121, 155, 176, 29);
		contentPane.add(btnIncribirse);
		btnIncribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				VentanaInscribirse vi;
				vi = new VentanaInscribirse(client,user);
				vi.setVisible(true);
				VentanaMenu.this.setVisible(false);
			
			}
		});
		
		
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.salir();
				System.exit(0);
				
			}
		});
		btnVolver.setBounds(307, 217, 117, 29);
		contentPane.add(btnVolver);
	}
	
	
}
