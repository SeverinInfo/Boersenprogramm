import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UI  extends JFrame {
    public static CHART chart;
    public static JButton optionsButton, buyButon, sellButton, exitOptionsButton, randomButton, DButton, WButton, MButton, YButton, sc5Button, sc10Button, sc100Button, sc1000Button;
    public static JPanel optionsPanel;
    public static JLabel purseLabel, shareLabel, priceLabel, timePeriodLabel, scaleLabel;
    public static boolean options;
    public static KEYHANDLER keyhandler;
    public static int paperAmount;

    public static void main(String[] args) {
        new UI();
    }

    UI(){
      keyhandler = new KEYHANDLER();
      DButton = new JButton("d");
      WButton = new JButton("w");
      MButton = new JButton("m");
      YButton = new JButton("y");
      sc5Button = new JButton("5");
      sc10Button = new JButton("10");
      sc100Button = new JButton("100");
      sc1000Button = new JButton("1000");
      chart = new CHART();
      optionsButton = new JButton("options");
      exitOptionsButton = new JButton("back");
      buyButon = new JButton("BUY");
      sellButton = new JButton("SELL");
      randomButton = new JButton("RANDOM");
      optionsPanel = new JPanel();
      purseLabel = new JLabel("PURSE: ");
      shareLabel = new JLabel("SHARE: ");
      priceLabel = new JLabel("PRICE: ");
      timePeriodLabel = new JLabel("                time period:");
      scaleLabel = new JLabel("     scale:");
      setSize(1000, 700);
      setVisible(true);
      setLayout(null);
      setResizable(false);
      getContentPane().setBackground(Color.gray);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      addKeyListener(keyhandler);
      add(chart);
      add(CHART.BackgroundPanel);
      options = false;
      paperAmount = 1;


      //Buttons
      optionsButton.setBounds(0, 0, 80, 20);
      optionsButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              openOptions();
              options = true;
          }
      });
      add(optionsButton);

      exitOptionsButton.setBounds(0,0,80, 20);
      exitOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeOptions();
                options = false;
            }
        });
      optionsPanel.add(exitOptionsButton);

      DButton.setBounds(410, 35, 45, 20);
      DButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              CHART.timeperiod = "day";
          }
      });
      add(DButton);

      WButton.setBounds(455, 35, 45, 20);
      WButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CHART.timeperiod = "week";
            }
        });
      add(WButton);

      MButton.setBounds(500, 35, 45, 20);
      MButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CHART.timeperiod = "month";
            }
        });
      add(MButton);

      YButton.setBounds(545 ,35, 45, 20);
      YButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              CHART.timeperiod = "year";
          }
      });
      add(YButton);

      sc5Button.setBounds(70, 260, 70, 20);
      sc5Button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              CHART.scale = 5;
          }
      });
      add(sc5Button);

      sc10Button.setBounds(70, 280, 70, 20);
      sc10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CHART.scale = 10;
            }
        });
      add(sc10Button);

      sc100Button.setBounds(70, 300, 70, 20);
      sc100Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CHART.scale = 100;
            }
        });
      add(sc100Button);

      sc1000Button.setBounds(70, 320, 70, 20);
      sc1000Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CHART.scale = 1000;
            }
        });
      add(sc1000Button);

      buyButon.setBounds(400, 580, 70, 20);
      add(buyButon);

      sellButton.setBounds(530, 580, 70, 20);
      add(sellButton);

      randomButton.setBounds(455, 540, 90, 20);
      randomButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              new STORAGE();
              updateLabels();
          }
      });
      add(randomButton);


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

      updateLabels();


      optionsPanel.setVisible(false);
      optionsPanel.setLayout(null);
      optionsPanel.setBounds(0, 0, 1000, 400);
      optionsPanel.setBackground(Color.black);
      optionsPanel.addKeyListener(keyhandler);
      add(optionsPanel);






    }
    public static void openOptions(){
        optionsPanel.setVisible(true);
        chart.setVisible(false);
        sellButton.setVisible(false);
        buyButon.setVisible(false);
        optionsButton.setVisible(false);
        optionsButton.setEnabled(false);
        CHART.BackgroundPanel.setVisible(false);
        timePeriodLabel.setVisible(false);
        DButton.setVisible(false);
        WButton.setVisible(false);
        MButton.setVisible(false);
        YButton.setVisible(false);
        randomButton.setVisible(false);

    }

    public static void closeOptions(){
        optionsPanel.setVisible(false);
        chart.setVisible(true);
        sellButton.setVisible(true);
        buyButon.setVisible(true);
        optionsButton.setVisible(true);
        optionsButton.setEnabled(true);
        CHART.BackgroundPanel.setVisible(true);
        timePeriodLabel.setVisible(true);
        DButton.setVisible(true);
        WButton.setVisible(true);
        MButton.setVisible(true);
        YButton.setVisible(true);
        randomButton.setVisible(true);

    }

    public static void updateLabels(){
        priceLabel.setText("PRICE: " + GENERATOR.generatedData[GENERATOR.generatorLenght - 1] + "$");

        if(GENERATOR.generatedData[GENERATOR.generatorLenght - 1] - GENERATOR.generatedData[0] < 0){
            shareLabel.setText("SHARE: "+ ((GENERATOR.generatedData[GENERATOR.generatorLenght - 1]) - (GENERATOR.generatedData[0]) + "$"));
            shareLabel.setForeground(Color.red);
        }
        else {
            shareLabel.setText("SHARE: "+ ((GENERATOR.generatedData[GENERATOR.generatorLenght - 1]) - (GENERATOR.generatedData[0]) + "$"));
            shareLabel.setForeground(Color.green);
        }

        purseLabel.setText("PURSE: " + paperAmount * GENERATOR.generatedData[GENERATOR.generatorLenght - 1] + "$");
    }


}
