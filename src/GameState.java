import java.awt.*;

public class GameState extends State{

    private Jugador jugador;
    private Mundo mundo;

    public GameState(Controlador controlador){
        super(controlador);
        mundo=new Mundo(controlador,"Recursos/Mundos/mundo1.txt");
        controlador.setMundo(mundo);
        jugador=new Jugador(controlador, 100,100);


    }

    @Override
    public void tick() {
        mundo.tick();
        jugador.thick();
    }

    @Override
    public void dibujar(Graphics g) {
        mundo.dibujar(g);
        jugador.dibujar(g);
    }
}
