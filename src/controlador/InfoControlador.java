/*
 *  Yeimer Armando Mendez Sanchez
 *   Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.InfoVista;

public class InfoControlador {
    private InfoVista infoVista;

    public InfoControlador(InfoVista infoVista) {
        this.infoVista = infoVista;
        
        infoVista.addBtnSalir(new SalirListener());
    }
    
    class SalirListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            infoVista.volverMenu();
        }
        
    }

}
