package com.mayab.calidad.doubles.tareaUnitTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatcher.*;

public class AlertTest {

	private Account accountMock;
	@Before
	public void setup() {
		accountMock = mock(Account.class);
	}
	
	@Test
	public void testAlert() {
	
		//CORRECTO
		Mockito.doCallRealMethod().when(accountMock).debit(Mockito.any(Double.class));
		accountMock.debit(50);
		Mockito.verify(accountMock).sendAlert(accountMock.getHolder() + ", your account balance is below 100");
	}

}
