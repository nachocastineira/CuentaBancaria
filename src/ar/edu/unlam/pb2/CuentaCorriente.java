package ar.edu.unlam.pb2;

public class CuentaCorriente extends CuentaSueldo {
	
	private Double comisionExtra;
	private Double sobregiro;
	
	public CuentaCorriente (String nombre, Double saldo,  Integer dni, Double comisionExtra, Double sobregiro)
	{
		super(nombre, saldo, dni);
		this.comisionExtra = comisionExtra;
		this.sobregiro = sobregiro;
	}

	public Double getComisionExtra() {
		return comisionExtra;
	}

	public void setComisionExtra(Double comisionExtra) {
		this.comisionExtra = comisionExtra;
	}

	public Double getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(Double sobregiro) {
		this.sobregiro = sobregiro;
	}
	
	

}
