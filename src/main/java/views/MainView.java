package views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel mainPanel;
    private JButton clientsListButton;
    private JButton addressListButton;
    private JButton manageLinesButton;

    MainView() {
        setContentPane(mainPanel);
        setSize(700, 400);
        setMinimumSize(new Dimension(700, 250));
        clientsListButton.addActionListener(e -> ClientsList.showScreen());
        addressListButton.addActionListener(e -> AddressList.showScreen());
        manageLinesButton.addActionListener(e -> AssociateClientWithPhone.showScreen());
    }

    public static void showScreen() {
        MainView mainView = new MainView();
        mainView.setLocationRelativeTo(null);
        mainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainView.setVisible(true);
    }
}
