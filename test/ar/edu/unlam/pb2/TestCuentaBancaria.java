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
	CajaDeAhorros miCajaDeAhorros = new CajaDeAhorros ("Pepe", 2.0, 12345678);
	miCajaDeAhorros.depositar(150.0);
	assertEquals(miCajaDeAhorros.getSaldo(), 152.0, 0.0);
}

@Test
public void testQueExtraeDineroEnCajaDeAhorros()     //OK
{ 
	CajaDeAhorros miCajaDeAhorros = new CajaDeAhorros ("Pepe", 100.0, 12345678);
	miCajaDeAhorros.extraer(10d);
	assertEquals(miCajaDeAhorros.getSaldo(), 90d, 0.0);
}

@Test
public void testQueExtraeDineroSinTenerSaldoEnCajaDeAhorros()     //OK
{ 
	CajaDeAhorros miCajaDeAhorros = new CajaDeAhorros ("Pepe", 100.0, 12345678);
	miCajaDeAhorros.extraer(300.0);
	assertEquals(miCajaDeAhorros.getSaldo(), 100.0, 0.0);  //el saldo es el mismo, no se extrae nada porque no tiene saldo suficiente
}

@Test
public void testQueExtraeDineroConCostoAdicionalEnCajaDeAhorros()     //se descuenta el costo  extra despues de la  5 extraccion
{ 
	CajaDeAhorros miCajaDeAhorros = new CajaDeAhorros ("Pepe", 100d, 12345678);
	miCajaDeAhorros.setCantidadMaximaDeExtraccionSinCostoExtra(4);
	miCajaDeAhorros.setCostoAdicionalLuegoDeQuintaExtraccion(5d);
	miCajaDeAhorros.extraer(10.0);  
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	assertEquals(miCajaDeAhorros.getSaldo(),  30d, 0);
}

@Test
public void testQueExtraeDineroConCostoAdicionalEnCajaDeAhorros2()     //se descuenta el costo  extra despues de la  5 extraccion
{ 
	CajaDeAhorros miCajaDeAhorros = new CajaDeAhorros ("Pepe", 100d, 12345678);
	miCajaDeAhorros.setCantidadMaximaDeExtraccionSinCostoExtra(5);
	miCajaDeAhorros.setCostoAdicionalLuegoDeQuintaExtraccion(6d);
	miCajaDeAhorros.extraer(10.0);  
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	miCajaDeAhorros.extraer(10.0);
	assertEquals(miCajaDeAhorros.getSaldo(),  18d, 0 );
}


@Test
public void testExtraDineroConSobregiroEnCuentaCorriente()
{
	CuentaCorriente  miCuentaCorriente = new CuentaCorriente ("Pepe", 100d, 12345, 1.05 , 0d); //(nombre, saldo, dni, comisionExtra, sobregiro) 
	miCuentaCorriente.depositar(100d);
	miCuentaCorriente.setSobregiro(100d);
	miCuentaCorriente.extraer(250d);
//	miCuentaCorriente.extraer(55d);  //poner limite al sobregiro
	assertEquals(miCuentaCorriente.getSaldo(), -52.5, 0d); //el saldo ya pasara a estar en negativo por el sobregiro utilizado + interes
	assertEquals(miCuentaCorriente.getSobregiro(), -52.5, 0d); //me muestra el negativo del sobregiro, es lo debe el cliente
}

@Test
public void testExtraDineroSinSobregiroEnCuentaCorriente()
{
	CuentaCorriente  miCuentaCorriente = new CuentaCorriente ("Pepe", 100d, 12345, 1d, 1d);
	miCuentaCorriente.depositar(100d);
	miCuentaCorriente.extraer(101d);
	assertEquals(miCuentaCorriente.getSaldo(), 99d, 0d); 
}

	





}
