package com.ipartek.formacion.holamundocomplejo;

public class App 
{
    public static void main( String[] args )
    {
    	ProcesadorMensajes procesador = new Fabrica("holamundo").getProcesadorMensajes();
        procesador.procesar();
    }
}
