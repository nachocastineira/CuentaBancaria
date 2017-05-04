package ar.edu.unlam.pb2;

public class CuentaSueldo {
	
		private String nombre;
		private Double saldo;
		private Integer dni;
		private Boolean operacionDeExtracionEfectuada = false;
		
							//constructores
		CuentaSueldo (String nombre, Double saldo,  Integer dni)
		{
			this.nombre = nombre;
			this.saldo = saldo;
			this.dni = dni;
		}

						//getters y setter
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		public Integer getDni() {
			return dni;
		}

		public void setDni(Integer dni) {
			this.dni = dni;
		}
		
					//metodos
		public void extraer(Double dineroExtraido)
		{	
			if(dineroExtraido<saldo)
			{
			saldo = saldo - dineroExtraido;
			operacionDeExtracionEfectuada = true;
			}
			else
			{
				saldo = saldo - 0;
				operacionDeExtracionEfectuada = false;
			}
		}
		
			
		public void depositar(Double dineroDepositado)
		{
			saldo = saldo + dineroDepositado;
		}

		
		public Integer contarCantidadDeExtracciones()  //CONTADOR NO FUNCIONA
		{
			Integer cantidadDeOperacionesExitosas = 0;
			 		
			if (this.operacionDeExtracionEfectuada.equals(true))
			{
				cantidadDeOperacionesExitosas++;
				return cantidadDeOperacionesExitosas;
			}
			else
			{
				return cantidadDeOperacionesExitosas;
			}
			
		}
		
}
