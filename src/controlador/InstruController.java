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
import vista.InstruPanel;

public class InstruController {

    private InstruPanel vista;

    public InstruController(InstruPanel vista) {
        this.vista = vista;

        vista.addNextButtonListener(new NextListener());
        vista.addBackButtonListener(new BackListener());
        vista.addExitButtonListener(new ExitListener());
        
        vista.addBackButtonMouseListener(new BackMouseListener());
        vista.addExitButtonMouseListener(new ExitMouseListener());
        vista.addNextButtonMouseListener(new NextMouseListener());
    }

    class NextListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vista.avanzarPag();
            System.out.println("Next");
        }
    }

    class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vista.retrocederPag();
            System.out.println("Back");
        }
    }
    
    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vista.volverManu();
            System.out.println("Exit");
        }
    }
    
    class BackMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e){
            System.out.println(e);
            vista.setBotonBack("/imagenes/AnteriorOn.png");
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            vista.setBotonBack("/imagenes/Anterior.png");
        }
    }
    
    class ExitMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e){
            System.out.println(e);
            vista.setBotonExit("/imagenes/XOn.png");
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            vista.setBotonExit("/imagenes/X.png");
        }
    }
    
    class NextMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e){
            System.out.println(e);
            vista.setBotonNext("/imagenes/SiguienteOn.png");
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            vista.setBotonNext("/imagenes/Siguiente.png");
        }
    }
}
