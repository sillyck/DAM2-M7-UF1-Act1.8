import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraBinaria extends JFrame {

	public CalculadoraBinaria() {
		
		super("IP Clalculadora");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(800, 400);
		 
		 //Dreta
		 //Introduir IP
		 JPanel panelIP = new JPanel();
		 panelIP.setLayout(new FlowLayout());
		 panelIP.add(new JTextField(3));
		 panelIP.add(new JLabel("."));
		 panelIP.add(new JTextField(3));
		 panelIP.add(new JLabel("."));
		 panelIP.add(new JTextField(3));
		 panelIP.add(new JLabel("."));
		 panelIP.add(new JTextField(3));
		 panelIP.add(new JLabel("/"));
		 panelIP.add(new JTextField(3));
		 
		 //Binari
		 JPanel panelBinari = new JPanel();
		 panelBinari.setLayout(new FlowLayout());
		 panelBinari.add(new JTextField(8));
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(new JTextField(8));
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(new JTextField(8));
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(new JTextField(8));
		 panelBinari.add(new JLabel("/"));
		 panelBinari.add(new JTextField(8));
		 
		 //Mascara de Subred
		 JPanel panelSubred = new JPanel();
		 panelSubred.setLayout(new FlowLayout());
		 panelSubred.add(new JTextField(8));
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(new JTextField(8));
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(new JTextField(8));
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(new JTextField(8));
		 panelSubred.add(new JLabel("/"));
		 panelSubred.add(new JTextField(8));
		 
		 JPanel panelDatos = new JPanel();
		 GridLayout gl = new GridLayout(4,2,0,5);
		 panelDatos.setLayout(gl);
		 panelDatos.add(new JLabel("IP Decimal: "));
		 panelDatos.add(new JTextField(10));
		 panelDatos.add(new JLabel("IP Binaria: "));
		 panelDatos.add(new JTextField(10));
		 panelDatos.add(new JLabel("Mascara Subred: "));
		 panelDatos.add(new JTextField(10));
		 panelDatos.add(new JLabel("Red: "));
		 panelDatos.add(panelBinari);
		 panelDatos.add(panelSubred);	 
		 
		 Container cp = getContentPane();
		 cp.add(panelDatos, BorderLayout.NORTH);
	}
}
