package Controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import Layouts.RegistroActual;

public class ControladorRegistroActual {
	
	public ControladorRegistroActual (Path p) {
		
		RegistroActual frameRegistro = new RegistroActual();
		frameRegistro.setVisible(true);
		
		try(BufferedReader br = new BufferedReader(new FileReader(p.toString()))) {
		    StringBuilder sb = new StringBuilder();
		    String line = null;
			try {
				line = br.readLine();
				System.out.println(line);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        try {
					line = br.readLine();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		    }
		    
		    String everything = sb.toString();
		    
			frameRegistro.textPane.setText(everything);
		    
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}

}
