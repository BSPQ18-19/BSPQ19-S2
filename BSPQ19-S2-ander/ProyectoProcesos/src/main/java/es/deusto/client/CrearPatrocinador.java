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

public class CrearPatrocinador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	public CrearPatrocinador(Client client, Usuario user ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearPatrocinador = new JLabel("CREAR PATROCINADOR ");
		lblCrearPatrocinador.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCrearPatrocinador.setBounds(97, 29, 208, 25);
		contentPane.add(lblCrearPatrocinador);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(38, 93, 61, 16);
		contentPane.add(lblCdigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(38, 137, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblContribucin = new JLabel("Contribución");
		lblContribucin.setBounds(38, 186, 97, 16);
		contentPane.add(lblContribucin);
		
		textField = new JTextField();
		textField.setBounds(147, 88, 158, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 132, 158, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 181, 158, 26);
		contentPane.add(textField_2);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin a = new VentanaAdmin(client, user);
				a.setVisible(true);
				CrearPatrocinador.this.setVisible(false);
			}
		});
		btnVolver.setBounds(25, 232, 117, 29);
		contentPane.add(btnVolver);
		
//		JButton btnCrear = new JButton("Crear");
//		btnCrear.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				client.crearPatrocinador(textField.getText(), textField_1.getText(), Double.parseDouble(textField_2.getText()));
//			}
//		});
//		btnCrear.setBounds(287, 232, 117, 29);
//		contentPane.add(btnCrear);
	}
}
