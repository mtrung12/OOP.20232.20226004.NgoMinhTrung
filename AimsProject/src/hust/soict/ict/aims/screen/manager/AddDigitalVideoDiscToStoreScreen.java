package hust.soict.ict.aims.screen.manager;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
    JLabel directorLabel = new JLabel("Enter the director:");
    JLabel lengthLabel = new JLabel("Enter the length:");
    JTextField directorTf = new JTextField();
    JTextField lengthTf = new JTextField();

    public AddDigitalVideoDiscToStoreScreen(){
        super();
        directorLabel.setPreferredSize(new Dimension(250,50));
        directorLabel.setFont(new Font(directorLabel.getFont().getName(), Font.BOLD, 20));
        directorTf.setPreferredSize(new Dimension(400,40));

        lengthLabel.setPreferredSize(new Dimension(250,50));
        lengthLabel.setFont(new Font(lengthLabel.getFont().getName(), Font.BOLD, 20));
        lengthTf.setPreferredSize(new Dimension(400,40));

        

        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;c.gridy=3;
        add(directorLabel,c);
        c.gridx=1;c.gridy=3;
        add(directorTf,c);
        c.gridx=0;c.gridy=4;
        add(lengthLabel, c);
        c.gridx=1; c.gridy=4;
        add(lengthTf,c);
        
    }

    public String getDirector() {
        return directorTf.getText();
    }

    public int getLength() {
        return Integer.parseInt(lengthTf.getText());
    }

    @Override
    public void refreshTextField(){
        super.refreshTextField();
        directorTf.setText("");
        lengthTf.setText("");
    }
}
