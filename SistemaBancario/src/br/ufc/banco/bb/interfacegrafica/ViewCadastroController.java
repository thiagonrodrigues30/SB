package br.ufc.banco.bb.interfacegrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				
				EnterValue a = new EnterValue();
				EnterValueController vc = new EnterValueController(a);
				vc.control();

			}

		};
		viewCadastro.getBtComum().addActionListener(actionListener);
		viewCadastro.getBtEspecial().addActionListener(actionListener);
		viewCadastro.getBtImposto().addActionListener(actionListener);
		viewCadastro.getBtPoupanca().addActionListener(actionListener);
	}

	
	
	
}