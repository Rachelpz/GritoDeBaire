package Clases;

public class Equipo {
	private String noSerie;
	   private String marca;
	   private TipoEquipo tipoE;
	   private String descripcion;
	   
	   public Equipo(String noSerie,String marca,TipoEquipo tipoE, String descripcion){
		   this.setDescripcion(descripcion);
		   this.setMarca(marca);
		   this.setTipoE(tipoE);
		   this.setNoSerie(noSerie);
	   }
	   
	public String getNoSerie() {
		return noSerie;
	}
	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public TipoEquipo getTipoE() {
		return tipoE;
	}
	public void setTipoE(TipoEquipo tipoE) {
		this.tipoE = tipoE;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	   

}
