import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet=sheet;
    }
    public BufferedImage crop(int x, int y, int ancho, int alto){
        return sheet.getSubimage(x, y, ancho, alto);

    }
}
