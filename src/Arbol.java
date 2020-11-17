import java.awt.*;

public class Arbol extends EntidadEstatica {
    public Arbol(Controlador controlador, float x, float y) {
        super(controlador, x, y, Casillas.ANCHOCASILLA, Casillas.ALTOCASILLA);
    }

    @Override
    public void tick() {

    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(Assets.arbol,(int)(x-controlador.getCamara().getxOffset()),(int)(y-controlador.getCamara().getyOffset()),ancho,alto,null);


    }
}
