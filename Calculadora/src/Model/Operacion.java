package Model;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Utility.Conexion;

/**
 * @author Miquel 
 * 21 nov. 2017
 */

public class Operacion {
	
	private Double valor1;
	private Double valor2;
	private char sym;
	private Double result;


	public Operacion (Double x, Double y, char op, Double r) {
		this.valor1 = x;
		this.valor2 = y;
		this.sym = op;
		this.result = r;
	}
	
	
	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}


	public boolean isResolved () {
		if (this.result.isNaN()) {
			return false;
		} else {
			return true;
		}
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
		this.insertarOperacion();
	}
	
	public void Reset () {

		this.valor1 = Double.NaN;
		this.valor2 = Double.NaN;
		this.sym = '\0';
		this.result = Double.NaN;
		System.out.println("Operacion reseteada /----------------------------/");
	
	}
	
	public void insertarOperacion(){

		Conexion.open();
		PreparedStatement stm;
		String ins = "INSERT INTO operacion (val1, val2, sym, res) VALUES (?,?,?,?)";
		try{
			stm=Conexion.con.prepareStatement(ins);
			stm.setDouble(1, this.getValor1());
			stm.setDouble(2, this.getValor2());
			stm.setString(3, this.getSymbol()+"");
			stm.setDouble(4, this.getResult());
			stm.executeUpdate(); 
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Error: "+e.getErrorCode()+" - "+e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/*TODO Implementar estas funciones para que se puedan hacer búsquedas 
	 * y clasificaciones de las operaciones dependiendo de la fecha, resultado, etc.
	
	public static Operacion load(Integer i) {
		Conexion.open();
		PreparedStatement stm;
		ResultSet respuesta;
		
		String consulta="Select * from operacion where id_operacion = ?";
		
		try {
			stm=Conexion.con.prepareStatement(consulta);
			stm.setInt(1, i);

			respuesta=stm.executeQuery();
			
			if (respuesta.next()) {
				return new Operacion(respuesta.getDouble("val1"),
								   respuesta.getDouble("val2"),
								   respuesta.getString("sym").charAt(0),
								   respuesta.getDouble("res"),
								   respuesta.getInt("id_operacion"));

			}			
			stm.close();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Operacion insertarOperacion (Double x, Double y, char op, Double r) {
		Conexion.open();
		PreparedStatement insercion;
		ResultSet respuesta;
		try {
			insercion=Conexion.con.prepareStatement("insert into operacion (val1, val2, sym, res) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			insercion.setDouble(1, x);
			insercion.setDouble(2, y);
			insercion.setString(3, op+"");
			insercion.setDouble(4, r);
			insercion.executeUpdate();
			respuesta=insercion.getGeneratedKeys();
			respuesta.next();

			if (respuesta.next()) return Operacion.load(respuesta.getInt(1));
			insercion.close();
			
		}  catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex.getErrorCode()+" - "+ex.getLocalizedMessage());
			ex.printStackTrace();
			return null;
		}
		return null;
		
	}
	
	public static LinkedList<Operacion> find() {
		Conexion.open();
		PreparedStatement stm;
		ResultSet respuesta;
		LinkedList<Operacion> lista=new LinkedList<Operacion>();
		
		String consulta="Select * from operacion ORDER BY nombre";
		
		try {
			stm=Conexion.con.prepareStatement(consulta);
			respuesta=stm.executeQuery();
			
			while(respuesta.next()) {
				lista.add(new Operacion(respuesta.getDouble("val1"),
						   respuesta.getDouble("val2"),
						   respuesta.getString("sym").charAt(0),
						   respuesta.getDouble("res"),
						   respuesta.getInt("id_operacion")));
			}			
			stm.close();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}*/

}
