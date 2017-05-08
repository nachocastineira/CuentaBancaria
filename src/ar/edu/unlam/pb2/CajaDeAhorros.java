package ar.edu.unlam.pb2;

public class CajaDeAhorros extends CuentaSueldo {  //heredo clase padre
	
		private Double costoAdicionalLuegoDeQuintaExtraccion = 0d;
		private Integer cantidadMaximaDeExtraccionSinCostoExtra = 0;
		private Integer extraccionesEfectuadas ;
	
	
	public CajaDeAhorros (String nombre, Double saldo,  Integer dni)
	{
		super(nombre, saldo, dni);
		this.extraccionesEfectuadas = 0;
	}
	
	
	public Double getCostoAdicionalLuegoDeQuintaExtraccion() {
		return costoAdicionalLuegoDeQuintaExtraccion;
	}

	public void setCostoAdicionalLuegoDeQuintaExtraccion(Double costoAdicionalLuegoDeQuintaExtraccion) {
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
public void extraer (Double dineroExtraido) 
{
	
	if (dineroExtraido<=super.getSaldo())  //solo se extrae si el valor de la extracción es menor al saldo disponible
{
			
		if (extraccionesEfectuadas<this.getCantidadMaximaDeExtraccionSinCostoExtra()) //le puedo setear la cantidad maxima de ext. sin costo extra
		{
			super.extraer(dineroExtraido);	
			extraccionesEfectuadas++;
		}
			
	else
			if (extraccionesEfectuadas>=this.getCantidadMaximaDeExtraccionSinCostoExtra())
			{
				super.setSaldo(super.getSaldo() - dineroExtraido - this.getCostoAdicionalLuegoDeQuintaExtraccion()); // le puedo setear costo extra
			}
}
}		
	
}







