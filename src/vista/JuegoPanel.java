/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
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
    private JButton jbCheck;
    private JButton jbSonido;
    private JLabel lbCuentaRegresiva;
    private ImageIcon[] countdownImgs;
    private int currentIndex = 0;
    private ImageIcon aUnoImg;
    private ImageIcon aDosImg;
    private ImageIcon bUnoImg;
    private ImageIcon bDosImg;
    private ImageIcon cUnoImg;
    private ImageIcon cDosImg;
    private ImageIcon dUnoImg;
    private ImageIcon dDosImg;
    private ImageIcon[] cuadradosIcons;
    private JLabel aUno;
    private JLabel aDos;
    private JLabel bUno;
    private JLabel bDos;
    private JLabel cUno;
    private JLabel cDos;
    private JLabel dUno;
    private JLabel dDos;

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
        
        actualizarConteo();
        
        jpContenido.add(jpConteo);
        
        
        // Panel Jugable
        
        jpJuego = new JPanel();
        jpJuego.setLayout(null);
        jpJuego.setSize(this.getWidth(),this.getHeight());
        jpJuego.setOpaque(false);
        jpJuego.setVisible(false);
        
        // Boton Check
        imgCheck = new ImageIcon(getClass().getResource("/imagenes/Check.png"));
        Image imgC = imgCheck.getImage();
        imgC = imgC.getScaledInstance(200,200,Image.SCALE_SMOOTH); // Escalar el icono
        imgCheck = new ImageIcon(imgC);
        jbCheck = new JButton(imgCheck);
        jbCheck.setBorderPainted(false);
        jbCheck.setContentAreaFilled(false);
        jbCheck.setFocusPainted(false);
        jbCheck.setBounds(920, 550, imgCheck.getIconWidth(), imgCheck.getIconHeight());
        jbCheck.setVisible(true);
        
        jpJuego.add(jbCheck);
        
        
        // Configurar zonas donde van a ir los cuadrados
        
        List<Point> posiciones = new ArrayList<>(); // Lista con las posiciones donde van los cuadrados
        posiciones.add(new Point(5, 320));
        posiciones.add(new Point(230, 320));
        posiciones.add(new Point(535, 10));
        posiciones.add(new Point(535, 200));
        posiciones.add(new Point(790, 320));
        posiciones.add(new Point(980, 320));
        posiciones.add(new Point(535, 435));
        posiciones.add(new Point(535, 615));
        

        // A1
        aUno = new JLabel("pox a1");
        
        aUnoImg = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_1.png"));
        Image imgAU = aUnoImg.getImage();
        imgAU = imgAU.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        aUnoImg = new ImageIcon(imgAU);
        
        //aUno.setIcon(aUnoImg);
        aUno.setBounds(5, 320, aUnoImg.getIconWidth(), aUnoImg.getIconHeight());
        
        jpJuego.add(aUno);
        
        // A2
        aDos = new JLabel("pox a2");
        
        aDosImg = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_2.png"));
        Image imgAD = aDosImg.getImage();
        imgAD = imgAD.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        aDosImg = new ImageIcon(imgAD);
        
        //aDos.setIcon(aDosImg);
        aDos.setBounds(230, 320, aDosImg.getIconWidth(), aDosImg.getIconHeight());
        
        jpJuego.add(aDos);
        
        // B1
        bUno = new JLabel("pox b1");
        
        bUnoImg = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_2.png"));
        Image imgBU = bUnoImg.getImage();
        imgBU = imgBU.getScaledInstance(185, 185, Image.SCALE_SMOOTH);
        bUnoImg = new ImageIcon(imgBU);
        
        //bUno.setIcon(bUnoImg);
        bUno.setBounds(535, 10, bUnoImg.getIconWidth(),bUnoImg.getIconHeight());
        
        jpJuego.add(bUno);
        
        
        // B2
        bDos = new JLabel("pox b2");
        
        bDosImg = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_4.png"));
        Image imgBD = bDosImg.getImage();
        imgBD = imgBD.getScaledInstance(185, 185, Image.SCALE_SMOOTH);
        bDosImg = new ImageIcon(imgBD);
        
//        bDos.setIcon(bDosImg);
        bDos.setBounds(535, 200, bDosImg.getIconWidth(), bDosImg.getIconHeight());
        
        jpJuego.add(bDos);
        
        // C1
        cUno = new JLabel("pox c1");
        
        cUnoImg = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_1.png"));
        Image imgCU = cUnoImg.getImage();
        imgCU = imgCU.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cUnoImg = new ImageIcon(imgCU);
        
//        cUno.setIcon(cUnoImg);
        cUno.setBounds(980, 320, cUnoImg.getIconWidth(), cUnoImg.getIconHeight());
        
        jpJuego.add(cUno);
        
        // C2
        cDos = new JLabel("pox c2");
        
        cDosImg = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_2.png"));
        Image imgCD = cDosImg.getImage();
        imgCD = imgCD.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        cDosImg = new ImageIcon(imgCD);
        
//        cDos.setIcon(cDosImg);
        cDos.setBounds(790, 320, cDosImg.getIconWidth(), cDosImg.getIconHeight());
        
        jpJuego.add(cDos);
        
        // D1
        dUno = new JLabel("pox d1");
        
        dUnoImg = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_3.png"));
        Image imgDU = dUnoImg.getImage();
        imgDU = imgDU.getScaledInstance(185, 185, Image.SCALE_SMOOTH);
        dUnoImg = new ImageIcon(imgDU);
        
//        dUno.setIcon(dUnoImg);
        dUno.setBounds(535, 615, dUnoImg.getIconWidth(),dUnoImg.getIconHeight());
        
        jpJuego.add(dUno);
        
        // D2
        dDos = new JLabel("pox d2");
        
        dDosImg = new ImageIcon(getClass().getResource("/imagenes/Blocks/Block_4.png"));
        Image imgDD = dDosImg.getImage();
        imgDD = imgDD.getScaledInstance(185, 185, Image.SCALE_SMOOTH);
        dDosImg = new ImageIcon(imgDD);
        
//        dDos.setIcon(dDosImg);
        dDos.setBounds(535, 435, dDosImg.getIconWidth(), dDosImg.getIconHeight());
        
        jpJuego.add(dDos);
        
        
        jpContenido.add(jpJuego);
        
        
        add(jpContenido);
    }
    
    public void actualizarConteo(){
        
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
    
    public JLabel getLbAU(String posicion){
        return aUno;
    }
    public JLabel getLbAD(String posicion){
        return aDos;
    }
    public JLabel getLbBU(String posicion){
        return bUno;
    }
    public JLabel getLbBD(String posicion){
        return bDos;
    }
    public JLabel getLbCU(String posicion){
        return cUno;
    }
    public JLabel getLbCD(String posicion){
        return cDos;
    }
    public JLabel getLbDU(String posicion){
        return dUno;
    }
    public JLabel getLbDD(String posicion){
        return dDos;
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
    
    public void addPanelMouseMotionListener(MouseMotionAdapter listener){
        jpContenido.addMouseMotionListener(listener);
    }
}