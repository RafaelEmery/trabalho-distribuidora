package agendaPrincipal;

/**
 * Classe abstrata para o item de uma agenda.
 * <p>
 * Usamos itens da agenda como Lembrete, Meta e Evento, que 
 * são as classes filhas, e instanciamos os mesmos na classe
 * Uso para inserir na agenda.
 * <p>
 * Além disso, é implementada a interface Serializable para
 * podermos armazenar e recuperar os arquivos em disco.
 * @author Rafael Emery
 * @version 1.0
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class ItemAgenda implements Serializable {
	private String titulo;
	private String descricao;
	private Periodo periodo; 
	
	//Metodos construtores
	/**
	 * Construtor vazio para o objeto
	 * @throws Exception caso o objeto seja vazio
	 */
	public ItemAgenda() throws Exception {
		throw new Exception("Item vazio. Digite aqui.");
	}
	/**
	 * Inicializa um objeto (no caso, filho)
	 * @param _titulo título do ítem
	 * @param _descricao descrição do ítem
	 * @param _periodo período do ítem
	 * @throws Exception caso os parâmetros sejam inválidos
	 */
	public ItemAgenda(String _titulo, String _descricao, Periodo _periodo) throws Exception {
		this.setTitulo(_titulo);
		this.setDescricao(_descricao);
		this.setPeriodo(_periodo);
	}
	
	//Metodos set
	/**
	 * Insere o título
	 * @param _titulo título do ítem
	 * @throws Exception caso a String seja vazia
	 */
	public void setTitulo(String _titulo) throws Exception {
		if (ItemAgenda.isStringValida(_titulo)) {
			this.titulo = _titulo;
		}
		else {
			throw new Exception("Titulo invalido.");
		}
	}
	/**
	 * Insere a descrição 
	 * @param _descricao descrição do ítem
	 * @throws Exception caso a String seja vazia
	 */
	public void setDescricao(String _descricao) throws Exception {
		if (ItemAgenda.isStringValida(_descricao)) {
			this.descricao = _descricao;
		}
		else {
			throw new Exception("Descricao invalida.");
		}
	}
	/**
	 * Insere o período
	 * @param _periodo período do ítem (Data, Data, Horario, Horario)
	 * @throws Exception caso o período seja inválido
	 */
	public void setPeriodo(Periodo _periodo) throws Exception {
		this.periodo = _periodo;
	}
	
	//Metodos get
	public String getTitulo() {
		return this.titulo;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public Periodo getPeriodo() {
		return this.periodo;
	}
	
	//Metodo compareTo
	/**
	 * Compara dois ítens da agenda
	 * @param aux Um objeto do tipo ItemAgenda (ou filho)
	 * @return Um inteiro que retorna 1, 0 ou -1
	 */
	public int compareTo(ItemAgenda aux) {
		return this.getTitulo().compareToIgnoreCase(aux.getTitulo());
	}
	
	//Metodo estatico que verifica se uma string nao eh vazia	
	/**
	 * Verifica se uma String é válida
	 * @param string Um objeto String
	 * @return Um booleano indicando se a string é vazia ou não
	 */
	public static boolean isStringValida(String string) {
		if (string.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Metodo equals
	/**
	 * Método que verifica se dois objetos são iguais e retorna um 
	 * booleano
	 * @param obj Objeto qualquer para se fazer um cast
	 * @return Um booleano que representa se os objetos são iguais ou não
	 */
	public boolean equals(Object obj) {
		ItemAgenda aux = (ItemAgenda) obj;
		if (this.descricao.equalsIgnoreCase(aux.descricao) && this.titulo.equalsIgnoreCase(aux.titulo)
		&& this.periodo.equals(aux.periodo)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nTitulo: ");
		builder.append(this.getTitulo());
		builder.append(";\nDescricao: ");
		builder.append(this.getDescricao());
		builder.append(";\nPeriodo: ");
		builder.append(this.getPeriodo());
		builder.append(";");
		return builder.toString();
	}
}





