package br.ufc.banco.dados;

import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayContas implements IRepositorioContas, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ContaAbstrata> contas = null; //Vetor começa sem nenhuma conta 
	
	public ArrayContas(){
		this.contas = new ArrayList<ContaAbstrata>();
	}
	

	public void apagar(String numero) throws CIException {
		ContaAbstrata conta = this.procurar(numero);
		if (conta != null) {
			this.contas.remove(conta);
		} else {
			throw new CIException(numero);
		}

	}
	public void inserir(ContaAbstrata conta) throws CEException {
		if (this.procurar(conta.obterNumero()) == null ){
			this.contas.add(conta);
		}
		else {
			throw new CEException(conta.obterNumero() + "já existente");
		}
	}

	public ContaAbstrata[] listar() {
		ContaAbstrata[] listaContaAbstrata = null;
		if (contas !=null){
			int i =0;
			listaContaAbstrata = new ContaAbstrata[this.contas.size()];
			for (ContaAbstrata c : contas){
				listaContaAbstrata[i] = c;
				i++;
			}
		}
	return listaContaAbstrata;
	}

	public int numeroContas() {
		return this.contas.size();
	}

	public ContaAbstrata procurar(String numero) {
		for (ContaAbstrata c : contas){
			if (c.obterNumero().equals(numero)){
				return c;
			}
			
		}
		return null;
	}
	
	public void serializaConta(String arquivo){
		try {
			FileOutputStream fileOut = new FileOutputStream(arquivo);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(this);
			System.out.println("A conta foi serializada com sucesso!");
			fileOut.close();
			objOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
