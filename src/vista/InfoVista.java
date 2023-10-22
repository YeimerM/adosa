/*
 *  Yeimer Armando Mendez Sanchez
 *   Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package vista;

import controlador.MenuPrincipalControlador;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InfoVista extends JFrame {
    
    private ImageIcon imgParaQue;
    private JPanel jpParaQue;
    private ImageIcon imgExit;
    private JButton jbExit;
    
    public InfoVista(){
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1142, 764));
        setTitle("PARA QUE SIRVE");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/IconAdosa.png")));
        setVisible(true);
        
        // Configurar Panel
        imgParaQue = new ImageIcon(getClass().getResource("/imagenes/LetParaQue.png"));
        jpParaQue = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgParaQue.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        jpParaQue.setSize(this.getSize());
        
        // BOTONES
        GridBagConstraints constraints = new GridBagConstraints();
        
        // SALIR
        imgExit = new ImageIcon(getClass().getResource("/imagenes/X.png"));
        jbExit = new JButton(imgExit);
        jbExit.setBorderPainted(false);
        jbExit.setContentAreaFilled(false);
        jbExit.setFocusPainted(false);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        constraints.insets = new Insets(10,1000,600,10);
        jpParaQue.add(jbExit, constraints);
        
        
        add(jpParaQue);
    }
    public void addBtnSalir(ActionListener listener) {
        jbExit.addActionListener(listener);
    }
    
    public void volverMenu() {
        dispose();
        MenuPrincipalVista mpVista = new MenuPrincipalVista();
        MenuPrincipalControlador mpControlador = new MenuPrincipalControlador(mpVista);
    }
}
