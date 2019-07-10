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

/**
 *
 * @author joao
 */
public class ProdutoBL {
    public static void criarCerveja(Component parent) throws Exception{
        Cerveja cerveja = new Cerveja();
        Cerveja.create(Detalhes.showInputsDialog(parent, cerveja, "Criar Cerveja"));
    }
    
    public static void listarCerveja(){
        Listar form = new Listar();
        form.setVisible(true);
    }
}
