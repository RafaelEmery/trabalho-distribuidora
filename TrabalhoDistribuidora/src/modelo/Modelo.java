package modelo;

import java.sql.ResultSet;
import java.util.LinkedList;

public abstract class Modelo {
    private static MySql connection = null;

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

    public static MySql getConnection() {
        return connection;
    }

    public static void setConnection(MySql connection) {
        Modelo.connection = connection;
    }
}
