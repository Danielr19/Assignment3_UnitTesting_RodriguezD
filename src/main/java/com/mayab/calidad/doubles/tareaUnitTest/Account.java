package com.mayab.calidad.doubles.tareaUnitTest;

import java.util.ArrayList;

public class Account implements AlertListener{
    
	private String holder; //Nombre del dueño de la cuenta
    private double balance; //Cantidad disponible en la cuenta
    private int zone; //Zona donde se crea la cuenta
    
    ArrayList<Double>comisiones; //Se usará para la tercer prueba.
    
    AlertListener alerts; //Quité este parametro del constructor, no le vi sentido que fuera parte del constructor

    public Account(String holder, double initialBalance, int zone){
    	if(zone == 1 || zone ==  2 || zone == 3)
    	{
    		this.holder = holder;
            this.balance = initialBalance;
            this.zone = zone;
            this.comisiones = new ArrayList<Double>();
    	}
        
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }
    public int getZone() {
    	return this.zone;
    }

    double debit(double balance) { 
        this.balance -= balance;
        if(this.balance < 100){
            //alerts.sendAlert(this.holder + ", your account balance is below 100");
        	sendAlert("String");
        	sendAlert(this.getHolder() + ", your account balance is below 100");
        }
        this.balance = this.balance - (balance * (this.zone/100));
        return this.balance;
    }

    double credit(double balance) {
        this.balance += balance;
        this.balance = this.balance - (balance * (this.zone/100));
        return this.balance;
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
    public String sendAlert(String msg) {
    	return msg;
    } //este será un mock implementando el de la interfaz
    
    public Double consultarComisiones() {
    	//Este método nunca se implementa solo se utiliza para el mock
    	return 0.0;
    }
    
}