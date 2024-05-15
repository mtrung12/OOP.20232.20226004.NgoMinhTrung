package hust.soict.ict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    JLabel authorLabel = new JLabel("Enter the authors:");
    JLabel instruction = new JLabel("Each author is seperated by a \",\"");
    JTextField authorTf = new JTextField();
    JButton addAuthorButton = new JButton("Add Author");
    ArrayList<String> authors = new ArrayList<String>();
    JTextArea authorListAdded = new JTextArea("new authors appear here");
    public AddBookToStoreScreen(){
        super();
        authorLabel.setPreferredSize(new Dimension(250,50));
        authorLabel.setFont(new Font(authorLabel.getFont().getName(), Font.BOLD, 20));
        authorTf.setPreferredSize(new Dimension(400,40));
        addAuthorButton.setPreferredSize(new Dimension(120,30));
        authorListAdded.setPreferredSize(new Dimension(650, 300));
        authorListAdded.setFont(new Font(authorListAdded.getFont().getName(), Font.PLAIN, 15));
        authorListAdded.setWrapStyleWord(true);
        authorListAdded.setEditable(false);
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;c.gridy=3;
        add(authorLabel,c);
        c.gridx=1;c.gridy=3;
        add(authorTf, c);
        c.gridx=0;c.gridy=4;
        add(instruction, c);
        c.gridx=1;c.gridy=4; c.fill=GridBagConstraints.NONE;c.anchor = GridBagConstraints.EAST;
        add(addAuthorButton, c);
        c.gridx=0;c.gridy=5; c.gridwidth=2; c.gridheight=3;  c.fill=GridBagConstraints.BOTH;
        c.insets = new Insets(10, 0, 0, 0);
        add(authorListAdded, c);
        addAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String authorString = authorTf.getText();
                String[] newAuthors = authorString.split(",");
                for (String author: newAuthors){
                    author = author.trim();
                    if(authors.contains(author)){
                        JOptionPane.showMessageDialog(null, "Author "+author+ " already exists");
                    }
                    else{
                        authors.add(author);
                    
                    }
                }
                authorTf.setText("");
                authorListAdded.setText(authorListString());
            }
        });
    }

    public ArrayList<String> getAuthors(){
        return authors;
    }

    public String authorListString(){
        String authors = "Authors:\n";
        int i = 0;
        for (String author: this.authors){
            i++;
            authors += "("+i+")"+author + ", ";
        }
        return authors;
    }
    @Override
    public void refreshTextField(){
        super.refreshTextField();
        authorTf.setText("");
    }
}
