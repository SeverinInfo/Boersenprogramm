import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class UI  extends JFrame {
    public static JButton optionsButton, buyButon, sellButton, exitOptionsButton, DButton, WButton, MButton, YButton, sc5Button, sc10Button, sc100Button, sc1000Button, speedupButton;
    public static JPanel optionsPanel;
    public static JLabel purseLabel, shareLabel, priceLabel, timePeriodLabel, scaleLabel;
    public static boolean options;
    public static KeyHandler keyhandler;
    public static int paperAmount;

    UI(){
      keyhandler = new KeyHandler();
      DButton = new JButton("d");
      WButton = new JButton("w");
      MButton = new JButton("m");
      YButton = new JButton("y");
      speedupButton = new JButton("SPEEDUP");
      sc5Button = new JButton("5");
      sc10Button = new JButton("10");
      sc100Button = new JButton("100");
      sc1000Button = new JButton("1000");
      optionsButton = new JButton("options");
      exitOptionsButton = new JButton("back");
      buyButon = new JButton("BUY");
      sellButton = new JButton("SELL");
      optionsPanel = new JPanel();
      purseLabel = new JLabel("PURSE: ");
      shareLabel = new JLabel("SHARE: ");
      priceLabel = new JLabel("PRICE: ");
      timePeriodLabel = new JLabel("                time period:");
      scaleLabel = new JLabel("     scale:");
      setSize(1000, 700);
      setVisible(true);
      setLayout(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      getContentPane().setBackground(Color.gray);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      addWindowListener(new WindowListener() {
          @Override
          public void windowOpened(WindowEvent e) {

          }

          @Override
          public void windowClosing(WindowEvent e) {

          }

          @Override
          public void windowClosed(WindowEvent e) {
              Storage.DataSaver("day");
              Storage.DataSaver("week");
              Storage.DataSaver("month");
              Storage.DataSaver("year");
              System.exit(EXIT_ON_CLOSE);

          }

          @Override
          public void windowIconified(WindowEvent e) {

          }

          @Override
          public void windowDeiconified(WindowEvent e) {

          }

          @Override
          public void windowActivated(WindowEvent e) {

          }

          @Override
          public void windowDeactivated(WindowEvent e) {

          }
      });
      addKeyListener(keyhandler);
      add(Chart.MPanel);
      add(Chart.BPanel);
      options = false;
      paperAmount = 1;


      //Buttons
      optionsButton.setBounds(0, 0, 80, 20);
      optionsButton.addActionListener(e -> {
          openOptions();
          options = true;
      });
      add(optionsButton);

      exitOptionsButton.setBounds(0,0,80, 20);
      exitOptionsButton.addActionListener(e -> {
          closeOptions();
          options = false;
      });
      optionsPanel.add(exitOptionsButton);

      speedupButton.setBounds(450, 540, 100, 20);
      speedupButton.addActionListener(e -> {
          Generator.updateTimeDay = 15;
          Generator.updateTimeWeek = 15;
          Generator.updateTimeMonth = 15;
          Generator.updateTimeYear = 15;
          Generator.createDayData();
          Generator.createWeekData();
          Generator.createMonthData();
          Generator.createYearData();
      });
      add(speedupButton);

      DButton.setBounds(410, 35, 45, 20);
      DButton.addActionListener(e -> Chart.timePeriod = "day");
      add(DButton);

      WButton.setBounds(455, 35, 45, 20);
      WButton.addActionListener(e -> Chart.timePeriod = "week");
      add(WButton);

      MButton.setBounds(500, 35, 45, 20);
      MButton.addActionListener(e -> Chart.timePeriod = "month");
      add(MButton);

      YButton.setBounds(545 ,35, 45, 20);
      YButton.addActionListener(e -> Chart.timePeriod = "year");
      add(YButton);

      sc5Button.setBounds(70, 260, 70, 20);
      sc5Button.addActionListener(e -> Chart.scale = 5);
      add(sc5Button);

      sc10Button.setBounds(70, 280, 70, 20);
      sc10Button.addActionListener(e -> Chart.scale = 10);
      add(sc10Button);

      sc100Button.setBounds(70, 300, 70, 20);
      sc100Button.addActionListener(e -> Chart.scale = 100);
      add(sc100Button);

      sc1000Button.setBounds(70, 320, 70, 20);
      sc1000Button.addActionListener(e -> Chart.scale = 1000);
      add(sc1000Button);

      buyButon.setBounds(400, 580, 70, 20);
      add(buyButon);

      sellButton.setBounds(530, 580, 70, 20);
      add(sellButton);

      //Label
      purseLabel.setBounds(30, 500, 100, 20);
      add(purseLabel);

      shareLabel.setBounds(30, 530, 100, 20);
      add(shareLabel);

      priceLabel.setBounds(30, 560, 100, 20);
      add(priceLabel);

      timePeriodLabel.setBounds(410, 15, 180, 20);
      add(timePeriodLabel);

      scaleLabel.setBounds(70, 240, 70, 20);
      add(scaleLabel);

      optionsPanel.setVisible(false);
      optionsPanel.setLayout(null);
      optionsPanel.setBounds(0, 0, 1000, 400);
      optionsPanel.setBackground(Color.black);
      optionsPanel.addKeyListener(keyhandler);
      add(optionsPanel);






    }
    public static void openOptions(){
        optionsPanel.setVisible(true);
        Chart.MPanel.setVisible(false);
        sellButton.setVisible(false);
        buyButon.setVisible(false);
        optionsButton.setVisible(false);
        optionsButton.setEnabled(false);
        Chart.BPanel.setVisible(false);
        timePeriodLabel.setVisible(false);
        DButton.setVisible(false);
        WButton.setVisible(false);
        MButton.setVisible(false);
        YButton.setVisible(false);
    }

    public static void closeOptions(){
        optionsPanel.setVisible(false);
        Chart.MPanel.setVisible(true);
        sellButton.setVisible(true);
        buyButon.setVisible(true);
        optionsButton.setVisible(true);
        optionsButton.setEnabled(true);
        Chart.BPanel.setVisible(true);
        timePeriodLabel.setVisible(true);
        DButton.setVisible(true);
        WButton.setVisible(true);
        MButton.setVisible(true);
        YButton.setVisible(true);
    }
}
