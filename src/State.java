import java.awt.*;

public abstract class State {
    //Las siguientes lineas permiten seleccionar, cambiar e identificar en que estado o parte del juego estamos.
    private static State currentState=null;

    public static void setState(State state){
        currentState=state;
    }

    public static State getState(){
        return currentState;
    }

    //CLASES
    protected Controlador controlador;

    public State(Controlador controlador){
        this.controlador=controlador;
    }

    public abstract void tick();

    public abstract void dibujar(Graphics g);


}
