
package es.deusto.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.server.jdo.Usuario;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrarParticipante extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public BorrarParticipante(Client client, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BORRAR PARTICIPATES");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(90, 28, 221, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEmail.setBounds(44, 107, 61, 16);
		contentPane.add(lblEmail);
		
		JLabel lblCodigoCarrera = new JLabel("Codigo carrera ");
		lblCodigoCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCodigoCarrera.setBounds(44, 171, 143, 16);
		contentPane.add(lblCodigoCarrera);
		
		textField = new JTextField();
		textField.setBounds(148, 103, 208, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 167, 175, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.BorrarPartcipante(textField_1.getText(), textField.getText());
			}
		});
		btnBorrar.setBounds(306, 230, 117, 29);
		contentPane.add(btnBorrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin va= new VentanaAdmin(client,user);
				va.setVisible(true);
				BorrarParticipante.this.setVisible(false);
			}
		});
		btnVolver.setBounds(19, 230, 117, 29);
		contentPane.add(btnVolver);
	}

}
