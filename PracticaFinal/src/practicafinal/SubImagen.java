/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal;


import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Elena
 */
public class SubImagen extends JLabel {
    private BufferedImage imagen;
    private int cod;

    public SubImagen() {
    }

    public SubImagen(int X, int Y, BufferedImage Imagen, int cod) {
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setOpaque(true);
        setPreferredSize(new Dimension(X, Y));
        imagen = Imagen;
        this.cod=cod;
    }
    
    
    public int getCodigo() {
        return cod;
    }
    public BufferedImage getImagen(){
        return imagen;
    }
    
    public void setCodigo(int a){
        cod=a;
    }
    
    public void setImagen(BufferedImage Imagen){
        imagen=Imagen;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            Image scaledImage = imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(scaledImage, 0, 0, null);
        }
    }
   
}