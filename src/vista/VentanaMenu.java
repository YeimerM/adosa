/*
 *  Yeimer Armando Mendez Sanchez
 *   Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMenu extends JFrame{
    
    private JPanel jpMenuInicio;
    public JLabel jlMenuInicio;
            
    public VentanaMenu(){
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jpMenuInicio = new JPanel();
        jlMenuInicio = new JLabel();
        
    }
}
