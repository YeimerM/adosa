/*
 *  Yeimer Armando Mendez Sanchez
 *  Luis Johany Portilla Romo
 *  FPOE Gr. #81
 *  MiniProyecto #2
 */

package modelo;

public class JuegoModel {
    private int nivel;
    private int vidas;
    private int puntaje;
    private int cuadradosAMostrar;
    
    public JuegoModel(){
        nivel = 1;
        vidas = 3;
        puntaje = 0;
        cuadradosAMostrar = nivel + 2;
    }
    
}
