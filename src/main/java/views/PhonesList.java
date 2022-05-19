package views;

import controller.TelefoneController;
import model.entity.Telefone;
import selector.PhoneSelector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PhonesList extends JPanel {
    private JPanel panel1;
    private JButton adicionarTelefoneButton;
    private JButton atualizarTabelaButton;
    private JTable phonesTable;
    private JButton deletarTelefoneButton;
    private JButton editarTelefoneButton;
    private JTextField ddiFilter;
    private JTextField stateFilter;
    private JTextField dddFilter;
    private JButton filtrarButton;

    private TelefoneController telefoneController = new TelefoneController();
    private ArrayList<Telefone> telefones;

    PhonesList() {
        add(panel1);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));
        phonesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        editarTelefoneButton.setEnabled(false);
        deletarTelefoneButton.setEnabled(false);

        criarLista(null);

        phonesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(phonesTable.getSelectedRow() != 0) {
                    editarTelefoneButton.setEnabled(true);
                    deletarTelefoneButton.setEnabled(true);
                } else {
                    editarTelefoneButton.setEnabled(false);
                    deletarTelefoneButton.setEnabled(false);
                }

            }
        });

        adicionarTelefoneButton.addActionListener(e -> addNewPhone());
        deletarTelefoneButton.addActionListener(e -> deletePhone());
        editarTelefoneButton.addActionListener(e -> editPhone());
        atualizarTabelaButton.addActionListener(e -> criarLista(null));

        filtrarButton.addActionListener(e -> {
            PhoneSelector phoneSelector = new PhoneSelector();
            phoneSelector.setDdi(ddiFilter.getText());
            phoneSelector.setDdd(dddFilter.getText());
            phoneSelector.setEstado(stateFilter.getText());

            criarLista(phoneSelector);
        });

    }

    private void editPhone() {
        JOptionPane.showMessageDialog(null, "Método ainda não implementado", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deletePhone() {
        JOptionPane.showMessageDialog(null, "Método ainda não implementado", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addNewPhone() {
        JOptionPane.showMessageDialog(null, "Método ainda não implementado", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void criarLista(PhoneSelector phoneSelector) {
        if(phoneSelector != null) {
            telefones = telefoneController.buscarTodosComFiltro(phoneSelector);
        } else {
            telefones = telefoneController.buscarTodos();
        }

        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "DDI", "DDD", "Número", "Estado"}, 0);
        phonesTable.setModel(tableModel);

        for (Telefone telefone: telefones) {
            String active = "Desativado";
            if(telefone.isAtivo()) {
                active = "Ativado";
            }
            tableModel.addRow(new Object[]{(telefone.getId()), (telefone.getDdi()), (telefone.getDdd()), (telefone.getNumero()), (active)});
        }
    }

}
