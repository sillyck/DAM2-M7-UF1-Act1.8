import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraBinaria extends JFrame {
	private JTextField[] ipDecimal = new JTextField[5];
	private JTextField ipMascara = new JTextField(3);
	private JTextField[] ipBinari = new JTextField[5];
	private JTextField[] ipMasBinari = new JTextField[5];
	private JTextField[] xarxaBinari = new JTextField[5];
	
	public CalculadoraBinaria() {
		
		super("IP Clalculadora");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(800, 400);
		 
		 //Decimal
		 JPanel panelIP = new JPanel();
		 panelIP.setLayout(new FlowLayout());
		 panelIP.add(ipDecimal[1]);
		 panelIP.add(new JLabel("."));
		 panelIP.add(ipDecimal[2]);
		 panelIP.add(new JLabel("."));
		 panelIP.add(ipDecimal[3]);
		 panelIP.add(new JLabel("."));
		 panelIP.add(ipDecimal[4]);
		 panelIP.add(new JLabel("/"));
		 panelIP.add(ipMascara);
		 
		 //Binari
		 JPanel panelBinari = new JPanel();
		 panelBinari.setLayout(new FlowLayout());
		 panelBinari.add(ipBinari[1]);
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(ipBinari[2]);
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(ipBinari[3]);
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(ipBinari[4]);
		 
		 //Mascara Binari
		 JPanel panelSubred = new JPanel();
		 panelSubred.setLayout(new FlowLayout());
		 panelSubred.add(ipMasBinari[1]);
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(ipMasBinari[2]);
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(ipMasBinari[3]);
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(ipMasBinari[4]);
		 
		 //XarxaBinari
		 JPanel panelRed = new JPanel();
		 panelRed.setLayout(new FlowLayout());
		 panelRed.add(xarxaBinari[1]);
		 panelRed.add(new JLabel("."));
		 panelRed.add(xarxaBinari[2]);
		 panelRed.add(new JLabel("."));
		 panelRed.add(xarxaBinari[3]);
		 panelRed.add(new JLabel("."));
		 panelRed.add(xarxaBinari[4]);
		 
		 //Grid organizat
		 JPanel panelDatos = new JPanel();
		 GridLayout gl = new GridLayout(4,2);
		 panelDatos.setLayout(gl);
		 panelDatos.add(new JLabel("IP Decimal: "));
		 panelDatos.add(panelIP);
		 panelDatos.add(new JLabel("IP Binaria: "));
		 panelDatos.add(panelBinari);
		 panelDatos.add(new JLabel("Mascara Subred: "));
		 panelDatos.add(panelSubred);
		 panelDatos.add(new JLabel("Red: "));
		 panelDatos.add(panelRed);
		 
		 //Boto de calcular
		 JButton boton = new JButton("Calcular");
		 boton.setBounds(100, 100, 100, 100);
		 
		 Container cp = getContentPane();
		 cp.add(panelDatos, BorderLayout.CENTER);
		 cp.add(boton, BorderLayout.SOUTH);
		 
	}
	
	private void setTextIpDecimal() {
		for(int i=1; i<5; i++) {
			ipDecimal[i] = new JTextField(3);
		}
	}
	
	private void setTextBi() {
		for(int i=1; i<5; i++) {
			ipBinari[i] = new JTextField(8);
			ipBinari[i].setEditable(false);
		}
	}
	
	private void setTextMascara() {
		for(int i=1; i<5; i++) {
			ipMasBinari[i] = new JTextField(8);
			ipMasBinari[i].setEditable(false);
		}
	}
	
	private void setTextXarxaBinari() {
		for(int i=1; i<5; i++) {
			xarxaBinari[i] = new JTextField(8);
			xarxaBinari[i].setEditable(false);
		}
	}
	
}
