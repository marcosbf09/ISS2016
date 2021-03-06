package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.dao.gerenciais.DaoMarca;
import modelo.estruturais.Operacao;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverMarca;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverMarca.
 * @author  Marcos
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverMarca extends ControllerViewRemover {
    private final ViewRemoverMarca viewRemoverMarca;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverMarca(ViewRemoverMarca oView) {
        super(oView);
        this.viewRemoverMarca = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        super.actionPerformed(oActionEvent);
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
    }

    @Override
    protected void remover() {
        try{
            new DaoMarca().remove(this.viewRemoverMarca.getMarca().getId());
            new DaoOperacao().insert(new Operacao("Marca = " + this.viewRemoverMarca.getMarca().getId(), new DaoAcao().get(24L), this.viewRemoverMarca.getUsuario()));
            new ViewMensagem(this.viewRemoverMarca.getViewConsulta(), "Marca Removida com Sucesso!").setVisible(true);
            this.viewRemoverMarca.getViewConsulta().clear();
            this.viewRemoverMarca.dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não é possível excluir a marca, pois ela está atrelada à produtos cadastrados neste sistema. " +
                    "\n por favor, exclua ou edite os produtos que possuem essa marca ou escolha outra marca.");
            this.viewRemoverMarca.getViewConsulta().clear();
            this.viewRemoverMarca.dispose();
        }
    }
}