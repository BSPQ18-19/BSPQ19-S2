package es.deusto.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;

	
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuAdministrador = new JLabel("Menu Administrador ");
		lblMenuAdministrador.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMenuAdministrador.setBounds(111, 5, 203, 29);
		contentPane.add(lblMenuAdministrador);
		
		JButton btnVerCarrera = new JButton("Ver Carreras");
		btnVerCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnVerCarrera.setBounds(121, 59, 176, 29);
		contentPane.add(btnVerCarrera);
		btnVerCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaVer vv = new VentanaVer();
				vv.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnCrearCarrera = new JButton("Crear Carrera ");
		btnCrearCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCrearCarrera.setBounds(121, 112, 176, 29);
		contentPane.add(btnCrearCarrera);
		btnCrearCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CrearCarrera cc = new CrearCarrera();
				cc.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnBorrarCarrera = new JButton("Borrar  Carrera ");
		btnBorrarCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnBorrarCarrera.setBounds(121, 169, 176, 29);
		contentPane.add(btnBorrarCarrera);
		btnBorrarCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BorrarCarrera bc = new BorrarCarrera();
				bc.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnVolver.setBounds(18, 232, 117, 29);
		contentPane.add(btnVolver);
	}
}
