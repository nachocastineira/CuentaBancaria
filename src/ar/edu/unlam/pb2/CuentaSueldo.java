package ar.edu.unlam.pb2;

public class CuentaSueldo {
	
		private String nombre;
		private Double saldo;
		private Integer dni;
		private Integer operacionDeExtracionEfectuada = 0; // variable para el contador

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
	if(dineroExtraido<=saldo)   //solo se extrae si el valor de la extraccion es menor al saldo disponible
   {
		saldo = saldo - dineroExtraido;
		this.operacionDeExtracionEfectuada++; // si la operacion es exitosa el contador subirá de 1 en 1
	}
	
}

		
public void depositar(Double dineroDepositado)
	{
		saldo = saldo + dineroDepositado;
	}

	
public Integer mostrarCantidadDeExtraccionesEfectuadas()   //devuelvo la cantidad de operaciones exitosas
		{
		return this.operacionDeExtracionEfectuada;
	}
		
	
		
}
