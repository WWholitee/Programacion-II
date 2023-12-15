/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal;


import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Elena
 */
public class panelSubimagen extends JPanel {
    private SubImagen[] puzzle;
    public PosicionPiezas posicion;
    private int[] orden;
    private int filas,columnas;
    private MouseListener gestorEventos;
    BufferedImage Imagen;
    private String Nombrefichero;
    private Image imagen;
    
    public panelSubimagen(int dimX, int dimY,File nombre,MouseListener gestorEventos, PosicionPiezas posicion) {
       imagen(nombre);
       Nombrefichero=nombre.toString();
       this.gestorEventos=gestorEventos;
       this.filas=dimX;
       this.columnas= dimY;
       setLayout(new GridLayout(dimX,dimY));
       puzzle=new SubImagen[dimX*dimY];
       cargar(posicion);
    }
    public void imagen(File nombre){
        try {
                Imagen = ImageIO.read(nombre);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    
   public void cargar(PosicionPiezas posicion){
       int contador=0;
        int x = Imagen.getWidth();
        int y = Imagen.getHeight();
        int xsubd= x/columnas;
        int ysubd = y/filas;
        for(int j=0; j<filas;j++){
            for(int i=0; i<columnas;i++){
                int poscx= i*xsubd;
                int poscy= j*ysubd;
                BufferedImage SUBD= Imagen.getSubimage(posicion.getCorx(contador), posicion.getCory(contador), xsubd, ysubd);
                
                
                puzzle[posicion.getPosc(contador)]= new SubImagen(filas,columnas,SUBD,contador);
                add(puzzle[posicion.getPosc(contador)]);
                 puzzle[posicion.getPosc(contador)].addMouseListener(gestorEventos);
                 contador++;
            }
        }
   }
  
    
    public int SeleccionCuadro(MouseEvent evento){
        int numerocomp;
        for(numerocomp=0;numerocomp<puzzle.length;numerocomp++){
            if (evento.getSource()==puzzle[numerocomp]) break;
        }
        return numerocomp;
    }
}