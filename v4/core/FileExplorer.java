package core;

import java.awt.*;
import javax.swing.*;

public class FileExplorer extends JFrame implements ActionListener {
    // implement sidebar
    public FileExplorer(){
        this.setTitle("File Explorer");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
}
