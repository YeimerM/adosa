/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package adosa2;

import controlador.MainController;
import java.awt.EventQueue;
import vista.MainView;

public class Main {
    public static void main(String[] args){
        // Iniciar modelo, view y controller
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView view = new MainView();
                MainController controller = new MainController(view);
                
            }
        });
    }
}
