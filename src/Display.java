import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ${Rohan_Swaby} on 5/26/2017.
 */
//interface for Gui
public class Display extends JFrame {
    private final JButton next = new JButton("Step");//nextButton
    private final JTextField perCycle = new JTextField("1",5);//forward
    private final JLabel increaseCycle = new JLabel("Move Cycle: ");//increase
    private  final JTextField ThisCycle = new JTextField("0", 5);//currentCycle
    private final JLabel Labelcycle = new JLabel("Cycle #: ");
    JPanel LevelOnePanel = new JPanel();//gridPanel
    JPanel LevelTwoPanel = new JPanel();//displayPanel
    JPanel GridLevelPanel[][];//screenPanel
    JPanel newScreenPanel = new JPanel();
    //Plant
    ImageIcon weed= new ImageIcon(this.getClass().getResource("weed.png"));
    ImageIcon Cor = new ImageIcon(this.getClass().getResource("cat.png"));
    ImageIcon Herb= new ImageIcon(this.getClass().getResource("H.png"));

   public Display(){
       GridLevelPanel = new JPanel[10][10];
       LevelOnePanel.setLayout(new GridLayout(10, 10));
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(700,600);
       //this can be wrapped in a function(
       int i,j;
       for(i = 0; i<10; i++){
           for(j = 0; j< 10; j++){
               GridLevelPanel[i][j] = new JPanel();
               GridLevelPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.BLUE));
               LevelOnePanel.add(GridLevelPanel[i][j]);



           }

       }
       LevelTwoPanel.add(LevelOnePanel);
       newScreenPanel.setLayout(new BoxLayout(newScreenPanel, BoxLayout.Y_AXIS));
       newScreenPanel.add(next);
       newScreenPanel.add(Box.createRigidArea(new Dimension(0,10)));
       newScreenPanel.add(increaseCycle);
       newScreenPanel.add(perCycle);
       newScreenPanel.add(Box.createRigidArea(new Dimension(0,10)));
       newScreenPanel.add(Labelcycle);
       newScreenPanel.add(Box.createRigidArea(new Dimension(0,10)));
       newScreenPanel.add(ThisCycle);
       LevelTwoPanel.add(newScreenPanel);
       this.add(LevelTwoPanel);
       this.setVisible(true);


    }
    /**
     * This returns the input of the user for the forward cycle and also gives an error dialog box if the user inputs
     * cycle that is less than 0
     * @return forward cycle integer
     */
    public int getCycle() {
        if (Integer.parseInt(perCycle.getText()) > 0)
        {
            return Integer.parseInt(perCycle.getText());
        } else {
            displayErrorMessage("Increase Cycle needs to be greater than 0");
            return 0;
        }
    }

    /**
     * This sets the TextField currentCycle to the parameter integer cycle
     * @param cycle integer for the cycle count
     */
    public void setCycle(int cycle) {
        perCycle.setText(Integer.toString(cycle));
    }

    /**
     * This will alert the Connector when the Next Button is pressed.
     * @param listenForNextButton
     */
    void addNextButtonListener (ActionListener listenForNextButton) {
        next.addActionListener(listenForNextButton);
    }

    /**
     * This method will update the screenPanel based on the row, column and the
     * toString() of the LivingBeing instance.
        */
    void updateGUI(int row, int col, String name) {
        if (name == "*")
            GridLevelPanel[row][col].add(new JLabel(weed, JLabel.CENTER));
        if (name == "&")
            GridLevelPanel[row][col].add(new JLabel(Herb, JLabel.CENTER));
        if (name == "@")
            GridLevelPanel[row][col].add(new JLabel(Cor, JLabel.CENTER));
    }

    /**
     * This will refresh the Icons as we update through the cycle.
     */
    void refreshGui () {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                GridLevelPanel[i][j].removeAll();
                GridLevelPanel[i][j].updateUI();
            }
        }
    }

    /**
     * This will display the errorMessage if there is any exceptions
     * @param errorMessage The String error Message
     */
    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}


/**
 * Screen() {
 screenPanel = new JPanel[10][10];
 gridPanel.setLayout(new GridLayout(10, 10));
 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 this.setSize(700,600);

 for (int i = 0; i < 10; i++) {
 for (int j = 0; j < 10; j++) {
 screenPanel[i][j] = new JPanel();
 screenPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
 gridPanel.add(screenPanel[i][j]);
 }
 }
 displayPanel.add(gridPanel);
 newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
 newPanel.add(nextButton);
 newPanel.add(Box.createRigidArea(new Dimension(0,10)));

 newPanel.add(increaseCycle);
 newPanel.add(forwardCycle);
 newPanel.add(Box.createRigidArea(new Dimension(0,10)));

 newPanel.add(cycleLabel);
 newPanel.add(Box.createRigidArea(new Dimension(0,0)));
 newPanel.add(currentCycle);
 displayPanel.add(newPanel);
 this.add(displayPanel);
 this.setVisible(true);
  */


