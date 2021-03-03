import java.io.IOException;

public class EjecutarComando {

	public static void main(String[] args) throws IOException, InterruptedException {
		 Process runProcess = Runtime.getRuntime().exec("notepad.exe C:\\JAVA_2020_NOVIEMBRE\\BACKUPS\\prueba.sql");
		 int processComplete = runProcess.waitFor();
		 
		 if(processComplete == 0) {
			 System.out.println("Todo correcto");
		 } else {
			 System.out.println("Ha habido algún error");
		 }
	}

}
