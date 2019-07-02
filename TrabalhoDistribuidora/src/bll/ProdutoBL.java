/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import gui.Detalhes;
import java.awt.Component;
import modelo.Cerveja;

/**
 *
 * @author joao
 */
public class ProdutoBL {
    public static void criarCerveja(Component parent){
        Cerveja cerveja = new Cerveja();
        Detalhes.showInputsDialog(parent, cerveja, "Criar Cerveja");
    }
    
    public static void listarCerveja(){
        
    }
}
