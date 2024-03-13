import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main(String[] args) {
        String[] choice = {"I do", "I don't"};
        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Choose Option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "I do" : "I don't"));
        System.exit(0);
    }
}
