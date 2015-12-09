package br.ufc.banco.dados;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.conta.excecoes.SIException;
import br.ufc.banco.dados.VectorContas;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;


public class VectorContasTest {

	Conta conta;
	VectorContas vector;
	
	@Before
	public void setUp() throws Exception {
		conta = new Conta("1");
		vector = new VectorContas();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserirInexist() {
		int nContas = vector.numeroContas();
		
		try {
			vector.inserir(conta);
		} catch (CEException e) {
			fail("Conta existente");
		}
		
		nContas++;
		assertEquals(nContas, vector.numeroContas(), 0);
	}
	
	@Test(expected = CEException.class)
	public void testInserirExist() throws CEException {
		vector.inserir(conta);
		vector.inserir(conta);
	}
	
	@Test
	public void testApagarExist() {
		try {
			vector.inserir(conta);
		} catch (CEException e) {
			fail("Conta já existente");
		}
		int nContas = vector.numeroContas();
		try {
			vector.apagar("1");
		} catch (CIException e) {
			fail("Conta não existente ao apagar");
		}
		nContas--;
		assertEquals(nContas, vector.numeroContas(), 0);
	}
	
	@Test(expected = CIException.class)
	public void testApagarInexist() throws CIException {
		vector.apagar("1");
	}

	@Test
	public void testProcurarExist() {
		try {
			vector.inserir(conta);
		} catch (CEException e) {
			fail("Conta já existente");
		}
		
		assertEquals(conta, vector.procurar("1"));
	}
	
	@Test
	public void testProcurarInexist() {
		assertEquals(null, vector.procurar("1"));
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
			vector.inserir(conta1);
			vector.inserir(conta2);
			vector.inserir(conta3);
		} catch (CEException e) {
			fail("Alguma das contas já existe");
		}
		
		assertArrayEquals(vecAbs, vector.listar());
	}

}
