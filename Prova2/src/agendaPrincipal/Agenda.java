package agendaPrincipal;

/**
 * Encapsula uma agenda com métodos para inserir e 
 * manipular elementos.
 * <p>
 * Possui uma coleção do tipo LinkedList para trabalhar com
 * a agenda e seus respectivos métodos de inserção e manipulação.
 * Além disso, possui a interface Serializable para gravar e 
 * recuperar a agenda em disco.
 * @author Rafael Emery
 * @version 1.0
 */

import java.util.*;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

@SuppressWarnings("serial")
public class Agenda implements Serializable {

	private List<ItemAgenda> agenda = new LinkedList<ItemAgenda>();
		
	//Metodos sobrecarregados para inserir
	/**
	 * Inserindo um ítem do tipo Evento
	 * @param evento instância de Evento
	 * @throws Exception caso o evento seja inválido
	 */
	public void insere(Evento evento) throws Exception {
		agenda.add(evento);
	}
	/**
	 * Inserindo um ítem do tipo Lembrete
	 * @param lembrete instância de Lembrete
	 * @throws Exception caso o lembrete seja inválido
	 */
	public void insere(Lembrete lembrete) throws Exception  {
		agenda.add(lembrete);
	}
	/**
	 * Inserindo um ítem do tipo Meta
	 * @param meta instância de Meta
	 * @throws Exception caso o evento seja inválido
	 */
	public void insere(Meta meta) throws Exception  {
		agenda.add(meta);
	}

	//Metodos get
	/**
	 * Consegue a lista
	 * @return retorna a Collection de agenda
	 */
	public List<ItemAgenda> getAgenda() {
		return this.agenda;
	}
	
	//Metodos para ordenar a agenda
	/**
	 * Ordena por prioridade da meta com o comparador definido na
	 * classe Meta
	 * <p>
	 * Exibe somente os meta ordenados pelo método sort
	 */
	public void ordenaPorPrioridade() {
		Collections.sort(this.agenda, new ComparaPorPrioridade());
		StringBuilder m = new StringBuilder();
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if (this.getAgenda().get(i).getClass() == Meta.class) {
				m.append(this.getAgenda().get(i));
			}
		}
		System.out.println(m.toString());
	}
	/**
	 * Ordena por quantidade de minutos do lembrete com o comparador definido na
	 * classe Lembrete
	 * <p>
	 * Exibe somente os lembretes ordenados pelo método sort
	 */
	public void ordenaPorQtdeMinutos() {
		Collections.sort(this.agenda, new ComparaPorQtdeMinutos());
		StringBuilder l = new StringBuilder();
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if (this.getAgenda().get(i).getClass() == Lembrete.class) {
				l.append(this.getAgenda().get(i));
			}
		}
		System.out.println(l.toString());
	}
	/**
	 * Ordena pelo local do evento com o comparador definido na
	 * classe Evento
	 */
	public void ordenaPorLocal() {
		Collections.sort(this.agenda, new ComparaPorLocal());
		StringBuilder e = new StringBuilder();
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if (this.getAgenda().get(i).getClass() == Evento.class) {
				e.append(this.getAgenda().get(i));
			}
		}
		System.out.println(e.toString());
	}
	
	//Metodo exibir itens em um determinado intervalo de datas
	/**
	 * Exibe os ítem da agenda em um determinado intervalo de datas
	 * @param dt1 data inicial do período escolhido
	 * @param dt2 data final do período escolhido
	 * @return uma instância de objeto StringBuilder com o toString(),
	 * imprimindo diretamente os dados selecionados/adicionados.
	 * @throws Exception caso o intervalo de datas seja inválido (datas de
	 * inicio e final incoerentes).
	 */
	public String itensIntervalo(Data dt1, Data dt2) throws Exception {
		if (dt1.compareTo(dt2) <= 0) {
			StringBuilder intervalo = new StringBuilder();
			for (int i = 0; i < this.agenda.size(); i++) {
				if ((agenda.get(i).getPeriodo().getDataInicio().compareTo(dt1) >= 0) && 
						(agenda.get(i).getPeriodo().getDataInicio().compareTo(dt2)) <= 0) {
					intervalo.append(agenda.get(i));
				}
			}
			return intervalo.toString();
		}
		else {
			throw new Exception("Intervalo invalido!");
		}
	}
	
	//Gravando a agenda em um arquivo
	/**
	 * Criando um arquivo e escrevendo a agenda nesse arquivo
	 * @param nomeArquivo nome do arquivo que será gerado
	 * @param agenda instância de agenda que será gravada
	 * @throws FileNotFoundException caso não encontre o arquivo
	 * @throws IOException problema na criação ou gravação do arquivo
	 */
	public static void gravaAgenda(String nomeArquivo, Object agenda) throws FileNotFoundException, IOException {
		ObjectOutputStream arquivo = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
		arquivo.writeObject(agenda);
		arquivo.flush();
		arquivo.close();
	}

	//Le o arquivo gravado
	/**
	 * Le o arquivo gravado (e será imprimido na classe Uso)
	 * @param nomeArquivo nome do arquivo que será buscado e lido
	 * @return retorna um objeto do tipo Agenda que será lido 
	 * @throws FileNotFoundException caso não encontre o arquivo
	 * @throws IOException problema na leitura do arquivo
	 * @throws ClassNotFoundException problema no casting do arquivo lido
	 * (caso Agenda não exista, por exemplo)
	 */
	public static Agenda leAgenda(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream arquivo = new ObjectInputStream(new FileInputStream(nomeArquivo));
		Agenda agenda = (Agenda) arquivo.readObject();
		arquivo.close();
		return agenda;
	}
	
	//Metodo toString
	/**
	 * Método toString personalizado para a impressão ser de 
	 * melhor visualização no console.
	 * <p>
	 * Irá imprimir basicamente o tipo do ítem e o elemento em
	 * questão.
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		System.out.println("Numero de itens: " + agenda.size());
		for (int i = 0; i < this.getAgenda().size(); i++) {
			builder.append("\nTipo: " + agenda.get(i).getClass());
			builder.append(agenda.get(i));
		}
		return builder.toString();
	}	
}