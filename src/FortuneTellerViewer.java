import javax.swing.*;
import java.awt.*;

public class FortuneTellerViewer {
    public static void main(String[] args)
    {
        FortuneTellerFrame frame = new FortuneTellerFrame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        //setting program's size and location when popping up
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/2, height/2);
        frame.setLocation(width/4,height/4);

        frame.setTitle("Fortune Teller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}