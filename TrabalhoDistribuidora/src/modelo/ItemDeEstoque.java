package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ItemDeEstoque extends Modelo {
    private static String tableName = "estoque";
    private static String[] fillable = { "quant", "idProduto" };
    private static String[] labels = { "Quantidade", "Núm. Produto" };
    
    private int id;
    private int quantidade;
    private Produto produto;

    public static String getTableName() {
        return ItemDeEstoque.tableName;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public ItemDeEstoque(){
        Cerveja produto = new Cerveja();
        this.setProduto(produto);
    }
    
    public ItemDeEstoque(int quantidade, Produto produto){
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }

    @Override
    public String[] getValues(){
        String[] retorno = { this.getQuantidade()+"", ((Cerveja)this.getProduto()).getId()+""};
        return retorno;
    }
    
    @Override 
    public String[] getLabels(){
        return ItemDeEstoque.labels;
    }
    
    @Override
    public String[] getFillable(){
        return ItemDeEstoque.fillable;
    }
    
    /**
     * Pega todos os registros da tabela da classe e retorna eles em uma linked list de objetos pessoa
     * @return LinkedList<ItemDeEstoque>
     * @author Cassio Fernandes
     * @throws Exception - Caso nao seja possivel criar um objeto Cerveja a partir dos dados do banco de dados
     */
    public static LinkedList<ItemDeEstoque> all() throws Exception{
        LinkedList<ItemDeEstoque> lista = new LinkedList<ItemDeEstoque>();
        ResultSet rs = ItemDeEstoque.getConnection().select(ItemDeEstoque.getTableName()).get();
        while(rs.next()) {
                lista.add(ItemDeEstoque.createFromDatabase(rs));
        }
        return lista;
    }

    /**
     * Procura por um elemento especifico no banco de dados e o retorna como objeto Cliente
     * @throws Exception - Caso nao seja possivel criar um objeto Cerveja a partir dos dados do banco de dados
     * @author Cassio Fernandes
     */
    public static ItemDeEstoque find(int id) throws Exception {
            ResultSet rs = ItemDeEstoque.getConnection().select(ItemDeEstoque.getTableName()).where("id", "=", id + "").get();
            rs.next();
            return ItemDeEstoque.createFromDatabase(rs);
    }
    
    /**
     * Pega os dados necessarios de um ResultSet e cria um objeto Cliente a partir destes dados
     * @param rs
     * @return ItemDeEstoque
     * @throws Exception
     */
    public static ItemDeEstoque createFromDatabase(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        int quantidade = rs.getInt("quant");
        int idProduto = rs.getInt("idProduto");
        Cerveja cerveja = Cerveja.find(idProduto);
        ItemDeEstoque newItem = new ItemDeEstoque(quantidade, cerveja);
        newItem.id = id;
        return newItem;
    }
    
    public static ItemDeEstoque create(String[] valores) throws Exception {
    	ResultSet rs = ItemDeEstoque.getConnection().create(ItemDeEstoque.getTableName(), ItemDeEstoque.fillable, ItemDeEstoque.createLinkedList(valores));
        rs.next();
    	return ItemDeEstoque.createFromDatabase(rs);
    }

    public ItemDeEstoque update(String[] valores) throws SQLException, Exception {
    	ResultSet rs = ItemDeEstoque.getConnection().update(ItemDeEstoque.getTableName(), ItemDeEstoque.fillable, ItemDeEstoque.createLinkedList(valores), this.id);
        rs.next();
    	return ItemDeEstoque.createFromDatabase(rs);
    }
    
    public void incrementaEstoque(int quantidade) throws Exception{
        int qtd = this.getQuantidade() + quantidade;
        this.setQuantidade(qtd);
        
        this.update(this.getValues());
    }
    
    public boolean decrementaEstoque(int quantidade) throws Exception{
        int qtd = this.getQuantidade() - quantidade;
        if (qtd>=0) {
            this.setQuantidade(qtd);
            this.update(this.getValues());
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Nome Produto: ");
        string.append(((Cerveja)this.getProduto()).getNome());
        string.append("\n Quantidade: ");
        string.append(this.getQuantidade());
        return string.toString();
    }
}
