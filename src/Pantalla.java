import javax.swing.*;
import java.awt.*;

//esta clase servirá para mostrar la pantalla y los gráficos

public class Pantalla {
    //se declaran como private porque no queremos que se puedan
    //modificar fuera de esta clase
    private JFrame pantalla;
    private String titulo;
    private int ancho, alto;
    private Canvas graficos;

    //generamos un constructor para crear la pantalla
    public Pantalla(String titulo, int ancho, int alto) {
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;

        crearPantalla();
    }

    //metodo para que en el constructor no haya tanto código
    private void crearPantalla(){

        /*Aquí se crea la pantalla del juego: se indica el tamaño,
        permite que se cierre, no deja que se pueda cambiar el tamaño,
        manda la pantalla al centro desde el principio y lo hace visible.*/

        pantalla = new JFrame(titulo);
        pantalla.setSize(ancho,alto);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);

        graficos= new Canvas();
        //se establece el tamaño de los graficos
        graficos.setPreferredSize(new Dimension(ancho, alto));
        //esto sirve para que se queden del mismo tamaño los gráficos
        graficos.setMinimumSize(new Dimension(ancho, alto));
        graficos.setMaximumSize(new Dimension(ancho, alto));
        graficos.setFocusable(false);

        //agregar los gráficos a la pantalla
        pantalla.add(graficos);
        //para que se vean todos los gráficos
        pantalla.pack();
    }

    public Canvas getGraficos() {
        return graficos;
    }

    public JFrame getPantalla(){
        return pantalla;
    }
}