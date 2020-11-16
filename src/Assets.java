import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass, water, dirt, charfr1, charfr2,charfr3,chariz1,chariz2,chariz3,charde1,charde2,charde3,charba1,charba2,charba3, letrero,tronco,tierra,zacate,arbol;
    private static final int ancho=100, alto=100;

    public static void inicializar(){
        SpriteSheet sheet=new SpriteSheet(CargarImagen.cargaImagen("/Texturas/assets.png"));

        charfr1=sheet.crop(0,0,ancho,alto);
        charfr2=sheet.crop(ancho,0,ancho,alto);
        charfr3=sheet.crop(ancho*2,0,ancho,alto);
        chariz1=sheet.crop(0,alto,ancho,alto);
        chariz2=sheet.crop(ancho,alto,ancho,alto);
        chariz3=sheet.crop(ancho*2,alto,ancho,alto);
        charde1=sheet.crop(0,alto*2,ancho,alto);
        charde2=sheet.crop(ancho,alto*2,ancho,alto);
        charde3=sheet.crop(ancho*2,alto*2,ancho,alto);
        charba1=sheet.crop(0,alto*3,ancho,alto);
        charba2= sheet.crop(ancho,alto*3,ancho,alto);
        charba3= sheet.crop(ancho*2,alto*3,ancho,alto);
        letrero=sheet.crop(ancho*3,0,ancho,alto);
        arbol=sheet.crop(ancho*4,0,ancho,alto);
        tronco=sheet.crop(ancho*5,0,ancho,alto);
        tierra=sheet.crop(ancho*3,alto,ancho,alto);
        zacate=sheet.crop(ancho*4,alto,ancho,alto);

    }
}


