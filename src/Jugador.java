import java.awt.*;

public class Jugador extends Criaturas {
    public Jugador(Controlador controlador,float x, float y) {
        super(controlador, x, y, Criaturas.CRIATURA_ANCHO_BASE, Criaturas.CRIATURA_ALTO_BASE);

        colision.x=33;
        colision.y=20;
        colision.width=40;
        colision.height=80;
    }

    @Override
    public void thick() {
        leerTeclado();
        mover();
        controlador.getCamara().centrarEnEntidad(this);
    }

    private void leerTeclado(){
        xMove=0;
        yMove=0;

        if (controlador.getTeclado().arriba){yMove=-velocidad;}
        if (controlador.getTeclado().abajo){yMove=velocidad;}
        if (controlador.getTeclado().izquierda){xMove=-velocidad;}
        if (controlador.getTeclado().derecha){xMove=velocidad;}
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(Assets.charfr2,(int)(x-controlador.getCamara().getxOffset()),(int)(y-controlador.getCamara().getyOffset()),ancho, alto,null);

        g.setColor(Color.RED);
        g.fillRect((int)(x + colision.x - controlador.getJuego().getCamara().getxOffset()),(int)(y + colision.y - controlador.getJuego().getCamara().getyOffset()), colision.width, colision.height);
    }
}
