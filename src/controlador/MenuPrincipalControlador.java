/*
 *  Yeimer Armando Mendez Sanchez
 *   Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuPrincipalVista;

public class MenuPrincipalControlador {

    private MenuPrincipalVista vista;

    public MenuPrincipalControlador(MenuPrincipalVista vista) {
        this.vista = vista;

        vista.addBtnComoJugarListener(new InstruccionesListener());

    }

    class JugarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    class InstruccionesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vista.abrirInstrucciones();
        }

    }
}
