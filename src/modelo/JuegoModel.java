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

    public int getNivel() {
        return nivel;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getCuadradosAMostrar() {
        return cuadradosAMostrar;
    }
    
    public void aumNivel(){
        nivel++;
    }
    
    public void dismNivel(){
        nivel--;
    }
    
    public void aumVida(){
        nivel++;
    }
    
    public void dismVida(){
        vidas--;
    }
    
    public void aumPuntaje(){
        puntaje = 5 * (int) Math.pow(2, nivel - 1);
    }
}
