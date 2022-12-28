import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Clock App");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);
        this.setVisible(true);
    }
}
