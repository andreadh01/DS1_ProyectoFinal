import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass, water, dirt;

    public static void inicializar(){
        SpriteSheet sheet=new SpriteSheet(CargarImagen.cargaImagen("/Texturas/terrain.png"));

    }
}


