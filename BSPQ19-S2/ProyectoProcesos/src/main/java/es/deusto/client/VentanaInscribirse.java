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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInscribirse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public VentanaInscribirse(Client client, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSCRIPCIÓN DE CARRERA ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(108, 18, 244, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEmail.setBounds(46, 88, 61, 16);
		contentPane.add(lblEmail);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNombre.setBounds(46, 125, 75, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblApellido.setBounds(46, 162, 75, 16);
		contentPane.add(lblApellido);
		
		JLabel lblCdigo = new JLabel("Código ");
		lblCdigo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCdigo.setBounds(46, 200, 75, 16);
		contentPane.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(144, 84, 251, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 121, 251, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 158, 251, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 196, 251, 26);
		contentPane.add(textField_3);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenu a = new VentanaMenu(client, user);
				a.setVisible(true);
				VentanaInscribirse.this.setVisible(false);
			}
		});
		btnVolver.setBounds(17, 243, 117, 29);
		contentPane.add(btnVolver);
		
		JButton btnInscribirse = new JButton("Inscribirse");
		btnInscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInscribirse.setBounds(302, 243, 117, 29);
		contentPane.add(btnInscribirse);
	}
}
