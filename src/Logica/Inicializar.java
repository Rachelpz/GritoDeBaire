package Logica;
import Clases.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

public class Inicializar {
	private Taller taller;
	Calendar fecha = Calendar.getInstance();
	private LinkedList <Trabajador> trabajadores=new LinkedList<Trabajador>();;
	private LinkedList <Asignacion> trabajo;
	private LinkedList<Equipo> equiposTerm=new LinkedList<Equipo>();;
	private LinkedList<EquipoXTipo> equiposEnRep=new LinkedList<EquipoXTipo>();
	private ArrayList<Equipo>equipos=new ArrayList<Equipo>();;
	
	//Patron Singleton
	private static Inicializar inicializado = null;
	public static Inicializar getSingletonInstance(){
		if(inicializado == null){
			inicializado = new Inicializar();
		}
		return inicializado;
	}
	public void iniciarEquipos(){
		taller = taller.getSingletonInstance();
			
		
		Equipo eq0 = new Equipo("0001","Samsung",TipoEquipo.LAVADORA,"Estable");
		Equipo eq1 = new Equipo("0002","Samsung",TipoEquipo.COCINA,"Danado");
		Equipo eq2 = new Equipo("0003","Panasonic",TipoEquipo.LAVADORA,"Roto");
		Equipo eq3 = new Equipo("0004","LG",TipoEquipo.AIRE,"Danado");
		Equipo eq4 = new Equipo("0005","HP",TipoEquipo.LAVADORA,"Estable");
		Equipo eq5 = new Equipo("0006","DELL",TipoEquipo.TELEVISOR,"Danado");
		Equipo eq6 = new Equipo("0007","Samsung",TipoEquipo.LAVADORA,"Roto");
		Equipo eq7 = new Equipo("0008","Panasonic",TipoEquipo.LAVADORA,"Danado");
		Equipo eq8 = new Equipo("0009","Asus",TipoEquipo.LAVADORA,"Danado");
		Equipo eq9 = new Equipo("0010","LG",TipoEquipo.TELEVISOR,"Danado");
		Equipo eq10 = new Equipo("0011","HP",TipoEquipo.TELEVISOR,"Roto");
		Equipo eq11 = new Equipo("0012","Philips",TipoEquipo.AIRE,"Danado");
		Equipo eq12 = new Equipo("0013","Asus",TipoEquipo.COCINA,"Danado");
		Equipo eq13 = new Equipo("0014","Xiaomi",TipoEquipo.REFRIGERACION,"Danado");
		Equipo eq14 = new Equipo("0015","Asus",TipoEquipo.LAVADORA,"Roto");
		Equipo eq15 = new Equipo("0016","Sony",TipoEquipo.TELEVISOR,"Danado");
		Equipo eq16 = new Equipo("0017","Xiaomi",TipoEquipo.AIRE,"Danado");
		Equipo eq17 = new Equipo("0018","Toshiba",TipoEquipo.AIRE,"Danado");
		Equipo eq18 = new Equipo("0019","Sony",TipoEquipo.TELEVISOR,"Danado");
		Equipo eq19 = new Equipo("0020","Xiaomi",TipoEquipo.AIRE,"Roto");
		Equipo eq20 = new Equipo("0021","Toshiba",TipoEquipo.COCINA,"Danado");
		Equipo eq21 = new Equipo("0022","HP",TipoEquipo.TELEVISOR,"Roto");
		Equipo eq22 = new Equipo("0023","Philips",TipoEquipo.AIRE,"Danado");
		
		equipos.add(eq7);
		equipos.add(eq8);
		EquipoXTipo eqT0=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq7.getTipoE());
		equipos.clear();
		equipos.add(eq9);
		equipos.add(eq10);
		EquipoXTipo eqT1=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq9.getTipoE());
		equipos.clear();
		
		equipos.add(eq12);
		EquipoXTipo eqT3=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq12.getTipoE());
		equipos.clear();
		equipos.add(eq13);
		EquipoXTipo eqT4=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq13.getTipoE());
		equipos.clear();
		equipos.add(eq14);
		EquipoXTipo eqT5=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq14.getTipoE());
		equipos.clear();
		equipos.add(eq15);
		EquipoXTipo eqT6=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq15.getTipoE());
		equipos.clear();
		equipos.add(eq16);
		EquipoXTipo eqT7=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq16.getTipoE());
		equipos.clear();
		
		equipos.add(eq18);
		EquipoXTipo eqT8=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq18.getTipoE());
		equipos.clear();
		equipos.add(eq19);
		EquipoXTipo eqT9=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq19.getTipoE());
		equipos.clear();
		equipos.add(eq20);
		EquipoXTipo eqT10=new EquipoXTipo((ArrayList<Equipo>)equipos.clone(),eq20.getTipoE());
		equipos.clear();
		
		
		taller.getEquiposRotos().offer(eq0);
		taller.getEquiposRotos().offer(eq1);
		taller.getEquiposRotos().offer(eq2);
		taller.getPendientes().offer(eq3);
		taller.getPendientes().offer(eq4);
		taller.getPendientes().offer(eq5);
		taller.getPendientes().offer(eq6);
		
		Trabajador trab0 = new Operario("Pedro Reyes","861025",25,'M',2,4,(LinkedList<EquipoXTipo>) equiposEnRep.clone(),(LinkedList<Equipo>) equiposTerm.clone());
		Trabajador trab1 = new Operario ("Alain Perez","950516",35,'M',10,6,(LinkedList<EquipoXTipo>) equiposEnRep.clone(),(LinkedList<Equipo>) equiposTerm.clone());
		Trabajador trab2 = new Operario("Raul Gonzalez","76070",40,'M',8,10,(LinkedList<EquipoXTipo>) equiposEnRep.clone(),(LinkedList<Equipo>) equiposTerm.clone());
		taller.getTrabajadores().add(trab0);
		taller.getTrabajadores().add(trab1);
		taller.getTrabajadores().add(trab2);
		if (trab0 instanceof Operario) {
		  
		
		((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().add(eqT0);
		((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().add(eqT1);
		((Operario) taller.getTrabajadores().get(0)).getEquiposTerm().add(eq11);
		}
		((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().add(eqT3);
		((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().add(eqT4);
		((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().add(eqT5);
		((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().add(eqT6);
		((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().add(eqT7);
		((Operario) taller.getTrabajadores().get(1)).getEquiposTerm().add(eq17);
		
		((Operario) taller.getTrabajadores().get(2)).getEquiposEnRep().add(eqT8);
		((Operario) taller.getTrabajadores().get(2)).getEquiposEnRep().add(eqT9);
		((Operario) taller.getTrabajadores().get(2)).getEquiposEnRep().add(eqT10);
		((Operario) taller.getTrabajadores().get(2)).getEquiposTerm().add(eq21);
		((Operario) taller.getTrabajadores().get(2)).getEquiposTerm().add(eq22);
		
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().get(0));
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().get(1));
		equiposTerm.add(((Operario) taller.getTrabajadores().get(0)).getEquiposTerm().get(0));
		
		((Operario) trab0).setEquiposEnRep((LinkedList<EquipoXTipo>) equiposEnRep.clone());
		((Operario) trab0).setEquiposTerm((LinkedList<Equipo>) equiposTerm.clone());
		equiposEnRep.clear();
		equiposTerm.clear();
		
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().get(0));
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().get(1));
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().get(2));
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().get(3));
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(1)).getEquiposEnRep().get(4));
		equiposTerm.add(((Operario) taller.getTrabajadores().get(1)).getEquiposTerm().get(0));
		
		((Operario) trab1).setEquiposEnRep((LinkedList<EquipoXTipo>) equiposEnRep.clone());
		((Operario) trab1).setEquiposTerm((LinkedList<Equipo>) equiposTerm.clone());
		equiposEnRep.clear();
		equiposTerm.clear();
		
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(2)).getEquiposEnRep().get(0));
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(2)).getEquiposEnRep().get(1));
		equiposEnRep.add(((Operario) taller.getTrabajadores().get(2)).getEquiposEnRep().get(2));
		equiposTerm.add(((Operario) taller.getTrabajadores().get(2)).getEquiposTerm().get(0));
		equiposTerm.add(((Operario) taller.getTrabajadores().get(2)).getEquiposTerm().get(1));
		
		((Operario) trab2).setEquiposEnRep((LinkedList<EquipoXTipo>) equiposEnRep.clone());
		((Operario) trab2).setEquiposTerm((LinkedList<Equipo>) equiposTerm.clone());
		equiposEnRep.clear();
		equiposTerm.clear();
	}		
	/*public void iniciarTrabajadores(){
		taller = taller.getSingletonInstance();
		
		
		
		equiposEnRep.add(taller.getTrabajadores().get(1).getEquiposEnRep().get(0));
		equiposEnRep.add(taller.getTrabajadores().get(1).getEquiposEnRep().get(1));
		equiposEnRep.add(taller.getTrabajadores().get(1).getEquiposEnRep().get(2));
		equiposEnRep.add(taller.getTrabajadores().get(1).getEquiposEnRep().get(3));
		equiposEnRep.add(taller.getTrabajadores().get(1).getEquiposEnRep().get(4));
		equiposTerm.add(taller.getTrabajadores().get(1).getEquiposTerm().get(0));
		
		Trabajador trab1 = new Trabajador ("Alain Perez","950516",35,'M',10,10,(LinkedList<EquipoXTipo>) equiposEnRep.clone(),(LinkedList<Equipo>) equiposTerm.clone(),5,1);
		
		equiposEnRep.clear();
		equiposTerm.clear();
		
		equiposEnRep.add(taller.getTrabajadores().get(2).getEquiposEnRep().get(0));
		equiposEnRep.add(taller.getTrabajadores().get(2).getEquiposEnRep().get(1));
		equiposEnRep.add(taller.getTrabajadores().get(2).getEquiposEnRep().get(2));
		equiposTerm.add(taller.getTrabajadores().get(2).getEquiposTerm().get(0));
		equiposTerm.add(taller.getTrabajadores().get(2).getEquiposTerm().get(1));
		
		Trabajador trab2 = new Trabajador("Raul Gonzalez","76070",40,'M',8,8,(LinkedList<EquipoXTipo>) equiposEnRep.clone(),(LinkedList<Equipo>) equiposTerm.clone(),3,2);
		taller.getTrabajadores().add(trab2);
		equiposEnRep.clear();
		equiposTerm.clear();
		
		
		
	}	*/
	
	public void iniciarAsignaciones(){
		taller = taller.getSingletonInstance();
		trabajadores.add(taller.getTrabajadores().get(0));
		
		Asignacion asig0 = new Asignacion(taller.getTrabajadores().get(0),((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().get(0).getEquipos().get(0),fecha,taller.devDiaF(((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().get(0).getEquipos().get(0)));
		Asignacion asig1 = new Asignacion(taller.getTrabajadores().get(0),((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().get(0).getEquipos().get(1),fecha,taller.devDiaF(((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().get(0).getEquipos().get(1)));
		Asignacion asig2 = new Asignacion(taller.getTrabajadores().get(0),((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().get(1).getEquipos().get(0),fecha,taller.devDiaF(((Operario) taller.getTrabajadores().get(0)).getEquiposEnRep().get(1).getEquipos().get(0)));
		
		
		taller.getTrabajo().add(asig0);
		taller.getTrabajo().add(asig1);
		taller.getTrabajo().add(asig2);
		
	}
	public Taller getTaller() {
		return taller;
	}
	
	
	public void IniciarDatos(){
		iniciarEquipos();
		//iniciarTrabajadores();
		iniciarAsignaciones();
	}
}
