package Clases;
import java.util.ArrayList;

public class EquipoXTipo {
	   private TipoEquipo tipoE;
	   private ArrayList <Equipo> equipos;
	   
	   
	   public EquipoXTipo(ArrayList<Equipo>equipos,TipoEquipo tipoE){
		   this.setEquipos(equipos);
		   this.setTipoE(tipoE);
	   }
	   
	public TipoEquipo getTipoE() {
		return tipoE;
	}
	public void setTipoE(TipoEquipo tipoE) {
		this.tipoE = tipoE;
	}
	public ArrayList <Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(ArrayList <Equipo> equipos) {
		this.equipos = equipos;
	}


}
