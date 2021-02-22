package com.ipartek.formacion.usuarioservlets.bibliotecas;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.ipartek.formacion.usuarioservlets.controladores.ControladoresException;

public class Password {
	public static String obtenerHash(String texto) {
		try {
//			SecureRandom random = new SecureRandom();
//			byte[] salt = new byte[16];
//			random.nextBytes(salt);

			byte[] salt = new byte[] { 1, 3, 7, -5, 3, 5, -67, -123, 123, 23, 56, 86, -23, 123, 21, 125 };

			KeySpec spec = new PBEKeySpec(texto.toCharArray(), salt, 65536, 128);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

			return Base64.getEncoder().encodeToString((factory.generateSecret(spec).getEncoded()));
		} catch (Exception e) {
			throw new ControladoresException("Error no esperado en el hashing del texto", e);
		}
	}
}
