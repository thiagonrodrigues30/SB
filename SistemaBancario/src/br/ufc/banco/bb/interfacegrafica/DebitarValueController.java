package br.ufc.banco.bb.interfacegrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.ufc.banco.bb.excecoes.TNRException;
import br.ufc.banco.bb.interfacegrafica.ViewController;

public class DebitarValueController {

	private DebitarValue ev;
	private ActionListener actionListener;

	public DebitarValueController(DebitarValue ev) {
		this.ev = ev;
	}

	// ESTA CLASSE SERVE APENAS PARA MOSTRAR AS JANELAS QUANDO FOR DEBITAR
	// ALGUM VALOR
	public void control() {

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String numero = ev.getConta().getText();
				double valor = 0;
				try {
					valor = Double.parseDouble(ev.getValor().getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Digite Números.. Please...");
					nfe.printStackTrace();
				}
				try {
					//*********** PRECISAVA????
					ViewController.banco.debitar(numero, valor);
					ev.dispose();
					JOptionPane.showMessageDialog(null, "Operação Realizada");
					
				} catch (TNRException tnre) {
					System.out.println("Erro: " + tnre.getMessage());
				}

			}

		};
		ev.getDone().addActionListener(actionListener);

	}
}
