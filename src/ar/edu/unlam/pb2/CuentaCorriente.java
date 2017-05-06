package ar.edu.unlam.pb2;

public class CuentaCorriente extends CuentaSueldo {
	
	private Double comisionExtra;
	private Double sobregiro;
	private Double saldoMasSobregiro = 0d;
	
	public CuentaCorriente (String nombre, Double saldo,  Integer dni, Double comisionExtra, Double sobregiro)
	{
		super(nombre, saldo, dni);
		this.comisionExtra = comisionExtra;
		this.sobregiro = sobregiro;
	}
	
	// PROBAR CONSTRUCTOR VACIO, PARA NO LLENARLO SIEMPRE EN LOS TEST//

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
	
	public Double getSaldoMasSobregiro() {
		return saldoMasSobregiro;
	}

	public void setSaldoMasSobregiro(Double saldoMasSobregiro) {
		this.saldoMasSobregiro = saldoMasSobregiro;
	}

	@Override
	public void extraer (Double dineroExtraido)  //EN CONSTRUCCION, esta bien --> falta aplicar interes al saldo
	{
		if (dineroExtraido>super.getSaldo())  //si el dinero a extraer es mayor al saldo disponible habrá sobregiro (limite adicional del banco) despues se devolvera con interes
		{
			this.setSaldoMasSobregiro(super.getSaldo()+this.sobregiro);  //sumo mi saldo mas sobregiro que brinda el banco
			super.setSaldo(this.getSaldoMasSobregiro()-dineroExtraido);  //hago la extraccion
			this.setSobregiro((super.getSaldo()-this.sobregiro)*this.getComisionExtra());  //el sobregiro ha sido usado y tendre que pagar lo prestado
										
		}
		
		else
		{
			super.setSaldo(getSaldo() - dineroExtraido);  //sino la extraccion sera normal
		}
	}

}
