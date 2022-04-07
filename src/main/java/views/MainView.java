package views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private JPanel mainPanel;
    private JButton clientList;
    private JButton addressList;
    private JButton phoneLine;

    MainView() {
        setContentPane(mainPanel);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));

        clientList.addActionListener(e -> ClientsList.showScreen());
        addressList.addActionListener(e -> Enderecos.showScreen());
        phoneLine.addActionListener(e -> AssociateClientWithPhone.showScreen());
    }

    public static void showScreen() {
        MainView mainView = new MainView();
        mainView.setLocationRelativeTo(null);
        mainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainView.setVisible(true);
    }

}
