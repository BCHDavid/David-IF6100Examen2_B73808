package cr.go.ucr.test;

import static org.junit.jupiter.api.Assertions.*;
import cr.go.ucr.OperacionAritmetica;
import cr.go.ucr.operaciones.Division;
import cr.go.ucr.operaciones.Resta;

class Test {

	OperacionAritmetica context;

	//Primero valida que no haya negativos entre los valores
	@org.junit.jupiter.api.Test
	void valorNegativo() {
		context = new OperacionAritmetica( new Resta() );
		assertEquals(context.procesar(-1, 21), -1);
	}
	
	//Segundo valida que el primer dato no sea menor que el segundo porque sino daria negativo y no es permitido
	@org.junit.jupiter.api.Test
	void valorPrimeroMayorQueSegundo() {
		context = new OperacionAritmetica( new Resta() );
		assertEquals(context.procesar(20, 30), -2);
	}
	
	//No se permite 0 como divisor
	@org.junit.jupiter.api.Test
	void valorCeroDivisor() {
		context = new OperacionAritmetica( new Division() );
		assertEquals(context.procesar(20, 0), -3);
	}

	//Estas 3 serian utilizando valores contrarios con el NotEquals
	@org.junit.jupiter.api.Test
	void valorNoCeroDivisor() {
		context = new OperacionAritmetica( new Division() );
		assertNotEquals(context.procesar(20, 2), -3);
	}
	
	@org.junit.jupiter.api.Test
	void SinValorNegativo() {
		context = new OperacionAritmetica( new Resta() );
		assertNotEquals(context.procesar(221, 21), -1);
	}
	
	@org.junit.jupiter.api.Test
	void valorPrimeroMayorQueSegundoNotEquals() {
		context = new OperacionAritmetica( new Resta() );
		assertNotEquals(context.procesar(50, 30), -2);
	}
}
