package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import Clases.Equipo;
import Clases.Taller;
import Clases.TipoEquipo;
import Clases.Trabajador;
import Logica.Validaciones;


public class AñadirEq extends JFrame {

	private JPanelBackground contentPane;
	//Patron Singleton
			private static AñadirEq eq= null;
			private JTextField textField;
			private JRadioButton rdbtnNewRadioButton_2; 
			private JRadioButton rdbtnNewRadioButton; 
			private JRadioButton rdbtnNewRadioButton_1; 
			private JRadioButton rdbtnNewRadioButton_3; 
			private JRadioButton rdbtnNewRadioButton_4; 
			private JTextField textField_1;
			private JTextField textField_2;
			public static AñadirEq getSingletonInstance(){
				if(eq == null){
					eq = new AñadirEq();
				}
				return eq;
			}
	public AñadirEq() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/portapapeles.png")));
		setResizable(false);
		setTitle("Añadir Equipo");
		setBounds(400, 200, 580, 260);
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setBackground("Imagenes/abstract-connecting-dots-lines-with-geometric-background_41981-1270.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNoSerie = new JLabel("No. Serie");
		lblNoSerie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoSerie.setBounds(15, 16, 102, 20);
		contentPane.add(lblNoSerie);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMarca.setBounds(15, 52, 69, 20);
		contentPane.add(lblMarca);
		
		JLabel lblTipoDeEquipo = new JLabel("Tipo De Equipo:");
		lblTipoDeEquipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeEquipo.setBounds(15, 121, 145, 20);
		contentPane.add(lblTipoDeEquipo);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(15, 85, 102, 20);
		contentPane.add(lblDescripcion);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(111, 14, 170, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setBounds(111, 50, 170, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Lavadora");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBounds(15, 153, 170, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Televisor");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_1.setBounds(192, 153, 170, 29);
		contentPane.add(rdbtnNewRadioButton_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setBounds(111, 85, 170, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Refrigeraci\u00F3n");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_2.setBounds(369, 153, 170, 29);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("Aire");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_3.setBounds(15, 190, 170, 29);
		contentPane.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("Cocina");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_4.setBounds(192, 190, 170, 29);
		contentPane.add(rdbtnNewRadioButton_4);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);  
		bg.add(rdbtnNewRadioButton_2);  bg.add(rdbtnNewRadioButton_3);  bg.add(rdbtnNewRadioButton_4);  
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String marca=textField_1.getText();
				String serie = textField.getText();
				String desc=textField_2.getText();
		    	TipoEquipo tipo = null;
		    	
		    	if(serie.length()!=0){
		    		if(Validaciones.getSingletonInstance().NombreValido(serie)){
		    			if(marca.length()!=0){
		    	    		if(Validaciones.getSingletonInstance().NombreValido(marca)){
		    	    			if(serie.length()!=0){
		    			    		if(Validaciones.getSingletonInstance().NombreValido(serie)){
		    	    			if(rdbtnNewRadioButton.isSelected()){
		    	    				tipo=TipoEquipo.LAVADORA;
		    	    			}else if(rdbtnNewRadioButton_1.isSelected())
		    	    				tipo=TipoEquipo.TELEVISOR;
		    	    				else if(rdbtnNewRadioButton_2.isSelected())		    	    				
		    	    				tipo=TipoEquipo.REFRIGERACION;
		    	    				else if(rdbtnNewRadioButton_3.isSelected())
		    	    				tipo=TipoEquipo.AIRE;
		    	    				else if(rdbtnNewRadioButton_4.isSelected()){	    	    				
		    	    				tipo=TipoEquipo.COCINA;
		    	    								    	    				
		    	    				}
		    	    			else
		    	    				JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un tipo");
		    	    			
		    	    			Equipo eq=new Equipo(serie, marca, tipo, desc);
		    	    			if(Taller.getSingletonInstance().hayOp(eq)){
	    	    				Taller.getSingletonInstance().getEquiposRotos().add(eq);
	    	    				JOptionPane.showMessageDialog(rootPane, "Se ha Introducido satisfactoriamente");
	    	    				Menu.getSingletonInstance().setEnabled(true);
	    	    				dispose();
		    	    			}else
		    	    				JOptionPane.showMessageDialog(rootPane, "No hay operarios disponibles para este tipo de equipo");
		    			    		}else
		    			    			JOptionPane.showMessageDialog(rootPane, "Descripcion inválida");
		    	    			}else
		    	    				JOptionPane.showMessageDialog(rootPane, "Ingrese una Descripcion");
		    			    		}else
		    	        		JOptionPane.showMessageDialog(rootPane, "Marca inválida");
		    	    		}else
		    	        		JOptionPane.showMessageDialog(rootPane, "Ingrese una Marca");
		    		}else
		    			JOptionPane.showMessageDialog(rootPane, "No. Serie invalido");
		    		}else
		        		JOptionPane.showMessageDialog(rootPane, "Ingrese un No. Serie");
		    	
				
				
			}
		});
		btnAadir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAadir.setBounds(386, 43, 115, 62);
		contentPane.add(btnAadir);
		
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
		button.setBounds(514, 173, 60, 46);
		contentPane.add(button);
	}
}
