package com.promineotech;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*; 


@SuppressWarnings("unused")
class TestDemoJUnitTest {

	private TestDemo testDemo; //this is a instance variable creation
	// Remember that instance variables are non-static variables which are defined in a class,
	// but outside of any method, constructor or a block
	
	
	//setup is the setUp method 
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo(); 
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
		assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class); 
	}
}

	//This is bringing something back called stream
	 static Stream<Arguments> arguementsForAddPositive() {
		 
		return Stream.of( 
				arguments(2,4,6, true));
		// arguments(0,-1,1, false)
		
							
	}
	
	@Test 
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() { 
		//These are somthing called "calls" 
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);

	}
	//mock means that you are testing the methods and what it calls 
	//spy helps mimic that i think 
	//in mock, you are creating a complete mock or fake object
	//while in spy, there is the real object and you just spying 
	//or stubbing specific methods of it
	@Test 
	void assertThatNumberedSqauredIsCorrect () {
		TestDemo testDemo = new TestDemo();
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt(); 
		int fiveSquared = mockDemo.randomNumberSquared(); 
		assertThat(fiveSquared).isEqualTo(25);
	}
}
