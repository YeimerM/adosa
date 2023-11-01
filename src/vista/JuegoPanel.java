/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */
package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JuegoPanel extends JPanel {

    private JPanel jpContenido;
    private JPanel jpConteo;
    private JPanel jpJuego;
    private ImageIcon imgJuegoBg;
    private ImageIcon imgVidas;
    private ImageIcon imgCheck;
    private ImageIcon imgSonido;
    private JLabel jlVida1;
    private JLabel jlVida2;
    private JLabel jlVida3;
    private JButton jbSonido;
    private JButton jbCheck;
    private JLabel jlPuntaje;
    private JLabel lbCuentaRegresiva;
    private ImageIcon[] countdownImgs;
    private int currentIndex = 0;
    private ImageIcon cuadroA;
    private ImageIcon cuadroB;
    private ImageIcon cuadroC;
    private ImageIcon cuadroD;
    private ImageIcon cuadroE;
    private ImageIcon cuadroF;
    private ImageIcon cuadroG;
    private ImageIcon cuadroH;
    private ImageIcon[] cuadradosIcons;
    private ArrayList<ImageIcon> cuadrosImgs;
    private ArrayList<JLabel> posicionesCuadro;
    private JLabel aUno;
    private JLabel aDos;
    private JLabel bUno;
    private JLabel bDos;
    private JLabel cUno;
    private JLabel cDos;
    private JLabel dUno;
    private JLabel dDos;
    private boolean cuadrossIguales;

    public JuegoPanel() {
        initComponentes();
    }

    private void initComponentes() {

        setSize(new Dimension(1260, 830));
        setVisible(true);
        
        imgJuegoBg = new ImageIcon(getClass().getResource("/imagenes/JuegoBg.png"));
        
        
        jpContenido = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgJuegoBg.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        jpContenido.setSize(this.getSize());
        jpContenido.setLayout(null);
        
        // Labels de vidas
        imgVidas = new ImageIcon(getClass().getResource("/imagenes/Vida.png"));
        Image imgV = imgVidas.getImage();
        imgV = imgV.getScaledInstance(80,80,Image.SCALE_SMOOTH); // Escalar el icono
        imgVidas = new ImageIcon(imgV);
        jlVida1 = new JLabel(imgVidas);
        jlVida1.setBounds(970, 10, imgVidas.getIconWidth(), imgVidas.getIconHeight());
        jlVida2 = new JLabel(imgVidas);
        jlVida2.setBounds(1060, 10, imgVidas.getIconWidth(), imgVidas.getIconHeight());
        jlVida3 = new JLabel(imgVidas);
        jlVida3.setBounds(1150, 10, imgVidas.getIconWidth(), imgVidas.getIconHeight());
        
        jpContenido.add(jlVida1);
        jpContenido.add(jlVida2);
        jpContenido.add(jlVida3);
        
        // Boton Sonido On/Off  
        
        imgSonido = new ImageIcon(getClass().getResource("/imagenes/Sonido.png"));
        Image imgS = imgSonido.getImage();
        imgS = imgS.getScaledInstance(100,100,Image.SCALE_SMOOTH); // Escalar el icono
        imgSonido = new ImageIcon(imgS);
        jbSonido = new JButton(imgSonido);
        jbSonido.setBorderPainted(false);
        jbSonido.setContentAreaFilled(false);
        jbSonido.setFocusPainted(false);
        jbSonido.setBounds(25, 650, imgSonido.getIconWidth(), imgSonido.getIconHeight());
        
        jpContenido.add(jbSonido);
        
        
        // Panel de countdown
        
        jpConteo = new JPanel();
        jpConteo.setBounds(410,265,420,235);
        jpConteo.setVisible(true);
        jpConteo.setOpaque(false);
        
        lbCuentaRegresiva = new JLabel("", SwingConstants.CENTER);
        jpConteo.add(lbCuentaRegresiva);
        
        countdownImgs = new ImageIcon[]{
                new ImageIcon(getClass().getResource("/imagenes/numero_3.png")),
                new ImageIcon(getClass().getResource("/imagenes/numero_2.png")),
                new ImageIcon(getClass().getResource("/imagenes/numero_1.png")),
                new ImageIcon(getClass().getResource("/imagenes/Ya.png"))
        };
        
        
        jpContenido.add(jpConteo);
        
        
        // Panel Jugable
        
        jpJuego = new JPanel();
        jpJuego.setLayout(null);
        jpJuego.setSize(this.getWidth(),this.getHeight());
        jpJuego.setOpaque(false);
        jpJuego.setVisible(false);
        
        // Boton Check
        imgCheck = new ImageIcon(getClass().getResource("/imagenes/Check.png"));
        Image imgCh = imgCheck.getImage();
        imgCh = imgCh.getScaledInstance(200,200,Image.SCALE_SMOOTH); // Escalar el icono
        imgCheck = new ImageIcon(imgCh);
        jbCheck = new JButton(imgCheck);
        jbCheck.setBorderPainted(false);
        jbCheck.setContentAreaFilled(false);
        jbCheck.setFocusPainted(false);
        jbCheck.setBounds(920, 550, imgCheck.getIconWidth(), imgCheck.getIconHeight());
        
        jpJuego.add(jbCheck);
        
        // Label Puntaje
        jlPuntaje = new JLabel();
        jlPuntaje.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
        jlPuntaje.setBounds(330,3,100,100);
        
        
        mostrarConteo();
        
        jpJuego.add(jlPuntaje);
        
        // imagenes de los cuadros
        
        // Cuadrado uno
        cuadroA = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_1.png")); 
        Image imgA = cuadroA.getImage();
        imgA = imgA.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cuadroA = new ImageIcon(imgA);
        
        // Cuadrado dos
        cuadroB = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_2.png"));
        Image imgB = cuadroB.getImage();
        imgB = imgB.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cuadroB = new ImageIcon(imgB);
        
        // Cuadrado tres
        cuadroC = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_3.png"));
        Image imgC = cuadroC.getImage();
        imgC = imgC.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cuadroC = new ImageIcon(imgC);
        
        // Cuadrado Cuatro
        cuadroD = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_4.png"));
        Image imgD = cuadroD.getImage();
        imgD = imgD.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cuadroD = new ImageIcon(imgD);
        
        // Cuadrado Cinco
        cuadroE = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_5.png"));
        Image imgE = cuadroE.getImage();
        imgE = imgE.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cuadroE = new ImageIcon(imgE);
        
        // Cuadrado Seis
        cuadroF = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_6.png"));
        Image imgF = cuadroF.getImage();
        imgF = imgF.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cuadroF = new ImageIcon(imgF);
        
        // Cuadrado Siete
        cuadroG = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_7.png"));
        Image imgG = cuadroG.getImage();
        imgG = imgG.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cuadroG = new ImageIcon(imgG);
        
        // Cuadrado Ocho
        cuadroH = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_8.png"));
        Image imgH = cuadroH.getImage();
        imgH = imgH.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cuadroH = new ImageIcon(imgH);
        
        // Lista cuadros
        
        cuadrosImgs = new ArrayList<>();
        cuadrosImgs.add(cuadroA);
        cuadrosImgs.add(cuadroB);
        cuadrosImgs.add(cuadroC);
        cuadrosImgs.add(cuadroD);
        cuadrosImgs.add(cuadroE);
        cuadrosImgs.add(cuadroF);
        cuadrosImgs.add(cuadroG);
        cuadrosImgs.add(cuadroH);

        // Posiciones de los Cuadrados
        
        // A1
        aUno = new JLabel();
        aUno.setBounds(5, 320, 190, 190);
        
        // A2
        aDos = new JLabel();
        aDos.setBounds(230, 320, 190, 190);
        
        // B1
        bUno = new JLabel();
        bUno.setBounds(535, 10, 185,185);
        
        // B2
        bDos = new JLabel();
        bDos.setBounds(535, 200, 185, 185);
        
        // C1
        cUno = new JLabel();
        cUno.setBounds(980, 320, 190, 190);
        
        // C2
        cDos = new JLabel();
        cDos.setBounds(790, 320, 190, 190);
        
        // D1
        dUno = new JLabel();
        dUno.setBounds(535, 615, 185,185);
        
        // D2
        dDos = new JLabel();
        dDos.setBounds(535, 435, 185, 185);
        
        // Lista de las posiciones
        posicionesCuadro = new ArrayList<>();
        posicionesCuadro.add(aUno);
        posicionesCuadro.add(aDos);
        posicionesCuadro.add(bUno);
        posicionesCuadro.add(bDos);
        posicionesCuadro.add(cUno);
        posicionesCuadro.add(cDos);
        posicionesCuadro.add(dUno);
        posicionesCuadro.add(dDos);

        
        jpContenido.add(jpJuego);
        
        add(jpContenido);
    }
    
    public void mostrarConteo(){
        
        Timer timer = new Timer();
        
        TimerTask tarea = new TimerTask(){
            @Override
            public void run() {
                if (currentIndex < countdownImgs.length) {
                    ImageIcon imageIcon = countdownImgs[currentIndex];
                    lbCuentaRegresiva.setIcon(imageIcon);
                    currentIndex++;
                } else {
                    cancel();
                    jpConteo.setVisible(false);
                    jpJuego.setVisible(true);
                }
            }
        };
        
        timer.scheduleAtFixedRate(tarea, 0,1000);
    }
    
   
    
    
    // Aqui usaremos la lista de cuadros para elejir el numero de cuadros a mostrar que seran 3 al inicio e ira aumentando con el nivel
    // Usaremos también una lista con las posiciones y esta se elijira al azar con el mismo parametro que elejir las 3 figuras
    // Cada vez que elijamos una cuadro a mostrar y una posicion esta se borrará para no repetirse
    public void mostrarCuadros(int nCuadros){
        
        Random rand = new Random();
        
        // Clonamos la lista de cuadrosImgs y posicionesCuadro para no modificar las originales
        ArrayList<ImageIcon> cuadrosDisponibles = new ArrayList<>(cuadrosImgs);
        ArrayList<JLabel> posicionesDisponibles = new ArrayList<>(posicionesCuadro);
        
        // Listas para almacenar los cuadros y las posiciones elegidas
        ArrayList<ImageIcon> cuadrosElegidos = new ArrayList<>();
        ArrayList<JLabel> posicionesElegidas = new ArrayList<>();
        
        for(int i = 0 ; i < nCuadros ; i++ ){
            // Elegir un índice aleatorio para cuadrosDisponibles
            int indiceCuadro = rand.nextInt(cuadrosDisponibles.size());
            int indicePosicion = rand.nextInt(posicionesDisponibles.size());
            
            // Agregar el cuadro y la posición elegidos a las listas correspondientes
            cuadrosElegidos.add(cuadrosDisponibles.get(indiceCuadro));
            posicionesElegidas.add(posicionesDisponibles.get(indicePosicion));
            
            // Agregamos cada cuadro al panel
            posicionesDisponibles.get(indicePosicion).setIcon(cuadrosDisponibles.get(indiceCuadro));
            jpJuego.add(posicionesDisponibles.get(indicePosicion));
            
            // Eliminar el cuadro y la posición elegidos de cuadrosDisponibles y posicionesDisponibles
            cuadrosDisponibles.remove(indiceCuadro);
            posicionesDisponibles.remove(indicePosicion);
        }
        
        // Talves necesite empezar a cambiar las figuras desde aqui mismo y verificar las figuras en pantalla desde aqui tambien
        // Hacer un while y crear un valos boolean que diga si hay dos figuras iguales en pantalla
        // Mientras este sea falso se da el while
        
        ArrayList<ImageIcon> cuadrosCambio = new ArrayList<>(cuadrosImgs);
            Timer time = new Timer();
            TimerTask tar = new TimerTask(){
                @Override
                public void run() {
                    if(((String.valueOf(posicionesElegidas.get(nCuadros-1).getIcon()) == null ? String.valueOf(posicionesElegidas.get(nCuadros-2).getIcon()) == null : String.valueOf(posicionesElegidas.get(nCuadros-1).getIcon()).equals(String.valueOf(posicionesElegidas.get(nCuadros-2).getIcon())))
                                || (String.valueOf(posicionesElegidas.get(nCuadros-1).getIcon()) == null ? String.valueOf(posicionesElegidas.get(nCuadros-3).getIcon()) == null : String.valueOf(posicionesElegidas.get(nCuadros-1).getIcon()).equals(String.valueOf(posicionesElegidas.get(nCuadros-3).getIcon()))) 
                                ||(String.valueOf(posicionesElegidas.get(nCuadros-2).getIcon()) == null ? String.valueOf(posicionesElegidas.get(nCuadros-3).getIcon()) == null : String.valueOf(posicionesElegidas.get(nCuadros-2).getIcon()).equals(String.valueOf(posicionesElegidas.get(nCuadros-3).getIcon()))))){
                        cancel();
                        cuadrossIguales = true;
                    } else{
                        // Esto elige un cuadro al azar y luego lo pone en una posicion al azar de las posiciones que tiene en este momento
                        int indCuadroCambiar = rand.nextInt(posicionesElegidas.size());
                        ImageIcon imgElegida = cuadrosCambio.get(rand.nextInt(cuadrosCambio.size()));
                        posicionesElegidas.get(indCuadroCambiar).setIcon(imgElegida); // Elige la posicion y poner set Icon
                        cuadrossIguales = false;
                    }
                }
                

            };
            time.scheduleAtFixedRate(tar, 0,1500);
    }
    
    public boolean getCuadrosIguales(){
        return cuadrossIguales;
    }
    
    public void verificarCuadro(){
        
    }

    public JPanel getPanel() {
        return jpContenido;
    }
    
    public JLabel getLbCuentaRegresiva(){
        return lbCuentaRegresiva;
    }
    
    public JPanel getJpConteo(){
        return jpConteo;
    }

    public JLabel getJlPuntaje() {
        return jlPuntaje;
    }
    
    // Listener
    
    public void addPanelMouseMotionListener(MouseMotionAdapter listener){
        jpContenido.addMouseMotionListener(listener);
    }
    
    public void addPanelJuegoListener(ComponentAdapter listener){
        jpJuego.addComponentListener(listener);
    }
    
    public void addCheckListener(MouseAdapter listener){
        jbCheck.addMouseListener(listener);
    }
}