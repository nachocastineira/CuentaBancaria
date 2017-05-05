package ar.edu.unlam.pb2;

public class CajaDeAhorros extends CuentaSueldo {  //heredo clase padre
	
	private Integer costoAdicionalLuegoDeQuintaExtraccion = 0;
	
	
	public CajaDeAhorros (String nombre, Double saldo,  Integer dni)
	{
		super(nombre, saldo, dni);
	}

	
	public Integer getCostoAdicionalLuegoDeQuintaExtraccion() {
		return costoAdicionalLuegoDeQuintaExtraccion;
	}

	public void setCostoAdicionalLuegoDeQuintaExtraccion(Integer costoAdicionalLuegoDeQuintaExtraccion) {
		this.costoAdicionalLuegoDeQuintaExtraccion = costoAdicionalLuegoDeQuintaExtraccion;
	}

	
	@Override
	public void extraer (Double dineroExtraido) //CORREGIRLO, NO FUNCIONA BIEN LA SOBREESCRITURA
	{
		if (dineroExtraido<super.getSaldo())  //solo se extrae si el valor de la extraccion es menor al saldo disponible
		{
			if (super.mostrarCantidadDeExtraccionesEfectuadas().equals(5))
				{	
		//			super.setSaldo((getSaldo() - dineroExtraido) - (getCostoAdicionalLuegoDeQuintaExtraccion()));
					super.setSaldo((getSaldo() - dineroExtraido) - this.costoAdicionalLuegoDeQuintaExtraccion);
				}
		
			else
				{
					super.setSaldo(getSaldo() - dineroExtraido);
				}
		}		
	}
	

}






