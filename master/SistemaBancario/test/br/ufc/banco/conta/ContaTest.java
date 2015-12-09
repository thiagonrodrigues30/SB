package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.excecoes.SIException;

public class ContaTest {
	
	Conta conta;
	double saldo;

	@Before
	public void setUp() throws Exception {
		conta = new Conta("1");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCreditarNormal() {
		saldo = conta.obterSaldo();
		saldo = saldo + 10;
		conta.creditar(10);
		assertEquals(saldo , conta.obterSaldo(), 0);
	}
	
	@Test
	public void testCreditarNegativo() {
		saldo = conta.obterSaldo();
		conta.creditar(-10);
		assertEquals(saldo , conta.obterSaldo(), 0);
	}

	@Test
	public void testDebitarNormal() {
		conta.creditar(10);
		saldo = conta.obterSaldo();
		saldo = saldo - 10;
		try {
			conta.debitar(10.0);
		} catch (SIException e) {
			System.out.println("Conta sem saldo para debitar.");
		}
		assertEquals(saldo , conta.obterSaldo(), 0);
	}

	@Test
	public void testDebitarNegativo() {		
		saldo = conta.obterSaldo();
		try {
			conta.debitar(-10);
		} catch (SIException e) {
			System.out.println("Conta sem saldo para debitar.");
		}
		assertEquals(saldo, conta.obterSaldo(), 0);
	}
	
	@Test(expected=SIException.class)
	public void testDebitarInexistente() throws SIException {	
		Conta conta2 = new Conta("11");
		conta2.debitar(10);
	}

}