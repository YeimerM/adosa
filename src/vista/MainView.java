/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */
package vista;

import controlador.InfoController;
import controlador.InstruController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainView extends JFrame {
    private CardLayout cdLayout;
    private JPanel jpContenido;
    
    // Atributos Panel Menu
    private JPanel menuPanel;
    private ImageIcon bgImage;
    private JLabel bgLabel;
    private ImageIcon imgJugar;
    private ImageIcon imgInstru;
    private ImageIcon imgInfo;
    private JButton btnJugar;
    private JButton btnInstru;
    private JButton btnInfo;
    
    // Paneles
    private InstruPanel instruPanel;
    private InstruController instruCtrl;
    private JPanel insPanel;
    
    private JuegoPanel juegoPanel;
    private JPanel juegPanel;
    
    private InfoPanel infoPanel;
    private InfoController infoCtrl;
    private JPanel infPanel;

    public MainView() {
        initComponentes();
    }

    private void initComponentes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1260, 800));
        setTitle("ADOSA 2");
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/IconAdosa.png")));
        setVisible(true);

        // Configurar Panel contenido
        cdLayout = new CardLayout();
        jpContenido = new JPanel(cdLayout);
        jpContenido.setSize(this.getSize());
        add(jpContenido);
        
        // Configurar Panel Menu
        menuPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        menuPanel.setSize(new Dimension(1260, 800));
        menuPanel.setLayout(new BorderLayout());
        
        bgImage = new ImageIcon(getClass().getResource("/imagenes/TitleMenu.png"));
        bgLabel = new JLabel(bgImage);
        
        // Crear un JLayeredPane para superponer los componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));

        // Configurar los botones y agregarlos al JLayeredPane
        
        // Boton Como Jugar
        imgInstru = new ImageIcon(getClass().getResource("/imagenes/ComoJugar.png"));
        Image imgI = imgInstru.getImage();
        imgI = imgI.getScaledInstance(270,200,Image.SCALE_SMOOTH); // Escalar el icono
        imgInstru = new ImageIcon(imgI);
        
        btnInstru = new JButton(imgInstru);
        btnInstru.setBorderPainted(false);
        btnInstru.setContentAreaFilled(false);
        btnInstru.setFocusPainted(false);
        btnInstru.setBounds(40, 515, imgInstru.getIconWidth(), imgInstru.getIconHeight());
        
        // Boton Jugar
        imgJugar = new ImageIcon(getClass().getResource("/imagenes/Jugar.png"));
        Image imgJ = imgJugar.getImage();
        imgJ = imgJ.getScaledInstance(525,200,Image.SCALE_SMOOTH); // Escalar el icono
        imgJugar = new ImageIcon(imgJ);
        
        btnJugar = new JButton(imgJugar);
        btnJugar.setBorderPainted(false);
        btnJugar.setContentAreaFilled(false);
        btnJugar.setFocusPainted(false);
        btnJugar.setBounds(350, 535, imgJugar.getIconWidth(), imgJugar.getIconHeight());
        
        // Boton Info
        imgInfo = new ImageIcon(getClass().getResource("/imagenes/ParaQue.png"));
        Image imgIn = imgInfo.getImage();
        imgIn = imgIn.getScaledInstance(390,175,Image.SCALE_SMOOTH); // Escalar el icono
        imgInfo = new ImageIcon(imgIn);
        
        btnInfo = new JButton(imgInfo);
        btnInfo.setBorderPainted(false);
        btnInfo.setContentAreaFilled(false);
        btnInfo.setFocusPainted(false);
        btnInfo.setBounds(860, 555, imgInfo.getIconWidth(), imgInfo.getIconHeight());

        layeredPane.add(bgLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(btnJugar, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(btnInstru, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(btnInfo, JLayeredPane.PALETTE_LAYER);
        menuPanel.add(layeredPane, BorderLayout.CENTER);
        
        // crear y agrgar al cardlayout los paneles
        
        // Panel Instrucciones
        instruPanel = new InstruPanel();
        instruCtrl = new InstruController(instruPanel);
        insPanel = instruPanel.getPanel();
        
        
        // Panel Juego
        juegoPanel = new JuegoPanel();
        juegPanel = juegoPanel.getPanel();
        
        
        // Panel Info
        infoPanel = new InfoPanel();
        infoCtrl = new InfoController(infoPanel);
        infPanel = infoPanel.getPanel();
        
        
        jpContenido.add(menuPanel, "menu");
        jpContenido.add(juegPanel, "juego");
        jpContenido.add(insPanel, "instrucciones");
        jpContenido.add(infPanel, "info");
        cdLayout.show(jpContenido, "menu");
    }
    public CardLayout getCdLayout(){
        return cdLayout;
    }
    
    public void mostrarPanelInstrucciones(){
        cdLayout.show(jpContenido, "instrucciones");
    }
    
    public void mostrarPanelJugar() {
        cdLayout.show(jpContenido, "juego");
    }
    
    public void mostrarPanelInfo(){
        cdLayout.show(jpContenido,"info");
    }

    //Agregar Listeners para los botones
    public void addJugarButtonListener(ActionListener listener) {
        btnJugar.addActionListener(listener);
    }

    public void addInstruButtonListener(ActionListener listener) {
        btnInstru.addActionListener(listener);
    }

    public void addInfoButtonListener(ActionListener listener) {
        btnInfo.addActionListener(listener);
    }

}
