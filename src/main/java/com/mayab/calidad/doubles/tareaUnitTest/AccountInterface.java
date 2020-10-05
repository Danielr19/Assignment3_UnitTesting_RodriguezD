package com.mayab.calidad.doubles.tareaUnitTest;

import java.util.ArrayList;

public interface AccountInterface {

	/*String holder; //Nombre del due�o de la cuenta
    double balance; //Cantidad disponible en la cuenta
    int zone; //Zona donde se crea la cuenta
    
    ArrayList<Double>comisiones; //Se usar� para la tercer prueba.
    
    AlertListener alerts;*/ //Quit� este parametro del constructor, no le vi sentido que fuera parte del constructor

    //public AccountInterface(String holder, double initialBalance, int zone);
	public ArrayList<Double> getComisiones();
    
    public double getBalance();
    
    public String getHolder();
    
    public int getZone();

    double debit(double balance);

    double credit(double balance);
    
    void setAlertListener(AlertListener listener);
    
    public String sendAlert(String msg);
    
    public Double calcularComisiones();
    
}
