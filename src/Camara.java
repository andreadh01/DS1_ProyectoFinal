public class Camara {

    private Juego juego;
    private float xOffset, yOffset;

    public Camara(Juego juego, float xOffset, float yOffset){
        this.juego=juego;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }

    public void centrarEnEntidad(Entidades e){
        xOffset=e.getX()-juego.getAncho()/2+e.getAncho()/2;
        yOffset=e.getY()-juego.getAlto()/2+e.getAlto()/2;
    }

    public void mover(float xAmt, float yAmt){
        xOffset+=xAmt;
        yOffset+=yAmt;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
