package br.ufc.banco.bb.interfacegrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterValueController {

	private EnterValue ev;
	private ActionListener actionListener;
	

	public EnterValueController(EnterValue ev) {
		this.ev = ev;
	}

	
	
	public void control() {

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				
			
			}
			
		};
		ev.getDone().addActionListener(actionListener);

	}
	

}
