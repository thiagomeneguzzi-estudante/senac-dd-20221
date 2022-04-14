package views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JButton clientsListButton;
    private JButton addressListButton;
    private JButton manageLinesButton;
    private JPanel clientsPanel;
    private JPanel addressPanel;
    private JPanel linePanel;

    MainView() {
        setContentPane(mainPanel);
        setSize(700, 400);
        setMinimumSize(new Dimension(700, 250));
        clientsPanel.add(new ClientsList());
        addressPanel.add(new AddressList());
        linePanel.add(new AssociateClientWithPhone());

        clientsListButton.addActionListener(e -> {
            contentPanel.remove(addressPanel);
            contentPanel.remove(linePanel);
            contentPanel.add(clientsPanel);
            validate();
        });
        addressListButton.addActionListener(e -> {
            contentPanel.remove(clientsPanel);
            contentPanel.remove(linePanel);
            contentPanel.add(addressPanel);
            validate();
        });
        manageLinesButton.addActionListener(e -> {
            contentPanel.remove(clientsPanel);
            contentPanel.remove(addressPanel);
            contentPanel.add(linePanel);
            validate();
        });
    }

    public static void showScreen() {
        MainView mainView = new MainView();
        mainView.setLocationRelativeTo(null);
        mainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainView.setVisible(true);
    }
}
