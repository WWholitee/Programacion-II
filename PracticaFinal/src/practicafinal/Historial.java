/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Elena
 */
//CLASE QUE LEE LOS DATOS DE UN FICHERO .DAT 
public class Historial {
   String NombreFichero;
   
    public Historial(String nombrefich){
   NombreFichero= nombrefich;
    }

    public void GuardarHistorial(Jugador jugador){
        try {
            JugadorObjetoFicherosAdicion oe = new JugadorObjetoFicherosAdicion(NombreFichero,true);
            try {
                oe.escritura(jugador);
            } catch (IOException e) {
                System.out.println("NO SE HA PODIDO ESCRIBIR EL OBJETO EN EL ARCHIVO");
            } finally {
                try {
                    oe.cierre();
                } catch (IOException ee) {
                    System.out.println("no se ha podido cerrar el archivo");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("NO SE HA ENCONTRADO EL ARDHIVO");
        } catch (IOException e) {
            System.out.println("HA HABIDO UN ERROR ");
        }
    }
        //DEVUELVE UN STRING DEL HISTORIAL ENTERO
    public String HistorialGeneral(){
        String historial = "";
        Jugador jugador = new Jugador();
         try{
            JugadorObjetoFicherosLectura ol= new JugadorObjetoFicherosLectura(NombreFichero);
            try{
                jugador=ol.lectura();
                while(true){
                    
                    System.out.println(jugador.toString());
                    historial = historial + jugador.toString();
                    jugador=ol.lectura();
                }
            }catch(EOFException e){
            ///no se hace nada
        }
            catch(ClassNotFoundException e){
                System.out.println("no se ha encontrado la clase ");
            }catch(IOException e){
                System.out.println("se ha producido un error"+e.toString());
            }finally{
                try{
                    ol.cierre();
                }catch(IOException e){
                    System.out.println("no se ha podido cerrar el archivo");
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("no se ha encontrado el archivo");
        }catch(IOException e){
            System.out.println("se ha producido algun error mientras se abria el archivo"+e);   
        }
         return historial;
    }
    //METODO QUE DADO UN CHAR ARRAY DEVUELVE UN STRING CON 
    //TODOS LOS OBJETOS JUGADOR CUYO NOMBRE SEA ESE
    public String HistorialSelectivo(char[] a){
        String historial = "";
        Jugador jugador = new Jugador();
         try{
            JugadorObjetoFicherosLectura ol= new JugadorObjetoFicherosLectura(NombreFichero);
            try{
                jugador=ol.lectura();
                while(true){
                    if(jugador.Equals(a)){
                    System.out.println(jugador.toString());
                    historial = historial + jugador.toString();
                    }
                    jugador=ol.lectura();
                }
            }catch(EOFException e){
            ///no se hace nada
        }
            catch(ClassNotFoundException e){
                System.out.println("no se ha encontrado la clase ");
            }catch(IOException e){
                System.out.println("se ha producido un error"+e.toString());
            }finally{
                try{
                    ol.cierre();
                }catch(IOException e){
                    System.out.println("no se ha podido cerrar el archivo");
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("no se ha encontrado el archivo");
        }catch(IOException e){
            System.out.println("se ha producido algun error mientras se abria el archivo"+e);   
        }
         return historial;
    }
  
}
