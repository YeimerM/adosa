/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vista.InfoPanel;

public class InfoController {
    private InfoPanel vista;
    
    public InfoController(InfoPanel vista){
        this.vista = vista;
        
        vista.addExitButtonListener(new ExitListener());
        vista.addExitButtonMouseListener(new ExitMouseListener());
        
    }
    
    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Exit");
            vista.volverManu();
        }
    }
    
    class ExitMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e){
            System.out.println(e);
            vista.setBotonExit("/imagenes/XOn.png");
        }
    }
}
