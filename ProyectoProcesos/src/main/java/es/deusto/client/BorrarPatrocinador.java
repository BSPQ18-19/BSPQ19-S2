package es.deusto.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.server.jdo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrarPatrocinador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	public BorrarPatrocinador(Client client,Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBorrar = new JLabel("BORRAR ");
		lblBorrar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblBorrar.setBounds(173, 35, 76, 16);
		contentPane.add(lblBorrar);
		
		textField = new JTextField();
		textField.setBounds(214, 103, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 158, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombrePatrocinador = new JLabel("Nombre Patrocinador ");
		lblNombrePatrocinador.setBounds(36, 108, 151, 16);
		contentPane.add(lblNombrePatrocinador);
		
		JLabel lblCodigoCarrera = new JLabel("Codigo carrera");
		lblCodigoCarrera.setBounds(36, 163, 97, 16);
		contentPane.add(lblCodigoCarrera);
		
		JButton btnBorrar = new JButton("Borrar ");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				client.BorrarPatrocinador(textField.getText(), textField_1.getText());
			}
		});
		btnBorrar.setBounds(315, 232, 117, 29);
		contentPane.add(btnBorrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin va= new VentanaAdmin(client,user);
				va.setVisible(true);
				BorrarPatrocinador.this.setVisible(false);
			}
		});
		btnVolver.setBounds(36, 232, 117, 29);
		contentPane.add(btnVolver);
	}

}
