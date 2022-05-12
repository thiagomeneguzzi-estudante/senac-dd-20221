package views;

import model.entity.Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainView extends JFrame {

    private JPanel mainPanel;

    MainView() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 450, 300);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu clientMenu = new JMenu("Clientes");
        JMenu addressMenu = new JMenu("Endereços");
        menuBar.add(clientMenu);
        menuBar.add(addressMenu);

        JMenuItem clientListMenuItem = new JMenuItem("Lista de clientes");
        JMenuItem addClientMenuItem = new JMenuItem("Adicionar cliente");
        clientMenu.add(clientListMenuItem);
        clientMenu.add(addClientMenuItem);

        JMenuItem addressListMenuItem = new JMenuItem("Lista de endereços");
        JMenuItem addAddressMenuItem = new JMenuItem("Criar endereço");
        addressMenu.add(addressListMenuItem);
        addressMenu.add(addAddressMenuItem);

        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(mainPanel);

        clientListMenuItem.addActionListener(e -> getClientsListPanel());
        addClientMenuItem.addActionListener(e -> createManageClientPanel(null));

        addressListMenuItem.addActionListener(e -> getAddressListPanel());
    }

    private void getClientsListPanel() {
        ClientsList clientsList = new ClientsList();

        clientsList.getEditClientButton().addActionListener(e -> {
            Cliente cliente = clientsList.getSelectedClient();
            createManageClientPanel(cliente);
        });

        clientsList.getAddClientButton().addActionListener(e -> {
            createManageClientPanel(null);
        });

        setContentPane(clientsList);
        revalidate();
    }

    private void createManageClientPanel(Cliente cliente) {
        ManageClients manageClients = new ManageClients(cliente);
        setContentPane(manageClients);
        revalidate();
    }

    private void getAddressListPanel() {
        AddressList addressList = new AddressList();
        setContentPane(addressList);
        revalidate();
    }

    public static void showScreen() {
        MainView mainView = new MainView();
        mainView.setLocationRelativeTo(null);
        mainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainView.setVisible(true);
    }
}
