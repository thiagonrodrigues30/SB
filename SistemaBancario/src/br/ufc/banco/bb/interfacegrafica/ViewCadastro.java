package br.ufc.banco.bb.interfacegrafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewCadastro extends JFrame {

  private JButton BtComum;
  private JButton BtImposto;
  private JButton BtPoupanca;
  private JButton BtEspecial;
  private JButton BtMenuInicial;

  private static Font mainFont = new Font("Serif", Font.BOLD, 15);

  public ViewCadastro() {

    super("Banco Gambioso");
    Container container = getContentPane();

    JPanel centro = new JPanel();
    JPanel east = new JPanel();

    east = getBotoesCadastro();
    centro = getMainScream();


    container.setLayout(new BorderLayout());
    container.add(BorderLayout.CENTER, centro);
    container.add(BorderLayout.EAST, east);


    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 500);
    setVisible(true);
    setLocationRelativeTo(null);
  }

  public JPanel getBotoesCadastro(){

    JPanel cadastro = new JPanel();
    cadastro.setLayout(new GridLayout(5, 1));

    BtComum = new JButton("Comum");
    BtComum.setFont(mainFont);
    BtImposto = new JButton("Imposto");
    BtImposto.setFont(mainFont);
    BtEspecial = new JButton("Especial");
    BtEspecial.setFont(mainFont);
    BtPoupanca = new JButton("Poupanca");
    BtPoupanca.setFont(mainFont);
    BtMenuInicial = new JButton("<<");
    BtMenuInicial.setFont(mainFont);


    cadastro.add(BtComum);
    cadastro.add(BtEspecial);
    cadastro.add(BtPoupanca);
    cadastro.add(BtImposto);
    cadastro.add(BtMenuInicial);
    return cadastro;
  }

  public JPanel getMainScream() {

    String text = "================================";
    String line = "Cadastrar Conta";
    String line1 = " [1] Comum";
    String line2 = " [2] Especial";
    String line3 = " [3] Poupanca";
    String line4 = " [4] Imposto";
    String line11 = "Digite o Botão com a opção desejada: ";

    JPanel TelaPrincipal = new JPanel();

    TelaPrincipal.setLayout(new GridLayout(11, 1, 0, 0));
    TelaPrincipal.add(new MyJLabelVersion(text, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(text, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line1, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line2, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line3, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line4, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(text, mainFont));
    TelaPrincipal.add(new MyJLabelVersion(line11, mainFont));
    TelaPrincipal.add(new MyJLabelVersion("Sua segurança está garantida usando o Banco do Gambioso,", mainFont));
    TelaPrincipal.add(
        new MyJLabelVersion("pois temos o melhor algoritmo com altíssimo nível de gambiosidade", mainFont));

    return TelaPrincipal;
  }
  public JButton getBtMenuIncial() {
    return BtMenuInicial;
  }

  public JButton getBtComum() {
    return BtComum;
  }

  public JButton getBtImposto() {
    return BtImposto;
  }

  public JButton getBtPoupanca() {
    return BtPoupanca;
  }

  public JButton getBtEspecial() {
    return BtEspecial;
  }

  public static Font getMainFont() {
    return mainFont;
  }

}
