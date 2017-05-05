package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaBancaria {

	@Test
	public void testQueCreaUnaCuentaSueldo() //OK
	{
		CuentaSueldo miCuentaSueldo = new CuentaSueldo ("Pepe", 50.0, 12345678);
		assertEquals(miCuentaSueldo.getDni(), 12345678, 0.0);
	}
	
	@Test
	public void testQueDepositaDineroEnCuentaSueldo() //OK
	{
		CuentaSueldo miCuentaSueldo = new CuentaSueldo ("Pepe", 2.0, 12345678);
		miCuentaSueldo.depositar(150.0);
		assertEquals(miCuentaSueldo.getSaldo(), 152.0, 0.0);
	}
	
	@Test
	public void testQueExtraeDineroEnCuentaSueldo() //OK
	{
		CuentaSueldo miCuentaSueldo = new CuentaSueldo ("Pepe", 100.0, 12345678);
		miCuentaSueldo.extraer(50.5);
		assertEquals(miCuentaSueldo.getSaldo(), 49.5, 0.0);
	}
	
	@Test
	public void testQueNoSePuedeExtraerImporteDeDineroMayorAlDelSaldo() //OK
	{
		CuentaSueldo miCuentaSueldo = new CuentaSueldo ("Pepe", 100.0, 12345678);
		miCuentaSueldo.extraer(150.0);
		miCuentaSueldo.extraer(8.0);
		assertEquals(miCuentaSueldo.getSaldo(), 92.0, 0.0);
	}
	
	@Test
	public void testQueDepositaYExtraeDineroEnCuentaSueldo() //OK
	{
		CuentaSueldo miCuentaSueldo = new CuentaSueldo ("Pepe", 0.0, 12345678); 			//la cuenta sueldo tiene 0 de saldo
		miCuentaSueldo.depositar(560.0);			 // se le deposita $560 a la cuenta sueldo
		miCuentaSueldo.extraer(120.5); 			// ahora se le extrae $120.5 al saldo
		assertEquals(miCuentaSueldo.getSaldo(), 439.5, 0.0); 			//verifico
	}
	
	@Test
	public void testQueDepositaDineroEnCajaDeAhorros()    //OK
	{
		CajaDeAhorros miCajaDeAhorros = new CajaDeAhorros ("Pepe", 2.0, 12345678, 6);
		miCajaDeAhorros.depositar(150.0);
		assertEquals(miCajaDeAhorros.getSaldo(), 152.0, 0.0);
	}
	
	@Test
	public void testQueExtraeDineroEnCajaDeAhorros()     //OK
	{ 
		CajaDeAhorros miCajaDeAhorros = new CajaDeAhorros ("Pepe", 100.0, 12345678, 6);
		miCajaDeAhorros.extraer(10.0);
		assertEquals(miCajaDeAhorros.getSaldo(), 90.0, 0.0);
	}
	
	@Test
	public void testQueExtraeDineroConCostoAdicionalEnCajaDeAhorros()     //Anda pero no se descuenta el costo extra (problema en el contador)
	{ 
		CajaDeAhorros miCajaDeAhorros = new CajaDeAhorros ("Pepe", 100.0, 12345678, 6);
		miCajaDeAhorros.extraer(10.0);
		miCajaDeAhorros.extraer(10.0);
		miCajaDeAhorros.extraer(10.0);
		miCajaDeAhorros.extraer(10.0);
		miCajaDeAhorros.extraer(10.0);
		assertEquals(miCajaDeAhorros.getSaldo(), 50.0, 0.0);
	}
	
	
	@Test
	public void testeandoContador()   // el contador ya funciona
	{
		CuentaSueldo miCuentaSueldo = new CuentaSueldo ("Pepe", 100.0, 12345678);
		miCuentaSueldo.extraer(10.0);
		miCuentaSueldo.extraer(10.0); 
		miCuentaSueldo.extraer(10.0);
		miCuentaSueldo.extraer(10.0); 
		assertEquals(miCuentaSueldo.mostrarCantidadDeExtraccionesEfectuadas(), 4, 0.0); 
		
	}
	
	
}
