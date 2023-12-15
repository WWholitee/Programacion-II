/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Elena
 */
public class PracticaFinal {
    //ATRIBUTOS

    private JFrame ventana;
    private Container panelContenidos;
    private JPanel panelVisualizacionmasBotton;
    private JPanel panelVisualizacionmasBotton2;
    private JPanel panelVisualizacion;
    private JPanel panelStandby, panelJuego;
    private JPanel ImagenResuelto;
    private JSplitPane separador;
    private JSplitPane separador2;
    private JSplitPane separador3;
    //Clases 
    private panelSubimagen puz;
    private PosicionPiezas posicion;
    private FicheroAleatorio file;
    private Jugador jugador;
    private Historial his;
    //usados en el codigo para controlar logica
    private int numeroColumnas, numeroFilas;
    int CuadroSeleccionado2 = -1;
    int CuadroSeleccionado = -1;
    private boolean partida = false;
    private boolean win = false;
    private boolean cambio = false;
    private boolean referscar = false;
    //Nombre del fichero de datos 
    private final String NombreFicheroHistorial = "resultados.dat";

    //metodo main con Control de la apariencia
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception error) {
            System.out.println("NO SE HA ESTABLECIDO LA APARIENCIA DESEADA: " + error);
        }
        new PracticaFinal().inicio();
    }

    private void inicio() {
        ventana = new JFrame("Practica Final - PROGRAMACION II - 2022-2023 - UIB");
        panelContenidos = ventana.getContentPane();
        panelContenidos.setLayout(new BorderLayout());
        ContenedoresYComponentes();

    }
///CONTENEDORES Y COMPONENTES DE LA VISUALIZACION BASE 

    private void ContenedoresYComponentes() {
        //contenedor botones izq
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1));

        //JButton  Nueva Partida
        JButton nuevaPartidaBoton = new JButton("NUEVA PARTIDA");
        nuevaPartidaBoton.setFont(new Font("arial", Font.BOLD, 13));
        nuevaPartidaBoton.setForeground(Color.WHITE);
        nuevaPartidaBoton.setBackground(Color.BLACK);
        nuevaPartidaBoton.addActionListener(new manipuladorEventosFuncionalidades());
        panelBotones.add(nuevaPartidaBoton);

        //JButton  Historial General
        JButton HistorialGeneralBoton = new JButton("HISTORIAL GENERAL");
        HistorialGeneralBoton.setFont(new Font("arial", Font.BOLD, 13));
        HistorialGeneralBoton.setForeground(Color.WHITE);
        HistorialGeneralBoton.setBackground(Color.BLACK);
        HistorialGeneralBoton.addActionListener(new manipuladorEventosFuncionalidades());
        panelBotones.add(HistorialGeneralBoton);

        //JButton  Historial Selectivo 
        JButton HistorialSelectivoBoton = new JButton("HISTORIAL SELECTIVO");
        HistorialSelectivoBoton.setFont(new Font("arial", Font.BOLD, 13));
        HistorialSelectivoBoton.setForeground(Color.WHITE);
        HistorialSelectivoBoton.setBackground(Color.BLACK);
        HistorialSelectivoBoton.addActionListener(new manipuladorEventosFuncionalidades());
        panelBotones.add(HistorialSelectivoBoton);

        //JButton  Salir
        JButton SalirBoton = new JButton("SALIR");
        SalirBoton.setFont(new Font("arial", Font.BOLD, 13));
        SalirBoton.setForeground(Color.WHITE);
        SalirBoton.setBackground(Color.BLACK);
        SalirBoton.addActionListener(new manipuladorEventosFuncionalidades());
        panelBotones.add(SalirBoton);
/////////////////////////////////////////////////JMenu bar
        //contenedor JMenuBar y Componentes
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("MENÚ");
        barraMenu.setBackground(Color.black);
        menu.setForeground(Color.white);

        //asociar Jbuttons a  JManubar
        JMenuItem nuevaPartidaMenu = new JMenuItem("NUEVA PARTIDA");
        JMenuItem HistorialGeneralMenu = new JMenuItem("HISTORIAL GENERAL");
        JMenuItem HistorialSelectivoMenu = new JMenuItem("HISTORIAL SELECTIVO");
        JMenuItem SalirMenu = new JMenuItem("SALIR");

        //gestor eventos 
        nuevaPartidaMenu.addActionListener(new manipuladorEventosFuncionalidades());
        HistorialGeneralMenu.addActionListener(new manipuladorEventosFuncionalidades());
        HistorialSelectivoMenu.addActionListener(new manipuladorEventosFuncionalidades());
        SalirMenu.addActionListener(new manipuladorEventosFuncionalidades());

        //meter comp JMenuItem a JMenu
        menu.add(nuevaPartidaMenu);
        menu.add(HistorialGeneralMenu);
        menu.add(HistorialSelectivoMenu);
        menu.add(SalirMenu);

        barraMenu.add(menu);
        ventana.add(barraMenu);

        //panel de menu de iconos
        JToolBar Iconmenu = new JToolBar();
        Iconmenu.setFloatable(false);
////////////////////////////////////////////////Iconos Menu
        //create Buttons
        JButton NuevPartidaIcon = new JButton("NUEVA PARTIDA");
        JButton HistorialGIcon = new JButton("HISTORIAL GENERAL");
        JButton HistorialSIcon = new JButton("HISTORIAL SELECTIVO");
        JButton CambiarFIcon = new JButton("CAMBIAR DIRECTORIO");
        JButton SalirIcon = new JButton("SALIR");
        //Hacemos que el texto no se vea 
        NuevPartidaIcon.setFont(new Font("arial", Font.BOLD, 0));
        HistorialGIcon.setFont(new Font("arial", Font.BOLD, 0));
        HistorialSIcon.setFont(new Font("arial", Font.BOLD, 0));
        CambiarFIcon.setFont(new Font("arial", Font.BOLD, 0));
        SalirIcon.setFont(new Font("arial", Font.BOLD, 0));

        //add Imagen
        NuevPartidaIcon.setIcon(new ImageIcon("iconoNuevaPartida.jpg"));
        HistorialGIcon.setIcon(new ImageIcon("iconoHistorialGeneral.jpg"));
        HistorialSIcon.setIcon(new ImageIcon("iconoHistorialSelectivo.jpg"));
        CambiarFIcon.setIcon(new ImageIcon("iconoCambiarDIrectorio.jpg"));
        SalirIcon.setIcon(new ImageIcon("iconoSalir.jpg"));
        //Add actionlistener
        NuevPartidaIcon.addActionListener(new manipuladorEventosFuncionalidades());
        HistorialGIcon.addActionListener(new manipuladorEventosFuncionalidades());
        HistorialSIcon.addActionListener(new manipuladorEventosFuncionalidades());
        CambiarFIcon.addActionListener(new manipuladorEventosFuncionalidades());
        SalirIcon.addActionListener(new manipuladorEventosFuncionalidades());

        Iconmenu.setBackground(Color.black);
        //Add al JPanel
        Iconmenu.add(NuevPartidaIcon);
        Iconmenu.add(HistorialGIcon);
        Iconmenu.add(HistorialSIcon);
        Iconmenu.add(CambiarFIcon);
        Iconmenu.add(SalirIcon);
//////////////////////////////Botones dentro del juego 
////////////////////////////////////////////////////////////////    

        //Panel VisualizacionmasBotton contiene el boton abandonar 
        panelVisualizacionmasBotton = new JPanel();
        panelVisualizacionmasBotton.setLayout(new CardLayout());

//JButton  Abandonar
        JButton abandonarBoton = new JButton("ABANDONAR");
        abandonarBoton.setFont(new Font("arial", Font.BOLD, 13));
        abandonarBoton.setForeground(Color.YELLOW);
        abandonarBoton.setBackground(Color.BLACK);
        abandonarBoton.addActionListener(new manipuladorEventosFuncionalidades());
        panelVisualizacionmasBotton.add(abandonarBoton);
        panelVisualizacionmasBotton.setVisible(false);
        
        //Panel VisualizacionmasBotton
        panelVisualizacionmasBotton2 = new JPanel();
        panelVisualizacionmasBotton2.setLayout(new CardLayout());

////////////////////////////////////////////////////////////////      
//JButton  Continuar
        JButton ContinuarBoton = new JButton("CONTINUAR");
        ContinuarBoton.setFont(new Font("arial", Font.BOLD, 13));
        ContinuarBoton.setForeground(Color.YELLOW);
        ContinuarBoton.setBackground(Color.BLACK);
        ContinuarBoton.addActionListener(new manipuladorEventosFuncionalidades());

        panelVisualizacionmasBotton2.add(ContinuarBoton);
        panelVisualizacionmasBotton2.setVisible(false);

/////////////////////
        ///JPanelVisualizacion
        panelVisualizacion = new JPanel();
        panelVisualizacion.setLayout(new CardLayout());
////////////////////////////////////////////////////////////////
        //JPanel Standby
        panelStandby = new JPanel();
        panelStandby.setLayout(new FlowLayout());
////////////////////////////////////////////////////////////////
        //JLabelIMagenUIB
        JLabel imagenUIB = new JLabel(new ImageIcon("UIB.jpg"));
        panelStandby.add(imagenUIB, BorderLayout.CENTER);

        ///Introduccion Contenedor Panel Visualizacion
        panelVisualizacion.add(panelStandby, "STANDBY");

        ImagenResuelto = new JPanel();
        
//////////////////////////////////////////////////////////////Separadores para la visualizacion 
        //separadores 
        separador = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        separador2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        separador3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        panelContenidos.add(barraMenu, BorderLayout.NORTH);
//        panelContenidos.add(panelVisualizacion, BorderLayout.SOUTH);

        separador3.setTopComponent(panelVisualizacion);
        separador3.setBottomComponent(panelVisualizacionmasBotton);

        separador.setLeftComponent(panelBotones);
        separador.setRightComponent(separador3);
        panelContenidos.add(separador, BorderLayout.SOUTH);

        //separador2
        separador2.setTopComponent(Iconmenu);
        separador2.setBottomComponent(separador);
        panelContenidos.add(separador2, BorderLayout.CENTER);

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }
//MANIPULADOR DE EVENTOS DE LOS BOTOTNES 

    private class manipuladorEventosFuncionalidades implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            CardLayout panel = (CardLayout) (panelVisualizacion.getLayout());
            switch (evento.getActionCommand()) {
                case "NUEVA PARTIDA":
                    if (!cambio) {
                        if (nuevapartida()) { //cogemos los datos del usuario 
                            primerainstancia(); // solo se realiza une vez 
                            instanciajuego();
                            panel.show(panelVisualizacion, "NIVEL");
                            //Ponemos el boton de abandonar
                            panelVisualizacionmasBotton.setVisible(true);
                            panel.show(panelVisualizacion, "PANELBOTON");
                            separador3.setDividerLocation(800);
                        }
                    }
                    break;
                case "HISTORIAL GENERAL":
                    if (partida == false) { //controlador para no meterse mientras juegas 
                        historialgeneral();
                        panel.show(panelVisualizacion, "HISTORIAL");
                    } else {
                        IntentoSalir();
                    }
                    break;

                case "HISTORIAL SELECTIVO":
                    if (partida == false) {//controlador para no meterse mientras juegas 
                        if (HistorialJugador()) {
                            panel.show(panelVisualizacion, "HISTORIAL");
                        }
                    } else {
                        IntentoSalir();
                    }
                    break;
                case "CAMBIAR DIRECTORIO":
                    break;
                case "SALIR":
                    System.exit(0);
                    break;
                case "ABANDONAR":
                    //mensaje de abandono
                    JOptionPane.showMessageDialog(ventana,
                            "NO LO HAS CONSEGUIDO-FALTA DE PACIENCIA"
                    );
                    jugador.setPuntiacion(0);
                    paritdaacaba();
                    break;
                case "CONTINUAR":
                    panelVisualizacionmasBotton2.setVisible(false);
                    separador3.setTopComponent(panelVisualizacion);
                    separador3.setBottomComponent(panelVisualizacionmasBotton);
                    panel.show(panelVisualizacion, "STANDBY");
                    break;

            }
        }

    }

    //METODO QUE INSTACIA LA PARTIDA SE HACE SOLO UNA VEZ:
    //BUSCA UN FICHERO ALEATIORIO
    //INSTANCIA LAS SUBDIVISIONES Y GUARDA LAS CORDENADAS DE CADA PIEZA 
    //DESORDENA LAS PIEZAS 
    private void primerainstancia() {
        if (partida == false) {
            panelJuego = new JPanel();
            panelJuego.setLayout(new BorderLayout());
            file = new FicheroAleatorio();
            posicion = new PosicionPiezas(numeroColumnas, numeroFilas);
            posicion.SetCoordenadas(posicion, file.Ficheronombre());
            posicion.desordenar();
            partida = true;

        }
    }

    //METODO QUE REINICIA LA VISUALIZACION DEL JUEGO SEGUN LAS PIEZAS MARCADAS
    private void instanciajuego() {
        if (cambio == true) {
            panelJuego.remove(puz);
        }

        puz = new panelSubimagen(numeroColumnas, numeroFilas, file.Ficheronombre(), new manipuladorEventosPanelJuego(), posicion);
        panelJuego.add(puz, BorderLayout.CENTER);
        panelVisualizacion.add(panelJuego, "NIVEL");
        cambio = false;

    }

    //VENTANA EMERGENTE PARA CONSEGUIR LOS DATOS DE LA NUEVA PARTIDA 
    private boolean nuevapartida() {
        String[] datos = {"NOMBRE DEL JUGADOR", "SUBDIVISIONES HORIZONTALES", "SUBDIVISIONES VERTICALES"};
        datos = new lecturaDatos(ventana, datos, '0').getDatosTexto();
        if (datos != null) {
            jugador = new Jugador();
            jugador.setJugador(datos[0].toCharArray());

            try {
                numeroColumnas = Integer.parseInt(datos[1]);
                numeroFilas = Integer.parseInt(datos[2]);
            } catch (NumberFormatException error) {
                entradaIncorrecta();
                return false;
            }

            return true;
        } else {
            entradaIncorrecta();
            return false;
        }
    }

    //METODO QUE LLAMA A HIS PARA GUARDAR LA INFORMACION DE LA PARTIDA  
    private void GuardarInfo() {
        his = new Historial(NombreFicheroHistorial);
        his.GuardarHistorial(jugador);
    }

    //PARTIDA TERMINADA
    private void paritdaacaba() {
        CardLayout panel = (CardLayout) (panelVisualizacion.getLayout());

        //ESTO HAY QUE CAMBIARLO
        panel.show(panelVisualizacion, "STANDBY");
        win = false;
        partida = false;
        CuadroSeleccionado = -1;
        CuadroSeleccionado2 = -1;

        GuardarInfo();

        System.out.println(jugador.toString());
        panelVisualizacionmasBotton.setVisible(false);

        VerImPuzzle();
        separador3.setTopComponent(ImagenResuelto);
        separador3.setBottomComponent(panelVisualizacionmasBotton2);
        panelVisualizacionmasBotton2.setVisible(true);

    }
///ENSEÑA EN PANTALLA LA IMAGEN QUE HEMOS RESUELTO 
    private void VerImPuzzle() {
        ImageIcon ic = new ImageIcon(file.toString());
        //logica para que se ajuste al tamaño de la pantalla la imagen
        Image image = ic.getImage().getScaledInstance(panelVisualizacion.getWidth(), panelVisualizacion.getHeight(), Image.SCALE_SMOOTH);
        ic = new ImageIcon(image);
        JLabel Imagen = new JLabel(ic);

        ImagenResuelto.add(Imagen);

    }

    ////MOUSE LISTENER PUZZLE
    private class manipuladorEventosPanelJuego implements MouseListener {

        @Override
        public void mousePressed(MouseEvent evento) {

            if (CuadroSeleccionado == -1) {// si es igual a -1 es que no esta seleccionado
                CuadroSeleccionado = puz.SeleccionCuadro(evento);
                //se le da el valor del cuadrado seleccionado
            } else if (CuadroSeleccionado != -1) {//aqui cogemos el del segundo valor 
                CuadroSeleccionado2 = puz.SeleccionCuadro(evento);
                //cambiamos la posicion de las piezas en el registro
                posicion.cambiopiezas(CuadroSeleccionado, CuadroSeleccionado2);
                cambio = true;
                //ponemos los valores centinela 
                CuadroSeleccionado = -1;
                CuadroSeleccionado2 = -1;
                referscar = true;
            }
          
            //si no hemos ganado,pero hay que refrescar se instancia el juego otra vez
            //con el registro cambiado y el cambio se ve reflejado
            if (win == false && referscar == true) {
                instanciajuego();
                CardLayout panel = (CardLayout) (panelVisualizacion.getLayout());
                panel.show(panelVisualizacion, "NIVEL");
                referscar = false;
                
            }
             //si estan ordenadas ponemos win=true
            if (posicion.ordenadas() == true) {
                    win = true;
                }
            
            if (win == true) {

                JOptionPane.showMessageDialog(ventana,
                        "HAS GANADO!!!!");
                jugador.setPuntiacion(10);
                paritdaacaba();

            }
            

        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
//metodo que muestra todo el historial recibido
//PARA VISUALIZAR EL HISTORIAL GENERAL

    private void historialgeneral() {
        //instanciamos el string que nos mostrará el historial
        String historial = "\t" + "HISTORIAL" + "\n" + "\n";
        
        JPanel panelHistorial = new JPanel();
        JTextArea texto = new JTextArea();

        his = new Historial(NombreFicheroHistorial);
        historial = historial + his.HistorialGeneral();
        texto.setText(historial);
        panelHistorial.add(texto);
        panelVisualizacion.add(panelHistorial, "HISTORIAL");
        panelHistorial.setLayout(new CardLayout());
        texto.setFont(new Font("arial", Font.BOLD, 45));
        ///SCROLLPANE
        JScrollPane scrollPane = new JScrollPane(texto);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelHistorial.add(scrollPane, BorderLayout.CENTER);

    }
//PARA VISUALIZAR EL HISTORIAL SELECTIVO

    private boolean HistorialJugador() {
        
        String historial = "\t" + "HISTORIAL SELECTIVO" + "\n" + "\n";
        JPanel panelHistorial = new JPanel();
        JTextArea texto = new JTextArea();

        his = new Historial(NombreFicheroHistorial);
        panelJuego = new JPanel();
        panelJuego.setLayout(new BorderLayout());
        
        String[] datos = {"HISTORIAL DEL JUGADOR" + "\n" + "INTRODUCIR NOMBRE DEL JUGADOR"};
        datos = new lecturaDatos(ventana, datos, '1').getDatosTexto();
        ///miramos que los datos sean correctos 
        if (datos != null) {
            historial = historial + his.HistorialSelectivo(datos[0].toCharArray());
            texto.setText(historial);
            panelHistorial.add(texto);
            panelVisualizacion.add(panelHistorial, "HISTORIAL");
            panelHistorial.setLayout(new CardLayout());
            texto.setFont(new Font("arial", Font.BOLD, 45));
            //AÑADIMOS SCROLLPANE
            JScrollPane scrollPane = new JScrollPane(texto);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            panelHistorial.add(scrollPane, BorderLayout.CENTER);
            return true;
        } else {
            entradaIncorrecta();
            return false;
        }

    }

    private void entradaIncorrecta() {

        JOptionPane.showMessageDialog(ventana, //contenedor padre
                "¡¡¡ NO HAS INTRODUCIDO LOS DATOS CORRECTAMENTE"
                + " !!!"//texto visualizado
        );

    }

    private void IntentoSalir() {
        JOptionPane.showMessageDialog(ventana, //contenedor padre
                "Abandona o termina la parida  "
                + "para salir"//texto visualizado
        );
    }

}
