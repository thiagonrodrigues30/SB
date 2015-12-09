package br.ufc.banco.conta;

import br.ufc.banco.conta.excecoes.SIException;

/*	Definição
 * O método debitar(double valor) da classe ContaImposto 
 * não está observando o caso excepcional de 
 * saldo insuficiente. Corrija esse bug!
 * */


public class ContaImposto extends ContaAbstrata {

	public ContaImposto(String numero) {
		super(numero);
	}

	/*
	 * 	Para resolver a questão de saldo insuficiente teríamos que
	 * 	verificar se a conta chegou a 0, ou seja, não pode-se tirar
	 *  mais do que se tem, assim temos que fazer uma verificação
	 *  para que se a debitação chegar a um valor negativo, não seja
	 *  completada esta operação.
	 *  
	 * */
	
	public void debitar(double valor) throws SIException{
		
		if (this.saldo >= (valor + (valor * 0.001))) {
			this.saldo = this.saldo - (valor + (valor * 0.001));
		} else {
			throw new SIException(numero, valor);
		}
			
	}
}
