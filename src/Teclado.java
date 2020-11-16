import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    private boolean[] teclas;
    public boolean arriba, abajo, izquierda, derecha;

    public Teclado(){
        teclas=new boolean[256];
    }

    public void tick(){
        arriba=teclas[KeyEvent.VK_W];
        abajo=teclas[KeyEvent.VK_S];
        izquierda=teclas[KeyEvent.VK_A];
        derecha=teclas[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()]=true;
        System.out.println("Pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()]=false;
    }
}
