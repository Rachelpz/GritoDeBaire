package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;






import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Creditos extends JFrame {
	private JPanelBackground contentPane;
	

	public Creditos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 550, 400);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/servicio-al-cliente (1).png")));
		setTitle("Créditos");
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground("Imagenes/abstract-background-with-geometric-mesh_1017-7686.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDesarrolladoPor = new JLabel("Desarrollado por:\r\n");
		lblDesarrolladoPor.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesarrolladoPor.setForeground(Color.BLACK);
		lblDesarrolladoPor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDesarrolladoPor.setBounds(10, 271, 132, 32);
		contentPane.add(lblDesarrolladoPor);
		
		JLabel lblRachelLpezRodrguez = new JLabel("Rachel L\u00F3pez Rodr\u00EDguez #18");
		lblRachelLpezRodrguez.setHorizontalAlignment(SwingConstants.CENTER);
		lblRachelLpezRodrguez.setForeground(Color.BLACK);
		lblRachelLpezRodrguez.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRachelLpezRodrguez.setBounds(131, 271, 216, 32);
		contentPane.add(lblRachelLpezRodrguez);
		
		JLabel lblVersin = new JLabel("Versi\u00F3n 1.0");
		lblVersin.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersin.setForeground(Color.BLACK);
		lblVersin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVersin.setBounds(197, 33, 132, 32);
		contentPane.add(lblVersin);
		
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
		button.setBounds(474, 314, 60, 46);
		contentPane.add(button);
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Creditos.class.getResource("/Imagenes/cujae2.png")));
		lblNewLabel.setBounds(453, 11, 81, 84);
		contentPane.add(lblNewLabel);
		
		JLabel lblFacultadDeIngeniera = new JLabel("Facultad de Ingenier\u00EDa Inform\u00E1tica");
		lblFacultadDeIngeniera.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacultadDeIngeniera.setForeground(new Color(255, 204, 0));
		lblFacultadDeIngeniera.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFacultadDeIngeniera.setBounds(113, 190, 314, 32);
		contentPane.add(lblFacultadDeIngeniera);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(233, 102, 88, 84);
		contentPane.add(label_2);
		label_2.setIcon(new ImageIcon(Creditos.class.getResource("/Imagenes/ORCA.png")));
		
		JLabel label_3 = new JLabel("GritoDe");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.CYAN);
		label_3.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		label_3.setBounds(176, 16, 123, 32);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Baire");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		label_4.setBounds(266, 16, 81, 32);
		contentPane.add(label_4);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				Menu.getSingletonInstance().setEnabled(true);
				dispose();
			}
		});
	}
	}

