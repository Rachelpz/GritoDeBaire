package Clases;
import java.util.Calendar;


public class Asignacion {
	   private Trabajador trabajador;
	   private Equipo equipo;
	   private Calendar fecha ;
	   private Calendar fechaFin;
	   
	   public Asignacion(Trabajador trabajador, Equipo equipo, Calendar fecha, Calendar fechaFin){
		   this.trabajador=trabajador;
		   this.equipo=equipo;
		   this.fecha=fecha;
		   this.fechaFin=fechaFin;
	   }
	
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public Calendar getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	

}
