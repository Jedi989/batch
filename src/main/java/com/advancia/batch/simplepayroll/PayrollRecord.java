package com.advancia.batch.simplepayroll;

public class PayrollRecord {

	private int empID;
	private float base;
	private float tax;
	private float bonus;
	private float net;
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getNet() {
		return net;
	}
	public void setNet(float net) {
		this.net = net;
	}
	
	
	
}
