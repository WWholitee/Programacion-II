/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal;

import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Elena
 */
///Fichero que escoge un fichero aleatorio desde una carpeta introducida 
public class FicheroAleatorio {
   File randomImageFile;
    public FicheroAleatorio(){
        File Directorio = new File("C:\\Users\\Elena\\Pictures\\vash");
       File[] imageFiles = Directorio.listFiles();
       if (imageFiles != null && imageFiles.length > 0) {
            Random random = new Random();
             randomImageFile = imageFiles[random.nextInt(imageFiles.length)];
            
    }
       
       
}
   
    public File Ficheronombre(){
           return randomImageFile;
       }
    public String toString(){
        return randomImageFile.toString();
    }
    }
