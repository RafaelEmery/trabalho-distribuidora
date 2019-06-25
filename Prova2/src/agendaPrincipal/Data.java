package agendaPrincipal;

/**
 * Encapsula as datas para agregar em Agenda.
 * <p>
 * Definimos uma data pelo formato "DD/MM/AAAA" e a classe 
 * possui validação de data de acordo com dias do mês e ano
 * bissexto.
 * <p>
 * Nas classes Periodo e Agenda, iremos ter duas datas: inicial
 * e final.
 * @author Rafael Emery
 * @version 1.0
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Data implements Serializable {
	private int dia, mes, ano;
	
	//Metodos construtores
	/**
	 * Construtor vazio
	 * @throws Exception caso a data seja vazia
	 */
	public Data() throws Exception {
		throw new Exception("Data vazia. Digite aqui.");
	}
	/**
	 * Construtor para três inteiros
	 * @param _dia inteiro do dia
	 * @param _mes inteiro do mês
	 * @param _ano inteiro do ano;
	 * @throws Exception caso a data seja inválida
	 */
	public Data(int _dia, int _mes, int _ano) throws Exception {
		this.setData(_dia, _mes, _ano);
	}
	/**
	 * Construtor para inicializar o objeto com o mês em String
	 * @param _dia inteiro de dia
	 * @param _mes String de mês (janeiro, agosto, etc.)
	 * @param _ano inteiro de ano
	 * @throws Exception caso a data seja inválida
	 */
	public Data(int _dia, String _mes, int _ano) throws Exception {
		this.setData(_dia, _mes, _ano);
	}
	/**
	 * Construtor para inicializar o objeto inserido por String
	 * @param _data String no formato "DD/MM/AAAA"
	 * @throws Exception caso a data seja inválida
	 */
	public Data(String _data) throws Exception {
		this.setData(_data);
	}
	
	//Metodos set
	/**
	 * Insere a partir de três inteiros
	 * @param _dia Dia da data
	 * @param _mes Mês da data
	 * @param _ano Ano da data
	 * @throws Exception Data inválida de acordo com o método isDataValida e isBissexto
	 */
	public void setData(int _dia, int _mes, int _ano) throws Exception {
		if (Data.isDataValida(_dia, _mes, _ano)) {
			this.dia = _dia;
			this.mes = _mes;
			this.ano = _ano;
		}
		else {	
			throw new Exception("Data invalida");
		}
	}
	
	/**
	 * Insere a data com um mes em String
	 * @param _dia O dia da data em inteiro
	 * @param _mes O mês da data em String
	 * @param _ano O ano da data em inteiro
	 * @throws Exception Caso o usuario entre com um mês que não exista
	 */
	public void setData(int _dia, String _mes, int _ano) throws Exception {
		
		//equalsIgnoreCase() para verificar o mes digitado
		if ("janeiro".equalsIgnoreCase(_mes))			
			this.setData(dia, 1, ano);		
		else if ("fevereiro".equalsIgnoreCase(_mes))	
			this.setData(dia, 2, ano); 
		else if ("marco".equalsIgnoreCase(_mes))		
			this.setData(dia, 3, ano); 		
		else if ("abril".equalsIgnoreCase(_mes))		
			this.setData(dia, 4, ano); 
		else if ("maio".equalsIgnoreCase(_mes))			
			this.setData(dia, 5, ano); 					
		else if ("junho".equalsIgnoreCase(_mes))		
			this.setData(dia, 6, ano); 			
		else if ("julho".equalsIgnoreCase(_mes))		
			this.setData(dia, 7, ano); 
		else if ("agosto".equalsIgnoreCase(_mes))		
			this.setData(dia, 8, ano); 			
		else if ("setembro".equalsIgnoreCase(_mes))		
			this.setData(dia, 9, ano);
		else if ("outubro".equalsIgnoreCase(_mes))		
			this.setData(dia, 10, ano); 
		else if ("novembro".equalsIgnoreCase(_mes)) 	
			this.setData(dia, 11, ano);
		else if ("dezembro".equalsIgnoreCase(_mes)) 	
			this.setData(dia, 12, ano);
		else 
			throw new Exception("Mes invalido");
	}
	
	/**
	 * Insere a data quando o usuário entra com uma String pelos métodos
	 * indexOf, substring e parseInt para separar e converter Strings em
	 * inteiros.
	 * <p>
	 * Usamos esse método devido a facilidade para a entrada de dados
	 * na classe Uso.
	 * @param _data Uma data em String que será convertida para inteiro em dia, mês e ano
	 * @throws Exception Caso a data seja inválida
	 */
	public void setData(String _data) throws Exception {
		int index1 = _data.indexOf("/");
		int index2 = _data.indexOf("/", index1 + 1);
		String _dia = _data.substring(0, index1);
		String _mes = _data.substring(index1 + 1, index2);
		String _ano = _data.substring(index2 + 1, index2 + 5);
		int dia = Integer.parseInt(_dia);
		int mes = Integer.parseInt(_mes);
		int ano = Integer.parseInt(_ano);
		this.setData(dia, mes, ano);
	}
	
	//Metodos get
	public int getDia() {
		return this.dia;
	}
	public int getMes() {
		return this.mes;
	}
	public int getAno() {
		return this.ano;
	}

	//Metodos para validar as datas entradas	
	/**
	 * Verifica se uma determinada data inserida é valida
	 * @return Um booleano que representa a validade da data
	 */
	public boolean isDataValida() {
		return Data.isDataValida(this.getDia(), this.getMes(), this.getAno());
	}
	
	/**
	 * Verifica se uma determinada data inserida é valida
	 * @param dia O dia da data
	 * @param mes O mês da data
	 * @param ano O ano da data
	 * @return Um booleano que representa a validade da data
	 */
	public static boolean isDataValida(int dia, int mes, int ano) {
		//Verif. basica
		if (dia <= 31 && mes <= 12 & ano >= 1582) {
			//Verif de meses com 30 dias
			if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia <= 30) {
				return true;	
			}
			//Verif de fevereiro
			if (mes == 2) {
				if (Data.isBissexto(ano)) {
					if (mes <= 29) {
						return true;
					}
					else {	
						return false;
					}
				}
				else {	
					if (dia <= 28) {		
						return true;
					}
					else {	
						return false;
					}
				}
			}
			//O resto sao os meses com 31 dias
			else {
				return true;
			}		
		}
		else {
			//Caso a data nao passe pelo teste de validacao
			return false;
		}
	}
	
	/**
	 * Verifica se o ano inserido é bissexto
	 * @param ano O ano da data
	 * @return Um booleano que indica se o ano é bissexto
	 */
	public static boolean isBissexto(int ano) {
		//Verif. para ano bissexto
		if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) { 
			return true;
		}
		else {
			return false;
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
		Data aux = (Data) obj;
		if (this.getDia() == aux.getDia() && this.getMes() == aux.getMes() && this.getAno() == aux.getAno()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo compareTo
	/**
	 * Compara duas datas
	 * @param obj Um objeto que será convertido em Data
	 * @return Um inteiro que retorna 1, 0 ou -1
	 */
	public int compareTo(Object obj) {
		Data aux = (Data) obj;
		if (this.getAno() > aux.getAno()) {
			return 1;
		}
		else if (this.getAno() == aux.getAno()) {
			if (this.getMes() > aux.getMes()) {
				return 1;
			}
			else if (this.getMes() < aux.getMes()) {
				return -1;
			}
			else {
				if (this.getDia() > aux.getDia()) {
					return 1;
				}
				else if (this.getDia() == aux.getDia()) {
					return 0;
				}
				else {
					return -1;
				}
			}
		}
		else {
			return -1;
		}
	}
			
	//Metodo toString
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append(this.getDia());
		data.append("/");
		data.append(this.getMes());
		data.append("/");
		data.append(this.getAno());
		return data.toString(); 
	}
}
