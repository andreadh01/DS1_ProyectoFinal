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

    public abstract void tick();

    public abstract void dibujar(Graphics g);

    public boolean checkColisionEntidad(float xOffset, float yOffset){
        for (Entidades e : controlador.getMundo().getEntidadesAdmin().getEntidades()) {
            if(e.equals(this)){
                continue;
            }
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset))) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x+colision.x+xOffset), (int)(y+colision.y+yOffset), colision.width, colision.height);
    }


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
