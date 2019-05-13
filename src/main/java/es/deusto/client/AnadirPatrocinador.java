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

public class AnadirPatrocinador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Create the frame.
	 */
	public AnadirPatrocinador(Client client,Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirPatrocinador = new JLabel("AÑADIR PATROCINADOR ");
		lblAadirPatrocinador.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAadirPatrocinador.setBounds(103, 33, 217, 16);
		contentPane.add(lblAadirPatrocinador);
		
		JLabel lblCodigoCarrera = new JLabel("Codigo carrera ");
		lblCodigoCarrera.setBounds(35, 102, 96, 16);
		contentPane.add(lblCodigoCarrera);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(35, 142, 96, 16);
		contentPane.add(lblNombre);
		
		JLabel lblContribucin = new JLabel("Contribución");
		lblContribucin.setBounds(35, 184, 96, 16);
		contentPane.add(lblContribucin);
		
		textField = new JTextField();
		textField.setBounds(174, 97, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 142, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(174, 179, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(313, 232, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin va = new VentanaAdmin(client,user);
				va.setVisible(true);
				AnadirPatrocinador.this.setVisible(false);
			}
		});
		btnVolver.setBounds(14, 232, 117, 29);
		contentPane.add(btnVolver);
	}

}
