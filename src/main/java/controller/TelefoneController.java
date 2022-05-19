package controller;

import model.bo.TelefoneBO;
import model.entity.Telefone;
import selector.PhoneSelector;

import java.util.ArrayList;

public class TelefoneController {

    public ArrayList<Telefone> buscarTodos() {
        TelefoneBO telefoneBO = new TelefoneBO();
        return telefoneBO.buscarTodos();
    }

    public ArrayList<Telefone> buscarTodosComFiltro(PhoneSelector phoneSelector) {
        TelefoneBO telefoneBO = new TelefoneBO();
        return telefoneBO.buscarTodosComFiltro(phoneSelector);
    }
}
