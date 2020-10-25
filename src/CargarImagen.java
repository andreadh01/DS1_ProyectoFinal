import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CargarImagen {
    public static BufferedImage cargaImagen (String path){
        try {
            return ImageIO.read(CargarImagen.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;

    }
}
