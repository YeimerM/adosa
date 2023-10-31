/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import modelo.JuegoModel;
import vista.JuegoPanel;

public class JuegoController {
    private JuegoPanel vista;
    private JuegoModel modelo;
    
    public JuegoController(JuegoPanel vista, JuegoModel modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        //vista.addPanelMouseMotionListener(new PanelMouseMotionListener());
    }

    private class PanelMouseMotionListener extends MouseMotionAdapter {
        
        @Override
        public void mouseMoved(MouseEvent e){
            System.out.println("X: " + e.getX() + " Y: " + e.getY());
        }
    }
}