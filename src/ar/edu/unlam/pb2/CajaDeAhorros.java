package ar.edu.unlam.pb2;

public class CajaDeAhorros extends CuentaSueldo {  //heredo clase padre
	
	private Integer costoAdicionalLuegoDeQuintaExtraccion;
	
	
	public CajaDeAhorros (String nombre, Double saldo,  Integer dni, Integer costoAdicionalLuegoDeQuintaExtraccion)
	{
		super(nombre, saldo, dni);
		this.costoAdicionalLuegoDeQuintaExtraccion = costoAdicionalLuegoDeQuintaExtraccion;
	}

	
	public Integer getCostoAdicionalLuegoDeQuintaExtraccion() {
		return costoAdicionalLuegoDeQuintaExtraccion;
	}

	public void setCostoAdicionalLuegoDeQuintaExtraccion(Integer costoAdicionalLuegoDeQuintaExtraccion) {
		this.costoAdicionalLuegoDeQuintaExtraccion = costoAdicionalLuegoDeQuintaExtraccion;
	}

	
	@Override
	public void extraer (Double dineroExtraido)
	{
	
		if (super.contarCantidadDeExtracciones().equals(5))
		{	
			super.setSaldo((getSaldo() - dineroExtraido) - this.costoAdicionalLuegoDeQuintaExtraccion);
		}
		
		else
		{
			super.setSaldo(getSaldo() - dineroExtraido);
		}
		
	}

}






