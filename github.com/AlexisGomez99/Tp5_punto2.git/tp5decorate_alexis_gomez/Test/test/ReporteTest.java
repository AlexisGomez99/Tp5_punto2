package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.jupiter.api.Test;

import modelo.SinSobrescribir;
import modelo.DecoradorReporte;
import modelo.Reporte;

public class ReporteTest {
	
	@Test
	public void seExportaUnArchivoSinSobrescribir() {
		String path= "C:\\Users\\Alexis\\Desktop\\Prueba1.txt";
		File file= new File(path);
		String mensaje="";
		String texto="Se pudo exportar\n";
		DecoradorReporte reporte= new SinSobrescribir(new Reporte(texto));
		
		//exercise
		try {
			assertTrue("fallo",reporte.export(file));
		} catch (IllegalArgumentException e) {
			mensaje= e.getMessage();
			assertEquals("El archivo ya existe...",mensaje); 
		}
	
	}
	@Test
	public void sePuedeExportarSobreescribiendo() {
		String path= "C:\\Users\\Alexis\\Desktop\\Prueba2.txt";
		File file= new File(path);
		String texto="Se pudo exportar\n";
		DecoradorReporte reporte= new Reporte(texto);
				
		//exercise
		assertTrue("fallo",reporte.export(file));
	}

}
