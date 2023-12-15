/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class lecturaDatos extends JDialog {
    private JTextField[] datos;
    private int numeroValores = 0;
     
    //a igual a 0 se abrira estilo iniciar partida
    //a igual a 1  se iniciara estilo Historial Selectivo
    public lecturaDatos(JFrame frame, String[] campos, int a) {
        super(frame, true);
      if(a=='0'){
        
        setTitle("INTRODUCCIÓN DATOS");

        numeroValores = campos.length;

        Container panelContenidos = getContentPane();
        panelContenidos.setLayout(new BorderLayout());

        JPanel panelNombres = new JPanel(new GridLayout(numeroValores, 1));
        panelNombres.setBackground(Color.BLACK);

        JPanel panelEntradas = new JPanel(new GridLayout(numeroValores, 1));
        panelEntradas.setBackground(Color.BLACK);

        UIManager.put("Label.background", Color.BLACK);
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 12));

        datos = new JTextField[numeroValores];

        for (int indice = 0; indice < datos.length; indice++) {
            JLabel concepto = new JLabel(campos[indice]);
            concepto.setHorizontalAlignment(SwingConstants.LEFT);
            concepto.setVerticalAlignment(SwingConstants.CENTER);

            datos[indice] = new JTextField(10);
            datos[indice].setText("");

            panelNombres.add(concepto);
            panelEntradas.add(datos[indice]);
        }

        panelContenidos.add(panelNombres, BorderLayout.WEST);
        panelContenidos.add(panelEntradas, BorderLayout.CENTER);

        JButton salirBoton = new JButton("CONFIRMAR");
        panelContenidos.add(salirBoton, BorderLayout.SOUTH);
        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(400, (numeroValores + 1) * 40);
        setLocationRelativeTo(frame);
        setVisible(true);
        
      }else if(a=='1'){
      
        setTitle("INTRODUCCIÓN DATOS");

        numeroValores = campos.length;

        Container panelContenidos = getContentPane();
        panelContenidos.setLayout(new BorderLayout());
        JPanel cont = new JPanel();
        cont.setLayout(new GridLayout(3, 1));
        
        JPanel panelTexto = new JPanel(new GridLayout(numeroValores, 1));
        panelTexto.setBackground(Color.BLACK);

        JPanel panelEntradas = new JPanel(new GridLayout(numeroValores, 1));
        panelEntradas.setBackground(Color.BLACK);

        UIManager.put("Label.background", Color.BLACK);
        UIManager.put("Label.foreground", Color.YELLOW);
        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 12));

        datos = new JTextField[numeroValores];

        for (int indice = 0; indice < datos.length; indice++) {
            JTextArea concepto = new JTextArea(campos[indice]);
            concepto.setForeground(Color.YELLOW);
            concepto.setBackground(Color.BLACK);

            datos[indice] = new JTextField(10);
            datos[indice].setText("");

            panelTexto.add(concepto);
            panelEntradas.add(datos[indice]);
        }

        cont.add(panelTexto, BorderLayout.NORTH);
        cont.add(panelEntradas, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setBackground(Color.BLACK);

        JButton salirBoton = new JButton("CONFIRMAR");
        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton cancelarBoton = new JButton("CANCELAR");
        cancelarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        panelBotones.add(salirBoton);
        panelBotones.add(cancelarBoton);
        panelContenidos.add(cont);
        cont.add(panelBotones, BorderLayout.SOUTH);

        setSize(250, 150);
        setLocationRelativeTo(frame);
        setVisible(true);
      }
    }

   
    public String[] getDatosTexto() {
        String[] datosIntroducidos = new String[numeroValores];
        for (int indice = 0; indice < datosIntroducidos.length; indice++) {
            datosIntroducidos[indice] = datos[indice].getText();
            if (datos[indice].getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ENTRADA INCORRECTA");
                return null;
            }
        }
        return datosIntroducidos;
    }
}