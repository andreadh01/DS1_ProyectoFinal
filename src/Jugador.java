import java.awt.*;
import java.awt.image.BufferedImage;

public class Jugador extends Criaturas {
    //Animaciones
    private Animacion anim_abajo, anim_arriba, anim_izq, anim_der;


    public Jugador(Controlador controlador,float x, float y) {
        super(controlador, x, y, Criaturas.CRIATURA_ANCHO_BASE, Criaturas.CRIATURA_ALTO_BASE);

        colision.x=33;
        colision.y=20;
        colision.width=40;
        colision.height=80;


        //Inicializar animaciones
        anim_abajo=new Animacion(500,Assets.jugador_abajo);
        anim_arriba=new Animacion(500, Assets.jugador_arriba);
        anim_izq=new Animacion(500, Assets.jugador_izq);
        anim_der=new Animacion(500,Assets.jugador_der);
    }

    @Override
    public void tick() {
        //Animaciones
        anim_abajo.tick();
        anim_arriba.tick();
        anim_izq.tick();
        anim_der.tick();

        //Movimiento
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
        g.drawImage(getAnimacionFrameActual(),(int)(x-controlador.getCamara().getxOffset()),(int)(y-controlador.getCamara().getyOffset()),ancho, alto,null);
    }

    private BufferedImage getAnimacionFrameActual() {
        if (xMove < 0) {
            return anim_izq.getCurrentFrame();
        } else if (xMove > 0) {
            return anim_der.getCurrentFrame();
        } else if (yMove < 0) {
            return anim_arriba.getCurrentFrame();
        } else if (yMove>0){
            return anim_abajo.getCurrentFrame();
        }else{
            return Assets.jugador_still;
        }
    }
}
