/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.awt.Component;

import gui.transacaoVenda.Listar;

/**
 *
 * @author joao
 */
public class TransacaoVendaBL {
	public static void criarTransacao(Component parent) throws Exception{
        Listar form = new Listar();
        form.setVisible(true);
    }
}
