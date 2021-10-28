package Logica;

import java.util.ArrayList;

public class LogicaMenu {
	//Patron Singleton
		private static LogicaMenu logicaMenuPrincipal = null;
		public static LogicaMenu getSingletonInstance(){
			if(logicaMenuPrincipal == null){
				logicaMenuPrincipal = new LogicaMenu();
			}
			return logicaMenuPrincipal;
		}

		public ArrayList<String> nombreElecc(int i){
	        ArrayList<String> lista = new ArrayList<String>();
	        switch (i) {
			case 0:
				lista.add("Añadir Equipo");
				lista.add("Añadir Trabajador");
				break;
			case 1:
				lista.add("Trabajadores No Pueden Reparar mas");
				lista.add("Trabajadores que tienen Equipos de cada Tipo");
				lista.add("Trabajadores Pueden Reparar Todos Tipos");
				break;
			case 2:
				lista.add("Listado de Trabajadores");
				lista.add("Listado de Equipos Pendientes");
				lista.add("Listado de Equipos Asignados");
				lista.add("Listado de Equipos Rotos");
				
				break;
			
			}
	        return lista;
		}
		
}
