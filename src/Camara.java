public class Camara {

    private Controlador controlador;
    private float xOffset, yOffset;

    public Camara(Controlador controlador, float xOffset, float yOffset){
        this.controlador=controlador;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }

    public void checarEspacioBlanco(){
        if(xOffset<0){
            xOffset=0;
        }
        else if(xOffset>controlador.getMundo().getAncho()*Casillas.ANCHOCASILLA-controlador.getAncho()){
            xOffset=controlador.getMundo().getAncho()*Casillas.ANCHOCASILLA-controlador.getAncho();
        }

        if(yOffset<0){
            yOffset=0;
        }
        else if(yOffset>controlador.getMundo().getAlto()*Casillas.ALTOCASILLA-controlador.getAlto()){
            yOffset=controlador.getMundo().getAlto()*Casillas.ALTOCASILLA-controlador.getAlto();
        }

    }

    public void centrarEnEntidad(Entidades e){
        xOffset=e.getX()-controlador.getAncho()/2+e.getAncho()/2;
        yOffset=e.getY()-controlador.getAlto()/2+e.getAlto()/2;
        checarEspacioBlanco();
    }

    public void mover(float xAmt, float yAmt){
        xOffset+=xAmt;
        yOffset+=yAmt;
        checarEspacioBlanco();
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
