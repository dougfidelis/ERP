package model;

public class MaterialBeans {
	
	private int codigoMaterial;
	private String descricaoMaterial;	
	private double quantidadeMaterial;
	private double valorMaterial;
	private double subTotalMateiral;
	
		
	
	
	public MaterialBeans(String descricaoMaterial, double quantidadeMaterial, double valorMaterial) {
		super();
		this.descricaoMaterial = descricaoMaterial;
		this.quantidadeMaterial = quantidadeMaterial;
		this.valorMaterial = valorMaterial;
	}

	public MaterialBeans(int codigoMaterial, String descricaoMaterial, double valorMaterial,
			double quantidadeMaterial) {
		super();
		this.codigoMaterial = codigoMaterial;
		this.descricaoMaterial = descricaoMaterial;
		this.valorMaterial = valorMaterial;
		this.quantidadeMaterial = quantidadeMaterial;
	}

	public MaterialBeans(int codigoMaterial, String descricaoMaterial, double valorMaterial, double quantidadeMaterial,
			double subTotalMateiral) {
		super();
		this.codigoMaterial = codigoMaterial;
		this.descricaoMaterial = descricaoMaterial;
		this.valorMaterial = valorMaterial;
		this.quantidadeMaterial = quantidadeMaterial;
		this.subTotalMateiral = subTotalMateiral;
	}
	
	public int getCodigoMaterial() {
		return codigoMaterial;
	}
	public void setCodigoMaterial(int codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}
	public String getDescricaoMaterial() {
		return descricaoMaterial;
	}
	public void setDescricaoMaterial(String descricaoMaterial) {
		this.descricaoMaterial = descricaoMaterial;
	}
	public double getValorMaterial() {
		return valorMaterial;
	}
	public void setValorMaterial(double valorMaterial) {
		this.valorMaterial = valorMaterial;
	}
	public double getQuantidadeMaterial() {
		return quantidadeMaterial;
	}
	public void setQuantidadeMaterial(double quantidadeMaterial) {
		this.quantidadeMaterial = quantidadeMaterial;
	}
	public double getSubTotalMateiral() {
		return subTotalMateiral;
	}
	public void setSubTotalMateiral(double subTotalMateiral) {
		this.subTotalMateiral = subTotalMateiral;
	}
	
	

}
