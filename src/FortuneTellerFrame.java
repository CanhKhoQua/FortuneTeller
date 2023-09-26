import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;
    JLabel iconLbl;
    ImageIcon FTIcon;

    JScrollPane scroller;
    JTextArea fortuneTA;
    JButton quitBtn;
    JButton fortuneBtn;
    ArrayList<String> fortunes = new ArrayList<>();

    public FortuneTellerFrame() {
        //Making an icon
        FTIcon = new ImageIcon("src/Clover.png");
        setIconImage(FTIcon.getImage());

        //Adding fortunes
        fortunes.add("A pleasant surprise is waiting for you soon.");
        fortunes.add("Your hard work will pay off in unexpected ways.");
        fortunes.add("Listen to your intuition - it will lead you well.");
        fortunes.add("Now is the time to try something new and exciting.");
        fortunes.add("A chance encounter will open new doors for you.");
        fortunes.add("Look for opportunities to help others - generosity leads to happiness.");
        fortunes.add("True friends are worth more than all the gold in the world.");
        fortunes.add("The solution to your problem will come to you in a dream.");
        fortunes.add("Your leadership skills will soon be recognized.");
        fortunes.add("Love is just around the corner - open your heart and it will find you.");
        fortunes.add("Music will bring great joy and healing to your life this week.");
        fortunes.add("A windfall of money comes your way - use it wisely.");

        //Setting Layout
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        createDisplayPanel();
        createControlPanel();

        mainPnl.add(iconPnl, BorderLayout.NORTH);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
        mainPnl.add(controlPnl, BorderLayout.SOUTH);
        add(mainPnl);
        pack();
    }

    private void createControlPanel() {
        controlPnl = new JPanel();

        //Making a fortune button perform functionally
        fortuneBtn = new JButton("Read My Fortune!");
        fortuneBtn.addActionListener(e -> {
            int lastIndex = -1;
            int index;
            Random rand = new Random();
            
            index = rand.nextInt(fortunes.size());
            lastIndex = index;

            do {
                index = rand.nextInt(fortunes.size());
            } while (index == lastIndex);

            fortuneTA.append(fortunes.get(index) + "\n");
        });

        //Making a quit button perform functionally
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(e -> System.exit(0));

        //Setting Grid Layout
        controlPnl.setLayout(new GridLayout(1, 2));

        //Adding buttons
        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

    }

    private void createDisplayPanel() {
        displayPnl = new JPanel();
        //create text area
        fortuneTA = new JTextArea(10, 40);
        fortuneTA.setFont(new Font("Arial", Font.PLAIN, 20));
        //only readable
        fortuneTA.setEditable(false);

        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
    }

    private void createIconPanel() {
        //Create iconPanel
        FTIcon = new ImageIcon("src/Clover.png");
        iconPnl = new JPanel();

        Image img = FTIcon.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
        FTIcon = new ImageIcon(img);

        iconLbl = new JLabel("Fortune Teller", FTIcon, SwingConstants.CENTER);
        iconLbl.setFont(new Font("Serif", Font.PLAIN, 48));
        iconPnl.add(iconLbl);
    }
}

