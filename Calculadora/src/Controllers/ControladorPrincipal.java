package Controllers;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Layouts.Historial;
import Layouts.MainScreen;
import Model.Operacion;


/**
 * @author Miquel 
 * 21 nov. 2017
 */

public class ControladorPrincipal {
	
	private MainScreen framePrincipal = new MainScreen();

	//Se crea una instancia de Operacion a la que se le irán modificando los parámetros para resolver las operaciones
	private Operacion o = new Operacion(Double.NaN, Double.NaN, '\0', Double.NaN);
	
	Path p = Paths.get("D:\\Git\\LocalCalculadora\\Calculadora\\log.txt");
	String s = System.lineSeparator();

	public ControladorPrincipal () {	
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		
    	try{
    		File file = new File(p.toString());

    		if  (file.delete()) {
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
    	try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.CREATE)) {
    		writer.flush();
    		//Se escribe la fecha actual en el archivo log
    		writer.write(dtf.format(now).toString());
    		writer.close();
    	} catch (IOException ioe) {
    		System.err.format("IOException: %s%n", ioe);
    	}

		updateResult();
		framePrincipal.setVisible(true);

		//
		framePrincipal.btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o.Reset();
				framePrincipal.txtResult.setText("0");
				framePrincipal.txtHistory.setText("0");
			}
		});
		
		framePrincipal.btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePrincipal.txtResult.setText("0");
			}
		});
		
		framePrincipal.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = framePrincipal.txtResult.getText(); 
				if (s.equals("")) {
					framePrincipal.txtResult.setText("");
				} else {
					s = s.substring(0, s.length() - 1);
					framePrincipal.txtResult.setText(s);
				}
			}
		});

		/*Definicion funcionalidades botones numéricos
		 * Cada botón numérico al ser pulsado escribe 
		 * el texto del botón al campo de texto principal
		 * de la calculadora.
		 * */

		framePrincipal.btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"0");
			}
		});
		framePrincipal.btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"1");
			}
		});
		framePrincipal.btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"2");
			}
		});
		framePrincipal.btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"3");
			}
		});
		framePrincipal.btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"4");
			}
		});
		framePrincipal.btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"5");
			}
		});
		framePrincipal.btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"6");
			}
		});
		framePrincipal.btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"7");
			}
		});
		framePrincipal.btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"8");
			}
		});
		framePrincipal.btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+"9");
			}
		});
	
	//Definicion funcionalidades botones de símbolos
		framePrincipal.btnComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = framePrincipal.txtResult.getText();
				if (txt.indexOf(".") >= 0) {
					System.out.println("El número ya tiene coma");
				} else {
					framePrincipal.txtResult.setText(framePrincipal.txtResult.getText()+".");
				}
			}
		});
		
		framePrincipal.btnMasMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double x = Double.parseDouble(framePrincipal.txtResult.getText());
			    x = -x;
			    framePrincipal.txtResult.setText(x.toString());
			}
		});
		
	//Definición boton igual
		framePrincipal.btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o.setValor2(Double.parseDouble(framePrincipal.txtResult.getText()));
				if (!o.getValor1().isNaN() && !o.getValor2().isNaN()) {
					o.Calcular();
					insertarRegistro();
				}
				
				updateResult();
			}
		});
		
	//Botones operaciones básicas
		framePrincipal.btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					Operacion(e);
				} catch (Exception e2) {
					errorCalculo();
				}
			}
		});
		
		framePrincipal.btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Operacion(e);
				} catch (Exception e2) {
					errorCalculo();
				}
			}
		});
		
		framePrincipal.btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Operacion(e);
				} catch (Exception e2) {
					errorCalculo();
				}
			}
		});
		
		framePrincipal.btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Operacion(e);
				} catch (Exception e2) {
					errorCalculo();
				}

			}
		});
		
		framePrincipal.btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Operacion(e);
				} catch (Exception e2) {
					errorCalculo();
				}

			}
		});
		
	//endBotones operaciones básicas
		
	//Botones funciones matemáticas
		
		framePrincipal.btnSRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double x = Double.parseDouble(framePrincipal.txtResult.getText());
				x = Math.sqrt(x);
				framePrincipal.txtResult.setText(x.toString());
			}
		});
		
		framePrincipal.btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double x = Double.parseDouble(framePrincipal.txtResult.getText());
				x = Math.pow(x, 2);
				framePrincipal.txtResult.setText(x.toString());
			}
		});
		
	//endBotones funciones matemáticas
		
//Menu
		framePrincipal.mntmExit.addActionListener(new ActionListener() {
			//Lanza una ventana emergente que piede al usuario si quiere salir dependiendo del input cierra el programa o sigue corriendo
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "Quiere cerrar el programa?", "Alerta", JOptionPane.YES_NO_OPTION);

				if (opcion == 0) {
					System.exit(0);
				} 
			}
		});
		
		framePrincipal.mntmMostrarRegistroTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Crea la ventana historial y la muestra en pantalla
				Historial frameHistorial = new Historial();
				frameHistorial.setVisible(true);
			}
		});
		
		framePrincipal.rojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePrincipal.mainColor = framePrincipal.softRed;
				framePrincipal.buttonColor = framePrincipal.strongRed;
				reloadJFrame(framePrincipal);

			}
		});
		
		framePrincipal.verde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePrincipal.mainColor = framePrincipal.softGreen;
				framePrincipal.buttonColor = framePrincipal.strongGreen;
				reloadJFrame(framePrincipal);

			}
		});
		
		framePrincipal.azul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePrincipal.mainColor = framePrincipal.softBlue;
				framePrincipal.buttonColor = framePrincipal.strongBlue;
				reloadJFrame(framePrincipal);

			}
		});
		
		framePrincipal.mntmExportarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("explorer.exe /select," + p);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		framePrincipal.mntmMostrarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorRegistroActual cRA = new ControladorRegistroActual(p);
			}
		});
//endMenu
	
	} //finControlador Principal
	
	//Lógica que decide si se tiene que resolver o simplemente asignar datos a la operacion (o)
	public void Operacion (ActionEvent e) {
		if (o.isResolved()) {			
			framePrincipal.txtHistory.setText(o.getResult().toString());
			framePrincipal.txtResult.setText("");
			o.setValor1(o.getResult());
			o.setValor2(Double.NaN);
			o.setOperacion(e.getActionCommand().charAt(0));

		} else {
			if (o.getValor1().isNaN()) {
				o.setValor1(Double.parseDouble(framePrincipal.txtResult.getText()));
				o.setOperacion(e.getActionCommand().charAt(0));
				framePrincipal.txtHistory.setText((o.getValor1().toString()+o.getSymbol()));
				framePrincipal.txtResult.setText("");
			}
			if (!o.getValor1().isNaN()) {
				o.setValor2(Double.parseDouble(framePrincipal.txtResult.getText()));
			}
		}
	}


	//Escribe todas las propiedades de la operacion en el archivo log.txt (writer)
	private void insertarRegistro() {
		try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
		    writer.write(s + o.getValor1() + o.getSymbol() + o.getValor2() + " = " + o.getResult());
		} catch (IOException ioe) {
		    System.err.format("IOException: %s%n", ioe);
		}
	}

	//Este método actualiza el texto para que muestre el resultado de la operacion (o)
	private void updateResult () {
		if (o.getResult().isNaN()) {
			framePrincipal.txtResult.setText("0");
		} else {
		framePrincipal.txtResult.setText(o.getResult().toString());
		}
	}

	
	private void errorCalculo() {
		System.out.println("ERROR: Error al resolver el calculo" + o.getValor1()+o.getSymbol()+o.getValor2()+"="+o.getResult());
	}
	
	private void reloadJFrame (JFrame frame) {
		SwingUtilities.updateComponentTreeUI(frame);
		frame.invalidate();
		frame.validate();
		frame.repaint();
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

