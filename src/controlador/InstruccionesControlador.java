/*
 *  Yeimer Armando Mendez Sanchez
 *   Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.InstruccionesVista;

public class InstruccionesControlador {
    private InstruccionesVista vistaIns;
    
    public InstruccionesControlador(InstruccionesVista vistaIns){
        this.vistaIns = vistaIns;
        
        vistaIns.addBtnNextListener(new NextListener());
        vistaIns.addBtnBackListener(new BackListener());
        vistaIns.addBtnExitListener(new ExitListener());
    }
    
    class NextListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaIns.avanzarPagina();
            System.out.println("Presiono adelante");
        }
    }
    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaIns.retrocederPagina();
            System.out.println("Presiono atras");
        }
    }
    class ExitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaIns.volverMenu();
            System.out.println("Salir de inst");
        }
    }

}
