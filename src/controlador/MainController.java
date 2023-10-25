/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MainView;

public class MainController {
    private MainView vista;
    
    public MainController(MainView vista){
        this.vista = vista;
        
        vista.addJugarButtonListener(new JugarListener());
        vista.addInstruButtonListener(new InstruccionesListener());
        vista.addInfoButtonListener(new InfoListener());
    }
    
    class JugarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Jugar");
            vista.mostrarPanelJugar();
        }
    }

    class InstruccionesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Como Jugar");
            vista.mostrarPanelInstrucciones();
        }
    }
    class InfoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Para Que Sirve");
            vista.mostrarPanelInfo();
        }
    }

}
