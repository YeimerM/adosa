/*
 *  Yeimer Armando Mendez Sanchez
 *   Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */
package vista;

import controlador.InstruccionesControlador;
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

public class MenuPrincipalVista extends JFrame {

    private JPanel jpMenuInicio;
    private ImageIcon imgMenu;
    private ImageIcon imgComoJugar;
    private ImageIcon imgJugar;
    private ImageIcon imgParaQue;
    private JButton jbComoJugar;
    private JButton jbJugar;
    private JButton jbParaQue;

    public MenuPrincipalVista() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1142, 764));
        setTitle("MAIN MENU");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/IconAdosa.png")));
        setVisible(true);
        
        // Configurar Panel
        imgMenu = new ImageIcon(getClass().getResource("/imagenes/TitleMenu.png"));
        jpMenuInicio = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgMenu.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        jpMenuInicio.setSize(this.getSize());

        // BOTONES
        GridBagConstraints constraints = new GridBagConstraints();
        
        // BTN CCOMO JUGAR
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTHWEST; // Alinea el botón en la esquina superior izquierda
        constraints.insets = new Insets(500, 50, 10, 50);
        
        imgComoJugar = new ImageIcon(getClass().getResource("/imagenes/ComoJugar.png"));
        jbComoJugar = new JButton(imgComoJugar);
        jbComoJugar.setBorderPainted(false);
        jbComoJugar.setContentAreaFilled(false);
        jbComoJugar.setFocusPainted(false);
        jpMenuInicio.add(jbComoJugar, constraints);

        // BTN JUGAR
        imgJugar = new ImageIcon(getClass().getResource("/imagenes/Jugar.png"));
        jbJugar = new JButton(imgJugar);
        jbJugar.setBorderPainted(false);
        jbJugar.setContentAreaFilled(false);
        jbJugar.setFocusPainted(false);
        
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.NORTH; // Alinea el botón en la esquina superior
        constraints.insets = new Insets(500, 50, 10, 50);
        jpMenuInicio.add(jbJugar, constraints);
        
        // BTN PARA QUE SIRVE
        imgParaQue = new ImageIcon(getClass().getResource("/imagenes/ParaQue.png"));
        jbParaQue = new JButton(imgParaQue);
        jbParaQue.setBorderPainted(false);
        jbParaQue.setContentAreaFilled(false);
        jbParaQue.setFocusPainted(false);
        
        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.NORTHEAST; // Alinea el botón en la esquina superior derecha
        constraints.insets = new Insets(500, 50, 10, 50);
        jpMenuInicio.add(jbParaQue, constraints);

        add(jpMenuInicio);
    }
    
    public void addBtnJugarListener(ActionListener listener){
        jbJugar.addActionListener(listener);
    }
    
    public void addBtnComoJugarListener(ActionListener listener){
        jbComoJugar.addActionListener(listener);
    }
    public void addBtnParaQueListener(ActionListener listener){
        jbParaQue.addActionListener(listener);
    }
    
    public void abrirInstrucciones(){
        dispose();
        InstruccionesVista instruccionesVista = new InstruccionesVista();
        InstruccionesControlador instruccionesCntrl = new InstruccionesControlador(instruccionesVista);
    }
}
