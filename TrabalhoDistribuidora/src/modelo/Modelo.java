package modelo;

import java.sql.ResultSet;
import java.util.LinkedList;

public abstract class Modelo {
	
    public abstract String[] getFillable();
    public abstract String[] getLabels();
    public abstract String[] getValues();

    public static LinkedList<String> createLinkedList(String[] valores) throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        for(String valor: valores) {
                list.add(valor);
        }
        return list;
    }
}
