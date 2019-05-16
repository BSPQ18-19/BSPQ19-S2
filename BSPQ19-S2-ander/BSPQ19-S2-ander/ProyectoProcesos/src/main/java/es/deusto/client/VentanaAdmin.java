<<<<<<< HEAD:ProyectoProcesos/src/main/java/es/deusto/client/VentanaAdmin.java
package es.deusto.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.server.jdo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;

	
	public VentanaAdmin(Client client, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
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
		btnVerCarrera.setBounds(121, 60, 176, 45);
		contentPane.add(btnVerCarrera);
		btnVerCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaVer vv = new VentanaVer(client, user);
				vv.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnCrearCarrera = new JButton("Crear Carrera ");
		btnCrearCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCrearCarrera.setBounds(121, 100, 176, 45);
		contentPane.add(btnCrearCarrera);
		btnCrearCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CrearCarrera cc = new CrearCarrera(client, user);
				cc.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnBorrarCarrera = new JButton("Borrar  Carrera ");
		btnBorrarCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnBorrarCarrera.setBounds(121, 140, 176, 45);
		contentPane.add(btnBorrarCarrera);
		btnBorrarCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BorrarCarrera bc = new BorrarCarrera(client , user);
				bc.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		

		JButton btnGestionarParticipantes = new JButton("Borrar participantes");
		btnGestionarParticipantes.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnGestionarParticipantes.setBounds(121, 180, 176, 45);
		contentPane.add(btnGestionarParticipantes);
		btnGestionarParticipantes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BorrarParticipante bp = new BorrarParticipante(client , user);
				bp.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnGestionarPatrocinador = new JButton("Gestionar patrocinadores");
		btnGestionarPatrocinador.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnGestionarPatrocinador.setBounds(121, 220, 176, 45);
		contentPane.add(btnGestionarPatrocinador);
		btnGestionarPatrocinador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPatrocinador vp = new VentanaPatrocinador(client , user);
				vp.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnVolver.setBounds(18, 300, 117, 29);
		contentPane.add(btnVolver);
	}
}
=======
package es.deusto.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.server.jdo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;

	
	public VentanaAdmin(Client client, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
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
		btnVerCarrera.setBounds(121, 60, 176, 45);
		contentPane.add(btnVerCarrera);
		btnVerCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaVer vv = new VentanaVer(client, user);
				vv.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnCrearCarrera = new JButton("Crear Carrera ");
		btnCrearCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCrearCarrera.setBounds(121, 100, 176, 45);
		contentPane.add(btnCrearCarrera);
		btnCrearCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CrearCarrera cc = new CrearCarrera(client, user);
				cc.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnBorrarCarrera = new JButton("Borrar  Carrera ");
		btnBorrarCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnBorrarCarrera.setBounds(121, 140, 176, 45);
		contentPane.add(btnBorrarCarrera);
		btnBorrarCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BorrarCarrera bc = new BorrarCarrera(client , user);
				bc.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		

		JButton btnGestionarParticipantes = new JButton("Borrar participantes");
		btnGestionarParticipantes.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnGestionarParticipantes.setBounds(121, 180, 176, 45);
		contentPane.add(btnGestionarParticipantes);
		btnGestionarParticipantes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BorrarParticipante bp = new BorrarParticipante(client , user);
				bp.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnGestionarPatrocinador = new JButton("Gestionar patrocinadores");
		btnGestionarPatrocinador.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnGestionarPatrocinador.setBounds(121, 220, 176, 45);
		contentPane.add(btnGestionarPatrocinador);
		btnGestionarPatrocinador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPatrocinador vp = new VentanaPatrocinador(client , user);
				vp.setVisible(true);
				VentanaAdmin.this.setVisible(false);
			}
		});
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnVolver.setBounds(18, 300, 117, 29);
		contentPane.add(btnVolver);
	}
}
>>>>>>> 328beefb2293cb367ab32325f37fab085863fd1c:BSPQ19-S2-ander/ProyectoProcesos/src/main/java/es/deusto/client/VentanaAdmin.java
