package model;

public class ItensBeans {
	
	private int codigoItem;
	private String descricao;
	private double valor;
	private double quantidade;
	private double subTotal;
	
	public ItensBeans(int codigoItem, String descricao, double valor, double quantidade) {
		super();
		this.codigoItem = codigoItem;
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(int codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	


	
	
}
