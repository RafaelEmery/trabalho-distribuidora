package agendaPrincipal;

/**
 * Encapsula o período com datas e horários para usar em Agenda
 * @author Rafael Emery
 * @version 1.0
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Periodo implements Serializable {
	private Data dataInicio, dataFinal;
	private Horario horarioInicio, horarioFinal;
	
	//Metodos construtores
	/**
	 * Construtor vazio para o objeto inicializado vazio
	 * @throws Exception caso o objeto seja vazio
	 */
	public Periodo() throws Exception {
		throw new Exception("Periodo vazio. Digite aqui.");
	}
	/**
	 * Construtor que inicializa um objeto com todos os argumentos
	 * @param _dataInicio data de inicio do período
	 * @param _dataFinal data de final do período
	 * @param _horarioInicio horário da data inicial
	 * @param _horarioFinal horário da data final
	 * @throws Exception caso as datas e/ou os horários sejam inválidos
	 */
	public Periodo(Data _dataInicio, Data _dataFinal, Horario _horarioInicio, Horario _horarioFinal) throws Exception {
		this.setPeriodo(_dataInicio, _dataFinal, _horarioInicio, _horarioFinal);
	}
	
	//Metodos set	
	/**
	 * Insere e verifica um determinado período de datas e horas
	 * @param _dataInicio Data inicial do período
	 * @param _dataFinal Data final do período
	 * @param _horarioInicio Horário da data inicial
	 * @param _horarioFinal Horário da data final
	 * @throws Exception Caso as datas e os horários sejam inválidos
	 */
	public void setPeriodo(Data _dataInicio, Data _dataFinal, Horario _horarioInicio, Horario _horarioFinal) throws Exception {
		if (_dataInicio.compareTo(_dataFinal) <= 0) {
			this.dataInicio = _dataInicio;
			this.dataFinal = _dataFinal;
			this.horarioInicio = _horarioInicio;
			this.horarioFinal = _horarioFinal;
		}
		else {
			throw new Exception("Periodo invalido.");
		}
	}
	
	
	//Metodos get
	public Data getDataInicio() {
		return this.dataInicio;
	}
	public Data getDataFinal() {
		return this.dataFinal;
	}
	public Horario getHorarioInicio() {
		return this.horarioInicio;
	}
	public Horario getHorarioFinal() {
		return this.horarioFinal;
	}
	
	//Metodo equals
	/**
	 * Método que verifica se dois objetos são iguais e retorna um 
	 * booleano
	 * @param obj Objeto qualquer para se fazer um cast
	 * @return Um booleano que representa se os objetos são iguais ou não
	 */
	public boolean equals(Object obj) {
		Periodo aux = (Periodo) obj;
		if ((this.getDataInicio() == aux.getDataInicio() && this.getDataFinal() == aux.getDataFinal()) && 
		(this.getHorarioInicio() == aux.getHorarioInicio() && this.getHorarioFinal() == aux.getHorarioFinal())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Inicio: ");
		builder.append(this.getDataInicio());
		builder.append(" as ");
		builder.append(this.getHorarioInicio());
		builder.append(" - Final: ");
		builder.append(this.getDataFinal());
		builder.append(" as ");
		builder.append(this.getHorarioFinal());
		return builder.toString();
	}
	
}
