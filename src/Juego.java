import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Juego implements Runnable{
    private Pantalla pantalla;
    public int ancho, alto;
    public String titulo;

    private Thread hilo;
    private boolean running=false;

    private BufferStrategy bs;
    private Graphics g;







    //este constructor sirve para que cuando se cree un juego,
    //tenga el mismo tamaño siempre
    public Juego(String titulo, int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.titulo=titulo;
    }


    //este metodo hara que aparezca la pantalla y las imagenes
    private void inicializar(){
        pantalla=new Pantalla(titulo,ancho,alto);


    }
    private void actualizar() {

    }
    private void dibujar() {
        bs=pantalla.getGraficos().getBufferStrategy();
        if(bs==null) {
            pantalla.getGraficos().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();

        //aqui se ponen los graficos

        //borra lo que hay en la pantalla
        g.clearRect(0,0,ancho,alto);

        //imagenes

        //mostrar los graficos
        bs.show();
        g.dispose();


    }

    //en este metodo se programara gran parte del juego
    public void run(){
        inicializar();
        while(running){
            //mientras el juego este corriendo, se deben actualizar las imagenes y movimientos
            actualizar();
            dibujar();

        }

        //lo detenemos aqui en caso de que no se haya detenido con el false
        stop();

    }

    //metodo para empezar el hilo
    public synchronized void start(){
        //la condición está para que solo use este método si no ha empezado el juego
        if (running) return;
        running=true;
        hilo=new Thread(this);
        //sirve para llamar el metodo run
        hilo.start();

    }

    //metodo para detener el hilo
    public synchronized void stop() {
        //la condición está para que solo use este método cuando no se ha detenido el juego
        if (!running) return;
        running=false;
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
