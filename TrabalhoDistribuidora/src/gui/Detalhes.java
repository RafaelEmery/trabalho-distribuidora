/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import modelo.Modelo;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author joao
 */
public abstract class Detalhes {
    /**
     * Mostra e recebe dados de um 
     * 
     * @param parent Pai da caixa de dialogo
     * @param object Objeto a ser inserido diálogo
     * @param mensagem Mensagem de Título
     * @return 
     */
    public static String[] showInputsDialog(Component parent, Object object, String mensagem){
        ArrayList<JComponent> componentes = new ArrayList<>();
        for(String campo: ((Modelo)object).getLabels()){
            componentes.add(new JLabel(campo));
            componentes.add(new JTextField());
        }
        
        for (int i = 1; i < componentes.size(); i += 2) {
            int j = (i-1)/2;
            ((JTextField)componentes.get(i)).setText(((Modelo)object).getValues()[j]);
        }
        
        JOptionPane.showConfirmDialog(parent, componentes.toArray(), mensagem, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        ArrayList<String> valores = new ArrayList<>();
        for (int i = 1; i < componentes.size(); i += 2) {
            valores.add(((JTextField)componentes.get(i)).getText());
        }
        
        return valores.toArray(new String[0]);
    }
}
