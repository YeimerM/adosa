/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.InstruPanel;

public class InstruController {

    private InstruPanel vista;

    public InstruController(InstruPanel vista) {
        this.vista = vista;

        vista.addNextButtonListener(new NextListener());
        vista.addBackButtonListener(new BackListener());
        vista.addExitButtonListener(new ExitListener());
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
}
