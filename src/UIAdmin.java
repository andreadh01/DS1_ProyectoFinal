import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIAdmin {
    private Controlador controlador;
    private ArrayList<UIObject> object;

    public UIAdmin(Controlador controlador) {
        this.controlador = controlador;
        object = new ArrayList<UIObject>();
    }

    public void tick(){
        for(UIObject o : object){
            o.tick();
        }

    }

    public void dibujar(Graphics g){
        for(UIObject o : object){
            o.dibujar(g);
        }

    }

    public void onMouseMove (MouseEvent e){
        for(UIObject o : object){
            o.onMouseMove(e);
        }

    }

    public void onMouseRelease (MouseEvent e){
        for(UIObject o : object){
            o.onMouseRelease(e);
        }

    }

    public void addObject(UIObject o){
        object.add(o);
    }

    public void removeObject(UIObject o){
        object.remove(o);
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public ArrayList<UIObject> getObjetos() {
        return object;
    }

    public void setObjetos(ArrayList<UIObject> objetos) {
        this.object = object;
    }
}
