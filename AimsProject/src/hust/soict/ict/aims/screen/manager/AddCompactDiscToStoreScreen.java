package hust.soict.ict.aims.screen.manager;

import javax.swing.*;

import hust.soict.ict.aims.media.Track;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
    JLabel artistLabel = new JLabel("Enter the artist:");
    JTextField artistTf = new JTextField();
    JLabel track = new JLabel("________________ Add new tracks to current CD ________________");
    JButton addTrackButton = new JButton("Add Track");
    JLabel trackTitleLabel = new JLabel("Enter track title:");
    JTextField trackTitleTf = new JTextField();
    JLabel trackLengthLabel = new JLabel("Enter track length:");
    JTextField trackLengthTf = new JTextField();
    JTextArea trackListAdded = new JTextArea("new tracks appear here");
    ArrayList <Track> trackList = new ArrayList<Track>();
    public AddCompactDiscToStoreScreen(){
        super();
        artistLabel.setPreferredSize(new Dimension(250,50));
        artistLabel.setFont(new Font(artistLabel.getFont().getName(), Font.BOLD, 20));
        artistTf.setPreferredSize(new Dimension(400,40));
        artistTf.setFont(new Font(artistTf.getFont().getName(), Font.PLAIN, 15));
        trackTitleTf.setPreferredSize(new Dimension(400,40));
        trackTitleTf.setFont(new Font(trackTitleTf.getFont().getName(), Font.PLAIN, 15));
        trackTitleLabel.setFont(new Font(trackTitleLabel.getFont().getName(), Font.BOLD, 20));
        trackLengthLabel.setFont(new Font(trackLengthLabel.getFont().getName(), Font.BOLD, 20));
        trackLengthTf.setPreferredSize(new Dimension(400,40));
        trackLengthTf.setFont(new Font(trackLengthTf.getFont().getName(), Font.PLAIN, 15));
        addTrackButton.setPreferredSize(new Dimension(120,30));
        track.setFont(new Font(track.getFont().getName(), Font.BOLD, 15));
        GridBagConstraints c = new GridBagConstraints();
        trackListAdded.setPreferredSize(new Dimension(650, 300));
        trackListAdded.setFont(new Font(trackListAdded.getFont().getName(), Font.PLAIN, 15));
        trackListAdded.setWrapStyleWord(true);
        trackListAdded.setEditable(false);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;c.gridy=3;
        add(artistLabel,c);
        c.gridx=1;c.gridy=3;
        add(artistTf, c);
        c.gridx=0;c.gridy=5;
        add(trackTitleLabel, c);
        c.gridx=1;c.gridy=5;
        add(trackTitleTf, c);
        c.gridx=0;c.gridy=6;
        add(trackLengthLabel, c);
        c.gridx=1;c.gridy=6;
        add(trackLengthTf, c);
        c.gridx=1;c.gridy=7;
        c.fill=GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.EAST;
        add(addTrackButton, c);
        c.gridx=0;c.gridy=4; c.gridwidth=2; c.anchor = GridBagConstraints.CENTER; 
        c.insets = new Insets(20, 0, 10, 0);
        add(track, c);
        c.gridx=0;c.gridy=8; c.gridwidth=2; c.gridheight=3;  c.fill=GridBagConstraints.BOTH;
        c.insets = new Insets(10, 0, 0, 0);
        add(trackListAdded, c);

        addTrackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = trackTitleTf.getText();
                int length = Integer.parseInt(trackLengthTf.getText());
                Track newTrack = new Track(title, length);
                if(trackList.contains(newTrack)){
                    JOptionPane.showMessageDialog(null, "This track is already in the list", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    trackList.add(newTrack);
                }
                trackTitleTf.setText("");
                trackLengthTf.setText("");
                trackListAdded.setText(trackListString());
            }
        });
    }

    @Override
    public void refreshTextField(){
        super.refreshTextField();
        artistTf.setText("");
    }

    public ArrayList<Track> getTrackList() {
        return trackList;
    }

    public String trackListString(){
        String trackListString = new String("List of tracks: \n");
        for(Track track: trackList){
            trackListString = trackListString + track.getTitle()+"<"+track.getLength()+ "s>" + ", ";
        }
        return trackListString;
    }

    
    
}
