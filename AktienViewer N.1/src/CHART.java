import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CHART extends JPanel {
public static int[] Value;
public static JLabel bottScaleLabel,bottmidScaleLabel, midScaleLabel,uppmidScaleLabel, uppScaleLabel, xTimelabel;
public static int scale;
public static String timeperiod = "day";
public static JPanel BackgroundPanel;



    public static void main(String[] args) {
         new UI();

    }

    CHART(){
        new STORAGE();
        STORAGE.DataSaver();
        STORAGE.DataLoader();

        BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(175, 65, 650, 450);
        BackgroundPanel.setBackground(new Color(100, 100, 100));
        BackgroundPanel.setLayout(null);
        BackgroundPanel.setVisible(true);
        scale = 10;
        setVisible(true);
        setBackground(Color.darkGray);
        setLayout(null);
        setBounds(200, 90, 600, 400);
        Value = new int[STORAGE.Data.length];

        //y beschriftunng
        bottScaleLabel = new JLabel();
        bottScaleLabel.setBounds(0, 419, 50, 12);
        bottScaleLabel.setForeground(Color.orange);
        BackgroundPanel.add(bottScaleLabel);
        bottmidScaleLabel = new JLabel();
        bottmidScaleLabel.setBounds(0, 319, 50, 12);
        bottmidScaleLabel.setForeground(Color.orange);
        BackgroundPanel.add(bottmidScaleLabel);
        midScaleLabel = new JLabel();
        midScaleLabel.setBounds(0, 219, 50, 12);
        midScaleLabel.setForeground(Color.orange);
        BackgroundPanel.add(midScaleLabel);
        uppmidScaleLabel = new JLabel();
        uppmidScaleLabel.setBounds(0,119, 50, 12);
        uppmidScaleLabel.setForeground(Color.orange);
        BackgroundPanel.add(uppmidScaleLabel);
        uppScaleLabel = new JLabel();
        uppScaleLabel.setBounds(0, 19, 50, 12);
        uppScaleLabel.setForeground(Color.orange);
        BackgroundPanel.add(uppScaleLabel);



        //x beschriftung
        xTimelabel = new JLabel("");
        xTimelabel.setBounds(0, 430, 650, 20);
        xTimelabel.setForeground(Color.orange);
        BackgroundPanel.add(xTimelabel);

    }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.orange);
            switch (timeperiod){
                case "day":
                    for (int i = 1; i < 6; i++) {
                        g.drawLine(i * 100, 0, i * 100, 400);
                        setSize(600, 400);
                    }
                    break;
                case "week":
                    for (int i = 1; i < 7; i++) {
                        g.drawLine(i * 85, 0, i * 85, 400);
                        setSize(600, 400);
                    }
                    break;
                case "month":
                    String date = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
                    int month = Integer.parseInt(date);
                    if (month == 8 || month == 3 || month == 5 || month == 7 || month == 1 || month == 10 || month == 12){
                        for (int i = 1; i < 31; i++) {
                            g.drawLine((i * 19) , 0, (i * 19) , 400);
                            setSize(589, 400);
                        }
                    }
                    else if (month == 2){
                        for (int i = 1; i < 28; i++) {
                            g.drawLine(i * 21, 0, i * 21, 400);
                            setSize(588, 400);
                        }
                    }
                    else if (month == 4 || month == 6 || month == 9 || month == 11) {
                        for (int i = 1; i < 30; i++) {
                            g.drawLine(i * 20, 0, i * 20, 400);
                            setSize(600, 400);
                        }
                    }
                    break;
                case "year":
                    for (int i = 1; i < 12; i++) {
                        g.drawLine(i * 50, 0, i * 50, 400);
                        setSize(600, 400);
                    }
            }       //oranenen Linien

            g.setColor(Color.WHITE);
            switch (scale){
                case 5:
                    UI.sc5Button.setBackground(Color.lightGray);
                    UI.sc10Button.setBackground(new Color (100, 100, 100));
                    UI.sc100Button.setBackground(new Color (100, 100, 100));
                    UI.sc1000Button.setBackground(new Color(100, 100, 100));

                    for (int j = 0; j < STORAGE.Data.length - 1; j++) {
                        g.drawLine((j * 20), 400 - (STORAGE.Data[j] * 80), (j * 20) + 20, 400 - (STORAGE.Data[j + 1] * 80));
                    }
                    break;
                case 10:
                    UI.sc5Button.setBackground(new Color (100, 100, 100));
                    UI.sc10Button.setBackground(Color.lightGray);
                    UI.sc100Button.setBackground(new Color (100, 100, 100));
                    UI.sc1000Button.setBackground(new Color(100, 100, 100));

                    for (int j = 0; j < STORAGE.Data.length - 1; j++) {
                        g.drawLine((j * 20), 400 - (STORAGE.Data[j] * 40), (j * 20) + 20, 400 - (STORAGE.Data[j + 1] * 40));
                    }
                    break;
                case 100:
                    UI.sc5Button.setBackground(new Color (100, 100, 100));
                    UI.sc10Button.setBackground(new Color (100, 100, 100));
                    UI.sc100Button.setBackground(Color.lightGray);
                    UI.sc1000Button.setBackground(new Color(100, 100, 100));

                    for (int j = 0; j < STORAGE.Data.length - 1; j++) {
                        g.drawLine((j * 20), 400 - (STORAGE.Data[j] * 4), (j * 20) + 20, 400 - (STORAGE.Data[j + 1] * 4));
                    }
                    break;
                case 1000:
                    UI.sc5Button.setBackground(new Color (100, 100, 100));
                    UI.sc10Button.setBackground(new Color (100, 100, 100));
                    UI.sc100Button.setBackground(new Color (100, 100, 100));
                    UI.sc1000Button.setBackground(Color.lightGray);

                    for (int j = 0; j < STORAGE.Data.length - 1; j++) {
                        g.drawLine((j * 20), 400 - (STORAGE.Data[j] * 4/10), (j * 20) + 20, 400 - (STORAGE.Data[j + 1] * 4/10));
                    }
                    break;
            }            //graphen

            super.repaint();
            updateInfo();
        }



    public static void updateInfo(){
        switch (scale){
            case 5:
                bottScaleLabel.setText("  0");
                bottmidScaleLabel.setText("1,25");
                midScaleLabel.setText(" 2,5");
                uppmidScaleLabel.setText("3,75");
                uppScaleLabel.setText("  5");
                break;
            case 10:
                bottScaleLabel.setText("  0");
                bottmidScaleLabel.setText(" 2,5");
                midScaleLabel.setText("  5");
                uppmidScaleLabel.setText(" 7,5");
                uppScaleLabel.setText(" 10");
                break;
            case 100:
                bottScaleLabel.setText("  0");
                bottmidScaleLabel.setText(" 25");
                midScaleLabel.setText(" 50");
                uppmidScaleLabel.setText(" 75");
                uppScaleLabel.setText("100");
                break;
            case 1000:
                bottScaleLabel.setText("  0");
                bottmidScaleLabel.setText("250");
                midScaleLabel.setText("500");
                uppmidScaleLabel.setText("750");
                uppScaleLabel.setText(" 1k");
                break;
        }
        switch (timeperiod){
            case "day":
                UI.DButton.setBackground(Color.lightGray);
                UI.WButton.setBackground(new Color(100, 100, 100));
                UI.MButton.setBackground(new Color(100, 100, 100));
                UI.YButton.setBackground(new Color(100, 100, 100));
                    String time = new SimpleDateFormat("HH:mm.ss").format(Calendar.getInstance().getTime());
                    xTimelabel.setText("-----------------------------------------------------------------------------------------------------------------------------------------------------" + time);
                    break;
            case "week":
                UI.DButton.setBackground(new Color(100, 100, 100));
                UI.WButton.setBackground(Color.lightGray);
                UI.MButton.setBackground(new Color(100, 100, 100));
                UI.YButton.setBackground(new Color(100, 100, 100));
                String date = new SimpleDateFormat("dd.MM").format(Calendar.getInstance().getTime());
                xTimelabel.setText("--------------------------------------------------------------------------------------------------------------------------------------------------------" + date);
                break;
            case "month":
                UI.DButton.setBackground(new Color(100, 100, 100));
                UI.WButton.setBackground(new Color(100, 100, 100));
                UI.MButton.setBackground(Color.lightGray);
                UI.YButton.setBackground(new Color(100, 100, 100));
                String month = new SimpleDateFormat("dd.MM").format(Calendar.getInstance().getTime());
                xTimelabel.setText("--------------------------------------------------------------------------------------------------------------------------------------------------------" + month);
                break;
            case "year":
                UI.DButton.setBackground(new Color(100, 100, 100));
                UI.WButton.setBackground(new Color(100, 100, 100));
                UI.MButton.setBackground(new Color(100, 100, 100));
                UI.YButton.setBackground(Color.lightGray);
                String year = new SimpleDateFormat("MM.yyyy").format(Calendar.getInstance().getTime());
                xTimelabel.setText("------------------------------------------------------------------------------------------------------------------------------------------------------" + year);
                break;
        }
    }
}
