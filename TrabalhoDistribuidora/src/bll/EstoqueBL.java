/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import gui.estoque.*;
import java.awt.Component;

/**
 *
 * @author joao
 */
public class EstoqueBL {
    public static void listar(Component parent){
        Listar listar = new Listar();
        listar.setVisible(true);
    }
}
