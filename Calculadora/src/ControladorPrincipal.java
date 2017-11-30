import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author Miquel 
 * 21 nov. 2017
 */

public class ControladorPrincipal {
	
	private vista frame = new vista();
	private Operacion o = new Operacion(Double.NaN, Double.NaN, '\0', Double.NaN);
	
	Path p = Paths.get("D:\\Git\\LocalCalculadora\\Calculadora\\log.txt");
	String s = System.lineSeparator();

	public ControladorPrincipal () {	
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		
		try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
		    writer.write(s + dtf.format(now));
		} catch (IOException ioe) {
		    System.err.format("IOException: %s%n", ioe);
		}
		
		//updateResult();
		frame.setVisible(true);

		frame.btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o.Reset();
				frame.txtResult.setText("");
				frame.txtHistory.setText("");
			}
		});
		
		//Definicion funcionalidades botones numéricos
		frame.btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"0");
			}
		});
		frame.btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"1");
			}
		});
		frame.btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"2");
			}
		});
		frame.btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"3");
			}
		});
		frame.btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"4");
			}
		});
		frame.btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"5");
			}
		});
		frame.btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"6");
			}
		});
		frame.btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"7");
			}
		});
		frame.btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"8");
			}
		});
		frame.btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.txtResult.setText(frame.txtResult.getText()+"9");
			}
		});
	
		//Definicion funcionalidades botones de símbolos
		frame.btnComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.txtResult.setText(frame.txtResult.getText()+".");
			}
		});
		
		//Definición boton igual
		frame.btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o.setValor2(Double.parseDouble(frame.txtResult.getText()));
				if (!o.getValor1().isNaN() && !o.getValor2().isNaN()) {
					o.Calcular();
					insertarRegistro();
				}
				
				updateResult();
			}
		});
		
		//Botones operaciones básicas
		frame.btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					Operacion(e);
				} catch (Exception e2) {
					System.out.println("ERROR: Error al resolver el calculo" + o.getValor1()+o.getSymbol()+o.getValor2()+"="+o.getResult());
				}
			}
		});
		
		frame.btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Operacion(e);
				} catch (Exception e2) {
					System.out.println("ERROR: Error al resolver el calculo" + o.getValor1()+o.getSymbol()+o.getValor2()+"="+o.getResult());
				}
			}
		});
		
		frame.btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Operacion(e);
				} catch (Exception e2) {
					System.out.println("ERROR: Error al resolver el calculo" + o.getValor1()+o.getSymbol()+o.getValor2()+"="+o.getResult());
				}
			}
		});
		
		frame.btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Operacion(e);
				} catch (Exception e2) {
					System.out.println("ERROR: Error al resolver el calculo" + o.getValor1()+o.getSymbol()+o.getValor2()+"="+o.getResult());
				}

			}
		});
		
	}
	
	public void Operacion (ActionEvent e) {
	/*	if (!o.getResult().isNaN()) {
			//Operation IS RESOLVED
			//TODO Insertar operación en el historial y resetear operacion
		} else {
			if(!o.getValor1().isNaN()) {
				//The operation IS NOT resolved but VAL1 IS already assigned
				//TODO Assign value to VAL2
				
			} else {
				//The operation IS NOT resolved and VAL1 IS NOT assigned
				//TODO Assign value to VAL 1 
				
			}
		}*/
		if (o.isResolved()) {			
			
			frame.txtHistory.setText(o.getResult().toString());
			frame.txtResult.setText("");
			o.setValor1(o.getResult());
			o.setValor2(Double.NaN);
			o.setOperacion(e.getActionCommand().charAt(0));
			
		} else {
			if (o.getValor1().isNaN()) {
				o.setValor1(Double.parseDouble(frame.txtResult.getText()));
				o.setOperacion(e.getActionCommand().charAt(0));
				frame.txtHistory.setText((o.getValor1().toString()+o.getSymbol()));
				frame.txtResult.setText("");
			}
			if (!o.getValor1().isNaN()) {
				o.setValor2(Double.parseDouble(frame.txtResult.getText()));
			}
		}

	}


	private void insertarRegistro() {
		// TODO Auto-generated method stub
		try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
		    writer.write(s + o.getValor1() + o.getSymbol() + o.getValor2() + " = " + o.getResult());
		} catch (IOException ioe) {
		    System.err.format("IOException: %s%n", ioe);
		}
	}

	//Funciones
	private void updateResult () {
		if (o.getResult().isNaN()) {
			frame.txtResult.setText("0");
		} else {
		frame.txtResult.setText(o.getResult().toString());
		}
	}
	
	//private void clear
	
}
	
	
	/*TODO
	 * 
	//Devuelve true si es par y false si es impar
	public boolean ParImpar (Double resultadoOperacion) {
		boolean isEven = false;
		isEven = (resultadoOperacion % 2) == 0;
		return isEven;
	}
	*/

