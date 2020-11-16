public class Controlador {

    private Juego juego;
    private Mundo mundo;

    public Controlador(Juego juego){
        this.juego=juego;
    }

    public int getAncho(){
        return juego.getAncho();
    }

    public int getAlto(){
        return juego.getAlto();
    }

    public Camara getCamara(){
        return juego.getCamara();
    }

    public Teclado getTeclado(){
       return juego.getTeclado();
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Mundo getMundo() {
        return mundo;
    }

    public void setMundo(Mundo mundo) {
        this.mundo = mundo;
    }
}
