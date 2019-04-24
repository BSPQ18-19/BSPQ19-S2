package es.deusto.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuAdministrador = new JLabel("Menu ");
		lblMenuAdministrador.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblMenuAdministrador.setBounds(163, 31, 183, 29);
		contentPane.add(lblMenuAdministrador);
		
		JButton btnVerCarrera = new JButton("Ver Carreras");
		btnVerCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnVerCarrera.setBounds(121, 105, 176, 29);
		contentPane.add(btnVerCarrera);
		
		btnVerCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaVer vv = new VentanaVer();
				vv.setVisible(true);
				VentanaMenu.this.setVisible(false);
			}
		});
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnVolver.setBounds(307, 217, 117, 29);
		contentPane.add(btnVolver);
	}
}
