package com.mayab.calidad.doubles.tareaUnitTest;

import java.util.ArrayList;

public interface AccountInterface {

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
