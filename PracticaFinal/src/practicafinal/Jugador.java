/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal;

import java.util.Date;

/**
 *
 * @author Elena
 */
public class Jugador implements java.io.Serializable {

    private static final int Max = 15;
    char[] Nombre;
    Date fecha = new Date();
    int date;
    int puntuacion;

    public Jugador() {
        Nombre = new char[Max];
        for (int indice = 0; indice < Max; indice++) {
            //concatenar el caracter de lapalabra almacenado en la componente
            //indice-ésima del array caracteres con el String resultado
            Nombre[indice] = ' ';
        }

        puntuacion = 0;
        date = fecha.getDate();

    }

    public void setPuntiacion(int punt) {
        puntuacion = punt;
    }
   
    public void setJugador(char[] a) {
        int contador = 0;
        while (contador < a.length) {
            Nombre[contador] = a[contador];
            contador++;
        }
        if (contador < Max) {
            Nombre[contador] = ' ';
            contador++;
        }
    }
    //COMPARA CHAR ARRAYS CON EL NOMBRE DEL JUGADOR 
    public boolean Equals(char[] a) {
        int contador = 0;
        int iguales = 0;
        int letrasNombre=0;
        for(int i =0;Nombre[i]!=' ';i++ ){
            letrasNombre++;
        }
        while (contador < a.length) {
            if (Nombre[contador] == a[contador]) {
                iguales++;
                contador++;
            } else {
                contador++;

            }
        }
        if (iguales == letrasNombre) {
            if (iguales == a.length) {
            return true;
            }else
            return false;
        } else {
            return false;
        }
    }

    public String toString(String res) {
        res = "";
        res = res + "JUGADOR: " + String.valueOf(Nombre) + "    ";
        res = res + "FECHA: " + date + "  ";
        res = res + "PUNTOS: " + puntuacion;
        res = res + '\n';
        return res;
    }

    public String toString() {
        String res = "";
        res = res + "JUGADOR: ";
        for (int indice = 0; indice < Max; indice++) {
            //concatenar el caracter de lapalabra almacenado en la componente
            //indice-ésima del array caracteres con el String resultado
            res = res + Nombre[indice];
        }
        res = res + "FECHA: " + date + "  ";
        res = res + "PUNTOS: " + puntuacion;
        res = res + "\n";
        return res;
    }

}
