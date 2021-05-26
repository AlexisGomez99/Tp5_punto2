package modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;


//Cambiar clase debe contener los ifs para sobreescribir
public class SinSobrescribir implements DecoradorReporte{
	private DecoradorReporte decReporte;


	public SinSobrescribir(DecoradorReporte dec) {
		this.decReporte=dec;
	}

	@Override
	public boolean export(File file) {
		if (file == null) {
			throw new IllegalArgumentException("File es NULL; no puedo exportar...");
		}
		if (file.exists()) {
			throw new IllegalArgumentException("El archivo ya existe...");
		}
		
		return decReporte.export(file);
	}
	
	

}
