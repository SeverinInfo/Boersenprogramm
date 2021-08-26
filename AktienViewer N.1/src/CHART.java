import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

public class CHART extends JPanel {
public static int[] Value;
public static JLabel bottScaleLabel,bottmidScaleLabel, midScaleLabel,uppmidScaleLabel, uppScaleLabel;
public static int scale;
public static String timeperiod = "month";




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
        setBounds(200, 70, 600, 400);
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
        //g.setColor(Color.ORANGE);
        //    for (int i = 1; i < 16; i++) {
         //       g.drawLine(i * 40, 0, i * 40, 400);
          //  }

            g.setColor(Color.WHITE);
            for (int j = 0; j < STORAGE.Data.length - 1; j++) {
                g.drawLine((j * 20) + 20, 400 - (STORAGE.Data[j] * 4), (j * 20) + 40, 400 - (STORAGE.Data[j + 1] * 4));
            }

            switch (timeperiod){
                case "day":
                    g.setColor(Color.orange);
                    for (int i = 1; i < 6; i++) {
                        g.drawLine(i * 100, 0, i * 100, 400);
                    }
                    break;
                case "week":
                    g.setColor(Color.orange);
                    for (int i = 1; i < 7; i++) {
                        g.drawLine(i * 85, 0, i * 85, 400);
                    }
                    break;
                case "month":
                    g.setColor(Color.orange);
                    String month = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
                    System.out.println(month);
                   /* if (month == "02" || month == "03" || month == "05" || month == "07" || month == "01" || month == "10" || month == "12"){
                        g.setColor(Color.orange);
                        for (int i = 1; i < 31; i++) {
                            g.drawLine(i * 19, 0, i * 19, 400);
                        }
                    }
                    else if (month == "08"){
                        g.setColor(Color.orange);
                        for (int i = 1; i < 28; i++) {
                            g.drawLine(i * 21, 0, i * 21, 400);
                        }

                    }
                    else if (month == "04" || month == "6" || month == "09" || month == "11") {
                        g.setColor(Color.orange);
                        for (int i = 1; i < 29; i++) {
                            g.drawLine(i * 20, 0, i * 20, 400);
                        }

                    }

                    */



                    switch(month){
                        case "08" :
                            g.setColor(Color.orange);
                            for (int i = 1; i < 31; i++) {
                                g.drawLine(i * 19, 0, i * 19, 400);
                            }
                    }






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

    void changeTimeLine(String timeperiod){

    }





}
