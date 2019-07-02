package modelo;

public class Fornecedor extends Pessoa {
	private String cidade;
	private String estado;
	private String empresa;
	private boolean inedito;
	
	//Metodos construtores
	public Fornecedor() {
            super();
	}
	
	public Fornecedor(String nome, String cadastro, String telefone, int tipoPessoa, String cidade, String estado, String empresa, boolean inedito) throws Exception {
		super(nome, cadastro, telefone, tipoPessoa);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setEmpresa(empresa);
		this.setInedito(inedito);
	}
	
	//Metodos set
	public void setCidade(String cidade) throws Exception {
		if (cidade.isEmpty() == false) {
			this.cidade = cidade;
		}
		else {
			throw new Exception("Cidade invalido");
		}
	}	
	public void setEstado(String estado) throws Exception {
		if (estado.isEmpty() == false) {
			this.estado = estado;
		}
		else {
			throw new Exception("Estado invalido");
		}
	}
	public void setEmpresa(String empresa) throws Exception {
		if (empresa.isEmpty() == false) {
			this.empresa = empresa;
		}
		else {
			throw new Exception("Empresa invalida");
		}
	}
	public void setInedito(boolean inedito) throws Exception {
		this.inedito = inedito;
	}
	
	//Metodos get
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getEmpresa() {
		return empresa;
	}
	public boolean isInedito() {
		return inedito;
	}
	
	/*
	//Metodo equals
	public boolean equals(Fornecedor fornecedor) {
	
	}
	*/
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", Cidade: ");
		builder.append(this.getCidade());
		builder.append(", Estado: ");
		builder.append(this.getEstado());
		builder.append(", Empresa que representa: ");
		builder.append(this.getEmpresa());
		builder.append(", Primeira vez: ");
		builder.append(this.isInedito());
		return builder.toString();
	}	
}
