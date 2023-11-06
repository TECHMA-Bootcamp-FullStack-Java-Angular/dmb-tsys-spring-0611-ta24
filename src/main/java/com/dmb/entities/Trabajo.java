package com.dmb.entities;

public enum Trabajo {
	
	DM(1600), 
	DIVER(1900),
	TENDER(1450), 
	SUPERVISOR(2100); 

	int salario;

	Trabajo(int salario) {
		this.salario = salario;
	}

	public int getSalarioCovenio() {
		return salario;
	}

}
