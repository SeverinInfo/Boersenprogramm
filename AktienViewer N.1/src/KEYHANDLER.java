import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KEYHANDLER implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("enter");
            if(UI.options == true){
                UI.closeOptions();
                UI.options = false;
            }
            else{
                UI.openOptions();
                UI.options = true;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
