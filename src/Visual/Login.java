package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Clases.User;


public class Login extends JFrame {

	private JPanelBackground contentPane;
	private JTextField txtNom;
	private JPasswordField pass;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel label_1;
   
	
	//Patron Singleton
			private static Login log = null;
			private JButton btnCrear;
			public static Login getSingletonInstance(){
				if(log == null){
					log = new Login();
				}
				return log;
			}
	


	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}catch(Exception e){
			e.printStackTrace();
		}
		User usuario = new User("Rachel", "Lopez",  "RachelL", "[1, 2, 3, 4]");
		User.añadirUsuario(usuario);
		User.setUsuarioActual(usuario);
					Login frame = Login.getSingletonInstance();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
	}

	public Login() {
		 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(350,550);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/autenticacion.png")));
		setTitle("Sistema de Entrada");
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));	
		contentPane.setBackground("Imagenes/fondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(51, 51, 51));
		btnEntrar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreUsuario = txtNom.getText();
				User usuario = User.getUser(nombreUsuario);

				if(usuario == null)
					JOptionPane.showMessageDialog(null, "El usuario no existe", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
				else{
					String contraseniaUsuario = usuario.getContrasena();
					String contraseniaEscrita = Arrays.toString(pass.getPassword());

					if(!contraseniaUsuario.equals(contraseniaEscrita))
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
					else{
						User.setUsuarioActual(usuario);
						Menu menu = Menu.getSingletonInstance();
					    menu.setVisible(true);
					    try {
							menu.iniciarMenuPrincipal();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    menu.cerrarLogin();		
					}
				}
			}
		});
		btnEntrar.setBounds(130, 412, 88, 33);
		contentPane.add(btnEntrar);
		
	
		txtNom = new JTextField();
		txtNom.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtNom.setToolTipText("");
		txtNom.setForeground(new Color(255, 255, 255));
		txtNom.setOpaque(false);
		txtNom.setBackground(Color.DARK_GRAY);
		txtNom.setBounds(30, 254, 284, 27);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		
		pass = new JPasswordField();
		pass.setFont(new Font("Verdana", Font.PLAIN, 12));
		pass.setBackground(Color.DARK_GRAY);
		pass.setBounds(30, 340, 284, 27);
		pass.setForeground(SystemColor.textHighlightText);
		pass.setOpaque(false);
		contentPane.add(pass);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(30, 221, 72, 22);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblContrasea.setBounds(30, 306, 98, 23);
		contentPane.add(lblContrasea);
		
		label_1 = new JLabel("");
		label_1.setBounds(86, 11, 200, 199);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/avatar.png")));
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Registro reg = Registro.getSingletonInstance();
				    reg.setVisible(true);
				    reg.iniciarRegistro(); 
				    reg.cerrarLogin();	
			}
		});
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCrear.setBackground(new Color(102, 102, 102));
		btnCrear.setBounds(246, 477, 88, 33);
		contentPane.add(btnCrear);
		
		JLabel lblnoTienesUn = new JLabel("\u00BFNo tienes Cuenta?");
		lblnoTienesUn.setHorizontalAlignment(SwingConstants.CENTER);
		lblnoTienesUn.setForeground(Color.WHITE);
		lblnoTienesUn.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblnoTienesUn.setBounds(75, 483, 199, 23);
		contentPane.add(lblnoTienesUn);
		

	

	}

}
