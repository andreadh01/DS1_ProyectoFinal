import java.awt.image.BufferedImage;

public class CasillaArbol extends Casillas {
    public CasillaArbol(int id) {
        super(Assets.arbol, id);
    }

    @Override
    public boolean EsSolido() {
        return true;
    }
}
