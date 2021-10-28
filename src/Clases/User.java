package Clases;

import java.util.ArrayList;

public class User {

		private String nombre;
		private String nombreUsuario;
		private String contrasena;
		private String primerApellido;
		private static final ArrayList<User> usuarios = new ArrayList<User>();
		private static User usuarioActual = new User(null, null, null, null);
		
		public User(String nombre,String primerApellido , String nombreUsuario,String contrasena ){
			setNombre(nombre);
			setPrimerApellido(primerApellido);			
			setNombreUsuario(nombreUsuario);
			setContrasena(contrasena);
		}
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getPrimerApellido() {
			return primerApellido;
		}

		public void setPrimerApellido(String primerApellido) {
			this.primerApellido = primerApellido;
		}

		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}

		public String getContrasena() {
			return contrasena;
		}

		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		public static ArrayList<User> getUsers(){
			return usuarios;
		}
		
		public static User getUsuarioActual() {
			return usuarioActual;
		}

		public static void setUsuarioActual(User usuarioActual) {
			User.usuarioActual = usuarioActual;
		}
		public static void añadirUsuario(User usuario){
			usuarios.add(usuario);
		}
		
		public static User getUser(String nombreUsuario){
			User usuario = null;
			boolean encontrado = false;
			
			for(int i = 0; i < usuarios.size() && !encontrado; i++){
				User usuarioActual = usuarios.get(i);
				
				if(usuarioActual.getNombreUsuario().equals(nombreUsuario)){
					encontrado = true;
					usuario = usuarioActual;
				}
			}
			return usuario;
		}
		
		
}
