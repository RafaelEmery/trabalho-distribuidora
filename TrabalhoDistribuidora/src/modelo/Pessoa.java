package modelo;

public abstract class Pessoa {
	private String nome;
	private String cadastro;
	private String telefone;
	private int tipoPessoa;
	
	//Metodos construtores
	public Pessoa() throws Exception {
		throw new Exception("Pessoa invalida.");
	}
	public Pessoa(String nome, String cadastro, String telefone, int tipoPessoa) throws Exception {
		this.setNome(nome);
		this.setCadastro(cadastro);
		this.setTelefone(telefone);
		this.setTipoPessoa(tipoPessoa);
	}
	
	//Metodos set
	public void setNome(String nome) throws Exception {
		if (nome.isEmpty() == false) {
			this.nome = nome;
		}
		else {
			throw new Exception("Nome invalido");
		}
	}
	public void setCadastro(String cadastro) throws Exception  {
		if (cadastro.isEmpty() == false) {
			this.cadastro = cadastro;
		}
		else {
			throw new Exception("Cadastro invalido");
		}
	}
	public void setTelefone(String telefone) throws Exception  {
		if (telefone.isEmpty() == false) {
			this.telefone = telefone;
		}
		else {
			throw new Exception("Telefone invalido");
		}
	}
	public void setTipoPessoa(int tipoPessoa) throws Exception {
		if (tipoPessoa >= 0) {
			this.tipoPessoa = tipoPessoa;
		}
		else {
			throw new Exception("Tipo de pessoa invalido");
		}
	}
	
	//Metodos get
	public String getNome() {
		return nome;
	}
	public String getCadastro() {
		return cadastro;
	}
	public String getTelefone() {
		return telefone;
	}
	public int getTipoPessoa() {
		return tipoPessoa;
	}

	//Metodo equals
	public boolean equals(Pessoa pessoa) {
		if (this.getNome().equalsIgnoreCase(pessoa.getNome()) && this.getCadastro().equalsIgnoreCase(pessoa.getCadastro())
				&& this.getTelefone().equalsIgnoreCase(pessoa.getTelefone()) && this.getTipoPessoa() == pessoa.getTipoPessoa()){
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nNome: ");
		builder.append(this.getNome());
		builder.append(", Cadastro (CPF/CNPJ): ");
		builder.append(this.getCadastro());
		builder.append(", Telefone: ");
		builder.append(this.getTelefone());
		builder.append(", Tipo de pessoa (Fisica/Juridica): ");
		builder.append(this.getTipoPessoa());
		return builder.toString();
	}
	
}
