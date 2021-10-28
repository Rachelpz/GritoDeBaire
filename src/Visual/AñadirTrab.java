package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Clases.Operario;
import Clases.Taller;
import Clases.Trabajador;
import Logica.Validaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AñadirTrab extends JFrame {

	private JPanelBackground contentPane;

	//Patron Singleton
	private static AñadirTrab t= null;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	public static AñadirTrab getSingletonInstance(){
		if(t == null){
			t = new AñadirTrab();
		}
		return t;
	}
	public AñadirTrab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/portapapeles.png")));
		setResizable(false);
		setTitle("Añadir Trabajador");
		setBounds(400, 200, 480, 310);
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setBackground("Imagenes/abstract-connecting-dots-lines-with-geometric-background_41981-1270.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(15, 16, 94, 20);
		contentPane.add(lblNombre);
		
		JLabel lblIdentificacin = new JLabel("Identificaci\u00F3n");
		lblIdentificacin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdentificacin.setBounds(15, 49, 117, 20);
		contentPane.add(lblIdentificacin);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEdad.setBounds(15, 85, 69, 20);
		contentPane.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSexo.setBounds(15, 121, 69, 20);
		contentPane.add(lblSexo);
		
		JLabel lblExperiencia = new JLabel("Experiencia");
		lblExperiencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExperiencia.setBounds(15, 157, 94, 20);
		contentPane.add(lblExperiencia);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(138, 14, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setBounds(138, 47, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBounds(138, 117, 146, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Femenino");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_1.setBounds(288, 117, 175, 29);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);    
		  
		
		SpinnerModel spinnerModel = new SpinnerNumberModel(18, //initial value
		         18, //min
		         100, //max
		         1);//step
		spinner = new JSpinner(spinnerModel);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinner.setBounds(138, 83, 50, 26);
		
		contentPane.add(spinner);
		SpinnerModel spinnerModel1 = new SpinnerNumberModel(0, //initial value
		        0, //min
		         80, //max
		         1);//step
		spinner_1 = new JSpinner(spinnerModel1);
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinner_1.setBounds(138, 155, 50, 26);
		contentPane.add(spinner_1);
		
		JLabel lblCantidadEquiposEspera = new JLabel("Cantidad Equipos Espera");
		lblCantidadEquiposEspera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadEquiposEspera.setBounds(15, 193, 216, 20);
		contentPane.add(lblCantidadEquiposEspera);
		SpinnerModel spinnerMode2 = new SpinnerNumberModel(1, //initial value
		         1, //min
		         100, //max
		         1);//step
		
		spinner_2 = new JSpinner(spinnerMode2);
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinner_2.setBounds(234, 190, 50, 26);
		contentPane.add(spinner_2);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ident=textField_1.getText();
				String nombre = textField.getText();
		    	int edad = (Integer) spinner.getValue();
		    	int exp= (Integer) spinner_1.getValue();
		    	int cant=(Integer) spinner_2.getValue();
		    	char sexo = 0;
		    	if(nombre.length()!=0){
		    		if(Validaciones.getSingletonInstance().NombreValido(nombre)){
		    			if(ident.length()!=0){
		    	    		if(Validaciones.getSingletonInstance().NombreValido(ident)){
		    	    			if(rdbtnNewRadioButton.isSelected()){
		    	    				sexo='M';
		    	    			}else if(rdbtnNewRadioButton_1.isSelected()){
		    	    				sexo='F';
		    	    				
		    	    			}
		    	    			else
		    	    				JOptionPane.showMessageDialog(rootPane, "Debe seleccionar sexo");
		    	    			Trabajador trab=new Operario(nombre, ident, edad, sexo, exp, cant, null, null);
	    	    				Taller.getSingletonInstance().getTrabajadores().add(trab);
	    	    				JOptionPane.showMessageDialog(rootPane, "Se ha Introducido satisfactoriamente");
	    	    				Menu.getSingletonInstance().setEnabled(true);
	    	    				dispose();
		    	    		}else
		    	        		JOptionPane.showMessageDialog(rootPane, "Identificación inválida");
		    	    		}else
		    	        		JOptionPane.showMessageDialog(rootPane, "Ingrese una identificación");
		    		}else
		    			JOptionPane.showMessageDialog(rootPane, "Nombre invalido");
		    		}else
		        		JOptionPane.showMessageDialog(rootPane, "Ingrese un nombre");
		    	
		    	
		    	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(171, 229, 108, 31);
		contentPane.add(btnNewButton);
		
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.getSingletonInstance().setEnabled(true);
				dispose();
			}
		});
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon(InfoUtil.class.getResource("/Imagenes/OUT.png")));
		button.setBounds(403, 214, 60, 46);
		contentPane.add(button);
		
		
	
	}
}
