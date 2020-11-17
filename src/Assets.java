import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass, water, dirt, jugador_still, letrero,tronco,tierra,zacate,arbol;
    public static BufferedImage[] jugador_abajo, jugador_arriba, jugador_izq, jugador_der, start, help;
    private static final int ancho=100, alto=100;

    public static void inicializar(){
        SpriteSheet sheet=new SpriteSheet(CargarImagen.cargaImagen("/Texturas/assets.png"));

        jugador_still=sheet.crop(ancho,0,ancho,alto);

        jugador_abajo= new BufferedImage[2];
        jugador_abajo[0]=sheet.crop(0,0,ancho,alto);
        jugador_abajo[1]=sheet.crop(ancho*2,0,ancho,alto);

        jugador_arriba=new BufferedImage[3];
        jugador_arriba[0]=sheet.crop(0,alto*3,ancho,alto);
        jugador_arriba[1]= sheet.crop(ancho,alto*3,ancho,alto);
        jugador_arriba[2]= sheet.crop(ancho*2,alto*3,ancho,alto);


        jugador_izq=new BufferedImage[3];
        jugador_izq[0]=sheet.crop(0,alto,ancho,alto);
        jugador_izq[1]=sheet.crop(ancho,alto,ancho,alto);
        jugador_izq[2]=sheet.crop(ancho*2,alto,ancho,alto);

        jugador_der=new BufferedImage[3];
        jugador_der[0]=sheet.crop(0,alto*2,ancho,alto);
        jugador_der[1]=sheet.crop(ancho,alto*2,ancho,alto);
        jugador_der[2]=sheet.crop(ancho*2,alto*2,ancho,alto);

        letrero=sheet.crop(ancho*3,0,ancho,alto);
        arbol=sheet.crop(ancho*4,0,ancho,alto);
        tronco=sheet.crop(ancho*5,0,ancho,alto);
        tierra=sheet.crop(ancho*3,alto,ancho,alto);
        zacate=sheet.crop(ancho*4,alto,ancho,alto);

        start=new BufferedImage[2];
        start[0]=sheet.crop(ancho*3,alto*2,ancho*2, alto);
        start[1]=sheet.crop(ancho*3,alto*3,ancho*2, alto);

        help=new BufferedImage[2];
        help[0]=sheet.crop(ancho*3, alto*4, ancho, alto);
        help[1]=sheet.crop(ancho*4, alto*4, ancho, alto);

    }
}


