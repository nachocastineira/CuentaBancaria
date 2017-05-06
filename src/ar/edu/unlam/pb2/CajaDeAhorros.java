package ar.edu.unlam.pb2;

public class CajaDeAhorros extends CuentaSueldo {  //heredo clase padre
	
	private Integer costoAdicionalLuegoDeQuintaExtraccion = 0;
	private Integer cantidadMaximaDeExtraccionSinCostoExtra = 0;
	
	
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
		
	public Integer getCantidadMaximaDeExtraccionSinCostoExtra() {
		return cantidadMaximaDeExtraccionSinCostoExtra;
	}


	public void setCantidadMaximaDeExtraccionSinCostoExtra(
			Integer cantidadMaximaDeExtraccionSinCostoExtra) {
		this.cantidadMaximaDeExtraccionSinCostoExtra = cantidadMaximaDeExtraccionSinCostoExtra;
	}


	@Override
public void extraer (Double dineroExtraido) //CORREGIRLO, extrae el dinero pero no descuenta luego de la 5 extraccion  //¡¡no descuenta porque sobreescribi el contador!!
{
	if (dineroExtraido<=super.getSaldo())  //solo se extrae si el valor de la extracción es menor al saldo disponible
{

		if (super.mostrarCantidadDeExtraccionesEfectuadas()>=(this.cantidadMaximaDeExtraccionSinCostoExtra))
		{
			super.setSaldo((getSaldo() - dineroExtraido) - this.costoAdicionalLuegoDeQuintaExtraccion);
		}
		
	else
		{
			super.setSaldo(getSaldo() - dineroExtraido);
		}
}		
}
	

}






