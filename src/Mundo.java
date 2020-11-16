import java.awt.*;

public class Mundo {

    private Controlador controlador;
    private int ancho, alto;
    private int spawnX,spawnY;
    private int[][] casillas;

    //genera el mundo
    public Mundo(Controlador controlador,String path){
        this.controlador=controlador;
        cargarMundo(path);
    }

    //Esta parte actualiza el controlador y hace que corra
    public void tick(){

    }

    //Procesa los graficos de cada casilla en el arreglo
    public void dibujar(Graphics g){
        //Todas estas variables hacen que solo las casillas en pantalla se calculen en lugar de el mapa completo.
        int xInicio= (int) Math.max(0,controlador.getCamara().getxOffset()/Casillas.ANCHOCASILLA);
        int xFin=(int) Math.min(ancho, (controlador.getCamara().getxOffset()+controlador.getAncho())/Casillas.ANCHOCASILLA+1);
        int yInicio=(int) Math.max(0,controlador.getCamara().getyOffset()/Casillas.ALTOCASILLA);
        int yFin=(int) Math.min(alto, (controlador.getCamara().getyOffset()+ controlador.getAlto())/Casillas.ALTOCASILLA+1);


        for (int y=yInicio;y<yFin;y++){
            for (int x=xInicio;x<xFin;x++){
                getCasilla(x,y).dibujar(g,(int)(x*Casillas.ANCHOCASILLA-controlador.getCamara().getxOffset()),(int)(y*Casillas.ALTOCASILLA-controlador.getCamara().getyOffset()));
            }
        }
    }

    //getCasillas sirve para generar las casillas desde la clase Casillas
    public Casillas getCasilla(int x, int y){
        if(x<0 || y<0 ||x>=ancho || x>=alto){
            return Casillas.casillaZacate;
        }

        Casillas c = Casillas.casillas[casillas[x][y]];
        if (c==null){
            return Casillas.casillaTierra;
        }
        return c;
    }

    //Carga el mundo y determina el tamaño con un arreglo
    private void cargarMundo(String path){
        String archivo= Utilidades.cargarArchivoComoString(path);
        String[] tokens= archivo.split("\\s+");
        ancho=Utilidades.parseInt(tokens[0]);
        alto=Utilidades.parseInt(tokens[1]);
        spawnX=Utilidades.parseInt(tokens[2]);
        spawnY=Utilidades.parseInt(tokens[3]);

        casillas= new int[ancho][alto];
        for (int y=0;y<alto;y++){
            for (int x=0;x<ancho;x++){
                casillas[x][y]= Utilidades.parseInt(tokens[(x+y*ancho)+4]);
            }
        }

    }
}
