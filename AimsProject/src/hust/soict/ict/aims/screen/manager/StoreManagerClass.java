package hust.soict.ict.aims.screen.manager;

import hust.soict.ict.aims.media.*;
import hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerClass extends JFrame implements ActionListener{
    private Store store;


    public static void main(String[] args) {
        Store newStore = new Store();
        storeInit(newStore);
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        new StoreManagerClass(newStore);
    }

    public StoreManagerClass(Store store){
        this.store = store;
        viewStore();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void viewStore(){
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void storeInit(Store store){
        //DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Guy Ritchie", 89, 18.99f);
        store.addMedia(dvd1); store.addMedia(dvd2); store.addMedia(dvd3);

        //CD + Track
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 9.99f);
        Track track1 = new Track("Billie Jean", 236);
        Track track2 = new Track("Beat It", 252);
        Track track3 = new Track("Man in the Mirror", 331);
        cd1.addTrack(track1); cd1.addTrack(track2); cd1.addTrack(track3);

        CompactDisc cd2 = new CompactDisc("Kind of Blue", "Jazz", "Miles Davis", 15.50f);
        Track track4 = new Track("So What", 431);
        Track track5 = new Track("Freddie Freeloader", 539);
        cd2.addTrack(track4); cd2.addTrack(track5);

        CompactDisc cd3 = new CompactDisc("Bohemian Rhapsody", "Rock", "Queen", 11.99f);
        Track track6 = new Track("Bohemian Rhapsody", 355);
        Track track7 =  new Track("Killer Queen", 205);
        Track track8 = new Track("Somebody to Love", 296);
        cd3.addTrack(track6); cd3.addTrack(track7); cd3.addTrack(track8);

        store.addMedia(cd1); store.addMedia(cd2); store.addMedia(cd3);

        //book
        Book book1 = new Book("Hannibal", "Crime Thriller", 8.99f);
        book1.addAuthor("Thomas Harris");
        Book book2 = new Book("Red Dragon", "Crime Thriller", 9.11f);
        book2.addAuthor("Thomas Harris");
        Book book3 = new Book("The Martian", "Science Fiction", 8.97f);
        book3.addAuthor("Andy Weir");
        Book book4 = new Book("The Lord of the Rings", "Fantasy", 9.25f);
        book4.addAuthor("J.R.R. Tolkien");
        store.addMedia(book1); store.addMedia(book2); store.addMedia(book3); store.addMedia(book4);
        
    }
    

    private JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem smViewStore = new JMenuItem("View Store");
        menu.add(smViewStore);
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        smViewStore.addActionListener(this);
        addBook.addActionListener(this);
        addCD.addActionListener(this);
        addDVD.addActionListener(this);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel(("AIMS"));
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    private JPanel createCenter(){
        JPanel center = new JPanel();
        JPanel sub_center = new JPanel();
        sub_center.setLayout((new GridLayout(0,3,3,3)));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(Media media: mediaInStore){
            MediaStore cell = new MediaStore(media);
            sub_center.add(cell);
        }
        JScrollPane scroll = new JScrollPane(sub_center, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(1010,650));
        center.add(scroll);
        return center;
    }

    public class MediaStore extends  JPanel implements ActionListener{
        private Media media;
        public MediaStore(Media media){
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
            title.setAlignmentX((CENTER_ALIGNMENT));

            JLabel cost = new JLabel(media.getCost()+"$");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));
            
            if(media instanceof Playable){
                JButton playButton = new JButton("Play");
                playButton.setPreferredSize(new Dimension(80,40));
                playButton.setFont(new Font(playButton.getFont().getName(), Font.PLAIN, 15));
                container.add(playButton);
                playButton.addActionListener(this);
            }

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder((Color.BLACK)));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source instanceof JButton){
                JButton pressed = (JButton) source;
                String text = pressed.getText();
                if(text.equals("Play")){
                    String playMessage = media.toStringPlay();
                    JOptionPane.showMessageDialog(null, playMessage, "Playing", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        AddBookToStoreScreen addBookPanel = new AddBookToStoreScreen();
        AddDigitalVideoDiscToStoreScreen addDVDPanel = new AddDigitalVideoDiscToStoreScreen();
        AddCompactDiscToStoreScreen addCDPanel = new AddCompactDiscToStoreScreen();

        if(source instanceof JMenuItem){
            JMenuItem choice  = (JMenuItem) source;
            String text = choice.getText();
            switch(text){
                case "View Store":
                getContentPane().removeAll();
                viewStore();
                revalidate();
                repaint();
                setVisible(true);
                break;


                case "Add Book":
                JButton addBookButton = new JButton("Add Book");
                addBookButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String title = addBookPanel.getTitle();
                        String category = addBookPanel.getCategory();
                        float cost = addBookPanel.getCost();
                        Book book = new Book(title, category, cost);
                        ArrayList<String> authors = addBookPanel.getAuthors();
                        authors.forEach(author -> book.addAuthor(author));
                        store.addMedia(book);
                        getContentPane().removeAll();
                        viewStore();
                        revalidate();
                        repaint();
                    }
                });
                addBookButton.setFont(new Font(addBookButton.getFont().getName(), Font.PLAIN, 15));
                
                getContentPane().removeAll();
                add(createNorth(), BorderLayout.NORTH);
                add(addBookPanel, BorderLayout.CENTER);
                add(addBookButton, BorderLayout.SOUTH);
                revalidate();
                repaint();
                setVisible(true);
                break;


                case "Add DVD":
                JButton addDVDButton = new JButton("Add DVD");
                addDVDButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String title = addDVDPanel.getTitle();
                        String category = addDVDPanel.getCategory();
                        float cost = addDVDPanel.getCost();
                        String director = addDVDPanel.getDirector();
                        int length = addDVDPanel.getLength();
                        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                        store.addMedia(dvd);
                        getContentPane().removeAll();
                        viewStore();
                        revalidate();
                        repaint();
                    }
                
                });
                addDVDButton.setFont(new Font(addDVDButton.getFont().getName(), Font.PLAIN, 15));

                getContentPane().removeAll();
                add(createNorth(), BorderLayout.NORTH);
                add(addDVDPanel, BorderLayout.CENTER);
                add(addDVDButton, BorderLayout.SOUTH);
                revalidate();
                repaint();
                setVisible(true);
                break;


                case "Add CD":
                
                JButton addCDButton = new JButton("Add CD");
                addCDButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String title = addCDPanel.getTitle();
                        String category = addCDPanel.getCategory();
                        float cost = addCDPanel.getCost();
                        CompactDisc cd = new CompactDisc(title, category, text, cost);
                        store.addMedia(cd);
                        addCDPanel.getTrackList().forEach(track -> cd.addTrack(track));
                        getContentPane().removeAll();
                        viewStore();
                        revalidate();
                        repaint();
                }});
                addCDButton.setFont(new Font(addCDButton.getFont().getName(), Font.PLAIN, 15));
                getContentPane().removeAll();
                add(createNorth(), BorderLayout.NORTH);
                add(addCDPanel, BorderLayout.CENTER);
                add(addCDButton, BorderLayout.SOUTH);
                revalidate();
                repaint();
                setVisible(true);
                break;
            }
        }
    }
}


