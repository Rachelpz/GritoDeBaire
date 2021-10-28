package Logica;


public class Validaciones {
	
	//Patron Singleton
	private static Validaciones validacion = null;
	public static Validaciones getSingletonInstance(){
		if(validacion == null){
			validacion = new Validaciones();
		}
		return validacion;
	}

	
	public boolean NombreValido(String nombre){
		boolean resp = true;
		int i = 0;
		while (i<nombre.length() && resp==true) {
			char a = nombre.charAt(i);
			if(!Character.isLetter(a) && a != ' '){
				resp = false;
			}
			i++;
		}
		return resp;
	}
	public static String ponerEnMayuscula(String cadena){
		String cadenaEnMayuscula = Character.toString(Character.toUpperCase(cadena.charAt(0)));
		
		for(int i = 1; i < cadena.length(); i++){
			char caracterActual = Character.toLowerCase(cadena.charAt(i));
			cadenaEnMayuscula += caracterActual;
			
			if(caracterActual == ' '){
				cadenaEnMayuscula += Character.toUpperCase(cadena.charAt(i + 1));
				i++;
			}
		}
		return cadenaEnMayuscula;
	}
	
	
	public static boolean caracterValido(char caracter){
		boolean valido = false;
		int valorASCII = (int)caracter;

		if(valorASCII == 8 || valorASCII == 10 || (valorASCII >= 65 && valorASCII <= 90) || (valorASCII >= 97 && valorASCII <= 122) || valorASCII == 127 
				|| valorASCII == 241 || valorASCII == 209 || valorASCII == 225 || valorASCII == 233 || valorASCII == 237 || valorASCII == 243 
				|| valorASCII == 250 || valorASCII == 193 || valorASCII == 201 || valorASCII == 205 || valorASCII == 211 || valorASCII == 218)
			valido = true;
		return valido;
	}
}
