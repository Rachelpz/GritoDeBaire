package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import Clases.Taller;
import Logica.Inicializar;
import Logica.LogicaMenu;




public class Menu extends JFrame {
	
	private JPanelBackground contentPane;
	private JScrollPane scrollPane;
	private int seleccionar;
	private JTable table;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	//Patron Singleton
			private static Menu menuPrinc = null;
			
			
			public static Menu getSingletonInstance(){
				if(menuPrinc == null){
					menuPrinc = new Menu();
				}
				return menuPrinc;
			}
			
			public void iniciarMenuPrincipal() throws IOException {
				
				Inicializar.getSingletonInstance().IniciarDatos();
			
				Menu.getSingletonInstance().iniciarTable(0, "Añadir", 2);
				//LogicaMenu.getSingletonInstance().buscarPass();
				menuPrinc.setLocationRelativeTo(null);
			}
			public void cerrarLogin(){
				Login.getSingletonInstance().dispose();
			}
			public void iniciarTable(int menu,String name,int cant){
					String[] lista = {name};
					Object[][] tab = new Object[cant][lista.length];
					for(int i = 0;i<cant;i++){
						tab[i][lista.length-1] = LogicaMenu.getSingletonInstance().nombreElecc(menu).get(i);
					}
					defaultTableModel = new DefaultTableModel(tab, lista);
					table.setModel(defaultTableModel);
					seleccionar = menu;
				}

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(540,325);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/scienceandfiction-clean_99231.png")));
		setTitle("Sistema de Entrada");
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));	
		contentPane.setBackground("Imagenes/abstract-connecting-dots-lines-with-geometric-background_41981-1270.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		String fecha  = Calendar.getInstance().getTime().toString();
		getContentPane().setLayout(null);
		JLabel lblHola = new JLabel(fecha);
		lblHola.setBounds(10, 280, 219, 16);
		lblHola.setFont(new Font("Tahoma", Font.BOLD, 10));
		getContentPane().add(lblHola);
		
		
		JLabel lblNewLabel = new JLabel("Bienvenido(a)");
		lblNewLabel.setBounds(402, 34, 132, 32);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarTable(0, "Añadir", 2);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setPressedIcon(new ImageIcon(Menu.class.getResource("/Imagenes/arte-y-diseno.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/arte-y-diseno.png")));
		btnNewButton.setBounds(10, 11, 48, 46);
		btnNewButton.setToolTipText("Añadir");
		btnNewButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		btnNewButton.setHorizontalTextPosition(AbstractButton.CENTER);
		
		
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarTable(1, "Reportes", 3);
			}
		});
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setActionCommand("");
		btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/graficas.png")));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setToolTipText("Reportes");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(68, 11, 48, 46);
		
		
		
		JButton btnNewButton_2 = new JButton("");
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Taller.getSingletonInstance().crearEncabezamiento();
					Taller.getSingletonInstance().actualizarOperarios();
					JOptionPane.showMessageDialog(rootPane, "Fichero actualizado satisfactoriamente");
					JOptionPane.showMessageDialog(rootPane,"Quedaron pendientes por asignar: "+ Taller.getSingletonInstance().getPendientes().size()+" equipos");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/lista (1).png")));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setToolTipText("Listados");
		btnNewButton_2.setBounds(126, 11, 48, 46);
		
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(false);
				InfoUtil info = new InfoUtil();
				info.setVisible(true);
			}
		});
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/Info.png")));
		btnNewButton_4.setBounds(476, 239, 48, 46);
		btnNewButton_4.setToolTipText("Información");
		getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("");
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(false);
				Creditos creditos = new Creditos();
				creditos.setVisible(true);
			}
		});
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/Creditos.png")));
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setBounds(184, 11, 48, 46);
		
		btnNewButton_5.setToolTipText("Créditos");
		
		
		JLabel lblNewLabel_1 = new JLabel("GritoDe");
		lblNewLabel_1.setBounds(353, 11, 123, 32);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Baire");
		lblNewLabel_2.setBounds(443, 11, 81, 32);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.black);
		lblNewLabel_2.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_5);
		
		
		
		
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setLocation(242, 11);
		btnNewButton_6.setSize(48, 46);
		contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_6.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/salida.png")));
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setFocusPainted(false);
		btnNewButton_6.setBorderPainted(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 69, 294, 200);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(245, 245, 245));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setEnabled(false);
				switch(seleccionar){
				case 0:
					if(table.getSelectedRow()==0){
						AñadirEq reserva = AñadirEq.getSingletonInstance();
						reserva.setVisible(true);
						
						
					}else{
						if(table.getSelectedRow()==1){
							AñadirTrab traba = AñadirTrab.getSingletonInstance();
							traba.setVisible(true);
						}
					}
					break;
					
				/*case 2:
					switch (table.getSelectedRow()) {
					case 0:
						CrearJFrame('a');
						break;
					case 1:
						CrearJFrame('b');
						break;
					case 2:
						CrearJFrame('c');
						break;
					case 3:
						CrearJFrame('d');
						break;
					case 4:
						CrearJFrame('e');
						break;
					case 5:
						CrearJFrame('f');
						break;
					case 6:
						CrearJFrame('g');
						break;
					}
					break;*/
					
				case 1:
					
					switch (table.getSelectedRow()) {
					case 0:
						setEnabled(false);
						TrabNoMas trabNM= new TrabNoMas();
						trabNM.setVisible(true);
						
						
					
						
						//destpas.InicioFuncion3();

						break;
					case 1:

						setEnabled(false);
						TrabCadaT trabCT=new TrabCadaT();
						trabCT.setVisible(true);
						//resvE.InicioFuncion4();
						break;
					case 2:
						setEnabled(false);
						TrabTodosT todT= new TrabTodosT();
						todT.setVisible(true);
						
						//Viacat.inicioFuncion2();
						//Viacat.funcion2();
			
						break;
					
				}
					break;
				}
			}
		});
		setEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDropMode(DropMode.ON);
		scrollPane.setViewportView(table);
	}
}
