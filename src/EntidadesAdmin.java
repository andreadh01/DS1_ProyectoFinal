import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntidadesAdmin {
    private Controlador controlador;
    private Jugador jugador;
    private ArrayList<Entidades> entidades;
    private Comparator<Entidades> acomodoDibujos=new Comparator<Entidades>() {
        @Override
        public int compare(Entidades a, Entidades b) {
            if(a.getY()+a.getAlto()<b.getY()+b.getAlto()){
                return -1;
            }
            return 1;
        }
    };

    public EntidadesAdmin(Controlador controlador, Jugador jugador) {
        this.controlador = controlador;
        this.jugador = jugador;
        entidades = new ArrayList<Entidades>();
        addEntidad(jugador);
    }

    public void tick(){
        for (int i = 0; i < entidades.size(); i++) {
            Entidades e=entidades.get(i);
            e.tick();
        }
        entidades.sort(acomodoDibujos);


    }

    public void dibujar(Graphics g){
        for(Entidades e : entidades){
            e.dibujar(g);
        }

    }

    public void addEntidad(Entidades e){
        entidades.add(e);
    }


    //getters y setters
    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public ArrayList<Entidades> getEntidades() {
        return entidades;
    }

    public void setEntidades(ArrayList<Entidades> entidades) {
        this.entidades = entidades;
    }
}
