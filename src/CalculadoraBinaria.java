import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField Error = new JTextField(10);

	public CalculadoraBinaria() {

		super("Calculadora IP Binaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 300);

		setTextIpDecimal();
		setTextBi();
		setTextMascara();
		setTextXarxaBinari();

		// Decimal
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

		// Binari
		JPanel panelBinari = new JPanel();
		panelBinari.setLayout(new FlowLayout());
		panelBinari.add(ipBinari[1]);
		panelBinari.add(new JLabel("."));
		panelBinari.add(ipBinari[2]);
		panelBinari.add(new JLabel("."));
		panelBinari.add(ipBinari[3]);
		panelBinari.add(new JLabel("."));
		panelBinari.add(ipBinari[4]);

		// Mascara Binari
		JPanel panelSubred = new JPanel();
		panelSubred.setLayout(new FlowLayout());
		panelSubred.add(ipMasBinari[1]);
		panelSubred.add(new JLabel("."));
		panelSubred.add(ipMasBinari[2]);
		panelSubred.add(new JLabel("."));
		panelSubred.add(ipMasBinari[3]);
		panelSubred.add(new JLabel("."));
		panelSubred.add(ipMasBinari[4]);

		// XarxaBinari
		JPanel panelRed = new JPanel();
		panelRed.setLayout(new FlowLayout());
		panelRed.add(xarxaBinari[1]);
		panelRed.add(new JLabel("."));
		panelRed.add(xarxaBinari[2]);
		panelRed.add(new JLabel("."));
		panelRed.add(xarxaBinari[3]);
		panelRed.add(new JLabel("."));
		panelRed.add(xarxaBinari[4]);

		// Grid organizat
		JPanel panelDatos = new JPanel();
		GridLayout gl = new GridLayout(5, 2);
		panelDatos.setLayout(gl);
		panelDatos.add(new JLabel("IP Decimal: "));
		panelDatos.add(panelIP);
		panelDatos.add(new JLabel("IP Binaria: "));
		panelDatos.add(panelBinari);
		panelDatos.add(new JLabel("Mascara Subred: "));
		panelDatos.add(panelSubred);
		panelDatos.add(new JLabel("Red: "));
		panelDatos.add(panelRed);
		Error.setEditable(false);
		panelDatos.add(Error);

		// Boto de calcular
		JButton boton = new JButton("Calcular");
		boton.setBounds(10, 10, 10, 10);
		boton.addActionListener(new EventBoto());

		// Panell Sud
		JPanel panelSud = new JPanel();
		panelSud.setLayout(new FlowLayout());
		panelSud.add(boton);

		Container cp = getContentPane();
		cp.add(panelDatos, BorderLayout.CENTER);
		cp.add(panelSud, BorderLayout.SOUTH);

	}

	public class EventBoto implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			int a = 0;
			boolean errors = false;
			int mascara = 0;

			for (int i = 1; i < ipDecimal.length; i++) {

				if (ipDecimal[i].getText().isEmpty() || ipMascara.getText().isEmpty()) {
					Error.setText("Hi ha algun camp buit");
					errors = true;

				} else if (!isNumero(ipDecimal[i].getText().toString())) {
					Error.setText("Algun camp de la ip no te numeros");
					errors = true;
					
				}else {
					a = Integer.parseInt(ipDecimal[i].getText());
					mascara = Integer.parseInt(ipMascara.getText());
					
				}

				if (a > 255 || a < 0) {
					Error.setText("La Ip no es correcte");
					errors = true;

				} else if (mascara > 32 || mascara < 0) {
					Error.setText("La mascara no es correcte");
					errors = true;

				}

			}

			if (errors == false) {
				calcularIP();
				calcularMascara();
				calcularXarxa();
				Error.setText("");
			} else {
				for (int i = 1; i < 5; i++) {
					ipBinari[i].setText("");
					ipMasBinari[i].setText("");
					xarxaBinari[i].setText("");
				}
			}

		}

	}

	public void calcularIP() {
		int a, operador;
		String intString = "", provisional = "";

		for (int i = 1; i < ipDecimal.length; i++) {

			intString = "";
			a = Integer.parseInt(ipDecimal[i].getText());

			do {
				operador = a % 2;
				intString = operador + intString;
				a = a / 2;
			} while (a > 0);

			while (intString.length() <= 7) {
				intString = "0" + intString;
			}

			StringBuilder sb = new StringBuilder(provisional);
			sb.reverse();

			ipBinari[i].setText(intString);
		}

	}

	public void calcularMascara() {
		int a = 0, operador;
		String intString = "";
		int mascara = Integer.parseInt(ipMascara.getText());

		for (int i = 0; i < mascara; i++) {

			intString = "";
			do {
				operador = a % 2;
				intString = operador + intString;
				a = a / 2;
			} while (a > 0);

			intString = "1";

			for (i = 1; i < mascara; i++) {
				intString = intString + "1";
			}

			do {
				intString = intString + "0";
			} while (intString.length() < 32);

		}

		for (int j = 1; j <= 4; j++) {
			ipMasBinari[j].setText(intString.substring((j - 1) * 8, (j - 1) * 8 + 8));
		}

	}

	public void calcularXarxa() {
		for (int i = 1; i <= 4; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 8; j++) {
				ipMasBinari[i].getText().substring(j, j + 1);

				if (ipMasBinari[i].getText().substring(j, j + 1).equals("1")) {
					sb.append(ipBinari[i].getText().substring(j, j + 1));
				} else {
					sb.append("0");
				}
			}
			xarxaBinari[i].setText(sb.toString());
		}
	}

	private static boolean isNumero(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void setTextIpDecimal() {
		for (int i = 1; i < 5; i++) {
			ipDecimal[i] = new JTextField(3);
		}
	}

	private void setTextBi() {
		for (int i = 1; i < 5; i++) {
			ipBinari[i] = new JTextField(8);
			ipBinari[i].setEditable(false);
		}
	}

	private void setTextMascara() {
		for (int i = 1; i < 5; i++) {
			ipMasBinari[i] = new JTextField(8);
			ipMasBinari[i].setEditable(false);
		}
	}

	private void setTextXarxaBinari() {
		for (int i = 1; i < 5; i++) {
			xarxaBinari[i] = new JTextField(8);
			xarxaBinari[i].setEditable(false);
		}
	}
}
