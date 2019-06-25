package agendaPrincipal;

/**
 * Encapsula um tipo de ItemAgenda chamado Meta.
 * <p>
 * Uma meta é ítem da agenda que possui como diferencial a
 * prioridade da meta (em inteiro).
 * <p>
 * A classe abaixo possui métodos construtores, setters e getters,
 * equals e outros para a manipulação de itens de agenda do tipo
 * Meta. Além disso implementa a interface Comparable para fazer 
 * a ordenação e a Serializable para a gravação em arquivo.
 * @author Rafael Emery
 * @version 1.0
 */

import java.util.Comparator; 
import java.io.Serializable;

@SuppressWarnings("serial")
public class Meta extends ItemAgenda implements Comparable<ItemAgenda>, Serializable {
	private int prioridade;

	//Metodos construtores
	/**
	 * Construtor vazio para o objeto
	 * @throws Exception caso o objeto seja vazio
	 */
	public Meta() throws Exception {
		super();
	}
	/**
	 * Inicializa uma instância de Lembrete
	 * @param _titulo título do ítem
	 * @param _descricao descrição do ítem
	 * @param _periodo período que ocorrerá a meta
	 * @param _prioridade nível de prioridade da meta (de 1 a ...) 
	 * @throws Exception caso os parâmetros sejam inválidos
	 */
	public Meta(String _titulo, String _descricao, Periodo _periodo, int _prioridade) throws Exception {
		super(_titulo, _descricao, _periodo);
		this.prioridade = _prioridade;
	}
	
	//Metodo set
	/**
	 * Insere e verifica a prioridade da meta
	 * @param _prioridade inteiro para a prioridade (de 1 a ...)
	 * @throws Exception caso a prioridade seja inválida (0 ou negativa)
	 */
	public void setPrioridade(int _prioridade) throws Exception {
		if (_prioridade <= 1) {
			this.prioridade = _prioridade;
		}
		else {
			throw new Exception("Prioridade invalida.");
		}
	}

	//Metodo get
	public int getPrioridade() {
		return this.prioridade;
	}
	
	//Metodo compareTo
	/**
	 * Compara duas prioridades
	 * @param aux Um objeto do tipo Meta
	 * @return Um inteiro que retorna 1, 0 ou -1
	 */
	public int compareTo(Meta aux) {
		if (this.prioridade > aux.prioridade) {
			return 1;
		}
		else if (this.prioridade == aux.prioridade) {
			return 0;
		}
		else {
			return -1;
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
		Meta aux = (Meta) obj;
		if (this.equals(aux) && this.prioridade == aux.prioridade) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\nPrioridade: ");
		builder.append(this.getPrioridade());
		builder.append(". ");
		return builder.toString();
	}
}

/**
 * Classe com a interface Comparator que fornece um método para 
 * ordenar as instâncias da classe Meta de acordo com o nivel de 
 * prioridade inserido pelo usuário.
 * <p>
 * A ordenação será feita pelo método sort (estático) da classe
 * Collections.
 * @author Rafael Emery
 * @version 1.0;
 */
class ComparaPorPrioridade implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda aux1, ItemAgenda aux2) {
		Meta meta1 = (Meta) aux1;
		Meta meta2 = (Meta) aux2;
		int prioridade1 = meta1.getPrioridade();
		int prioridade2 = meta2.getPrioridade();
		if (prioridade1 > prioridade2) {
			return 1;
		}
		else if (prioridade1 == prioridade2) {
			return 0;
		}
		else {
			return -1;
		}
	}
}






