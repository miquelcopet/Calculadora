import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Miquel 
 * 21 nov. 2017
 */

public class ControladorPrincipal {
	
	private vista frame = new vista();
	private Operacion o = new Operacion(Double.NaN, Double.NaN, '\0', Double.NaN);
	private String historial = "";
	
	public ControladorPrincipal () {
		//updateResult();
		frame.setVisible(true);

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
	
	
	//Funciones
	private void updateResult () {
		if (o.getResult().isNaN()) {
			frame.txtResult.setText("0");
		} else {
		frame.txtResult.setText(o.getResult().toString());
		}
	}
	
	private void updateHistory() {
		frame.txtHistory.setText(historial);
	}
	
	public void Operacion (ActionEvent e) {
		if (o.getResult().isNaN()) {
			if (o.getValor1().isNaN()) {
				//Si X esta vacio se le da el valor 
				o.setValor1(Double.parseDouble(frame.txtResult.getText()));
				o.setOperacion(e.getActionCommand().charAt(0));
				frame.txtResult.setText(frame.txtResult.getText()+e.getActionCommand().charAt(0));
				
				
			} else {
				//Si X esta lleno, se llena y con el valor introducido
				o.setValor2(Double.parseDouble(frame.txtResult.getText()));
				
				if (!o.getValor1().isNaN() && !o.getValor2().isNaN()) {
					//Si tanto x como y tienen valor, se calcula la operacion se actualiza el resulatado en pantalla
					o.Calcular();
					frame.txtHistory.setText(frame.txtHistory.getText() + o.getValor1().toString() + o.getSymbol() + o.getValor2());
					updateResult();
				}
			}
		} else {
			//La operacion ya tiene simbolo o esta resuelta asi que se guarda en el historial y se resetea la operacion
			Double _tempOldResult = o.getResult();
			o.Reset();
			o.setValor1(_tempOldResult);
			o.setOperacion(e.getActionCommand().charAt(0));
			updateResult();
			
		}

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
}
