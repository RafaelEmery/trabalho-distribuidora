/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import modelo.Cliente;
import gui.Detalhes;
import gui.cliente.Listar;
import java.awt.Component;

/**
 *
 * @author joao
 */
public class ClienteBL {
    public static void criar(Component parent) throws Exception{
        Cliente cliente = new Cliente();
        Cliente.create(Detalhes.showInputsDialog(parent, cliente, "Criar Cliente"));
    }
    
    public static void listar(){
        Listar form = new Listar();
        form.setVisible(true);
    }
}
