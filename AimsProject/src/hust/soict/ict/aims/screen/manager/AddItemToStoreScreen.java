package hust.soict.ict.aims.screen.manager;



import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JPanel {
    private JLabel titleLabel = new JLabel("Enter the title:");
    private JTextField titleTf = new JTextField();

    private JLabel categoryLabel = new JLabel("Enter the category:");
    private JTextField categoryTf = new JTextField();

    private JLabel costLabel = new JLabel("Enter the cost:");
    private JTextField costTf = new JTextField();


    public AddItemToStoreScreen(){
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        // this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        titleLabel.setPreferredSize(new Dimension(250,50));
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 20));

        categoryLabel.setPreferredSize(new Dimension(250,50));
        categoryLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 20));

        costLabel.setPreferredSize(new Dimension(250,50));
        costLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 20));

        titleTf.setPreferredSize(new Dimension(400,40));
        categoryTf.setPreferredSize(new Dimension(400,40));
        costTf.setPreferredSize(new Dimension(400,40));
        c.gridx = 0; c.gridy=0; 
        this.add(titleLabel, c);
        c.gridx = 1; c.gridy = 0;
        this.add(titleTf, c);

        c.gridx = 0; c.gridy = 1;
        this.add(categoryLabel, c);
        c.gridx = 1; c.gridy = 1;
        this.add(categoryTf, c);

        c.gridx = 0; c.gridy = 2;
        this.add(costLabel, c);
        c.gridx=1; c.gridy = 2; 
        this.add(costTf, c);

    }

    public String getTitle(){
        return titleTf.getText();
    }

    public String getCategory() {
        return categoryTf.getText();
    }

    public float getCost() {
        return Float.parseFloat(costTf.getText());
    }
    
    public void refreshTextField(){
        titleTf.setText("");
        categoryTf.setText("");
        costTf.setText("");
    }
    

}
