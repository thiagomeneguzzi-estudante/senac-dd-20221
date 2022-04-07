package controller;

import model.bo.LinhaTelefonicaBO;
import model.entity.LinhaTelefonica;

public class LinhaTelefonicaController {
    static LinhaTelefonicaBO linhaTelefonicaBO = new LinhaTelefonicaBO();

    public String criar(LinhaTelefonica linhaTelefonica) {
        LinhaTelefonica createdLine = linhaTelefonicaBO.criar(linhaTelefonica);
        return "Linha telefonica criada com sucesso! ( "+createdLine.getId()+" )";
    }

    public String desativarLinha(int idTelefone) {
        boolean desactivated = linhaTelefonicaBO.desativarLinha(idTelefone);
        return desactivated ? "Linha telefonica desativada!" : "Erro ao desativar linha telefonica";
    }

    public int getClientIdByPhoneId(int phoneId) {
        return linhaTelefonicaBO.getClientIdByPhoneId(phoneId);
    }

}
