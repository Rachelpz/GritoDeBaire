package Visual;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelBackground extends JPanel{
	public JPanelBackground() {
	}
	 private Image fondo;
	
	
	@Override
	public void paint(Graphics a){
		int height , width;
		height=this.getSize().height;
		width=this.getSize().width;
		
		if(fondo!=null)
			a.drawImage(fondo,0,0,width,height,this);
		setOpaque(false);
		super.paint(a);
		
	}
	public void setBackground(String fondoImg){
		Image temp;	
		java.net.URL direccion=ClassLoader.getSystemResource(fondoImg);
		temp=Toolkit.getDefaultToolkit().createImage(direccion);
		this.fondo=temp;
		this.repaint();
	}
}
