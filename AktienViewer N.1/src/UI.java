import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI  extends JFrame {
    public static CHART chart;
    public static JButton optionsButton, buyButon, sellButton, exitOptionsButton;
    public static JPanel optionsPanel;
    public static JLabel purseLabel, shareLabel, priceLabel;
    public static boolean options;
    public static KEYHANDLER keyhandler;

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
      optionsPanel = new JPanel();
      purseLabel = new JLabel("PURSE: ");
      shareLabel = new JLabel("SHARE: ");
      priceLabel = new JLabel("PRICE: ");
      setSize(1000, 700);
      setVisible(true);
      setLayout(null);
      setResizable(false);
      getContentPane().setBackground(Color.gray);
      addKeyListener(keyhandler);
      add(chart);
      options = false;


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

      buyButon.setBounds(400, 550, 70, 20);
      add(buyButon);
      sellButton.setBounds(530, 550, 70, 20);
      add(sellButton);

      purseLabel.setBounds(30, 500, 100, 20);
      add(purseLabel);

      shareLabel.setBounds(30, 530, 100, 20);
      add(shareLabel);

      priceLabel.setBounds(30, 560, 100, 20);
      add(priceLabel);


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


}
