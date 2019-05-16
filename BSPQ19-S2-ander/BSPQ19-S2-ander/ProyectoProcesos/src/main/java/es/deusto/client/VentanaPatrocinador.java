package es.deusto.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.server.jdo.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPatrocinador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	
	public VentanaPatrocinador(Client client,Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionPatrocinadores = new JLabel("GESTION PATROCINADORES");
		lblGestionPatrocinadores.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGestionPatrocinadores.setBounds(80, 28, 253, 16);
		contentPane.add(lblGestionPatrocinadores);
		
//		JButton btnCrear = new JButton("Crear");
//		btnCrear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
//		btnCrear.setBounds(157, 60, 117, 29);
//		contentPane.add(btnCrear);
//		btnCrear.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				CrearPatrocinador cp = new CrearPatrocinador(client , user);
//				cp.setVisible(true);
//				VentanaPatrocinador.this.setVisible(false);
//			}
//		});
		
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAadir.setBounds(157, 100, 117, 29);
		contentPane.add(btnAadir);
		btnAadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AnadirPatrocinador ap = new AnadirPatrocinador(client , user);
				ap.setVisible(true);
				VentanaPatrocinador.this.setVisible(false);
			}
		});
		
		JButton btnBorrar = new JButton("Borrar ");
		btnBorrar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBorrar.setBounds(157, 140, 117, 29);
		contentPane.add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BorrarPatrocinador bp = new BorrarPatrocinador(client , user);
				bp.setVisible(true);
				VentanaPatrocinador.this.setVisible(false);
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin va= new VentanaAdmin(client,user);
				va.setVisible(true);
				VentanaPatrocinador.this.setVisible(false);
			}
		});
		btnVolver.setBounds(312, 231, 117, 29);
		contentPane.add(btnVolver);
	}

}
