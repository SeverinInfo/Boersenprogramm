import javax.swing.*;
import java.awt.*;

public class CHART extends JPanel {
public static int[] Value;
public static JLabel bottScaleLabel,bottmidScaleLabel, midScaleLabel,uppmidScaleLabel, uppScaleLabel;
public static int scale;





    public static void main(String[] args) {
         new UI();

    }

    CHART(){
        new STORAGE();
        STORAGE.DataSaver();
        STORAGE.DataLoader();
        scale = 100;
        setVisible(true);
        setBackground(Color.darkGray);
        setLayout(null);
        setBounds(200, 50, 600, 400);
        Value = new int[STORAGE.Data.length];
        bottScaleLabel = new JLabel();
        bottScaleLabel.setBounds(0, 388, 50, 12);
        bottScaleLabel.setForeground(Color.orange);
        add(bottScaleLabel);
        bottmidScaleLabel = new JLabel();
        bottmidScaleLabel.setBounds(0, 288, 50, 12);
        bottmidScaleLabel.setForeground(Color.orange);
        add(bottmidScaleLabel);
        midScaleLabel = new JLabel();
        midScaleLabel.setBounds(0, 188, 50, 12);
        midScaleLabel.setForeground(Color.orange);
        add(midScaleLabel);
        uppmidScaleLabel = new JLabel();
        uppmidScaleLabel.setBounds(0,88, 50, 12);
        uppmidScaleLabel.setForeground(Color.orange);
        add(uppmidScaleLabel);
        uppScaleLabel = new JLabel();
        uppScaleLabel.setBounds(0, 0, 50, 12);
        uppScaleLabel.setForeground(Color.orange);
        add(uppScaleLabel);
        changeScale();

    }

        @Override
        protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
            for (int i = 1; i < 16; i++) {
                g.drawLine(i * 40, 0, i * 40, 400);
            }

            g.setColor(Color.WHITE);
            for (int j = 0; j < STORAGE.Data.length - 1; j++) {
                g.drawLine((j * 20) + 20, 400 - (STORAGE.Data[j] * 4), (j * 20) + 40, 400 - (STORAGE.Data[j + 1] * 4));
            }
        super.repaint();
    }

    public static void loadValues(){

    }

    public static void changeScale(){
        switch (scale){
            case 5:
                bottScaleLabel.setText("0");
                bottmidScaleLabel.setText("1,25");
                midScaleLabel.setText("2,5");
                uppmidScaleLabel.setText("3,75");
                uppScaleLabel.setText("5");
                break;
            case 10:
                bottScaleLabel.setText("0");
                bottmidScaleLabel.setText("2,5");
                midScaleLabel.setText("5");
                uppmidScaleLabel.setText("7,5");
                uppScaleLabel.setText("10");
                break;
            case 100:
                bottScaleLabel.setText("0");
                bottmidScaleLabel.setText("25");
                midScaleLabel.setText("50");
                uppmidScaleLabel.setText("75");
                uppScaleLabel.setText("100");
                break;
            case 1000:
                bottScaleLabel.setText("0");
                bottmidScaleLabel.setText("250");
                midScaleLabel.setText("500");
                uppmidScaleLabel.setText("750");
                uppScaleLabel.setText("1000");
                break;

        }
    }





}
