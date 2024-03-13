import javax.swing.JOptionPane;

public class assignment225 {
    public static void main(String[] args) {
        try {
            String a1 = JOptionPane.showInputDialog(null, "Enter a: ");
            double a = Double.parseDouble(a1);
            String b1 = JOptionPane.showInputDialog(null, "Enter b: ");
            double b = Double.parseDouble(b1);
            
            JOptionPane.showMessageDialog(null,
                "Sum: " + (a + b) + "\n" +
                "Difference: " + Math.abs(a - b) + "\n" +
                "Product: " + (a * b) + "\n" +
                "Quotient: " + (a / b)
            );
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT","Syntax Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
