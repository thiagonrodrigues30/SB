package br.ufc.banco.bb.interfacegrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.bb.excecoes.TNRException;
import br.ufc.banco.dados.VectorContas;
import br.ufc.banco.dados.excecoes.CIException;


public class ViewController {

	private View view;
	private ActionListener actionListener;
	public static BancoBrasil banco = new BancoBrasil(new VectorContas());
	private String numero;


	public ViewController(View v){
		this.view=v;

	}

	public void control(){

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				if(e.getSource()==view.getCriarConta()){
					view.dispose();
					ViewCadastro vc = new ViewCadastro();
					ViewCadastroController vcc = new ViewCadastroController(vc);
					vcc.control();
				}else if(e.getSource()==view.getFazerDeposito()){
					CreditarValue a = new CreditarValue();
					CreditarValueController vc = new CreditarValueController(a);
					vc.control();
				}else if(e.getSource()==view.getRealizarSaque()){
					DebitarValue a = new DebitarValue();
					DebitarValueController vc = new DebitarValueController(a);
					vc.control();
				}else if(e.getSource()==view.getVisualizarSaldo()){

					numero = JOptionPane.showInputDialog("Número da conta.");
					try{
						JOptionPane.showMessageDialog(null, "Conta: "+
					numero+"\nR$ "+banco.saldo(numero));
					//confirmOperation();// supondo que clicou ok e tal...
					}catch (TNRException tnre) {
						System.out.println();
						System.out.println("Erro: " + tnre.getMessage());
					}

				}else if(e.getSource()==view.getRemoverConta()){
					numero = JOptionPane.showInputDialog("Número da conta.");
					try {
						banco.remover(numero);
						confirmOperation();// supondo que clicou ok e tal...
					} catch (CIException cnee) {
						System.out.println("Erro: " + cnee.getMessage());
					}
				}else if(e.getSource()==view.getRenderJuros()){
					numero = JOptionPane.showInputDialog("Número da conta.");
					try {
						banco.renderJuros(numero);
						confirmOperation();// supondo que clicou ok e tal...
					} catch (TNRException tnre) {
						System.out.println("Erro: " + tnre.getMessage());
					}
				}else if(e.getSource()==view.getRenderBonus()){
					numero = JOptionPane.showInputDialog("Número da conta.");
					try {
						banco.renderBonus(numero);
						confirmOperation();// supondo que clicou ok e tal...
					} catch (TNRException tnre) {
						System.out.println("Erro: " + tnre.getMessage());
					}
				}else if(e.getSource()==view.getTransferencia()){
					String numeroOrigem = JOptionPane.showInputDialog("Número da conta Origem.");
					String numeroDestino = JOptionPane.showInputDialog("Número da conta Destino.");
					String valor = JOptionPane.showInputDialog("Valor a ser debitado.");

					double value=0;
					try{
						value = Double.parseDouble(valor);
					}catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Digite Números.. Please...");
						nfe.printStackTrace();
					}

					try {
						banco.transferir(numeroOrigem, numeroDestino, value);
						confirmOperation();
					} catch (TNRException tnre) {
						System.out.println("Erro: " + tnre.getMessage());
					}
				}



			}
		};
		view.getCriarConta().addActionListener(actionListener);
		view.getFazerDeposito().addActionListener(actionListener);
		view.getRealizarSaque().addActionListener(actionListener);
		view.getTransferencia().addActionListener(actionListener);
		view.getVisualizarSaldo().addActionListener(actionListener);
		view.getRemoverConta().addActionListener(actionListener);
		view.getRenderJuros().addActionListener(actionListener);
		view.getRenderBonus().addActionListener(actionListener);



	}

	public void confirmOperation(){
		JOptionPane.showMessageDialog(null, "Operação Realizada");
	}
	/*
	public static void main(String[] args){
		View v = new View();
		ViewController vc = new ViewController(v);
		vc.control();
	}*/


}
