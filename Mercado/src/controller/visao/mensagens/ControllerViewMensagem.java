package controller.visao.mensagens;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewMensagem.
 * @author  Alison
 * @see     controller.visao.ControllerViewModal
 */
public class ControllerViewMensagem extends ControllerViewModal {
    private final ViewMensagem viewMensagem;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewMensagem(ViewMensagem oView) {
        super(oView);
        this.viewMensagem = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewMensagem.getButtonOk())) {
            this.viewMensagem.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if ((oKeyEvent.getKeyCode() == KeyEvent.VK_F1) || 
            (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER)) {
            this.viewMensagem.dispose();
        }
    }
}