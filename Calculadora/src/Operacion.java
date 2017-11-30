
/**
 * @author Miquel 
 * 21 nov. 2017
 */

public class Operacion {
	
	private Double valor1;
	private Double valor2;
	private Double result;
	private char sym;
	
	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public Operacion (Double x, Double y, char op, Double r) {
		this.valor1 = x;
		this.valor2 = y;
		this.sym = op;
		this.result = r;
	}
	
	public Double getValor1() {
		return valor1;
	}

	public void setValor1(Double valor1) {
		this.valor1 = valor1;
	}

	public Double getValor2() {
		return valor2;
	}

	public void setValor2(Double valor2) {
		this.valor2 = valor2;
	}

	public char getSymbol() {
		return sym;
	}

	public void setOperacion(char simboloOperacion) {
		this.sym = simboloOperacion;
	}

	@SuppressWarnings("unused")
	public void Calcular() {
		
		Double x = this.getValor1();
		Double y = this.getValor2();
		
		switch (this.sym) {
		case '+':
			this.result = this.valor1+this.valor2;
			break;
		case '-':
			this.result = this.valor1-this.valor2;
			break;
		case 'x':
			this.result = this.valor1*this.valor2;
			break;
		case '/':
			this.result = this.valor1/this.valor2;
			break;
		default:
			break;
		}
		
		System.out.println("Calculo completado " + this.valor1 + this.sym + this.valor2 + " = " + this.result);
	}
	
	public void Reset () {
		
		//TODO Guardar operación completa en un historial

		this.valor1 = Double.NaN;
		this.valor2 = Double.NaN;
		this.sym = '\0';
		this.result = Double.NaN;
		System.out.println("Operacion reseteada /----------------------------/");
	
	}


}
