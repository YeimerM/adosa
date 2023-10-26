/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import vista.InfoPanel;
import vista.InstruPanel;
import vista.JuegoPanel;
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
            vista.getPanelContenido().add(getPanelJug(),"jugar");
            vista.getCdLayout().show(vista.getPanelContenido(), "jugar");
        }
    }

    class InstruccionesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Como Jugar");
            vista.getPanelContenido().add(getPanelIns(),"instrucciones");
            vista.getCdLayout().show(vista.getPanelContenido(), "instrucciones");
        }
    }
    class InfoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Para Que Sirve");
            vista.getPanelContenido().add(getPanelInf(),"info");
            vista.getCdLayout().show(vista.getPanelContenido(), "info");
        }
    }
        
    public JPanel getPanelIns(){
        InstruPanel instruPanel = new InstruPanel();
        InstruController instruCtrl = new InstruController(instruPanel);
        JPanel panelView = instruPanel.getPanel();
        return panelView;
    }
    
    public JPanel getPanelJug(){
        JuegoPanel juegoPanel = new JuegoPanel();
        JuegoController juegoCtrl = new JuegoController(juegoPanel);
        JPanel panelView = juegoPanel.getPanel();
        return panelView;
    }
    
    public JPanel getPanelInf(){
        InfoPanel infoPanel = new InfoPanel();
        InfoController infoCtrl = new InfoController(infoPanel);
        JPanel panelView = infoPanel.getPanel();
        return panelView;
    }
}
