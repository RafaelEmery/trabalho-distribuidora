package agendaPrincipal;

/**
 * Encapsula um tipo de ItemAgenda chamado Evento.
 * <p>
 * Um evento é um item da agenda que possui como diferencial
 * o local que irá acontecer.
 * <p>
 * A classe abaixo possui métodos construtores, setters e getters,
 * equals e outros para a manipulação de itens de agenda do tipo
 * Evento. Além disso implementa a interface Comparable para fazer 
 * a ordenação e a Serializable para a gravação em arquivo.
 * @author Rafael Emery
 * @version 1.0
 */

import java.util.Comparator;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Evento extends ItemAgenda implements Comparable<ItemAgenda>, Serializable {
	private String local;
	
	//Metodos construtores
	/**
	 * Construtor vazio para o objeto
	 * @throws Exception caso o objeto seja vazio
	 */
	public Evento() throws Exception {
		super();
	}
	/**
	 * Inicializa uma instância de Evento
	 * @param _titulo título do ítem
	 * @param _descricao descrição do ítem
	 * @param _periodo período que ocorrerá o evento
	 * @param _local local que irá acontecer o evento
	 * @throws Exception caso os parâmetros sejam inválidos
	 */
	public Evento(String _titulo, String _descricao, Periodo _periodo, String _local) throws Exception {
		super(_titulo, _descricao, _periodo);
		this.setLocal(_local);
	}
	
	//Metodo set
	/**
	 * Insere o local no objeto
	 * @param _local local que irá ocorrer o evento
	 * @throws Exception caso o local seja vazio
	 */
	public void setLocal(String _local) throws Exception {
		if (ItemAgenda.isStringValida(_local)) {
			this.local = _local;
		}
		else {
			throw new Exception("Local vazio");
		}
	}
	
	//Metodo get
	public String getLocal() {
		return this.local;
	}
	
	//Metodo compareTo
	/**
	 * Compara dois locais
	 * @param aux Um objeto do tipo Evento
	 * @return Um inteiro que retorna 1, 0 ou -1
	 */
	public int compareTo(Evento aux) {
		return this.getLocal().compareToIgnoreCase(aux.getLocal());
	}
	
	//Metodo equals
	/**
	 * Método que verifica se dois objetos são iguais e retorna um 
	 * booleano
	 * @param obj Objeto qualquer para se fazer um cast
	 * @return Um booleano que representa se os objetos são iguais ou não
	 */
	public boolean equals(Object obj) {
		Evento aux = (Evento) obj;
		if (this.equals(aux) && this.local.equalsIgnoreCase(aux.getLocal())) {
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
		builder.append("\nLocal: ");
		builder.append(this.getLocal());
		builder.append(". ");
		return builder.toString();
	}	
}

/**
 * Classe com a interface Comparator que fornece um método para 
 * ordenar as instâncias da classe Evento de acordo com o local
 * <p>
 * A ordenação será feita pelo método sort (estático) da classe
 * Collections.
 * @author Rafael Emery
 * @version 1.0;
 */
class ComparaPorLocal implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda aux1, ItemAgenda aux2) {
		Evento evento1 = (Evento) aux1;
		Evento evento2 = (Evento) aux2;
		return evento1.getLocal().compareToIgnoreCase(evento2.getLocal());
	}
}
