/*
 *  Yeimer Armando Mendez Sanchez
 *   Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InstruccionesVista extends JFrame {
    
    private ImageIcon imgInstru;
    private JPanel jpInstru;
    private JButton jbNext;
    private JButton jbBack;
    private JButton jbExit;
    private ImageIcon imgNext;
    private ImageIcon imgBack;
    private ImageIcon imgExit;
    private List<ImageIcon> imgInstrucciones;
    private int paginaActual; // Contador de pág instrucciones
    
    public InstruccionesVista() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1142, 764));
        setTitle("INSTRUCCIONES");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/IconAdosa.png")));
        setVisible(true);
        
        
        // Imagenes Instrucciones
        imgInstrucciones = new ArrayList<>();
        imgInstrucciones.add(new ImageIcon(getClass().getResource("/imagenes/Instru1.png")));
        imgInstrucciones.add(new ImageIcon(getClass().getResource("/imagenes/Instru2.png")));
        imgInstrucciones.add(new ImageIcon(getClass().getResource("/imagenes/Instru3.png")));
        imgInstrucciones.add(new ImageIcon(getClass().getResource("/imagenes/Instru4.png")));
        
        // Configurar Panel
        paginaActual = 0;
        imgInstru = new ImageIcon(getClass().getResource("/imagenes/Instru1.png"));
        jpInstru = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgInstru.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        jpInstru.setSize(this.getSize());
        

        
        // BOTONES
        GridBagConstraints constraints = new GridBagConstraints();
        
        // ANTERIOR
        imgBack = new ImageIcon(getClass().getResource("/imagenes/Anterior.png"));
        jbBack = new JButton(imgBack);
        jbBack.setBorderPainted(false);
        jbBack.setContentAreaFilled(false);
        jbBack.setFocusPainted(false);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(10,10,10,400);
        jpInstru.add(jbBack, constraints);
        
        // SIGUIENTE
        imgNext = new ImageIcon(getClass().getResource("/imagenes/Siguiente.png"));
        jbNext = new JButton(imgNext);
        jbNext.setBorderPainted(false);
        jbNext.setContentAreaFilled(false);
        jbNext.setFocusPainted(false);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(10,400,10,10);
        jpInstru.add(jbNext, constraints);
        
        // SALIR
        imgExit = new ImageIcon(getClass().getResource("/imagenes/X.png"));
        jbExit = new JButton(imgExit);
        jbExit.setBorderPainted(false);
        jbExit.setContentAreaFilled(false);
        jbExit.setFocusPainted(false);
        
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        //constraints.insets = new Insets(10,10,10,10);
        jpInstru.add(jbExit, constraints);
        
        
        
        
        
        // ARREGLAR PARA QUE AL AMPLIAR SE AJUSTE EL LUGAR DONDE ESTAN LOS BOTONES 
        
        
        
        
        
        
        add(jpInstru);
    }
    
    public void addBtnNextListener(ActionListener listener){
        jbNext.addActionListener(listener);
    }
    
    public void addBtnBackListener(ActionListener listener){
        jbBack.addActionListener(listener);
    }
    
    public void addBtnExitListener(ActionListener listener){
        jbExit.addActionListener(listener);
    }
    
    public void setImgInstru(ImageIcon imgIconInstru){
        imgInstru = imgIconInstru;
        jpInstru.removeAll();
        jpInstru.revalidate();
        jpInstru.repaint();
    }
    
    public void avanzarPagina() {
        if (paginaActual < imgInstrucciones.size() - 1) {
            paginaActual++;
            setImgInstru(imgInstrucciones.get(paginaActual));
        }
    }

    public void retrocederPagina() {
        if (paginaActual > 0) {
            paginaActual--;
            setImgInstru(imgInstrucciones.get(paginaActual));
        }
    }
}

