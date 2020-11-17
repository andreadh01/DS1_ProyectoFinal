import java.awt.*;

public class GameState extends State{

    private Mundo mundo;


    public GameState(Controlador controlador){
        super(controlador);
        mundo=new Mundo(controlador,"Recursos/Mundos/mundo1.txt");
        controlador.setMundo(mundo);



    }

    @Override
    public void tick() {
        mundo.tick();
    }

    @Override
    public void dibujar(Graphics g) {
        mundo.dibujar(g);
    }
}
