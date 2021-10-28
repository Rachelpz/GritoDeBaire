package Clases;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;


public class Trabajador implements Serializable{
	   private static final long serialVersionUID = 1L;
	   private String nombre;
	   private String ident;
	   private int edad;
	   private char sexo;
	   private int experiencia;
	  
	   
	   public Trabajador(String nombre,String ident,int edad,char sexo,int experiencia){
		   this.setNombre(nombre);
		   this.setIdent(ident);
		   this.setEdad(edad);
		   this.setSexo(sexo);
		   this.setExperiencia(experiencia);
	
	   }
	   
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	

}
