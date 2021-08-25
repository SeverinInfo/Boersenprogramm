import javax.swing.*;
import java.awt.*;

public class CHARTDRAWER extends JPanel {
    STORAGE storage;



    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setColor(Color.WHITE);
        for (int i = 0; i < 15; i++) {
            g.drawLine(i * 40 , storage.Data[i], i * 40 + 40, storage.Data[i + 1] );
        }


        super.repaint();
    }


}
