import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{

    private BufferedImage[] images;
    private ClickListener click;


    public UIImageButton(float x, float y, int ancho, int alto, BufferedImage[] images, ClickListener click) {
        super(x, y, ancho, alto);
        this.images=images;
        this.click=click;
    }

    @Override
    public void tick() { }

    @Override
    public void dibujar(Graphics g) {
        if(hovering) g.drawImage(images[1],(int)x,(int)y,ancho,alto, null);
        else g.drawImage(images[0],(int)x,(int)y,ancho,alto, null);

    }

    @Override
    public void onClick() {
        click.onClick();

    }
}
