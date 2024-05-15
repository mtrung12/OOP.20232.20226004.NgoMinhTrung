package hust.soict.ict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
    JLabel artistLabel = new JLabel("Enter the artist:");
    JTextField artistTf = new JTextField();
    public AddCompactDiscToStoreScreen(){
        super();
        artistLabel.setPreferredSize(new Dimension(250,50));
        artistLabel.setFont(new Font(artistLabel.getFont().getName(), Font.PLAIN, 20));
        artistTf.setPreferredSize(new Dimension(400,40));

        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;c.gridy=3;
        add(artistLabel,c);
        c.gridx=1;c.gridy=3;
        add(artistTf, c);
    }
}
