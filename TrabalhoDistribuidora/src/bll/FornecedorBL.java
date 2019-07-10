package bll;


import modelo.Fornecedor;
import gui.Detalhes;
import gui.cliente.Listar;
import java.awt.Component;

/**
 *
 * @author joao
 */
public class FornecedorBL {
    public static void criar(Component parent) throws Exception{
        Fornecedor fornecedor = new Fornecedor();
        Fornecedor.create(Detalhes.showInputsDialog(parent, fornecedor, "Criar Fornecedor"));
    }
    
    public static void listar(){
        Listar form = new Listar();
        form.setVisible(true);
    }
}

