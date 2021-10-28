package Clases;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Taller {
	private Queue <Equipo> equiposRotos=new ArrayDeque<Equipo>();
	private Queue <Equipo> pendientes=new ArrayDeque<Equipo>();
	private LinkedList <Trabajador> trabajadores=new LinkedList<Trabajador>();
	private LinkedList <Asignacion> trabajo=new LinkedList<Asignacion>();
	private File fichOperarios=new File("fichOperarios.dat");
	
	private static Taller taller=null;
	public static Taller getSingletonInstance(){
		if(taller==null)
			taller=new Taller();		
		return taller;
	}
	
	public void crearEncabezamiento() throws IOException{
	     RandomAccessFile fichOp = new RandomAccessFile(fichOperarios,"rw");
	      
	         //Escribir la cantidad de trabajadores inicial 0
	      fichOp.writeInt(trabajadores.size());  
	      //Escribir Trabajadores actuales
	      Trabajador t=null;
	      Trabajador a=new Trabajador(null, null, 0, (char) 0, 0);
	      Iterator<Trabajador> trab = trabajadores.iterator();
			while (trab.hasNext() ) {
				t= (Trabajador) trab.next();
				
				a=new Trabajador(t.getNombre(),t.getIdent(),t.getEdad(),t.getSexo(),t.getExperiencia());
				if(t instanceof Operario){
				byte[]arrayT=Convert.toBytes(a);
				fichOp.writeInt(arrayT.length);
				fichOp.write(arrayT);
				fichOp.writeInt(((Operario) t).cantRepT());
				}
			}
	      fichOp.close();
	}
	   public void actualizarOperarios()throws FileNotFoundException, IOException, ClassNotFoundException  {
		   
		   try {
			RandomAccessFile fichOp = new RandomAccessFile(fichOperarios, "rw");
            int cantOp = fichOp.readInt();
            for (int i = 0; i < cantOp; i++) {
                long pos = fichOp.getFilePointer();
                int tam = fichOp.readInt();
                byte[] arrOp = new byte[tam];
                fichOp.read(arrOp);
                Trabajador opPers = (Trabajador) Convert.toObject(arrOp);
                Trabajador op = buscarTrabajador(opPers.getIdent());
                
                fichOp.seek(pos);
                arrOp = Convert.toBytes(opPers);
                fichOp.writeInt(arrOp.length);
                fichOp.write(arrOp);
                fichOp.writeInt(((Operario) op).cantRepT());
                
                if(((Operario)op).getEquiposTerm()!=null){
                Iterator<Equipo> iterEqTerm = ((Operario) op).getEquiposTerm().iterator();
                while (iterEqTerm.hasNext()) {
                    Equipo eqTerm = iterEqTerm.next();
                    Iterator<Asignacion> iterAsig = trabajo.iterator();
                    boolean found = false;
                    while (iterAsig.hasNext() && !found) {
                        Asignacion asig = iterAsig.next();
                        if (asig.getEquipo().equals(eqTerm)) {
                            found = true;
                            iterAsig.remove(); 
                        }
                    }
                    iterEqTerm.remove();
                }
                }
            }
          
            asignarReparacion();             
            fichOp.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   }

	public Trabajador buscarTrabajador(String ident) {
		boolean found = false;
		Trabajador t = null;
		Iterator<Trabajador> trab = trabajadores.iterator();
		while (trab.hasNext() && !found) {
			t= (Trabajador) trab.next();
			if (t.getIdent().equalsIgnoreCase(ident)&& t instanceof Operario)
			found = true;
			}
		return t;
	}
	
	public LinkedList <Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(LinkedList <Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
	
	public LinkedList <Asignacion> getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(LinkedList <Asignacion> trabajo) {
		this.trabajo = trabajo;
	}

	public Queue <Equipo> getEquiposRotos() {
		return equiposRotos;
	}

	public void setEquiposRotos(Queue <Equipo> equiposRotos) {
		this.equiposRotos = equiposRotos;
	}

	public Queue <Equipo> getPendientes() {
		return pendientes;
	}

	public void setPendientes(Queue <Equipo> pendientes) {
		this.pendientes = pendientes;
	}

public void	asignarReparacion(){
	Calendar f=Calendar.getInstance();
	
	while(!equiposRotos.isEmpty())
		pendientes.offer(equiposRotos.poll());
	
	Queue <Equipo> aux=new ArrayDeque<Equipo>();
	aux.addAll(pendientes);
	while(!aux.isEmpty()){
    if(mayorCapTip(aux.peek())!=null){    	//SE ENCUENTRA ALGUIEN CAPACITADO PARA ASIGNARLE
    	Asignacion a= new Asignacion(mayorCapTip(aux.peek()),aux.peek() ,f,devDiaF(aux.peek()));
    	
    	trabajo.addLast(a);
        aux.poll();
        pendientes.poll();
        
		
    }
	else if(mayorCapTip(aux.peek())==null){ // NO SE ENCUENTRA ALGUIEN PARA ASIGNARLE VA A LA LISTA DE PENDIENTES
	pendientes.offer(pendientes.poll());
	aux.poll();
	
}
	}}

public Trabajador mayorCapTip(Equipo equipo){
	Iterator<Trabajador> iter = trabajadores.iterator();
	Trabajador t=null;
	int a=0;
	int i = 0;
	Trabajador mayor=null;
	while(iter.hasNext()){
		 t= (Trabajador) iter.next();		
		 if(((Operario) t).getEquiposEnRep()!=null){
			 for(i=0;i<((Operario) t).getEquiposEnRep().size();i++)
			if (a<((Operario) t).getCantEqipSim()-((Operario) t).cantAtend()&& ((Operario) t).getEquiposEnRep().get(i).getTipoE().compareTo(equipo.getTipoE())==0){
				a=((Operario) t).getCantEqipSim()-((Operario) t).cantAtend();		
			    mayor=((Operario) t);
			}
		 }
		 }
	if(a==0)
		return t=null;
	else
		((Operario) mayor).asignarEquipo(equipo);
		return mayor;
}

public LinkedList <Trabajador> noPuedenMas(){
	Iterator<Trabajador> iter = trabajadores.iterator();
	LinkedList <Trabajador> aux=new LinkedList<Trabajador>();
	Trabajador t=null;
	
	while(iter.hasNext()){
		 t= (Trabajador) iter.next();	
		 if(t instanceof Operario)
			if (((Operario) t).getCantEqipSim()-((Operario) t).cantAtend()==0)
				aux.add(t);	 
}
	return aux;
	
}


public LinkedList <Trabajador> puedenTipos(){
	Iterator<Trabajador> iter = trabajadores.iterator();
	boolean found;
	LinkedList <Trabajador> aux=new LinkedList<Trabajador>();
	TipoEquipo[] auxx=TipoEquipo.values();
	Trabajador t=null;
	while(iter.hasNext()){
		found=true;
		 t= (Trabajador) iter.next();
		 if(((Operario) t).getEquiposEnRep()!=null){
		 for(int j=0;j<auxx.length&&found;j++){
			 found=false;
			 for(int i=0;i<((Operario) t).getEquiposEnRep().size()&&!found;i++){
				 if(((Operario) t).getEquiposEnRep().get(i).getTipoE().compareTo(auxx[j])==0)
				 found=true;
			 }
			 
		 }
		 if(found)
		 aux.add(t);	 
		 }
	}
	return aux;
}
public LinkedList <Trabajador> tieneTipo(){
	Iterator<Trabajador> iter = trabajadores.iterator();
	boolean found = false;
	LinkedList <Trabajador> aux=new LinkedList<Trabajador>();
	Trabajador t=null;
	while(iter.hasNext()){
		found=true;
		 t= (Trabajador) iter.next();
		 if(t instanceof Operario)
		 if(((Operario) t).getEquiposEnRep()==null){
			 found=false;
		 }else
			 for(int i=0;i<((Operario) t).getEquiposEnRep().size()&&found;i++){
			if (((Operario) t).getEquiposEnRep().get(i).getEquipos().isEmpty())
				found=false;	
		 }
		 if(found)
		 aux.add(t);
		 
	}
	return aux;
}
public Calendar devDiaF(Equipo e){
	Calendar fecha = Calendar.getInstance();
	int dias=CantidadDeDías(e);
    fecha.add(Calendar.DAY_OF_YEAR, -dias);  
    return fecha ;
		
}
public int CantidadDeDías(Equipo e) {
	int a =(int) (Math.random() * (20 - 5 + 1) + 5) ; 
	return a;
}

public boolean hayOp(Equipo eq){
	Iterator<Trabajador> iter = trabajadores.iterator();
	boolean found = false;
	Trabajador t=null;
	
	while(iter.hasNext()&&!found){
		 t= (Trabajador) iter.next();
		 if(t instanceof Operario)
		 for(int i=0;i<((Operario) t).getEquiposEnRep().size()&&!found;i++)
		 if(eq.getTipoE().compareTo(((Operario) t).getEquiposEnRep().get(i).getTipoE())==0)
			 found=true;
	}
	
	return found;
	
}
}