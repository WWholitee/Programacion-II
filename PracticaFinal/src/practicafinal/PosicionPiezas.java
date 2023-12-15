/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Elena
 */
public class PosicionPiezas {
    public int[] poscpiezas;
    public int[] poscactual;
    public int[] posx;
    public int[] posy;
    BufferedImage Imagen;
     private int filas,columnas;
    
    public PosicionPiezas(int a , int b){
        int contador=0;
        filas=a;
        columnas=b;
        poscactual = new int[a*b];
        poscpiezas = new int[a*b];
        posx = new int[a*b];
        posy = new int[a*b];
        
        for(int j=0; j<a;j++){
        for(int i=0;i<b;i++){
            poscpiezas[contador]=contador;
            poscactual[contador]=contador;
            contador++;
            
        }
        }
    }
    //hacemos cambio de piezas 
    public void cambiopiezas(int p1, int p2){
        //valores auxiliares para 1
        int aux=poscactual[p1];
        int auxx=  posx[p1];
        int auxy =posy[p1];
        
        poscactual[p1]=poscactual[p2];
        posx[p1]=posx[p2];
        posy[p1]=posy[p2];
        
        poscactual[p2]=aux;
        posx[p2]=auxx;
        posy[p2] = auxy; 
        
    }
    //Logica para desordenar las piezas
    public void desordenar(){
        Random random = new Random();
        for (int i =poscpiezas.length - 1;i > 0;i--) {
            int j = random.nextInt(i + 1);
            cambiopiezas(i,j);
           }
    }
    //Devuelve true si las piezas estan ordenadas
    public boolean ordenadas(){
        int contador=0;
        for(int j =0;j<poscactual.length;j++){
            if(poscactual[j]==j){
                contador++;
            }
            
        }
        if(contador==poscactual.length){
            return true;
        }else 
            return false;
    }
    //Nos guarda las posiciones de corte de las piezas para poder 
    //luego coger bien los trozos de las imagenes
     public void SetCoordenadas(PosicionPiezas posicion,File nombre ){
         imagen(nombre);
        int contador=0;
       int x = Imagen.getWidth();
        int y = Imagen.getHeight();
        int xsubd= x/columnas;
        int ysubd = y/filas;
        for(int j=0; j<filas;j++){
            for(int i=0; i<columnas;i++){
                int poscx= i*xsubd;
                int poscy= j*ysubd;
                posicion.setCorx(contador, poscx, poscy);
                contador++;
                }
            }
        
   }
      public void imagen(File nombre){
        try {
                Imagen = ImageIO.read(nombre);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public void setCorx(int p, int x, int y){
        posx[p]=x;
        posy[p]=y;
    }
    public int getCorx(int a ){
        return posx[a];
    }
    public int getCory(int a ){
        return posy[a];
    }
    public int getPosc(int a){
        int b=poscpiezas[a];
        return b;
    }
   
    public int[] posiciones(){
        return poscpiezas;
    }
}
