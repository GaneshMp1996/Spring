package com.project.demo;



public class Method {
	
	public void Walk() {
		System.out.println("Walk methos is involked..........");
	}
	public void Sleep() {
		System.out.println("Sleep method is involked..");
	}
	public String Name() {
		return "Ganesh";
	}
	public boolean areYouJavaDevoloper() {
		return true;
	}
	public static void main(String[] args) {
		Method methpd=new Method();
		methpd.Walk();
		methpd.Sleep();
		System.out.println(methpd.Name());
		System.out.println(methpd.areYouJavaDevoloper());
	}

}
