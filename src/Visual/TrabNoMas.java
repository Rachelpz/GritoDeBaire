package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Taller;
import Clases.Trabajador;

public class TrabNoMas extends JFrame {

	

	private JPanelBackground contentPane;
	private JTable table;
	private DefaultTableModel defaultTableModel;

	public TrabNoMas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/portapapeles.png")));
		setResizable(false);
		setTitle("Reporte 2");
		setBounds(400, 200, 580, 360);
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setBackground("Imagenes/abstract-connecting-dots-lines-with-geometric-background_41981-1270.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 29, 476, 217);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		setTitle("Lista de Trabajadores Que no pueden reparar más equipos por el momento. ");
		//title.setText("Lista de Trabajadores");
		LinkedList<Trabajador>t=Taller.getSingletonInstance().noPuedenMas();
		String [] titulo = {"Nombre","Identificacion"};
		Object [][] tabla = new Object[t.size()][titulo.length];
    	
		for(int fila = 0;fila<t.size();fila++){
			for(int columna = 0;columna<titulo.length;columna++){
				String nombreCelda = "";
				switch (columna) {
				case 0:
					nombreCelda = t.get(fila).getNombre();
					break;
				case 1:
					nombreCelda = t.get(fila).getIdent();
					break;
		
				}
				tabla[fila][columna] = nombreCelda;
			}
		}
		defaultTableModel = new DefaultTableModel(tabla, titulo);
		table.setModel(defaultTableModel);
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
		button.setBounds(499, 262, 60, 46);
		contentPane.add(button);
	}
}
