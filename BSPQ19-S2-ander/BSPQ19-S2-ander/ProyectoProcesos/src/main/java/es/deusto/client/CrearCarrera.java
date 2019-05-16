<<<<<<< HEAD:ProyectoProcesos/src/main/java/es/deusto/client/CrearCarrera.java
package es.deusto.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.server.jdo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class CrearCarrera extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Date fecha; 

	
	public CrearCarrera(Client client,Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearCarrera = new JLabel("Crear Carrera ");
		lblCrearCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCrearCarrera.setBounds(138, 5, 152, 39);
		contentPane.add(lblCrearCarrera);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(29, 56, 61, 16);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 93, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(29, 133, 61, 16);
		contentPane.add(lblFecha);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(29, 161, 61, 16);
		contentPane.add(lblLugar);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(29, 195, 61, 16);
		contentPane.add(lblPrecio);
		
		JLabel lblPremio = new JLabel("Premio");
		lblPremio.setBounds(29, 223, 61, 16);
		contentPane.add(lblPremio);
		
		textField = new JTextField();
		textField.setBounds(102, 51, 216, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 88, 216, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(102, 128, 216, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(102, 156, 216, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(102, 190, 216, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(102, 218, 216, 26);
		contentPane.add(textField_5);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin b = new VentanaAdmin(client, user);
				b.setVisible(true);
				CrearCarrera.this.setVisible(false);
				
				
			}
		});
		btnVolver.setBounds(327, 243, 117, 29);
		contentPane.add(btnVolver);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cambiar string a fecha
				
				try {
					Client.server.crearCarrear(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), Double.parseDouble(textField_4.getText()), Double.parseDouble(textField_5.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(327, 218, 117, 29);
		contentPane.add(btnNewButton);
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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class CrearCarrera extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Date fecha; 

	
	public CrearCarrera(Client client,Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearCarrera = new JLabel("Crear Carrera ");
		lblCrearCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCrearCarrera.setBounds(138, 5, 152, 39);
		contentPane.add(lblCrearCarrera);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(29, 56, 61, 16);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 93, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(29, 133, 61, 16);
		contentPane.add(lblFecha);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(29, 161, 61, 16);
		contentPane.add(lblLugar);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(29, 195, 61, 16);
		contentPane.add(lblPrecio);
		
		JLabel lblPremio = new JLabel("Premio");
		lblPremio.setBounds(29, 223, 61, 16);
		contentPane.add(lblPremio);
		
		textField = new JTextField();
		textField.setBounds(102, 51, 216, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 88, 216, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(102, 128, 216, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(102, 156, 216, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(102, 190, 216, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(102, 218, 216, 26);
		contentPane.add(textField_5);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin b = new VentanaAdmin(client, user);
				b.setVisible(true);
				CrearCarrera.this.setVisible(false);
				
				
			}
		});
		btnVolver.setBounds(327, 243, 117, 29);
		contentPane.add(btnVolver);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cambiar string a fecha
				
				try {
					Client.server.crearCarrear(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), Double.parseDouble(textField_4.getText()), Double.parseDouble(textField_5.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(327, 218, 117, 29);
		contentPane.add(btnNewButton);
	}
}
>>>>>>> 328beefb2293cb367ab32325f37fab085863fd1c:BSPQ19-S2-ander/ProyectoProcesos/src/main/java/es/deusto/client/CrearCarrera.java
