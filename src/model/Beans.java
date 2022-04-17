package model;

public class Beans {
	
	/**______Atributos Clientes_______**/
	private int codigoCliente;
	private String nomeCliente;
	private String telCliente;
	private String emailCliente;
	private String endCliente;
	
	/**_____Construtores Clientes_____**/
	public Beans(String nomeCliente, String telCliente, String emailCliente, String endCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.telCliente = telCliente;
		this.emailCliente = emailCliente;
		this.endCliente = endCliente;
	}
	
	public Beans(int codigoCliente, String nomeCliente, String telCliente, String emailCliente, String endCliente) {
		super();
		this.codigoCliente = codigoCliente;
		this.nomeCliente = nomeCliente;
		this.telCliente = telCliente;
		this.emailCliente = emailCliente;
		this.endCliente = endCliente;
	}

	/**_______Get&Set Clientes________**/
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
	public String getTelCliente() {
		return telCliente;
	}
	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
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
	/**_______________________________**/
}
