package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JPanel mainPanel;
    private JButton clientsListButton;
    private JButton addressListButton;
    private JButton manageLinesButton;
    private JButton gerenciarTelefonesButton;

    MainView() {
        setContentPane(mainPanel);
        setSize(700, 400);
        setMinimumSize(new Dimension(700, 250));
        clientsListButton.addActionListener(e -> ClientsList.showScreen());
        addressListButton.addActionListener(e -> AddressList.showScreen());
        manageLinesButton.addActionListener(e -> AssociateClientWithPhone.showScreen());
        gerenciarTelefonesButton.addActionListener(e -> PhonesList.showScreen());
    }

    public static void showScreen() {
        MainView mainView = new MainView();
        mainView.setLocationRelativeTo(null);
        mainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainView.setVisible(true);
    }
}
