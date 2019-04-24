package es.deusto.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Address;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.deusto.server.jdo.Usuario;
import net.miginfocom.swing.MigLayout;

public class VRegistro extends JFrame {

	private JPanel contentPane;

	private JTextField textField;
	private JPasswordField passwordField;
	private static Logger log;
	private Client client;
	public static String nomfich;
	private Usuario u;

	/**
	 * Create the frame.
	 */
	public VRegistro(Client client, VInicio vinicio) {
		this.client = client;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 524, 303);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 25));
		setContentPane(contentPane);

		JPanel panel_Mid = new JPanel();
		panel_Mid.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_Mid, BorderLayout.CENTER);
		panel_Mid.setLayout(new MigLayout("", "[125px][344px][100px]", "[30px][30px][30px][23px]"));

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_Mid.add(lblUsuario, "cell 0 0,grow");

		textField = new JTextField();
		panel_Mid.add(textField, "cell 1 0,grow");
		textField.setColumns(10);

		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Mid.add(lblContrasenya, "cell 0 1,alignx right,growy");

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_Mid.add(passwordField, "cell 1 1,growx,aligny center");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblIniciarSesion = new JLabel("INICIAR SESION");
		lblIniciarSesion.setFont(new Font("Monospaced", Font.PLAIN, 29));
		panel.add(lblIniciarSesion);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new MigLayout("", "[180px][63px][95px][150]", "[23px]"));

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(6, 50, 113));
		btnVolver.setForeground(Color.BLACK);
		panel_1.add(btnVolver, "cell 1 0,alignx left,aligny top");
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vinicio.setVisible(true);
				VRegistro.this.setVisible(false);
			}
		});

		JButton btnHasOlvidadoLa = new JButton("\u00BFHas olviado la contrase\u00F1a?");
		btnHasOlvidadoLa.setBackground(new Color(6, 50, 113));
		btnHasOlvidadoLa.setForeground(Color.BLACK);

		btnHasOlvidadoLa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String mail = JOptionPane.showInputDialog("Escribe tu mail");

				// String pass = BD.olvidarContra(contra);

					enviarCorreo(mail);
				
			}

		});
		panel_Mid.add(btnHasOlvidadoLa, "cell 1 3,alignx center,aligny center");

		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBackground(new Color(6, 50, 113));
		btnIniciarSesion.setForeground(Color.BLACK);
		panel_1.add(btnIniciarSesion, "cell 2 0,alignx left,aligny top");
		btnIniciarSesion.addActionListener(new ActionListener() {

			/*
			 * Boton iniciar sesion Comprueba en la base de datos si existe el usuario, si
			 * existe llama a la ventana principal sino mensaje de error
			 * 
			 */

			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = textField.getText();
				System.out.println(usuario);
				String contrasenya = String.valueOf(passwordField.getPassword());
				Usuario user = client.iniciarSesion(usuario, contrasenya);
				if (user != null) {
					//JOptionPane.showMessageDialog(VRegistro.this, "Inicio Sesion Correcto");

					//Esto deberia de ir pero na
					
//					if (u.isAdmin() == true) {
//						VentanaAdmin b = new VentanaAdmin();
//						b.setVisible(true);
//						VRegistro.this.setVisible(false);
//					} else {
//					VentanaMenu a = new VentanaMenu();
//					a.setVisible(true);
//					VRegistro.this.setVisible(false);
//					}
					
					VentanaAdmin b = new VentanaAdmin();
					b.setVisible(true);
					VRegistro.this.setVisible(false);
					
				} else {
					JOptionPane.showMessageDialog(VRegistro.this, "Inicio Sesion Inorrecto");
				}
			}
		});

	}

	/**
	 * Metodo que envia la contraseña olvidada al correo correspondiente
	 */

//	public void enviarCorreo(
//             String mail) throws AddressException,
//            MessagingException {
//
//		//Sacar contraseña
//		
//		String pass = client.sacarContra(mail);
//		
//        // sets SMTP server properties
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", 587);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//// *** BEGIN CHANGE
//        properties.put("mail.smtp.user", "udcycling98@gmail.com");
//
//        // creates a new session, no Authenticator (will connect() later)
//        Session session = Session.getDefaultInstance(properties);
//// *** END CHANGE
//
//        // creates a new e-mail message
//        Message msg = new MimeMessage(session);
//
//        msg.setFrom(new InternetAddress("udcycling98@gmail.com"));
//        InternetAddress[] toAddresses = { new InternetAddress(mail) };
//        msg.setRecipients(Message.RecipientType.TO, toAddresses);
//        msg.setSubject("Recuperación de contraseña");
//        // set plain text message
//        msg.setText("Su contraseña es: " + "\n" + "	" + pass + "\n" + "\n" + "\n" + "El Equipo de UD CYCLING");
//
//// *** BEGIN CHANGE
//        // sends the e-mail
//        Transport t = session.getTransport("smtp");
//        t.connect("udcycling98@gmail.com", "procesos");
//        t.sendMessage(msg, msg.getAllRecipients());
//        t.close();
//// *** END CHANGE
//
//    }
	
	
	private void enviarCorreo(String mail) {

		// El correo gmail de envÌo
		String correoEnvia = "udcycling98@gmail.com";
		String claveCorreo = "procesos";

		// La configuraciÛn para enviar correo
		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.user", correoEnvia);
		properties.put("mail.password", claveCorreo);

		// Obtener la sesion
		Session session = Session.getInstance(properties, null);
		int aviso = 0;

		String pass = client.sacarContra(mail);
		if (pass.equals(null)) {
			JOptionPane.showMessageDialog(null, "Correo electronico no existe");

		} else {
			try {
				// Crear el cuerpo del mensaje
				MimeMessage mimeMessage = new MimeMessage(session);

				// Agregar quien envÌa el correo
				mimeMessage.setFrom(new InternetAddress(correoEnvia, "UD CYCLING"));

				// Los destinatarios
				InternetAddress[] internetAddresses = { new InternetAddress(mail) };

				// Agregar los destinatarios al mensaje
				mimeMessage.setRecipients(Message.RecipientType.TO, internetAddresses);

				// Agregar el asunto al correo
				mimeMessage.setSubject("Recuperación de contraseña");

				// Creo la parte del mensaje
				MimeBodyPart mimeBodyPart = new MimeBodyPart();
				mimeBodyPart.setText(
						"Su contraseña es: " + "\n" + "	" + pass + "\n" + "\n" + "\n" + "El Equipo de UD CYCLING");
				// Crear el multipart para agregar la parte del mensaje anterior
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(mimeBodyPart);
				// multipart.addBodyPart(mimeBodyPartAdjunto);

				// Agregar el multipart al cuerpo del mensaje
				mimeMessage.setContent(multipart);

				// Enviar el mensaje
				Transport transport = session.getTransport("smtp");
				transport.connect(correoEnvia, claveCorreo);
				transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

				transport.close();

			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				aviso = 1;
			}
			if (aviso == 0) {
				JOptionPane.showMessageDialog(null, "Correo electronico enviado exitosamente");
				log.log(Level.INFO, "Correo de recuperación de contraseña enviado");
			}

		}
		
		
		
	}

}
