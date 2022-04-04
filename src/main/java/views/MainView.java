package views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private JTabbedPane mainTabs;
    private JPanel mainPanel;

    MainView() {
        setContentPane(mainPanel);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));

    }

    public static void showScreen() {
        MainView mainView = new MainView();
        mainView.setLocationRelativeTo(null);
        mainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainView.setVisible(true);
    }

}
