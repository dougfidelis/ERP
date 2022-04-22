package model;

public class OrcamentosBeans {

	/** ______Atributos Clientes_______ **/
	
	private int codigoOrcamento;
	private int validade;
	private int entrega;
	private double rt;
	private double imposto;
	private double valor;
	private String arquiteto;
	private String emissao;
	private String formPgto;
	private String situacao;
	private int codigoCliente;
	
	public OrcamentosBeans(int validade, int entrega, double rt, double imposto, double valor, String arquiteto,
			String emissao, String formPgto, String situacao, int codigoCliente) {
		super();
		this.validade = validade;
		this.entrega = entrega;
		this.rt = rt;
		this.imposto = imposto;
		this.valor = valor;
		this.arquiteto = arquiteto;
		this.emissao = emissao;
		this.formPgto = formPgto;
		this.situacao = situacao;
		this.codigoCliente = codigoCliente;
	}
	
	
	public OrcamentosBeans(int codigoOrcamento, int validade, int entrega, double rt, double imposto, double valor,
			String arquiteto, String emissao, String formPgto, String situacao, int codigoCliente) {
		super();
		this.codigoOrcamento = codigoOrcamento;
		this.validade = validade;
		this.entrega = entrega;
		this.rt = rt;
		this.imposto = imposto;
		this.valor = valor;
		this.arquiteto = arquiteto;
		this.emissao = emissao;
		this.formPgto = formPgto;
		this.situacao = situacao;
		this.codigoCliente = codigoCliente;
		
	}
	public int getCodigoOrcamento() {
		return codigoOrcamento;
	}
	public void setCodigoOrcamento(int codigoOrcamento) {
		this.codigoOrcamento = codigoOrcamento;
	}
	public int getValidade() {
		return validade;
	}
	public void setValidade(int validade) {
		this.validade = validade;
	}
	public int getEntrega() {
		return entrega;
	}
	public void setEntrega(int entrega) {
		this.entrega = entrega;
	}
	public double getRt() {
		return rt;
	}
	public void setRt(double rt) {
		this.rt = rt;
	}
	public double getImposto() {
		return imposto;
	}
	public void setImposto(double imposto) {
		this.imposto = imposto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getArquiteto() {
		return arquiteto;
	}
	public void setArquiteto(String arquiteto) {
		this.arquiteto = arquiteto;
	}
	public String getEmissao() {
		return emissao;
	}
	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}
	public String getFormPgto() {
		return formPgto;
	}
	public void setFormPgto(String formPgto) {
		this.formPgto = formPgto;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	
	
}
