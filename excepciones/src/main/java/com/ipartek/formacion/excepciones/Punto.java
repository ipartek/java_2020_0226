package com.ipartek.formacion.excepciones;

public class Punto {
	private int x, y;

	public Punto(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < 0) {
			throw new PuntoException("La x debe ser mayor que 0");
		}

		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y < 0) {
			throw new PuntoException("La y debe ser mayor que 0");
		}

		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

}
