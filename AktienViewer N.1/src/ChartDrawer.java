import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChartDrawer extends JLabel {

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.orange);
        switch (Chart.timePeriod){
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
        switch (Chart.scale) {
            case 5 -> {
                UI.sc5Button.setBackground(Color.lightGray);
                UI.sc10Button.setBackground(new Color(100, 100, 100));
                UI.sc100Button.setBackground(new Color(100, 100, 100));
                UI.sc1000Button.setBackground(new Color(100, 100, 100));
                switch (Chart.timePeriod) {
                    case "day":
                        for (int j = 0; j < Generator.dayData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.dayData.get(j) * 80), (j * 2) + 1, 400 - (Generator.dayData.get(j + 1) * 80));
                        }
                        break;
                    case "week":
                        for (int j = 0; j < Generator.weekData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.weekData.get(j) * 80), (j * 2) + 1, 400 - (Generator.weekData.get(j + 1) * 80));
                        }
                        break;
                    case "month":
                        for (int j = 0; j < Generator.monthData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.monthData.get(j) * 80), (j * 2) + 1, 400 - (Generator.monthData.get(j + 1) * 80));
                        }
                        break;
                    default:
                        for (int j = 0; j < Generator.yearData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.yearData.get(j) * 80), (j * 2) + 1, 400 - (Generator.yearData.get(j + 1) * 80));
                        }
                        break;
                }
            }
            case 10 -> {
                UI.sc5Button.setBackground(new Color(100, 100, 100));
                UI.sc10Button.setBackground(Color.lightGray);
                UI.sc100Button.setBackground(new Color(100, 100, 100));
                UI.sc1000Button.setBackground(new Color(100, 100, 100));
                switch (Chart.timePeriod) {
                    case "day":
                        for (int j = 0; j < Generator.dayData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.dayData.get(j) * 40), (j * 2) + 1, 400 - (Generator.dayData.get(j + 1) * 40));
                        }
                        break;
                    case "week":
                        for (int j = 0; j < Generator.weekData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.weekData.get(j) * 40), (j * 2) + 1, 400 - (Generator.weekData.get(j + 1) * 40));
                        }
                        break;
                    case "month":
                        for (int j = 0; j < Generator.monthData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.monthData.get(j) * 40), (j * 2) + 1, 400 - (Generator.monthData.get(j + 1) * 40));
                        }
                        break;
                    default:
                        for (int j = 0; j < Generator.yearData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.yearData.get(j) * 40), (j * 2) + 1, 400 - (Generator.yearData.get(j + 1) * 40));
                        }
                        break;
                }
            }
            case 100 -> {
                UI.sc5Button.setBackground(new Color(100, 100, 100));
                UI.sc10Button.setBackground(new Color(100, 100, 100));
                UI.sc100Button.setBackground(Color.lightGray);
                UI.sc1000Button.setBackground(new Color(100, 100, 100));
                switch (Chart.timePeriod) {
                    case "day":
                        for (int j = 0; j < Generator.dayData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.dayData.get(j) * 4), (j * 2) + 1, 400 - (Generator.dayData.get(j + 1) * 4));
                        }
                        break;
                    case "week":
                        for (int j = 0; j < Generator.weekData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.weekData.get(j) * 4), (j * 2) + 1, 400 - (Generator.weekData.get(j + 1) * 4));
                        }
                        break;
                    case "month":
                        for (int j = 0; j < Generator.monthData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.monthData.get(j) * 4), (j * 2) + 1, 400 - (Generator.monthData.get(j + 1) * 4));
                        }
                        break;
                    default:
                        for (int j = 0; j < Generator.yearData.size() - 1; j++) {
                            g.drawLine((j * 2), 400 - (Generator.yearData.get(j) * 4), (j * 2) + 1, 400 - (Generator.yearData.get(j + 1) * 4));
                        }
                        break;
                }
            }
            case 1000 -> {
                UI.sc5Button.setBackground(new Color(100, 100, 100));
                UI.sc10Button.setBackground(new Color(100, 100, 100));
                UI.sc100Button.setBackground(new Color(100, 100, 100));
                UI.sc1000Button.setBackground(Color.lightGray);
                switch (Chart.timePeriod) {
                    case "day":
                        for (int j = 0; j < Generator.dayData.size() - 1; j++) {
                            g.drawLine((j * 2), 400, (j * 2) + 1, 400);
                        }
                        break;
                    case "week":
                        for (int j = 0; j < Generator.weekData.size() - 1; j++) {
                            g.drawLine((j * 2), 400, (j * 2) + 1, 400);
                        }
                        break;
                    case "month":
                        for (int j = 0; j < Generator.monthData.size() - 1; j++) {
                            g.drawLine((j * 2), 400, (j * 2) + 1, 400);
                        }
                        break;
                    default:
                        for (int j = 0; j < Generator.yearData.size() - 1; j++) {
                            g.drawLine((j * 2), 400, (j * 2) + 1, 400);
                        }
                        break;
                }
            }
        }

        repaint();
        Chart.updateInfo();
    }
}
