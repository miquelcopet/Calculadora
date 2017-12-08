import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public static String bd="calculadora";
	public static String login="root";
	public static String pass="";
	public static String host="localhost";
	private static String url="jdbc:mysql://"+host+"/"+bd+"?useSSL=false";
	
	public static Connection con=null;
	
	
	public static void open(){
		try {
			if ((con==null) || (con.isClosed())) {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, login, pass);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void close() {
		try {
			if(!con.isClosed()){
				con.close();
			}
			
		} catch (Exception e) {
			
		}
		
	}


}
