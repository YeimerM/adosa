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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InfoPanel extends JPanel{

    
    private JPanel jpContenido;
    private ImageIcon imgInfo;
    private ImageIcon imgExit;
    private JButton jbExit;
    
    public InfoPanel(){
        initComponentes();
    }

    private void initComponentes() {
        setSize(new Dimension(1260, 830));
        setVisible(true);
        
        imgInfo = new ImageIcon(getClass().getResource("/imagenes/Info.png"));
        jpContenido = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgInfo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        jpContenido.setSize(this.getSize());
        jpContenido.setLayout(null);
        
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
        
        jpContenido.add(jbExit);
    }
    
    public JPanel getPanel() {
        return jpContenido;
    }

    public void volverManu() {
        System.out.println("Volviendo al menu");
        jpContenido.setVisible(false);
    }
    
    public void setBotonExit(String rutaImg){
        Image img = new ImageIcon(getClass().getResource(rutaImg)).getImage();
        img = img.getScaledInstance(125, 115, Image.SCALE_SMOOTH);
        jbExit.setIcon(new ImageIcon(img));
    }
    
    public void addExitButtonListener (ActionListener listener){
        jbExit.addActionListener(listener);
    }
    
    public void addExitButtonMouseListener(MouseAdapter listener) {
        jbExit.addMouseListener(listener);
    }
}
