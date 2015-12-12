package br.ufc.banco.bb.interfacegrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {

	private View view;
	private ActionListener actionListener;


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


	/*
	public static void main(String[] args){
		View v = new View();
		ViewController vc = new ViewController(v);
		vc.control();
	}*/


}
