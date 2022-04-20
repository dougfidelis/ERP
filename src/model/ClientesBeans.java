package model;

public class ClientesBeans {

	/** ______Atributos Clientes_______ **/
	private int codigoCliente;
	private String nomeCliente;
	private String foneCliente;
	private String emailCliente;
	private String endCliente;

	/** _____Construtores Clientes_____ **/

	public ClientesBeans(String nomeCliente, String foneCliente, String emailCliente, String endCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.foneCliente = foneCliente;
		this.emailCliente = emailCliente;
		this.endCliente = endCliente;
	}

	public ClientesBeans() {
	}

	public ClientesBeans(int codigoCliente) {
		super();
		this.codigoCliente = codigoCliente;
	}

	public ClientesBeans(int codigoCliente, String nomeCliente, String foneCliente, String emailCliente, String endCliente) {
		super();
		this.codigoCliente = codigoCliente;
		this.nomeCliente = nomeCliente;
		this.foneCliente = foneCliente;
		this.emailCliente = emailCliente;
		this.endCliente = endCliente;
	}

	/** _______Get&Set Clientes________ **/
	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getFoneCliente() {
		return foneCliente;
	}

	public void setFoneCliente(String foneCliente) {
		this.foneCliente = foneCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getEndCliente() {
		return endCliente;
	}

	public void setEndCliente(String endCliente) {
		this.endCliente = endCliente;
	}
	/** _______________________________ **/

}
