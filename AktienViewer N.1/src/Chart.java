import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Chart {
public static JLabel bottScaleLabel, botMidScaleLabel, midScaleLabel, upMidScaleLabel, upScaleLabel, xTimeLabel;
public static int scale = 10;
public static String timePeriod = "day";
public static JPanel BPanel, MPanel;


   public static void createChart(){
        BPanel = new JPanel();
        MPanel = new JPanel();
        BPanel.setBounds(175, 65, 650, 450);
        BPanel.setBackground(new Color(100, 100, 100));
        BPanel.setLayout(null);
        BPanel.setVisible(true);
        MPanel.setVisible(true);
        MPanel.setBackground(Color.darkGray);
        MPanel.setLayout(null);
        MPanel.setBounds(200, 90, 600, 400);

       //y Beschriftunng
       bottScaleLabel = new JLabel();
       bottScaleLabel.setBounds(0, 419, 50, 12);
       bottScaleLabel.setForeground(Color.orange);
       BPanel.add(bottScaleLabel);
       botMidScaleLabel = new JLabel();
       botMidScaleLabel.setBounds(0, 319, 50, 12);
       botMidScaleLabel.setForeground(Color.orange);
       BPanel.add(botMidScaleLabel);
       midScaleLabel = new JLabel();
       midScaleLabel.setBounds(0, 219, 50, 12);
       midScaleLabel.setForeground(Color.orange);
       BPanel.add(midScaleLabel);
       upMidScaleLabel = new JLabel();
       upMidScaleLabel.setBounds(0,119, 50, 12);
       upMidScaleLabel.setForeground(Color.orange);
       BPanel.add(upMidScaleLabel);
       upScaleLabel = new JLabel();
       upScaleLabel.setBounds(0, 19, 50, 12);
       upScaleLabel.setForeground(Color.orange);
       BPanel.add(upScaleLabel);

       //x beschriftung
       xTimeLabel = new JLabel("");
       xTimeLabel.setBounds(0, 430, 650, 20);
       xTimeLabel.setForeground(Color.orange);
       BPanel.add(xTimeLabel);

       ChartDrawer chd = new ChartDrawer();
       setupDraw(chd, 0, 0, 600, 400);
    }

    public static void updateInfo(){
        switch (scale) {
            case 5 -> {
                bottScaleLabel.setText("  0");
                botMidScaleLabel.setText("1,25");
                midScaleLabel.setText(" 2,5");
                upMidScaleLabel.setText("3,75");
                upScaleLabel.setText("  5");
            }
            case 10 -> {
                bottScaleLabel.setText("  0");
                botMidScaleLabel.setText(" 2,5");
                midScaleLabel.setText("  5");
                upMidScaleLabel.setText(" 7,5");
                upScaleLabel.setText(" 10");
            }
            case 100 -> {
                bottScaleLabel.setText("  0");
                botMidScaleLabel.setText(" 25");
                midScaleLabel.setText(" 50");
                upMidScaleLabel.setText(" 75");
                upScaleLabel.setText("100");
            }
            case 1000 -> {
                bottScaleLabel.setText("  0");
                botMidScaleLabel.setText("250");
                midScaleLabel.setText("500");
                upMidScaleLabel.setText("750");
                upScaleLabel.setText(" 1k");
            }
        }
        switch (timePeriod) {
            case "day" -> {
                UI.DButton.setBackground(Color.lightGray);
                UI.WButton.setBackground(new Color(100, 100, 100));
                UI.MButton.setBackground(new Color(100, 100, 100));
                UI.YButton.setBackground(new Color(100, 100, 100));
                String time = new SimpleDateFormat("HH:mm.ss").format(Calendar.getInstance().getTime());
                xTimeLabel.setText("-----------------------------------------------------------------------------------------------------------------------------------------------------" + time);
            }
            case "week" -> {
                UI.DButton.setBackground(new Color(100, 100, 100));
                UI.WButton.setBackground(Color.lightGray);
                UI.MButton.setBackground(new Color(100, 100, 100));
                UI.YButton.setBackground(new Color(100, 100, 100));
                String date = new SimpleDateFormat("dd.MM").format(Calendar.getInstance().getTime());
                xTimeLabel.setText("--------------------------------------------------------------------------------------------------------------------------------------------------------" + date);
            }
            case "month" -> {
                UI.DButton.setBackground(new Color(100, 100, 100));
                UI.WButton.setBackground(new Color(100, 100, 100));
                UI.MButton.setBackground(Color.lightGray);
                UI.YButton.setBackground(new Color(100, 100, 100));
                String month = new SimpleDateFormat("dd.MM").format(Calendar.getInstance().getTime());
                xTimeLabel.setText("--------------------------------------------------------------------------------------------------------------------------------------------------------" + month);
            }
            case "year" -> {
                UI.DButton.setBackground(new Color(100, 100, 100));
                UI.WButton.setBackground(new Color(100, 100, 100));
                UI.MButton.setBackground(new Color(100, 100, 100));
                UI.YButton.setBackground(Color.lightGray);
                String year = new SimpleDateFormat("MM.yyyy").format(Calendar.getInstance().getTime());
                xTimeLabel.setText("------------------------------------------------------------------------------------------------------------------------------------------------------" + year);
            }
        }


      /*  UI.priceLabel.setText("PRICE: " + Generator.dayData.get(Generator.dayData.size() - 1) + "$");

        if(Generator.dayData.get(Generator.dayData.size() - 1) - Generator.dayData.get(0) < 0){
            UI.shareLabel.setText("SHARE: "+ ((Generator.dayData.get(Generator.dayData.size() - 1)) - (Generator.dayData.get(0)) + "$"));
            UI.shareLabel.setForeground(Color.red);
        }
        else {
            UI.shareLabel.setText("SHARE: "+ ((Generator.dayData.get(Generator.dayData.size() - 1)) - (Generator.dayData.get(0)) + "$"));
            UI.shareLabel.setForeground(Color.green);
        }

        UI.purseLabel.setText("PURSE: " + UI.paperAmount * Generator.dayData.get(Generator.dayData.size() - 1) + "$");

       */
    }



    public static void setupDraw(JLabel draw, int x, int y, int width, int height){
        draw.setBounds(x, y, width, height);
        draw.setVisible(true);
        MPanel.add(draw);
    }


}
