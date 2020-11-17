import java.awt.image.BufferedImage;

public class CasillaLetrero extends Casillas{
    public CasillaLetrero( int id) {
        super(Assets.letrero, id);
    }
    @Override
    public boolean EsSolido() {
        return true;
    }
}
