
//esta clase va a ejecutar el programa

public class Launcher {
    public static void main(String[] args) {

        //se pone el título de la pantalla, se establece ancho y alto
        Juego juego= new Juego("Ajolotito", 800, 600);
        juego.start();

    }
}
