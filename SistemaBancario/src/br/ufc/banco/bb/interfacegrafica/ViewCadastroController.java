package br.ufc.banco.bb.interfacegrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.conta.ContaEspecial;
import br.ufc.banco.conta.ContaImposto;
import br.ufc.banco.conta.ContaPoupanca;


public class ViewCadastroController {

	private ActionListener actionListener;
	private ViewCadastro viewCadastro;

	public ViewCadastroController(ViewCadastro vc) {
		this.viewCadastro = vc;

	}

	public void control() {

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ContaAbstrata conta = null;
				/*
				// CHAMADA PARA ENTER VALUE
				EnterValue a = new EnterValue();
				EnterValueController vc = new EnterValueController(a);
				vc.control();
				*/

				if(e.getSource()==viewCadastro.getBtComum()){

					String answers = JOptionPane.showInputDialog("Entre com o Número da Conta Comum");
					if(answers!=null){
						conta = new Conta(answers);
						confirmOperation();
					}else{cancelOperation();}

				}else if(e.getSource()==viewCadastro.getBtEspecial()){

					String answers = JOptionPane.showInputDialog("Entre com o Número da Conta Especial");
					if(answers!=null){
						conta = new ContaEspecial(answers);
						confirmOperation();
					}else{cancelOperation();}

				}else if(e.getSource()==viewCadastro.getBtImposto()){

					String answers = JOptionPane.showInputDialog("Entre com o Número da Conta Imposto");
					if(answers!=null){
						conta = new ContaImposto(answers);
						confirmOperation();
					}else{cancelOperation();}

				}else if(e.getSource()==viewCadastro.getBtPoupanca()){

					String answers = JOptionPane.showInputDialog("Entre com o Número da Conta Especial");
					if(answers!=null){
						conta = new ContaPoupanca(answers);
						confirmOperation();
					}else{cancelOperation();}
				}else if(e.getSource()==viewCadastro.getBtMenuIncial()){
					viewCadastro.dispose();
					//FUNCIONA CRIANDO UM NOVO OBJETO?
					View v = new View();
					ViewController vc = new ViewController(v);
					vc.control();
					//TAABB24H.vc.control(); // same Object
				}

			}

		};
		viewCadastro.getBtComum().addActionListener(actionListener);
		viewCadastro.getBtEspecial().addActionListener(actionListener);
		viewCadastro.getBtImposto().addActionListener(actionListener);
		viewCadastro.getBtPoupanca().addActionListener(actionListener);
		viewCadastro.getBtMenuIncial().addActionListener(actionListener);
	}

	public void confirmOperation(){
		JOptionPane.showMessageDialog(null, "Operação Realizada");
	}
	public void cancelOperation(){
		JOptionPane.showMessageDialog(null, "Operação Cancelada");
	}


}