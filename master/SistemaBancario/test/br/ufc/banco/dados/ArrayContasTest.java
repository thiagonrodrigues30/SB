package br.ufc.banco.dados;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class ArrayContasTest {

	Conta conta;
	ArrayContas array;
	
	@Before
	public void setUp() throws Exception {
		conta = new Conta("1");
		array = new ArrayContas();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserirInexist() {
		int nContas = array.numeroContas();
		
		try {
			array.inserir(conta);
		} catch (CEException e) {
			fail("Conta existente");
		}
		
		nContas++;
		assertEquals(nContas, array.numeroContas(), 0);
	}

	@Test(expected = CEException.class)
	public void testInserirExist() throws CEException {
		array.inserir(conta);
		array.inserir(conta);
	}
	
	@Test
	public void testApagarExist() {
		try {
			array.inserir(conta);
		} catch (CEException e) {
			fail("Conta já existente");
		}
		int nContas = array.numeroContas();
		try {
			array.apagar("1");
		} catch (CIException e) {
			fail("Conta não existente ao apagar");
		}
		nContas--;
		assertEquals(nContas, array.numeroContas(), 0);
	}
	
	@Test(expected = CIException.class)
	public void testApagarInexist() throws CIException {
		array.apagar("1");
	}
	
	@Test
	public void testProcurarExist() {
		try {
			array.inserir(conta);
		} catch (CEException e) {
			fail("Conta já existente");
		}
		
		assertEquals(conta, array.procurar("1"));
	}
	
	@Test
	public void testProcurarInexist() {
		assertEquals(null, array.procurar("1"));
	}
	
	@Test
	public void testListar() {
		Conta conta1 = new Conta("11");
		Conta conta2 = new Conta("22");
		Conta conta3 = new Conta("33");
		ContaAbstrata[] vecAbs = new ContaAbstrata[3];
		
		vecAbs[0] = conta1;
		vecAbs[1] = conta2;
		vecAbs[2] = conta3;
		
		try {
			array.inserir(conta1);
			array.inserir(conta2);
			array.inserir(conta3);
		} catch (CEException e) {
			fail("Alguma das contas já existe");
		}
		
		assertArrayEquals(vecAbs, array.listar());
	}
}
