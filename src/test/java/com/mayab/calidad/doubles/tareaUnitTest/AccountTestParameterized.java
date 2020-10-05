package com.mayab.calidad.doubles.tareaUnitTest; 

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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

//3er test
import static org.mockito.Matchers.*;

import org.mockito.Mockito;
//Crear comportamiento al vuelo
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.*;

import org.junit.Test;

@RunWith(Parameterized.class)
public class AccountTestParameterized {

	private static int counter = 0;
	
	private String expectedHolder;
	private double expectedBalance;
	private int expectedZone;	
	private double expectedComission;
	
	private ArrayList<Account> accounts;
	private Account account1;
	private Account account2;
	private Account account3;
	
	@Before
	public void setup() {
	
		this.account1 = new Account("Daniel", 400, 1);
		this.account2 = new Account("Carlos", 600, 2);
		this.account3 = new Account("Andrea", 850, 3);
		
		this.accounts = new ArrayList<Account>(Arrays.asList(account1, account2, account3));	
	}
	

	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"Daniel",400,1,4},
            {"Carlos",600,2,12},
             {"Andrea",850,3,25.5}
		});
	}	
	
	public AccountTestParameterized(String holder , double balance, int zone, double comission) //MultiplyTest
	{
		this.expectedHolder = holder;
		this.expectedBalance = balance;
		this.expectedZone = zone;
		this.expectedComission = comission;
	}
	@Test
	public void createThreeAccounts() {
		assertThat(accounts.get(counter).getHolder(), is(expectedHolder));
		assertThat(accounts.get(counter).getBalance(), is(expectedBalance));
		assertThat(accounts.get(counter).getZone(), is(expectedZone));
		assertThat(accounts.get(counter).getBalance() * accounts.get(counter).getZone()/100, is(expectedComission));

		
		counter++; //El counter es una variable global que incrementara por cada cuenta probada.
	}
}
	


