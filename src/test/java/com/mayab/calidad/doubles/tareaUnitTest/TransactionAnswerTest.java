package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.calidad.mayab.dao.Alumno;

import static org.mockito.Mockito.mock;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
//import static org.testing.Assert.assertEquals;
import static org.mockito.ArgumentMatcher.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;

public class TransactionAnswerTest {

	private static int comisionCounter = 0;
	AccountInterface accountMock;
	
	@Before
	public void setup() {
		accountMock = mock(AccountInterface.class);
		setupBaseDatos();
	}
	
	public void setupBaseDatos() {
		when(accountMock.getComisiones()).thenReturn(new ArrayList<Double>());
	}
	
	@Test
	public void comisionTest() {
		when(accountMock.credit(Mockito.any(Double.class))).thenAnswer(new Answer<Double>() {
			public Double answer(InvocationOnMock invocation) throws Throwable{
				Double balance = (Double)invocation.getArguments()[0];
				accountMock.getComisiones().add(balance);
				comisionCounter ++;
				
				return balance;
			}
		});
		
		when(accountMock.debit(Mockito.any(Double.class))).thenAnswer(new Answer<Double>() {
			public Double answer(InvocationOnMock invocation) throws Throwable{
				Double balance = (Double)invocation.getArguments()[0];
				balance = balance * (-1);
				accountMock.getComisiones().add(balance);
				comisionCounter ++;
				
				return balance;
			}
		});
		
		when(accountMock.calcularComisiones()).thenAnswer(new Answer<Double>() {
			public Double answer(InvocationOnMock invocation) throws Throwable{
				Double sumaComisiones = 0.0;
				for(Double comision: accountMock.getComisiones()) {
					sumaComisiones += Math.abs(comision) * 0.01;
				}
				return sumaComisiones;
			}
			
		});
		
		accountMock.debit(300);
		accountMock.credit(700);
		accountMock.credit(100);
		
		assertThat(11.0,is(accountMock.calcularComisiones()));
		assertThat(3, is(accountMock.getComisiones().size()));
	}

}
