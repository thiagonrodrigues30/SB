package br.ufc.banco.bb;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import br.ufc.banco.bb.excecoes.TCIException;
import br.ufc.banco.bb.excecoes.TNRException;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.conta.ContaEspecial;
import br.ufc.banco.conta.ContaPoupanca;
import br.ufc.banco.conta.excecoes.SIException;
import br.ufc.banco.dados.ArrayContas;
import br.ufc.banco.dados.IRepositorioContas;
import br.ufc.banco.dados.VectorContas;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class BancoBrasil {

	private IRepositorioContas repositorio = null;

	private double taxa = 0.001;

	public BancoBrasil(IRepositorioContas repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(ContaAbstrata conta) throws CEException {
		this.repositorio.inserir(conta);
		repositorio.serializaConta("Conta.ser");
	}

	public void remover(String numero) throws CIException {
		this.repositorio.apagar(numero);
		repositorio.serializaConta("Conta.ser");
	}

	public void creditar(String numConta, double valor) throws TNRException {
		ContaAbstrata conta = this.repositorio.procurar(numConta);
		if (conta != null) {
			conta.creditar(valor);
			repositorio.serializaConta("Conta.ser");
		} else {
			throw new TNRException(new CIException(numConta));
		}

	}

	public void debitar(String numConta, double valor) throws TNRException {
		ContaAbstrata conta = this.repositorio.procurar(numConta);
		if (conta != null) {
			try {
				conta.debitar(valor);
				repositorio.serializaConta("Conta.ser");
			} catch (SIException sie) {
				throw new TNRException(sie);
			}
		} else {
			throw new TNRException(new CIException(numConta));
		}
	}

	public double saldo(String numConta) throws TNRException {
		ContaAbstrata conta = this.repositorio.procurar(numConta);
		if (conta != null) {
			return conta.obterSaldo();
		} else {
			throw new TNRException(new CIException(numConta));
		}

	}

	public void transferir(String numOrigem, String numDestino, double valor)
			throws TNRException {
		ContaAbstrata contaOrigem = this.repositorio.procurar(numOrigem);
		if (contaOrigem != null) {
			ContaAbstrata contaDestino = this.repositorio.procurar(numDestino);
			if (contaDestino != null) {
				try {
					contaOrigem.debitar(valor);
					contaDestino.creditar(valor);
					repositorio.serializaConta("Conta.ser");
				} catch (SIException sie) {
					throw new TNRException(sie);
				}
			} else {
				throw new TNRException(new CIException(numDestino));
			}
		} else {
			throw new TNRException(new CIException(numOrigem));
		}

	}

	public void renderJuros(String numConta) throws TNRException {
		ContaAbstrata contaAuxiliar = this.repositorio.procurar(numConta);
		if (contaAuxiliar != null) {
			if (contaAuxiliar instanceof ContaPoupanca) {
				((ContaPoupanca) contaAuxiliar).rendeJuros(this.taxa);
				repositorio.serializaConta("Conta.ser");
			} else {
				throw new TNRException(new TCIException(numConta));
			}
		} else {
			throw new TNRException(new CIException(numConta));
		}
	}

	public void renderBonus(String numConta) throws TNRException {
		ContaAbstrata contaAuxiliar = this.repositorio.procurar(numConta);
		if (contaAuxiliar != null) {
			if (contaAuxiliar instanceof ContaEspecial) {
				((ContaEspecial) contaAuxiliar).rendeBonus();
				repositorio.serializaConta("Conta.ser");
			} else {
				throw new TNRException(new TCIException(numConta));
			}
		} else {
			throw new TNRException(new CIException(numConta));
		}
	}

	public int numeroContas() {
		return this.repositorio.numeroContas();
	}

	public double saldoTotal() {
		double saldo = 0;
		if (this.repositorio.numeroContas() > 0) {
			ContaAbstrata[] contas = this.repositorio.listar();
			for (int i = 0; i < contas.length; i++) {
				saldo += contas[i].obterSaldo();
			}
		}
		return saldo;
	}
	
	public void desserializaConta(String arquivo){
		try {
			FileInputStream fileIn = new FileInputStream(arquivo);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			if (this.repositorio instanceof ArrayContas){
				repositorio = (ArrayContas) objIn.readObject();
			}
			
			if (this.repositorio instanceof VectorContas){
				repositorio = (VectorContas) objIn.readObject();
				System.out.println("Conta desserializada com sucesso!");
			}
			
			fileIn.close();
			objIn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
