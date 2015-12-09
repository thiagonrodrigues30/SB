package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.excecoes.SIException;

public class ContaImpostoTest {
	
	ContaImposto contaImposto;
	Double saldo;

	@Before
	public void setUp() throws Exception {
		contaImposto = new ContaImposto("4");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDebitarNormal() {
		contaImposto.creditar(20);
		saldo = contaImposto.obterSaldo();
		saldo = saldo - (10 + (10 * 0.001));
		try {
			contaImposto.debitar(10);
		} catch (SIException e) {
			System.out.println("Sem saldo para debitar");
		}
		assertEquals(saldo, contaImposto.obterSaldo(), 0);
	}
	
	@Test
	public void testDebitarNegativo() throws SIException {
		saldo = contaImposto.obterSaldo();
		contaImposto.debitar(-10);
		assertEquals(saldo, contaImposto.obterSaldo(), 0);
	}

}
