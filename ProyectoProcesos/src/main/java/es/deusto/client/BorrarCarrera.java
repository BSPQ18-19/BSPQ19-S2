package es.deusto.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.server.Server;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrarCarrera extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public BorrarCarrera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBorrarCarreras = new JLabel("Borrar Carreras");
		lblBorrarCarreras.setBounds(130, 20, 203, 25);
		lblBorrarCarreras.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblBorrarCarreras);
		
		JLabel lblCodigoDeLa = new JLabel("Codigo de la Carrera");
		lblCodigoDeLa.setBounds(37, 116, 128, 16);
		contentPane.add(lblCodigoDeLa);
		
		textField = new JTextField();
		textField.setBounds(226, 111, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBorrar.setBounds(48, 209, 117, 29);
		contentPane.add(btnBorrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin a = new VentanaAdmin();
				a.setVisible(true);
				BorrarCarrera.this.setVisible(false);
			}
		});
		btnVolver.setBounds(252, 209, 117, 29);
		contentPane.add(btnVolver);
	}

}
