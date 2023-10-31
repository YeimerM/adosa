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
import javax.swing.JPanel;
import modelo.JuegoModel;
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
        
        vista.addJugarButtonMouseListener(new JugarMouseListener());
        vista.addInstruButtonMouseListener(new InstruccionesMouseListener());
        vista.addInfoButtonMouseListener(new InfoMouseListener());
    }
    
    
    // Action Listener
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
    
    // Mouse Adapter
    
    class JugarMouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e){
            vista.setBotonJugar("/imagenes/JugarOn.png");
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            vista.setBotonJugar("/imagenes/Jugar.png");
        }
    }
    
    class InstruccionesMouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e){
            vista.setBotonInstru("/imagenes/ComoJugarOn.png");
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            vista.setBotonInstru("/imagenes/ComoJugar.png");
        }
    }
    
    class InfoMouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e){
            vista.setBotonInfo("/imagenes/ParaQueOn.png");
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            vista.setBotonInfo("/imagenes/ParaQue.png");
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
        JuegoModel juegoModel = new JuegoModel();
        JuegoController juegoCtrl = new JuegoController(juegoPanel, juegoModel);
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
