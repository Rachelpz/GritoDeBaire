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




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoUtil extends JFrame {

	private JPanelBackground contentPane;
	private JButton button;

	
	public InfoUtil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 500, 350);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/infoME.png")));
		setTitle("Información Útil");
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground("Imagenes/white-background-with-shiny-mesh_1017-7683.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSolicitaChoferesPara = new JLabel("Pasos para A\u00F1adir Trabajadores:\r\n");
		lblSolicitaChoferesPara.setBounds(8, 11, 374, 26);
		lblSolicitaChoferesPara.setForeground(new Color(0, 102, 102));
		lblSolicitaChoferesPara.setFont(new Font("Javanese Text", Font.PLAIN, 18));
		contentPane.add(lblSolicitaChoferesPara);
		
		
		JLabel lblChoferDemnibus = new JLabel("1- Dirigirse a la Pesta\u00F1a A\u00F1adir y Buscar Trabajador");
		lblChoferDemnibus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChoferDemnibus.setBounds(8, 42, 338, 24);
		contentPane.add(lblChoferDemnibus);
		
		JLabel lblChoferDemnibus_1 = new JLabel("2- Introducir Los Datos");
		lblChoferDemnibus_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChoferDemnibus_1.setBounds(8, 77, 328, 24);
		contentPane.add(lblChoferDemnibus_1);
		
		JLabel lblMantenerUnaBuena = new JLabel("1- Verifique que cuenta con la versi\u00F3n 1.0\r\n");
		lblMantenerUnaBuena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMantenerUnaBuena.setBounds(8, 235, 408, 24);
		contentPane.add(lblMantenerUnaBuena);
		
		JLabel lblLosInteresadosDeben = new JLabel("La asignaci\u00F3n de los equipos rotos y pendientes es\r\n");
		lblLosInteresadosDeben.setBounds(8, 264, 471, 19);
		lblLosInteresadosDeben.setForeground(Color.RED);
		lblLosInteresadosDeben.setFont(new Font("Javanese Text", Font.PLAIN, 18));
		contentPane.add(lblLosInteresadosDeben);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.getSingletonInstance().setEnabled(true);
				dispose();
			}
		});
		
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(424, 264, 60, 46);
		getContentPane().add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(InfoUtil.class.getResource("/Imagenes/OUT.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(438, 270, 46, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblPasosParaAadir = new JLabel("Pasos para A\u00F1adir Equipos:\r\n");
		lblPasosParaAadir.setForeground(new Color(0, 102, 102));
		lblPasosParaAadir.setFont(new Font("Javanese Text", Font.PLAIN, 18));
		lblPasosParaAadir.setBounds(8, 107, 374, 26);
		contentPane.add(lblPasosParaAadir);
		
		JLabel lblDirigirseA = new JLabel("1- Dirigirse a la Pesta\u00F1a A\u00F1adir y Buscar Equipo");
		lblDirigirseA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDirigirseA.setBounds(8, 139, 338, 24);
		contentPane.add(lblDirigirseA);
		
		JLabel label_2 = new JLabel("2- Introducir Los Datos");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(8, 172, 328, 24);
		contentPane.add(label_2);
		
		JLabel lblCualquierErrorEn = new JLabel("Cualquier error en la app:");
		lblCualquierErrorEn.setForeground(new Color(0, 102, 102));
		lblCualquierErrorEn.setFont(new Font("Javanese Text", Font.PLAIN, 18));
		lblCualquierErrorEn.setBounds(8, 212, 471, 19);
		contentPane.add(lblCualquierErrorEn);
		
		JLabel lblTocandoElBotn = new JLabel("tocando el bot\u00F3n de Lista");
		lblTocandoElBotn.setForeground(Color.RED);
		lblTocandoElBotn.setFont(new Font("Javanese Text", Font.PLAIN, 18));
		lblTocandoElBotn.setBounds(8, 289, 471, 19);
		contentPane.add(lblTocandoElBotn);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				Menu.getSingletonInstance().setEnabled(true);
				dispose();
			}
		});
	}
	}


