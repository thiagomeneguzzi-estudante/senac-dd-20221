package model.bo;

import model.dao.LinhaTelefonicaDAO;
import model.entity.LinhaTelefonica;

public class LinhaTelefonicaBO {
    static LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();

    public LinhaTelefonica criar(LinhaTelefonica linhaTelefonica) {
        return linhaTelefonicaDAO.criar(linhaTelefonica);
    }

    public boolean desativarLinha(int idTelefone) {
        return linhaTelefonicaDAO.desativarLinhaTelefonica(idTelefone);
    }

    public int getClientIdByPhoneId(int phoneId) {
        return linhaTelefonicaDAO.getClientIdByPhoneId(phoneId);
    }
}
