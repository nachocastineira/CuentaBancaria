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

	// ERRORES A CORREGIR: No puedo poner limite a sobregiro, siempre me deja seguir extrayendo dinero	
	
	@Override
	public void extraer (Double dineroExtraido) 
	{
		if (dineroExtraido>super.getSaldo())  //si el dinero a extraer es mayor al saldo disponible habrá sobregiro (limite adicional del banco) despues se devolvera con interes
		{
			this.setSaldoMasSobregiro(super.getSaldo()+this.sobregiro);  //sumo mi saldo mas sobregiro que brinda el banco

			super.setSaldo(this.getSaldoMasSobregiro()-dineroExtraido);  //hago la extraccion
			this.setSobregiro((super.getSaldo()-this.sobregiro)*this.getComisionExtra());  //el sobregiro ha sido usado y tendre que pagar lo prestado
			super.setSaldo(this.getSobregiro());  //saldo en negativo por el sobregiro utilizado
		}
		else
		{
				super.extraer(dineroExtraido);  //sino la extraccion sera normal
		}
	}
		
			
}
