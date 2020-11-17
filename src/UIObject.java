import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {
    protected float x, y;
    protected int ancho, alto;
    protected Rectangle colision;
    protected boolean hovering=false;

    public UIObject(float x, float y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        colision=new Rectangle((int)x, (int)y, ancho, alto);
    }

    public abstract void tick();

    public abstract void dibujar(Graphics g);

    public abstract void onClick();

    public void onMouseMove(MouseEvent e){
        if(colision.contains(e.getX(),e.getY())) hovering=true;
        else hovering=false;

    }
    public void onMouseRelease(MouseEvent e){
        if(hovering){
            onClick();
        }

    }


    //getters y setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }
}
