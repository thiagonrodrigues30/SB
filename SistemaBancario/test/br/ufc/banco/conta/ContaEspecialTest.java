package br.ufc.banco.conta;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContaEspecialTest {
	
	ContaEspecial contaEspecial;
	Double saldo;

	@Before
	public void setUp() throws Exception {
		contaEspecial = new ContaEspecial("2"); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreditarNormal() {
		saldo = contaEspecial.obterSaldo();
		saldo = saldo + 10;
		contaEspecial.creditar(10);
		assertEquals(saldo, contaEspecial.obterSaldo(), 0);
	}
	
	@Test
	public void testCreditarNegativo() {
		saldo = contaEspecial.obterSaldo();
		contaEspecial.creditar(-10);
		assertEquals(saldo, contaEspecial.obterSaldo(), 0);
	}

	@Test
	public void testBonusNormal() {
		saldo = contaEspecial.obterSaldo();
		saldo = saldo + 10;
		saldo = (saldo * 0.01);
		contaEspecial.creditar(10);
		assertEquals(saldo, contaEspecial.obterBonus() , 0);
	}
	
	@Test
	public void testBonusNegativo() {
		saldo = contaEspecial.obterBonus();
		contaEspecial.creditar(-10);
		assertEquals(saldo, contaEspecial.obterBonus() , 0);
	}
	
	@Test
	public void testRendeBonus() {
		saldo = contaEspecial.obterSaldo();
		saldo = saldo + 10;
		
		contaEspecial.creditar(10);
		saldo = saldo + contaEspecial.obterBonus();
		contaEspecial.rendeBonus();
		assertEquals(saldo, contaEspecial.obterSaldo() , 0);
	}

}

