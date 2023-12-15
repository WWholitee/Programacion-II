package practicafinal;


import java.io.*;

public class JugadorObjetoFicherosLectura {
  
    private ObjectInputStream fichero =null;
  
    public JugadorObjetoFicherosLectura(String nombreFichero) throws FileNotFoundException, IOException{
 
       fichero = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreFichero))); 
    }
    
    public Jugador lectura() throws ClassNotFoundException,IOException { 
        
        Jugador jugador=new Jugador();
       
        jugador= (Jugador) fichero.readObject();      
       
        return jugador; 
    }

    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
    public void cierre() throws IOException {
        if (fichero!=null) {
            fichero.close();
        }               
    }
}

