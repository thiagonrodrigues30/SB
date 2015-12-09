package br.ufc.banco.conta;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContaPoupancaTest {

	ContaPoupanca contaPoupanca;
	Double saldo;
	
	@Before
	public void setUp() throws Exception {
		contaPoupanca = new ContaPoupanca("3");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRendeJuros() {
		saldo = contaPoupanca.obterSaldo();
		saldo = saldo + 10;
		saldo = saldo + (saldo * 0.02);
		
		contaPoupanca.creditar(10);
		contaPoupanca.rendeJuros(0.02);
		assertEquals(saldo, contaPoupanca.obterSaldo(), 0);
	}

}

