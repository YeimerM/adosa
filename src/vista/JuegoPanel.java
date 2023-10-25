/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JuegoPanel extends JPanel {

    private JPanel jpContenido;
    private ImageIcon imgJuegoBg;

    public JuegoPanel() {
        initComponentes();
    }

    private void initComponentes() {

        setSize(new Dimension(1142, 764));
        setVisible(true);

        imgJuegoBg = new ImageIcon(getClass().getResource("/imagenes/JuegoBg.png"));
        jpContenido = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgJuegoBg.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        jpContenido.setSize(this.getSize());
        jpContenido.setLayout(null);

    }

    public JPanel getPanel() {
        return jpContenido;
    }
}
