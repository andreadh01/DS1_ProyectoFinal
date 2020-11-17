import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Juego implements Runnable{
    private Pantalla pantalla;
    private int ancho, alto;
    public String titulo;

    private Thread hilo;
    private boolean running=false;

    private BufferStrategy bs;
    private Graphics g;

    //States
    public State gameState;
    public State menuState;

    //Controles
    private Teclado teclado;
    private MouseAdmin mouseAdmin;

    //Camara
    private Camara camara;

    //Controlador
    private Controlador controlador;


    //este constructor sirve para que cuando se cree un juego,
    //tenga el mismo tamaño siempre
    public Juego(String titulo, int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.titulo=titulo;
        teclado=new Teclado();
        mouseAdmin=new MouseAdmin();
    }


    //este metodo hara que aparezca la pantalla y las imagenes
    private void inicializar(){
        pantalla=new Pantalla(titulo,ancho,alto);
        pantalla.getPantalla().addKeyListener(teclado);
        pantalla.getPantalla().addMouseListener(mouseAdmin);
        pantalla.getPantalla().addMouseMotionListener(mouseAdmin);
        pantalla.getGraficos().addMouseListener(mouseAdmin);
        pantalla.getGraficos().addMouseMotionListener(mouseAdmin);
        Assets.inicializar();

        controlador=new Controlador(this);
        camara=new Camara(controlador,0,0);

        gameState= new GameState(controlador);
        menuState=new MenuState(controlador);
        State.setState(menuState);
    }

    private void actualizar() {
        teclado.tick();
        if (State.getState() !=null){
            State.getState().tick();
        }
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

        if (State.getState() !=null){
            State.getState().dibujar(g);
        }

        //mostrar los graficos
        bs.show();
        g.dispose();
    }

    //en este metodo se programara gran parte del juego
    public void run(){
        inicializar();
        int fps=60;
        double tiempoPorActualizacion=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        int ticks=0;

        while(running){
            //mientras el juego este corriendo, se deben actualizar las imagenes y movimientos
            //revisa el tiempo que le toma ejecutar el juego para mantenerlo estable a 60fps
            now=System.nanoTime();
            delta+=(now-lastTime)/tiempoPorActualizacion;
            timer+=now-lastTime;
            lastTime=now;

            if(delta>=1) {
                actualizar();
                dibujar();
                ticks++;
                delta--;
            }

            //contador de fps
            if(timer>=1000000000){
                System.out.println("Ticks and frames: "+ticks);
                ticks=0;
                timer=0;
            }

        }

        //lo detenemos aqui en caso de que no se haya detenido con el false
        stop();

    }

    public Teclado getTeclado(){
        return teclado;
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

    public MouseAdmin getMouseAdmin(){
        return mouseAdmin;
    }

    public Camara getCamara(){
        return camara;
    }

    public int getAncho(){
        return ancho;
    }

    public int getAlto(){
        return alto;
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
