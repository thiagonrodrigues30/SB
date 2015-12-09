package br.ufc.banco.bb.interfacegrafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View extends JFrame{

  private JButton criarConta;
  private JButton fazerDeposito;
  private JButton realizarSaque;
  private JButton transferencia;
  private JButton visualizarSaldo;
  private JButton removerConta;
  private JButton renderJuros;
  private JButton renderBonus;


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

    criarConta = new JButton("Criar Conta");
    container2.add(criarConta);
    fazerDeposito = new JButton("Fazer Depósito");
    container2.add(fazerDeposito);
    realizarSaque = new JButton("Realizar Saque");
    container2.add(realizarSaque);
    transferencia = new JButton("Transferência");
    container2.add(transferencia);
    visualizarSaldo = new JButton("Visualizar Saldo");
    container2.add(visualizarSaldo);
    removerConta = new JButton("Remover Conta");
    container2.add(removerConta);
    renderJuros = new JButton("Render Juros");
    container2.add(renderJuros);
    renderBonus = new JButton("Render Bonus");
    container2.add(renderBonus);



    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(700,500);
    setVisible(true);
  }


  public JButton getCriarConta() {
    return criarConta;
  }


  public JButton getFazerDeposito() {
    return fazerDeposito;
  }


  public JButton getRealizarSaque() {
    return realizarSaque;
  }


  public JButton getTransferencia() {
    return transferencia;
  }


  public JButton getVisualizarSaldo() {
    return visualizarSaldo;
  }


  public JButton getRemoverConta() {
    return removerConta;
  }


  public JButton getRenderJuros() {
    return renderJuros;
  }


  public JButton getRenderBonus() {
    return renderBonus;
  }

}
