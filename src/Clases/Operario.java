package Clases;

import java.util.LinkedList;

public class Operario extends Trabajador {
	
		private int cantEqipSim;
	   private LinkedList<EquipoXTipo> equiposEnRep=new LinkedList<EquipoXTipo>();
	   private LinkedList<Equipo> equiposTerm=new LinkedList<Equipo>();
	   
	public Operario(String nombre, String ident, int edad, char sexo,
			int experiencia, int cantEquipSim,
			LinkedList<EquipoXTipo> equiposEnRep,
			LinkedList<Equipo> equiposTerm) {
		super(nombre, ident, edad, sexo, experiencia);
		// TODO Auto-generated constructor stub
	this.setCantEqipSim(cantEquipSim);
	this.setEquiposEnRep(equiposEnRep);
	this.setEquiposTerm(equiposTerm);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public LinkedList<EquipoXTipo>getEquiposEnRep(){
return equiposEnRep;
}
public void setEquiposEnRep(LinkedList<EquipoXTipo>equiposEnRep){
	this.equiposEnRep=equiposEnRep;
}
public LinkedList<Equipo>getEquiposTerm(){
return equiposTerm;
}
public void setEquiposTerm(LinkedList<Equipo>equiposTerm){
	this.equiposTerm=equiposTerm;
}
	public int cantRepT(){
		int cant=0;
		if(equiposTerm==null)
			return cant;
		for(int i =0;i<equiposTerm.size();i++){			
			cant++;
		}
		return cant;
	}
	public int cantAtend(){
		int cant=0;
		if(equiposEnRep==null)
			return cant;
		for(int i=0;i<equiposEnRep.size();i++){
			for(int j=0;j<equiposEnRep.get(i).getEquipos().size();j++)
				cant++;
		}
		return cant;
	}
	public int getCantEqipSim() {
		return cantEqipSim;
	}
	public void setCantEqipSim(int cantEqipSim) {
		this.cantEqipSim = cantEqipSim;
	}
	
	public void asignarEquipo(Equipo e){
		for(int i=0;i<this.getEquiposEnRep().size();i++){
			if(this.getEquiposEnRep().get(i).getTipoE().compareTo(e.getTipoE())==0){
			this.getEquiposEnRep().get(i).getEquipos().add(e);
			
			}
			}
	}

}

