package br.ufc.banco.bb.interfacegrafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class EnterValue extends JFrame{
	
	private JTextField conta;
	private JTextField valor;
	private JButton done;
	private static Font mainFont = new Font("Serif", Font.BOLD, 15);;
	
	public EnterValue(){
		
		super("Enter Data");
		
		JLabel title = new JLabel("Entrada");
		title.setFont(mainFont);
		JLabel numeroConta = new JLabel("Nº Conta:");
		numeroConta.setFont(mainFont);
		JLabel valorRS = new JLabel("R$:");
		valorRS.setFont(mainFont);
		
		
		
		
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(null);
		
		conta = new JTextField();
		conta.setFont(mainFont);
		valor = new JTextField();
		valor.setFont(mainFont);
		
		done = new JButton("Done");
		done.setFont(mainFont);
		done.setBounds(180,132,200,25);
		
		
		/* IN ORDER */
		title.setBounds(240, 10, 200, 30);
		numeroConta.setBounds(40,57,100,30);
		conta.setBounds(180, 60, 200, 25);
		valorRS.setBounds(70,97,80,30);
		valor.setBounds(180, 100, 200, 25);
		
		p.add(title);
		p.add(numeroConta);
		p.add(conta);
		p.add(valorRS);
		p.add(valor);
		p.add(done);
		c.add(BorderLayout.CENTER,p);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 200);
		setVisible(true);
		setResizable(false);
	}

	public JTextField getConta() {
		return conta;
	}
	public JButton getDone(){
		return done;
	}
	
	public void setConta(JTextField conta) {
		this.conta = conta;
	}

	public JTextField getValor() {
		return valor;
	}

	public void setValor(JTextField valor) {
		this.valor = valor;
	}
	

}

