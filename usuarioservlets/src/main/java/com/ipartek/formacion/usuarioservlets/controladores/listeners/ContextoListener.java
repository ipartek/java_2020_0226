package com.ipartek.formacion.usuarioservlets.controladores.listeners;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.usuarioservlets.controladores.Configuracion;
import com.ipartek.formacion.usuarioservlets.controladores.ControladoresException;

@WebListener
public class ContextoListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			String pathConfiguracion = sce.getServletContext().getRealPath("/WEB-INF/dao.properties");
	
			try (FileInputStream fis = new FileInputStream(pathConfiguracion)) {
				Properties prop = new Properties();
				prop.load(fis);

				String motor = prop.getProperty("motor");
				Configuracion.setMotor(motor);
			}
		} catch (Exception e) {
			throw new ControladoresException("No se ha podido cargar la configuración",e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// No tenemos nada que hacer en este caso
	}

}
