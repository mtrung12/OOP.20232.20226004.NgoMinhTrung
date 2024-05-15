package hust.soict.ict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    JLabel authorLabel = new JLabel("Enter the authors:");
    JLabel instruction = new JLabel("Each author is seperated by a \",\"");
    JTextField authorTf = new JTextField();

    public AddBookToStoreScreen(){
        super();
        authorLabel.setPreferredSize(new Dimension(250,50));
        authorLabel.setFont(new Font(authorLabel.getFont().getName(), Font.PLAIN, 20));
        authorTf.setPreferredSize(new Dimension(400,40));

        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;c.gridy=3;
        add(authorLabel,c);
        c.gridx=1;c.gridy=3;
        add(authorTf, c);
        c.gridx=0;c.gridy=4;
        add(instruction, c);
    }

    public String getAuthorList(){
        String authors = new String();
        authors = this.authorTf.getText();
        return authors;
    }
}
