/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.awt.Component;

import gui.Detalhes;
import gui.transacaoVenda.Listar;
import modelo.TransacaoVenda;

/**
 *
 * @author joao
 */
public class TransacaoVendaBL {
	public static void criarTransacao(Component parent) throws Exception{
        TransacaoVenda transacao = new TransacaoVenda();
        Listar form = new Listar();
        form.setVisible(true);
    }
}
