import Model.Utils;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The main view class for the Image Filtering GUI.
 */
public class StatisticsView extends JFrame implements IView {

  private final JButton poissonDistribution;
  private final JButton expectedValue;
  private final JButton variance;
  private final JButton quitButton;
  private final JTextField input;
  private final JLabel programOutput;

  /**
   * Allows for a GUI viewer to be constructed with all its buttons and whatnot.
   */
  public StatisticsView() {
    super();
    this.setTitle("High-Tech MBTA Statistical Analysis");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());

    //button panel
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.NORTH);

    //input textfield
    input = new JTextField(15);
    buttonPanel.add(input);

    // Poisson Distribution Button
    poissonDistribution = new JButton("Poisson Distribution");
    buttonPanel.add(poissonDistribution);

    // Expected Value Button
    expectedValue = new JButton("Expected Value");
    buttonPanel.add(expectedValue);

    // Variance Button
    variance = new JButton("Variance");
    buttonPanel.add(variance);

    //Quit Button
    quitButton = new JButton("Quit");
    buttonPanel.add(quitButton);

    //dialog boxes
    JPanel dialogBoxesPanel = new JPanel();
    dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("Dialog boxes"));
    dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.PAGE_AXIS));
    buttonPanel.add(dialogBoxesPanel);

    // Message Panel
    JPanel messageDialogPanel = new JPanel();
    messageDialogPanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(messageDialogPanel);

    // Placing Output
    programOutput = new JLabel("", JLabel.CENTER);
    this.add(programOutput, BorderLayout.CENTER);

    this.pack();
  }


  public void makeVisible() {
    this.setVisible(true);
  }


  public void clearInputString() {
    input.setText("");
  }


  public void addFeatures(Features features) {

    //POISSON DISTRIBUTION BUTTON
    poissonDistribution.addActionListener(evt -> {
      if (input.getText().length() != 0) {
        this.updateOutput(String.valueOf(features.poissionDistribution(input.getText())));
        this.pack();
        this.repaint();
      }
      this.clearInputString();
    });

    //EXPECTED VALUE BUTTON
    expectedValue.addActionListener(evt -> {
      if (input.getText().length() != 0) {
        this.updateOutput(String.valueOf(features.expectedValue(input.getText())));
        this.pack();
        this.repaint();
      }
      this.clearInputString();
    });

    //VARIANCE BUTTON
    variance.addActionListener(evt -> {
      if (input.getText().length() != 0) {
        this.updateOutput(String.valueOf(features.variance(input.getText())));
        this.pack();
        this.repaint();
      }
      this.clearInputString();
    });

    // QUIT BUTTON
    quitButton.addActionListener((ActionEvent e) -> {
      System.exit(0);
    });
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override
  public void renderMessage(String message) throws IOException {
    Utils.nullCheck(message);
    JOptionPane.showMessageDialog(this, message, "Error Thrown",
        JOptionPane.PLAIN_MESSAGE);
  }

  @Override
  public void updateOutput(String text) {
   if (text == null) {
     programOutput.setText(" ");
   } else {
     programOutput.setText(text);
   }
   programOutput.repaint();
  }
}