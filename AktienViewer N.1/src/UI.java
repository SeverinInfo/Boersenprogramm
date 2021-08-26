import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;

public class UI  extends JFrame {
    public static CHART chart;
    public static JButton optionsButton, buyButon, sellButton, exitOptionsButton, randomButton, DButton, WButton, MButton, YButton;
    public static JPanel optionsPanel;
    public static JLabel purseLabel, shareLabel, priceLabel, timePeriod;
    public static boolean options;
    public static KEYHANDLER keyhandler;
    public static int paperAmount;

    public static void main(String[] args) {
        new UI();
    }

    UI(){
      keyhandler = new KEYHANDLER();
      chart = new CHART();
      optionsButton = new JButton("options");
      exitOptionsButton = new JButton("back");
      buyButon = new JButton("BUY");
      sellButton = new JButton("SELL");
      randomButton = new JButton("RANDOM");
      DButton = new JButton("d");
      WButton = new JButton("w");
      MButton = new JButton("m");
      YButton = new JButton("y");
      optionsPanel = new JPanel();
      purseLabel = new JLabel("PURSE: ");
      shareLabel = new JLabel("SHARE: ");
      priceLabel = new JLabel("PRICE: ");
      timePeriod = new JLabel("                time period:");
      setSize(1000, 700);
      setVisible(true);
      setLayout(null);
      setResizable(false);
      getContentPane().setBackground(Color.gray);
      addKeyListener(keyhandler);
      add(chart);
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
      add(DButton);

      WButton.setBounds(455, 35, 45, 20);
      add(WButton);

      MButton.setBounds(500, 35, 45, 20);
      add(MButton);

      YButton.setBounds(545 ,35, 45, 20);
      add(YButton);

      buyButon.setBounds(400, 550, 70, 20);
      add(buyButon);

      sellButton.setBounds(530, 550, 70, 20);
      add(sellButton);

      randomButton.setBounds(455, 510, 90, 20);
      randomButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              new CHART();
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

      timePeriod.setBounds(410, 15, 180, 20);
      add(timePeriod);

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

    }

    public static void closeOptions(){
        optionsPanel.setVisible(false);
        chart.setVisible(true);
        sellButton.setVisible(true);
        buyButon.setVisible(true);
        optionsButton.setVisible(true);
        optionsButton.setEnabled(true);

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
