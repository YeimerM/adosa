/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package vista;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InstruPanel extends JPanel{
    private CardLayout cdLayout;
    private JPanel jpContenido;
    private ImageIcon imgInstru1;
    private ImageIcon imgInstru2;
    private ImageIcon imgInstru3;
    private ImageIcon imgInstru4;
    private JPanel jpInstru1;
    private JPanel jpInstru2;
    private JPanel jpInstru3;
    private JPanel jpInstru4;
    private JButton jbNext;
    private JButton jbBack;
    private JButton jbExit;
    private ImageIcon imgNext;
    private ImageIcon imgBack;
    private ImageIcon imgExit;
    private int paginaActual; // Contador de pág instrucciones
    
    public InstruPanel(){
        initComponentes();
    }

    private void initComponentes() {
        setSize(new Dimension(1142, 764));
        setVisible(true);
        paginaActual = 0;
        
        // Configurar Panel contenido
        cdLayout = new CardLayout();
        jpContenido = new JPanel(cdLayout);
        jpContenido.setSize(this.getSize());
        
        // Configurar panel instru 1
        imgInstru1 = new ImageIcon(getClass().getResource("/imagenes/Instru1.png"));
        jpInstru1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgInstru1.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        jpInstru1.setSize(new Dimension(1260, 800));
        jpInstru1.setLayout(null);
        
        // Configurar panel instru 2
        imgInstru2 = new ImageIcon(getClass().getResource("/imagenes/Instru2.png"));
        jpInstru2 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgInstru2.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        jpInstru2.setSize(new Dimension(1260, 800));
        jpInstru2.setLayout(null);
        
        // Configurar panel instru 3
        imgInstru3 = new ImageIcon(getClass().getResource("/imagenes/Instru3.png"));
        jpInstru3 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgInstru3.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        jpInstru3.setSize(new Dimension(1260, 800));
        jpInstru3.setLayout(null);
        
        // Configurar panel instru 4
        imgInstru4 = new ImageIcon(getClass().getResource("/imagenes/Instru4.png"));
        jpInstru4 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgInstru4.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        jpInstru4.setSize(new Dimension(1260, 800));
        jpInstru4.setLayout(null);
        
        
        // Configurar los botones
        // Boton Siguiente
        imgNext = new ImageIcon(getClass().getResource("/imagenes/Siguiente.png"));
        Image imgN = imgNext.getImage();
        imgN = imgN.getScaledInstance(220,90,Image.SCALE_SMOOTH); // Escalar el icono
        imgNext = new ImageIcon(imgN);
        
        jbNext = new JButton(imgNext);
        jbNext.setBorderPainted(false);
        jbNext.setContentAreaFilled(false);
        jbNext.setFocusPainted(false);
        jbNext.setBounds(1005, 225, imgNext.getIconWidth(), imgNext.getIconHeight());
        
        // Boton Salir
        imgExit = new ImageIcon(getClass().getResource("/imagenes/X.png"));
        Image imgE = imgExit.getImage();
        imgE = imgE.getScaledInstance(125,115,Image.SCALE_SMOOTH); // Escalar el icono
        imgExit = new ImageIcon(imgE);
        
        jbExit = new JButton(imgExit);
        jbExit.setBorderPainted(false);
        jbExit.setContentAreaFilled(false);
        jbExit.setFocusPainted(false);
        jbExit.setBounds(1115, 30, imgExit.getIconWidth(), imgExit.getIconHeight());
        
        
        // Boton Atras
        imgBack = new ImageIcon(getClass().getResource("/imagenes/Anterior.png"));
        Image imgB = imgBack.getImage();
        imgB = imgB.getScaledInstance(220,90,Image.SCALE_SMOOTH); // Escalar el icono
        imgBack = new ImageIcon(imgB);
        
        jbBack = new JButton(imgBack);
        jbBack.setBorderPainted(false);
        jbBack.setContentAreaFilled(false);
        jbBack.setFocusPainted(false);
        jbBack.setBounds(30, 225, imgBack.getIconWidth(), imgBack.getIconHeight());
        jbBack.setVisible(false);
        
        
        
        jpContenido.add(jpInstru1, "instru");
        jpContenido.add(jpInstru2, "instru2");
        jpContenido.add(jpInstru3, "instru3");
        jpContenido.add(jpInstru4, "instru4");
        
        // Añadir botones al panel
        if (paginaActual == 0){
            jpInstru1.add(jbExit);
            jpInstru1.add(jbNext);
            jpInstru1.add(jbBack);
            cdLayout.show(jpContenido,"instru");
        }
        
    }
    
    public JPanel getPanel(){
        return jpContenido;
    }
    
    public void volverManu(){
        System.out.println("volviendo al menu...");
        paginaActual = 0;
        jpInstru1.add(jbExit);
        jpInstru1.add(jbNext);
        jpInstru1.add(jbBack);
        jbBack.setVisible(false);
        jbNext.setVisible(true);
        cdLayout.show(jpContenido,"instru");
        jpContenido.setVisible(false);
        
    }
    
    public void avanzarPag(){
        if (paginaActual < 3) {
            paginaActual++;
            cdLayout.show(jpContenido, "instru" + (paginaActual + 1));
            jbBack.setVisible(true);
            if (paginaActual == 1){
                jpInstru2.add(jbExit);
                jpInstru2.add(jbNext);
                jpInstru2.add(jbBack);
            } else if(paginaActual == 2){
                jpInstru3.add(jbExit);
                jpInstru3.add(jbNext);
                jpInstru3.add(jbBack);
            } else if(paginaActual == 3){
                jpInstru4.add(jbExit);
                jpInstru4.add(jbNext);
                jpInstru4.add(jbBack);
            }
            if (paginaActual == 3) {
                jbNext.setVisible(false);
            }
            if (paginaActual != 3){
                jbNext.setVisible(true);
            }
            if(paginaActual != 0){
                jbBack.setVisible(true);
            }
        }
    }
    
    public void retrocederPag() {
        if (paginaActual > 0) {
            paginaActual--;
            cdLayout.show(jpContenido, "instru" + (paginaActual + 1));
            if (paginaActual == 1){
                jpInstru2.add(jbExit);
                jpInstru2.add(jbNext);
                jpInstru2.add(jbBack);
            } else if(paginaActual == 2){
                jpInstru3.add(jbExit);
                jpInstru3.add(jbNext);
                jpInstru3.add(jbBack);
            } else if(paginaActual == 3){
                jpInstru4.add(jbExit);
                jpInstru4.add(jbNext);
                jpInstru4.add(jbBack);
            }
            
            
            
            if (paginaActual == 0){
                cdLayout.show(jpContenido, "instru");
                jpInstru1.add(jbExit);
                jpInstru1.add(jbNext);
                jpInstru1.add(jbBack);
                jbBack.setVisible(false);
            }
            if(paginaActual != 0){
                jbBack.setVisible(true);
            }
            if (paginaActual != 3){
                jbNext.setVisible(true);
            }            
        }
    }
    
    public void setBotonBack(String rutaImg){
        Image img = new ImageIcon(getClass().getResource(rutaImg)).getImage();
        img = img.getScaledInstance(220, 90, Image.SCALE_SMOOTH);
        jbBack.setIcon(new ImageIcon(img));
    }
    
    public void setBotonExit(String rutaImg){
        Image img = new ImageIcon(getClass().getResource(rutaImg)).getImage();
        img = img.getScaledInstance(125, 115, Image.SCALE_SMOOTH);
        jbExit.setIcon(new ImageIcon(img));
    }
    
    public void setBotonNext(String rutaImg){
        Image img = new ImageIcon(getClass().getResource(rutaImg)).getImage();
        img = img.getScaledInstance(220, 90, Image.SCALE_SMOOTH);
        jbNext.setIcon(new ImageIcon(img));
    }
    
    // Agregar Listeners para los botones
    public void addNextButtonListener(ActionListener listener) {
        jbNext.addActionListener(listener);
    }
    
    public void addExitButtonListener(ActionListener listener) {
        jbExit.addActionListener(listener);
    }
    
    public void addBackButtonListener(ActionListener listener) {
        jbBack.addActionListener(listener);
    }
    
    // Agregar Mouse Listeners para los botones
    public void addBackButtonMouseListener(MouseAdapter listener) {
        jbBack.addMouseListener(listener);
    }
    
    public void addExitButtonMouseListener(MouseAdapter listener) {
        jbExit.addMouseListener(listener);
    }
    
    public void addNextButtonMouseListener(MouseAdapter listener) {
        jbNext.addMouseListener(listener);
    }
    
}
