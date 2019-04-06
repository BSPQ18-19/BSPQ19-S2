package es.deusto.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.deusto.server.Server;
import es.deusto.server.jdo.Usuario;
import net.miginfocom.swing.MigLayout;


public class VCrearUsuario extends JFrame {


	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VInicio vI;
	private JTextField textField_usuario;
	private JPasswordField passwordField;
	private JTextField textField_email;
	private Usuario user;

	/**
	 * Create the frame.
	 * @param listaJugadores 
	 */
	public VCrearUsuario(Client client, VInicio ventanaanterior) {
		
		vI = ventanaanterior;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 464, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_Mid = new JPanel();
		panel_Mid.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_Mid, BorderLayout.CENTER);
		panel_Mid.setLayout(new MigLayout("", "[60px][][200px]", "[15px][25px][25px][25px][25px][25px]")); 

		JLabel lbl_Usuario = new JLabel("Usuario");
		panel_Mid.add(lbl_Usuario, "cell 1 1,alignx trailing");

		textField_usuario = new JTextField();
		panel_Mid.add(textField_usuario, "flowx,cell 2 1,growx");
		textField_usuario.setColumns(10);

		JLabel lbl_Password = new JLabel("Contraseña");
		panel_Mid.add(lbl_Password, "cell 1 3,growx");

		passwordField = new JPasswordField();
		panel_Mid.add(passwordField, "cell 2 3,growx");

		

		JPanel panel_TOP = new JPanel();
		panel_TOP.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_TOP, BorderLayout.NORTH);

		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Monospaced", Font.PLAIN, 29));
		panel_TOP.add(lblRegistro);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new MigLayout("", "[120px][][][][]", "[]"));

		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBackground(new Color(7, 46, 7));
		btn_Volver.setForeground( Color.BLACK);
		btn_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VCrearUsuario.this.setVisible(false);
				vI.setVisible(true);

			}
		});
		panel.add(btn_Volver, "cell 1 0");

		JButton btn_Registrarse = new JButton("Registrarse");
		btn_Registrarse.setBackground(new Color(7, 46, 113));
		btn_Registrarse.setForeground(Color.BLACK);
		panel.add(btn_Registrarse, "cell 3 0");
		btn_Registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = textField_usuario.getText();
				String contrasenya = String.valueOf(passwordField.getPassword());
				client.registrarUsuario(usuario, contrasenya);
				VCrearUsuario.this.setVisible(false);
				
				}
		});

	}
}