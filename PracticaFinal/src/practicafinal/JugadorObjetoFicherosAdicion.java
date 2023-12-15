package practicafinal;


import java.io.*;

public class JugadorObjetoFicherosAdicion {
    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos cuando se desee crear un fichero nuevo
    private ObjectOutputStream fichero1=null;
    //declaración objeto AdicionObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos cuando se desee añadir objetos en un fichero ya existente
    private AdicionObjectOutputStream fichero2=null; 
    
    //MÉTODO CONSTRUCTOR
    public JugadorObjetoFicherosAdicion(String nombreFichero) throws IOException, FileNotFoundException { 

        fichero1= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero)));      
   }    

    public JugadorObjetoFicherosAdicion(String nombreFichero, boolean adicion) throws IOException, FileNotFoundException { 

        fichero2 = new  AdicionObjectOutputStream(new BufferedOutputStream (new FileOutputStream(nombreFichero,adicion)));         
   }

    public void escritura(Jugador jugador) throws IOException {
 
        if (fichero2==null) {
            fichero1.writeObject(jugador);
        }
        else {
            fichero2.writeObject(jugador);
        }
    }

    public void cierre() throws IOException {
        if (fichero2==null) {
            fichero1.close();
        }
        else {
            fichero2.close();
        }              
    }
}
   

