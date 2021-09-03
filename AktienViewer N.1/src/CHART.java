import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class CHART  {
public static JLabel bottScaleLabel,bottmidScaleLabel, midScaleLabel,uppmidScaleLabel, uppScaleLabel, xTimelabel;
public static int scale = 10;
public static String timeperiod = "day";
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

       //y beschriftunng
       bottScaleLabel = new JLabel();
       bottScaleLabel.setBounds(0, 419, 50, 12);
       bottScaleLabel.setForeground(Color.orange);
       BPanel.add(bottScaleLabel);
       bottmidScaleLabel = new JLabel();
       bottmidScaleLabel.setBounds(0, 319, 50, 12);
       bottmidScaleLabel.setForeground(Color.orange);
       BPanel.add(bottmidScaleLabel);
       midScaleLabel = new JLabel();
       midScaleLabel.setBounds(0, 219, 50, 12);
       midScaleLabel.setForeground(Color.orange);
       BPanel.add(midScaleLabel);
       uppmidScaleLabel = new JLabel();
       uppmidScaleLabel.setBounds(0,119, 50, 12);
       uppmidScaleLabel.setForeground(Color.orange);
       BPanel.add(uppmidScaleLabel);
       uppScaleLabel = new JLabel();
       uppScaleLabel.setBounds(0, 19, 50, 12);
       uppScaleLabel.setForeground(Color.orange);
       BPanel.add(uppScaleLabel);

       //x beschriftung
       xTimelabel = new JLabel("");
       xTimelabel.setBounds(0, 430, 650, 20);
       xTimelabel.setForeground(Color.orange);
       BPanel.add(xTimelabel);

       CHARTDRAWER chd = new CHARTDRAWER();
       setupDraw(chd, 0, 0, 600, 400);
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


      /*  UI.priceLabel.setText("PRICE: " + GENERATOR.dayData.get(GENERATOR.dayData.size() - 1) + "$");

        if(GENERATOR.dayData.get(GENERATOR.dayData.size() - 1) - GENERATOR.dayData.get(0) < 0){
            UI.shareLabel.setText("SHARE: "+ ((GENERATOR.dayData.get(GENERATOR.dayData.size() - 1)) - (GENERATOR.dayData.get(0)) + "$"));
            UI.shareLabel.setForeground(Color.red);
        }
        else {
            UI.shareLabel.setText("SHARE: "+ ((GENERATOR.dayData.get(GENERATOR.dayData.size() - 1)) - (GENERATOR.dayData.get(0)) + "$"));
            UI.shareLabel.setForeground(Color.green);
        }

        UI.purseLabel.setText("PURSE: " + UI.paperAmount * GENERATOR.dayData.get(GENERATOR.dayData.size() - 1) + "$");

       */
    }



    public static void setupDraw(JLabel draw, int x, int y, int width, int height){
        draw.setBounds(x, y, width, height);
        draw.setVisible(true);
        MPanel.add(draw);
    }


}
