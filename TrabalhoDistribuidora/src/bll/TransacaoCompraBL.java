package bll;
import java.awt.Component;

import gui.Detalhes;
import gui.transacaoCompra.Listar;
import modelo.TransacaoCompra;

/**
 *
 * @author joao
 */
public class TransacaoCompraBL {
	public static void criarTransacao(Component parent) throws Exception{
		TransacaoCompra transacao = new TransacaoCompra();
        Listar form = new Listar();
        form.setVisible(true);
    }
}