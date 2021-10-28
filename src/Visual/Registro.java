package Visual;


import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import Clases.User;
import Logica.Validaciones;


public class Registro extends JFrame {

	private JPanelBackground contentPane;
	
			private static Registro reg = null;
			private JTextField textField;
			private JTextField textField_1;
			private JTextField textField_2;
			private JPasswordField pass;
			private JLabel lblError;
			private JLabel lblError1;
			private JLabel lblError2;
			private JLabel label1;
			private JLabel label;
			private JLabel lblNombre;
			private JLabel lblPrimerApellido;
			private JLabel label_1;
			private JLabel lblConfirmarContrasea;
			private JPasswordField pass1;
			private boolean nombreUsuarioValido = false;
			
			
			//Patron Singleton
			public static Registro getSingletonInstance(){
				if(reg == null){
					reg = new Registro();
				}
				return reg;
			}
			public void iniciarRegistro() {
				reg.setLocationRelativeTo(null);
			
			}
			public void cerrarLogin(){
				Login.getSingletonInstance().dispose();
			}
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,550);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/autenticacion.png")));
		setTitle("Sistema de Registro");
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));	
		contentPane.setBackground("Imagenes/fondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1 = new JLabel("");
		label1.setBounds(86, 11, 169, 172);
		contentPane.add(label1);
		label1.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/agregar-usuario (2).png")));
		
		label = new JLabel("Usuario");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 12));
		label.setBounds(30, 274, 60, 22);
		contentPane.add(label);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNombre.setBounds(30, 208, 60, 22);
		contentPane.add(lblNombre);
		
		lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrimerApellido.setForeground(Color.WHITE);
		lblPrimerApellido.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPrimerApellido.setBounds(186, 208, 128, 22);
		contentPane.add(lblPrimerApellido);
		
		label_1 = new JLabel("Contrase\u00F1a");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		label_1.setBounds(30, 340, 88, 23);
		contentPane.add(label_1);
		
		lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarContrasea.setForeground(Color.WHITE);
		lblConfirmarContrasea.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblConfirmarContrasea.setBounds(30, 407, 181, 23);
		contentPane.add(lblConfirmarContrasea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {

					char caracter = tecla.getKeyChar();
					boolean valido = Validaciones.caracterValido(caracter);

					if(!valido){
						lblError1.setText("Solo puede contener letras");
						tecla.consume();
					}
					else
						lblError1.setText("");
				}
			}
		);
		textField.setToolTipText("");
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Verdana", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(30, 241, 128, 22);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
			
	
					char caracter = tecla.getKeyChar();
					boolean valido = Validaciones.caracterValido(caracter);

					if(!valido){
						lblError2.setText("Solo puede contener letras");
						tecla.consume();
					}
					else
						lblError2.setText("");
				}
			}
		);
		textField_1.setToolTipText("");
		textField_1.setOpaque(false);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(186, 241, 128, 22);
		contentPane.add(textField_1);
		lblError1 =new JLabel("");
		lblError1.setForeground(Color.RED);
		lblError1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblError1.setBounds(30, 225, 182, 17);
		contentPane.add(lblError1);
		
		lblError2 =new JLabel("");
		lblError2.setForeground(Color.RED);
		lblError2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblError2.setBounds(186, 225, 182, 17);
		contentPane.add(lblError2);;
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblError.setBounds(29, 291, 182, 17);
		contentPane.add(lblError);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				String nombreUsuario = textField_2.getText();
				char caracter = tecla.getKeyChar();
				
					if(nombreUsuario.length() == 0 && caracter == ' '){
						lblError.setText("No puede empezar con espacio");
						tecla.consume();
					}
					else{
						int valorASCII = (int)caracter;

						if(valorASCII >= 32 && valorASCII != 127){
							nombreUsuario = nombreUsuario + caracter;
							User usuario = User.getUser(nombreUsuario);

							if(usuario != null){
								lblError.setText("El usuario ya existe");
								nombreUsuarioValido = false;
							}
							else{
								lblError.setText("");
								nombreUsuarioValido = true;
							}

						}
						else{
							User usuario = User.getUser(nombreUsuario);

							if(usuario != null){
								lblError.setText("El usuario ya existe");
								nombreUsuarioValido = false;
							}
							else{
								lblError.setText("");
								nombreUsuarioValido = true;
							}
						}
					}
				}
			}
		);
		textField_2.setToolTipText("");
		textField_2.setOpaque(false);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.DARK_GRAY);
		textField_2.setBounds(30, 307, 284, 22);
		contentPane.add(textField_2);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Verdana", Font.PLAIN, 12));
		pass.setBackground(Color.DARK_GRAY);
		pass.setBounds(30, 441, 284, 22);
		pass.setForeground(SystemColor.textHighlightText);
		pass.setOpaque(false);
		contentPane.add(pass);
		
		pass1 = new JPasswordField();
		pass1.setFont(new Font("Verdana", Font.PLAIN, 12));
		pass1.setBackground(Color.DARK_GRAY);
		pass1.setBounds(30, 374, 284, 22);
		pass1.setForeground(SystemColor.textHighlightText);
		pass1.setOpaque(false);
		contentPane.add(pass1);
		
		JButton btnCrear = new JButton("Crear");
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textField.getText();
				String primerApellido =textField_1.getText();
				String nombreUsuario = textField_2.getText();
				String contrasenia = Arrays.toString(pass.getPassword());
				String contraseniaRepetida = Arrays.toString(pass1.getPassword());
				boolean vacio = nombre.isEmpty() || primerApellido.isEmpty() || nombreUsuario.isEmpty() 
						|| contrasenia.isEmpty() || contraseniaRepetida.isEmpty();
				if(vacio)
					JOptionPane.showMessageDialog(null, "Por favor introduzca todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
				else if(!contrasenia.equals(contraseniaRepetida))
					JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales", "Error", JOptionPane.ERROR_MESSAGE);
				else if(nombreUsuario.charAt(nombreUsuario.length() - 1) == ' ')
					JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener espacios al final", "Error", JOptionPane.ERROR_MESSAGE);
				else if(!nombreUsuarioValido)
					JOptionPane.showMessageDialog(null, "Datos no válidos. Verifique los datos introducidos.", "Error", JOptionPane.ERROR_MESSAGE);
				else{
					int entrada = JOptionPane.showConfirmDialog(null, "¿Está seguro que todos los datos son correctos?", "Seleccione una opción",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if(entrada == 0){
						nombre = Validaciones.ponerEnMayuscula(nombre);
						primerApellido = Validaciones.ponerEnMayuscula(primerApellido);
						User usuario = new User(nombre, primerApellido,  nombreUsuario, contrasenia);
						User.añadirUsuario(usuario);
						User.setUsuarioActual(User.getUser(nombreUsuario));
						dispose();
						Login log = Login.getSingletonInstance();
					    log.setVisible(true);
						
					}
				}
			}
		});
	
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCrear.setBackground(new Color(51, 51, 51));
		btnCrear.setBounds(226, 477, 88, 33);
		contentPane.add(btnCrear);
	}
}

