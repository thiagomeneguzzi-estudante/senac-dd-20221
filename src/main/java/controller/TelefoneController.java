package controller;

import model.bo.TelefoneBO;
import model.entity.Telefone;

import java.util.ArrayList;

public class TelefoneController {

    public ArrayList<Telefone> buscarTodos() {
        TelefoneBO telefoneBO = new TelefoneBO();
        return telefoneBO.buscarTodos();
    }
}
