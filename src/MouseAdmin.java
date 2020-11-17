import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseAdmin implements MouseListener, MouseMotionListener {

    private boolean izqPresionado, derPresionado;
    private int mouseX, mouseY;
    private UIAdmin uiAdmin;

    public MouseAdmin(){

    }

    public void setUIAdmin(UIAdmin uiAdmin){
        this.uiAdmin=uiAdmin;
    }

    //getters


    public boolean isIzqPresionado() {
        return izqPresionado;
    }

    public boolean isDerPresionado() {
        return derPresionado;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    //metodos implementados
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1) izqPresionado=true;
        else if (e.getButton()==MouseEvent.BUTTON3) derPresionado=true;


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1) izqPresionado=false;
        else if (e.getButton()==MouseEvent.BUTTON3) derPresionado=false;

        if(uiAdmin!=null){
            uiAdmin.onMouseRelease(e);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        if(uiAdmin!=null){
            uiAdmin.onMouseMove(e);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
