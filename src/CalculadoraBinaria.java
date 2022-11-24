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

	public CalculadoraBinaria() {
		
		super("IP Clalculadora");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(800, 400);
		 
		 //Introduir IP
		 JPanel panelIP = new JPanel();
		 panelIP.setLayout(new FlowLayout());
		 panelIP.add(new JTextField(4));
		 panelIP.add(new JLabel("."));
		 panelIP.add(new JTextField(4));
		 panelIP.add(new JLabel("."));
		 panelIP.add(new JTextField(4));
		 panelIP.add(new JLabel("."));
		 panelIP.add(new JTextField(4));
		 panelIP.add(new JLabel("/"));
		 panelIP.add(new JTextField(4));
		 
		 //Binari
		 JPanel panelBinari = new JPanel();
		 panelBinari.setLayout(new FlowLayout());
		 panelBinari.add(new JTextField(5));
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(new JTextField(5));
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(new JTextField(5));
		 panelBinari.add(new JLabel("."));
		 panelBinari.add(new JTextField(5));
		 
		 //Mascara de Subred
		 JPanel panelSubred = new JPanel();
		 panelSubred.setLayout(new FlowLayout());
		 panelSubred.add(new JTextField(5));
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(new JTextField(5));
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(new JTextField(5));
		 panelSubred.add(new JLabel("."));
		 panelSubred.add(new JTextField(5));
		 
		 //Mascara de Subred
		 JPanel panelRed = new JPanel();
		 panelRed.setLayout(new FlowLayout());
		 panelRed.add(new JTextField(5));
		 panelRed.add(new JLabel("."));
		 panelRed.add(new JTextField(5));
		 panelRed.add(new JLabel("."));
		 panelRed.add(new JTextField(5));
		 panelRed.add(new JLabel("."));
		 panelRed.add(new JTextField(5));
		 
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
	
	private void omplirTextFiled (JTextField[] array, Container cp) {
		
		for(int i=0; i<array.length; i++) {
			array[i] = new JTextField("");
			cp.add(array[i]);
			cp.add(new JLabel("."));
		}
	}
	
}
