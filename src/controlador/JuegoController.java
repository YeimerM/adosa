/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package controlador;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
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
        vista.mostrarCuadros(modelo.getCuadradosAMostrar());
        vista.addPanelJuegoListener(new PanelJuegoListener());
        vista.getJlPuntaje().setText(String.valueOf(modelo.getPuntaje()));
        
        vista.addCheckListener(new botonCheckListener());
    }
    
    public class botonCheckListener extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (vista.getCuadrosIguales()){
                modelo.aumNivel();
                modelo.aumPuntaje();
                vista.mostrarCuadros(modelo.getCuadradosAMostrar());
            }
        }
    }
    
    private class PanelJuegoListener extends ComponentAdapter{
        @Override
        public void componentShown(ComponentEvent e) {
            
        }
    }
}