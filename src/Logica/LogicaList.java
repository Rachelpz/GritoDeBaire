package Logica;

import java.util.LinkedList;

import Clases.Taller;

import Clases.Trabajador;

public class LogicaList {
	
	//Patron Singleton
			private static LogicaList LogicaListas = null;
			public static LogicaList getSingletonInstance(){
				if(LogicaListas == null){
					LogicaListas = new LogicaList();
				}
				return LogicaListas;
			}
			
	public Object[][] TablaTrabajador(int cantP){
		LinkedList<Trabajador>t=Taller.getSingletonInstance().tieneTipo();
    	Object [] [] tabla = new Object[t.size()][cantP];
    	for(int i = 0;i<t.size();i++){
    		for(int j=0;j<cantP;j++){
    			String Nombre = "";
    			switch (j) {
				case 0:
					Nombre = "Trabajador"+(i+1);
					break;
				case 1:
					Nombre = Taller.getSingletonInstance().getTrabajadores().get(i).getNombre();
					break;
				case 2:
					Nombre = Taller.getSingletonInstance().getTrabajadores().get(i).getIdent();
					break;
				
				}
    			tabla[i][j] = Nombre;
    		}
    	}
		return tabla;
	}

}
