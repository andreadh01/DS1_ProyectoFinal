import java.awt.image.BufferedImage;

public class Animacion {
    private int velocidad, index;
    private long ultimoTiempo, cronometro;
    private BufferedImage[] frames;

    public Animacion(int velocidad, BufferedImage[] frames) {
        this.velocidad = velocidad;
        this.frames = frames;
        index=0;
        cronometro=0;
        ultimoTiempo=System.currentTimeMillis();
    }

    public void tick(){
        cronometro+=System.currentTimeMillis()-ultimoTiempo;
        ultimoTiempo= System.currentTimeMillis();

        if(cronometro>velocidad){
            index++;
            cronometro=0;

            if(index>= frames.length){
                index=0;
            }
        }

    }

    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
}
