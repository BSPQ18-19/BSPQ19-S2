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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;



public class VInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInicio frame = new VInicio(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VInicio(Client client) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 457, 229);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(50, 50));
		
		JPanel panel_Top = new JPanel();
		panel_Top.setBackground(Color.WHITE);
		panel.add(panel_Top, BorderLayout.NORTH);
		panel_Top.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("UD CYCLING");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 35));
		panel_Top.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel panel_MID = new JPanel();
		panel_MID.setBackground(Color.WHITE);
		panel.add(panel_MID, BorderLayout.CENTER);
		panel_MID.setLayout(new MigLayout("", "[100px][][35px][][95px][100px]", "[23px][][]"));
		
		JButton btnIniSesison = new JButton("Iniciar Sesion");
		btnIniSesison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VInicio.this.setVisible(false);
				VRegistro vR=new VRegistro(client, VInicio.this);
				vR.setVisible(true);
			}
		});
		btnIniSesison.setForeground(Color.black);
		btnIniSesison.setBackground(new Color(6, 50, 113));
		
		panel_MID.add(btnIniSesison, "cell 1 1,grow");
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setBackground(new Color(6, 50, 113));
		panel_MID.add(btnRegistrar, "cell 4 1,grow");
		
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VInicio.this.setVisible(false);
				
				VCrearUsuario vCr= new VCrearUsuario(client, VInicio.this);
				vCr.setVisible(true);
				
			}
		});
	}
	
	
}
