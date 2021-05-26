package modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Reporte implements DecoradorReporte{
	private String reporte;

	public Reporte(String reporte) {
		this.reporte = reporte;
	}

	
	public boolean export(File file) {
		boolean x=true;
		try {
			file.createNewFile();
			Files.write(Paths.get(file.getAbsolutePath()), reporte.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			x=false;
			e.printStackTrace();
		}
		return x;
	}
}