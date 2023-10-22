/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package adosa;

import controlador.MenuPrincipalControlador;
import java.awt.EventQueue;
import vista.MenuPrincipalVista;

public class Main {
    public static void main(String[] args){
        // Iniciar modelo, view y controller
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuPrincipalVista vistaMenu = new MenuPrincipalVista();
                MenuPrincipalControlador ctrladorMenu = new MenuPrincipalControlador(vistaMenu);
            }
        });
    }
}
