import java.awt.*;
import java.awt.image.BufferedImage;

public class Casillas {
    //Static Stuff here
    public static Casillas[] casillas=new Casillas[256];
    public static Casillas casillaZacate=new CasillaZacate(0);
    public static Casillas casillaTierra=new CasillaTierra(1);
    public static Casillas casillaLetrero=new CasillaLetrero(2);
    public static Casillas casillaArbol=new CasillaArbol(3);
    public static Casillas casillaTronco=new CasillaTronco(4);



    //Class

    public static final int ANCHOCASILLA=100, ALTOCASILLA=100;

    protected BufferedImage textura;
    protected final int id;

    public Casillas(BufferedImage textura, int id){
        this.textura=textura;
        this.id =id;

        casillas[id]=this;
    }

    public void tick(){

    }

    public void dibujar(Graphics g, int x, int y){
        g.drawImage(textura,x,y,ANCHOCASILLA,ALTOCASILLA, null);
    }

    public boolean EsSolido(){
        return false;
    }

    public int getId(){
        return id;
    }

}
