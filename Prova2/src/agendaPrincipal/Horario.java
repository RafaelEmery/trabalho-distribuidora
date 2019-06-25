package agendaPrincipal;

/**
 * Encapsula os horários para agregar no período.
 * <p>
 * Podemos definir um horário por inteiros (horas e minutos) e 
 * por String "HORAS:MINUTOS", e o formato das horas são: 0 a 
 * 23 horas e 0 a 59 minutos.
 * <p>
 * Usaremos essa classe para agregar a classe Periodo. Na agenda,
 * iremos usar dois horários, o inicial e o final.
 * @author Rafael Emery
 * @version 1.0
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Horario implements Serializable{
	private int horas, minutos;
	
	//Metodos construtores	
	/**
	 * Construtor para o objeto vazio
	 * @throws Exception caso não possua horário
	 */
	public Horario() throws Exception {
		throw new Exception("Horario vazio. Digite aqui");
	}
	/**
	 * Construtor para inicializar os campos do objeto
	 * @param _horas horas do horário
	 * @param _minutos minutos do horário
	 * @throws Exception problemas na inserção
	 */
	public Horario(int _horas, int _minutos) throws Exception {
		this.setHorario(_horas, _minutos);
	}
	/**
	 * Construtor para inicializar o objeto com uma String
	 * @param _horario String "XX:XX" para o objeto
	 * @throws Exception problemas na inserção
	 */
	public Horario(String _horario) throws Exception {
		this.setHorario(_horario);
	}
	
	//Metodos set
	/**
	 * Método para inserir o horário 
	 * @param _horas inteiro de horas
	 * @param _minutos inteiro de minutos
	 * @throws Exception horário inválido de acordo com isHorarioValido
	 */
	public void setHorario(int _horas, int _minutos) throws Exception {
		if (Horario.isHorarioValido(_horas, _minutos)) {
			this.horas = _horas;
			this.minutos = _minutos;
		}
		else {
			throw new Exception("Horario invalido");
		}
	}	
	/**
	 * Insere um horário em String. Optamos por usar esse métoto set 
	 * na Agenda pela facilidade de digitação.
	 * <p>
	 * O método usa o indexOf, substring e parseInt para pegar o índice
	 * e as strings e fazer a conversão para inteiro, entrando com o 
	 * setHorario padrão (inteiros)
	 * @param _horario Um objeto de Horario
	 * @throws Exception Caso o horário seja inválido
	 */
	public void setHorario(String _horario) throws Exception {
		int index1 = _horario.indexOf(":");
		String _horas = _horario.substring(0, index1);
		String _minutos = _horario.substring(index1 + 1, index1 + 3);
		int horas = Integer.parseInt(_horas);
		int minutos = Integer.parseInt(_minutos);
		this.setHorario(horas, minutos);
	}
	
	//Metodos get
	public int getHoras() {
		return this.horas;
	}
	public int getMinutos() {
		return this.minutos;
	}
	
	//Metodos para validar o horario	
	/** 
	 * Verifica se um horário é válido
	 * @return Um booleano que representa a validade do horário
	 */
	public boolean isHorarioValido() {
		return Horario.isHorarioValido(this.getHoras(), this.getMinutos());
	}
	/**
	 * Verifica se um horário é válido
	 * @param horas As horas do objeto
	 * @param minutos Os minutos do objeto
	 * @return Um booleano que representa a validade do horário
	 */
	public static boolean isHorarioValido(int horas, int minutos) {
		if ((horas >= 0 && horas <= 23) && (minutos >= 0 && minutos <= 59)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo compareTo
	/**
	 * Método que faz uma comparação entre dois horários e retorna
	 * um inteiro
	 * @param obj Objeto qualquer para fazer um cast
	 * @return Um inteiro que representa se é maior, igual ou
	 * menor que o objeto em questão
	 */
	public int compareTo(Object obj) {
		Horario aux = (Horario) obj;
		if (this.getHoras() > aux.getHoras()) {
			return 1;
		}
		else if (this.getHoras() == aux.getHoras()) {
			if (this.getMinutos() > aux.getMinutos()) {
				return 1;
			}
			else if (this.getMinutos() == aux.getMinutos()) {
				return 0;
			}
			else {
				return -1;
			}
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
		Horario aux = (Horario) obj;
		if (this.getHoras() == aux.getHoras() && this.getMinutos() == aux.getMinutos()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder horario = new StringBuilder();
		horario.append(this.getHoras());
		horario.append(":");
		horario.append(this.getMinutos());
		return horario.toString();
	}
	
}
