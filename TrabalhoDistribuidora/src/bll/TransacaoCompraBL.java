package bll;
import java.awt.Component;

import gui.transacaoCompra.*;

/**
 *
 * @author joao
 */
public class TransacaoCompraBL {
	public static void criarTransacao(Component parent) throws Exception{
		Criar form = new Criar();
        form.setVisible(true);
    }
}