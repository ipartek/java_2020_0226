import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

//http://chuwiki.chuidiang.org/index.php?title=Backup_de_MySQL_con_Java

public class EjecutarComando {

	public static void main(String[] args) throws IOException, InterruptedException {

		Process p = Runtime.getRuntime()
				.exec("mysqldump -u root -padmin supermercado");

		try (InputStream is = p.getInputStream(); FileOutputStream fos = new FileOutputStream("backup_pruebas.sql")) {
			byte[] buffer = new byte[1000];

			int leido;
			while ((leido = is.read(buffer)) > 0) {
				fos.write(buffer, 0, leido);
			}
		}

		int processComplete = p.waitFor();

		if (processComplete == 0) {
			System.out.println("Todo correcto");
		} else {
			System.out.println("Ha habido algún error");
		}
	}

}
