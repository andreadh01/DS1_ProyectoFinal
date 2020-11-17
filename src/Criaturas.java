public abstract class Criaturas extends Entidades {

    public static final int SALUD_BASE=10;
    public static final float VEL_BASE=3.0f;
    public static final int CRIATURA_ANCHO_BASE=100;
    public static final int CRIATURA_ALTO_BASE=100;

    protected int salud;
    protected float velocidad;
    protected float xMove, yMove;

    public Criaturas(Controlador controlador, float x, float y, int ancho, int alto) {
        super(controlador, x, y, ancho, alto);
        salud=SALUD_BASE;
        velocidad=VEL_BASE;
        xMove=0;
        yMove=0;
    }

    public void mover(){
        if(!checkColisionEntidad(xMove,0f)) {
            moveX();
        }
        if(!checkColisionEntidad(0f,yMove)) {
            moveY();
        }
    }

    public void moveX(){
        //movimiento a la derecha
        if (xMove>0){
            int tx=(int)(x+xMove+colision.x + colision.width)/Casillas.ANCHOCASILLA;
            if (!colisionConCasilla(tx,(int)(y+colision.y)/Casillas.ALTOCASILLA) &&
                    !colisionConCasilla(tx,(int)(y+colision.y+colision.height)/Casillas.ALTOCASILLA)){
                x+=xMove;
            }else {
                x=tx*Casillas.ANCHOCASILLA-colision.x-colision.width-1;
            }
        }
        //movimiento a la izquierda
        else if (xMove<0) {
            int tx = (int) (x + xMove + colision.x) / Casillas.ANCHOCASILLA;
            if (!colisionConCasilla(tx, (int) (y + colision.y) / Casillas.ALTOCASILLA) &&
                    !colisionConCasilla(tx, (int) (y + colision.y + colision.height) / Casillas.ALTOCASILLA)) {
                x += xMove;
            } else {
                x = tx * Casillas.ANCHOCASILLA + Casillas.ANCHOCASILLA - colision.x;
            }
        }
    }

    public void moveY(){
        //mover hacia arriba
        if (yMove<0){
            int ty=(int)(y+yMove+colision.y)/Casillas.ALTOCASILLA;
            if(!colisionConCasilla((int)(x+colision.x)/Casillas.ANCHOCASILLA,ty) && !colisionConCasilla((int)(x+colision.x+colision.width)/Casillas.ANCHOCASILLA,ty)){
                y+=yMove;
            }
        }
        //mover hacia abajo
        else if(yMove>0){
            int ty=(int)(y+yMove+colision.y+colision.height)/Casillas.ALTOCASILLA;
            if(!colisionConCasilla((int)(x+colision.x)/Casillas.ANCHOCASILLA,ty) && !colisionConCasilla((int)(x+colision.x+colision.width)/Casillas.ANCHOCASILLA,ty)){
                y+=yMove;
            }
        }
    }

    protected boolean colisionConCasilla(int x, int y){
        return controlador.getMundo().getCasilla(x,y).EsSolido();
    }

    //Aqui van todos los getters y setters

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }
}
