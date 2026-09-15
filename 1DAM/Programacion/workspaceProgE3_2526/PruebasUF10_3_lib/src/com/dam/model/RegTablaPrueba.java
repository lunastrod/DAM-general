package com.dam.model;

// representa un registro de la tabla TABLA_PRUEBA
public class RegTablaPrueba {
	private int id;
	private String desc;
	
	public RegTablaPrueba(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public RegTablaPrueba(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "RegTablaPrueba [id=" + id + ", desc=" + desc + "]";
	}

	public String getDesc() {
		return desc;
	}
	
	
}
