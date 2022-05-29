import javax.swing.*;

public class Driver extends JFrame {

    Desktop desktop;

    Driver() {
        desktop = new Desktop();
        this.add(desktop);
        this.setTitle("Windows 95");
        this.setResizable(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
    }
}
