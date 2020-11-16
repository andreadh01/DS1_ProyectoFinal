import java.awt.*;

public abstract class Entidades {

    protected Controlador controlador;
    protected float x, y;
    protected int ancho, alto;
    protected Rectangle colision;

    public Entidades(Controlador controlador, float x, float y, int ancho, int alto){
        this.controlador=controlador;
        this.x=x;
        this.y=y;
        this.ancho=ancho;
        this.alto=alto;

        colision=new Rectangle(0,0,ancho,alto);
    }

    public abstract void thick();

    public abstract void dibujar(Graphics g);

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
}
