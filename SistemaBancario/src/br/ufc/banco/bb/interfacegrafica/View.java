package br.ufc.banco.bb.interfacegrafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
//import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextField;

import br.ufc.banco.bb.interfacegrafica.MyJLabelVersion; // Minha versão de JLabel....

@SuppressWarnings("serial")
public class View extends JFrame {

  private JButton criarConta;
  private JButton fazerDeposito;
  private JButton realizarSaque;
  private JButton transferencia;
  private JButton visualizarSaldo;
  private JButton removerConta;
  private JButton renderJuros;
  private JButton renderBonus;


  private static Font mainFont = new Font("Serif", Font.BOLD, 15);



  public View() {

    super("Banco Gambioso");
    Container container = getContentPane();

    JPanel centro = new JPanel();
    JPanel east = new JPanel();
    east = getBotoes();
    centro = getMainScream();


    container.setLayout(new BorderLayout());
    container.add(BorderLayout.CENTER, centro);
    container.add(BorderLayout.EAST, east);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 500);
    setVisible(true);
    setLocationRelativeTo(null);
  }

  public JPanel getBotoes() {

    JPanel container2 = new JPanel();
    container2.setLayout(new GridLayout(8, 1));
    criarConta = new JButton("Criar Conta");
    criarConta.setFont(mainFont);

    container2.add(criarConta);
    fazerDeposito = new JButton("Fazer Depósito");
    fazerDeposito.setFont(mainFont);

    container2.add(fazerDeposito);
    realizarSaque = new JButton("Realizar Saque");
    realizarSaque.setFont(mainFont);

    container2.add(realizarSaque);
    transferencia = new JButton("Transferência");
    transferencia.setFont(mainFont);

    container2.add(transferencia);
    visualizarSaldo = new JButton("Visualizar Saldo");
    visualizarSaldo.setFont(mainFont);

    container2.add(visualizarSaldo);
    removerConta = new JButton("Remover Conta");
    removerConta.setFont(mainFont);

    container2.add(removerConta);
    renderJuros = new JButton("Render Juros");
    renderJuros.setFont(mainFont);

    container2.add(renderJuros);
    renderBonus = new JButton("Render Bonus");
    renderBonus.setFont(mainFont);

    container2.add(renderBonus);
    return container2;
  }


  public JPanel getMainScream() {

    String text = "================================";
    String line = "Bem Vindo ao Banco do Brasil";
    String line1 = "Terminal de Auto-Atendimento";
    String line2 = " [1] Cadastrar Conta";
    String line3 = " [2] Fazer Depósito";
    String line4 = " [3] Realizar Saque";
    String line5 = " [4] Transferência";
    String line6 = " [5] Visualizar Saldo";
    String line7 = " [6] Remover Conta";
    String line8 = " [7] Render Juros";
    String line9 = " [8] Render Bonus";
    String line10 = " [9] Sair";
    String line11 = "Digite o Botão com a opção desejada: ";

    JPanel TelaPrincipal = new JPanel();

    TelaPrincipal.setLayout(new GridLayout(20, 1, 0, 0));
    TelaPrincipal.add(new MyJLabelVersion(text, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line1, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(text, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line2, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line3, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line4, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line5, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line6, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line7, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line8, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line9, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line10, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line11, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(text, mainFont));
    TelaPrincipal.add(new MyJLabelVersion("Sua segurança está garantida usando o Banco do Gambioso,", mainFont));
    TelaPrincipal.add(
        new MyJLabelVersion("pois temos o melhor algoritmo com altíssimo nível de gambiosidade", mainFont));

    return TelaPrincipal;
  }

  public Font getMainFont() {
    return mainFont;
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
