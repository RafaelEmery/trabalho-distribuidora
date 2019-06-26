package modelo;

public class Cerveja extends Produto {
	private String nome;
	private String tipoCerveja;
	private double porcentagemAlcool;
	
	//Metodos construtores
	public Cerveja() throws Exception {
		super();
	}
	public Cerveja(String nome, String tipoCerveja, double porcentagemAlcool, double valor, int codigoDeBarra) throws Exception {
		super(valor, codigoDeBarra);
		this.setNome(nome);
		this.setTipoCerveja(tipoCerveja);
		this.setPorcentagemAlcool(porcentagemAlcool);
	}
	
	//Metodos set
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTipoCerveja(String tipoCerveja) {
		this.tipoCerveja = tipoCerveja;
	}
	public void setPorcentagemAlcool(double porcentagemAlcool) {
		this.porcentagemAlcool = porcentagemAlcool;
	}
	
	//Metodos get
	public String getNome() {
		return nome;
	}
	public String getTipoCerveja() {
		return tipoCerveja;
	}
	public double getPorcentagemAlcool() {
		return porcentagemAlcool;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\n Nome: ");
		builder.append(this.getNome());
		builder.append(", Tipo de cerveja: ");
		builder.append(this.getTipoCerveja());
		builder.append(", Porcentagem de alcool: ");
		builder.append(this.getPorcentagemAlcool());
		return builder.toString();
	}
}
