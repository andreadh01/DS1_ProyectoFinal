import java.awt.*;

public class MenuState extends State{

    private UIAdmin uiAdmin;

    public MenuState(Controlador controlador){
        super(controlador);
        uiAdmin=new UIAdmin(controlador);
        controlador.getMouseAdmin().setUIAdmin(uiAdmin);

        uiAdmin.addObject(new UIImageButton(200, 200, 128, 64, Assets.start, new ClickListener() {
            @Override
            public void onClick() {
                controlador.getMouseAdmin().setUIAdmin(null);
                State.setState(controlador.getJuego().gameState);
            }
        }));

    }

    @Override
    public void tick() {
        uiAdmin.tick();

    }

    @Override
    public void dibujar(Graphics g) {
        uiAdmin.dibujar(g);

    }
}
