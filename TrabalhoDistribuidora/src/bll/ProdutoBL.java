/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import gui.Detalhes;
import gui.produto.Listar;

import java.awt.Component;
import modelo.Cerveja;
import modelo.ItemDeEstoque;

/**
 *
 * @author joao
 */
public class ProdutoBL {
    public static void criarCerveja(Component parent) throws Exception{
        Cerveja cerveja = new Cerveja();
        cerveja = Cerveja.create(Detalhes.showInputsDialog(parent, cerveja, "Criar Cerveja"));
        ItemDeEstoque item = new ItemDeEstoque(0, cerveja);
        ItemDeEstoque.create(item.getValues());
    }
    
    public static void listarCerveja(){
        Listar form = new Listar();
        form.setVisible(true);
    }
}
