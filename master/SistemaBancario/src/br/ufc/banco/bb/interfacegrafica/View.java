package br.ufc.banco.bb.interfacegrafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View extends JFrame{
	public View(){
		super ("Banco Gambioso");
		Container container = getContentPane();
		Container container2 = new JPanel();
		JLabel TelaPrincipal = new JLabel();
		
		
		container.setLayout(new BorderLayout());
		container.add(BorderLayout.CENTER, TelaPrincipal);
		container.add(BorderLayout.EAST,container2);
		container.add(BorderLayout.SOUTH, new JLabel("Sua segurança está garantida usando o Banco do Gambioso, pois temos o melhor algoritmo com altíssimo nível de gambiosidade"));
		
		container2.setLayout(new GridLayout(8,1));
		container2.add(new JButton("Criar conta"));
		container2.add(new JButton("Fazer depósito"));
		container2.add(new JButton("Realizar Saque"));
		container2.add(new JButton("Transferência"));
		container2.add(new JButton("Visualizar Saldo"));
		container2.add(new JButton("Remover Conta"));
		container2.add(new JButton("Render Juros"));
		container2.add(new JButton("Render Bonus"));
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,768);
		setVisible(true);
	}
	public static void main(String[] args) {
		new View();		
	}
}
