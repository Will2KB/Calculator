package Testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	private static Instant startedAt;
	private Calculator calculatorUnderTest;

	@BeforeAll
	public static void initStartingTime() {
		startedAt = Instant.now();
	}

	@AfterAll
	public static void showTestDuration() {
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}

	@BeforeEach
	public void initCalculator() {
		this.calculatorUnderTest = new Calculator();
	}

	@AfterEach
	public void undefCalculator() {
		this.calculatorUnderTest = null;
	}

	@Test
	public void testAddTwoPositiveNumbers() {
		// Arrange
		int a = 2;
		int b = 3;

		// Act
		int somme = calculatorUnderTest.add(a, b);

		// Assert
		assertThat(somme).isEqualTo(5);
	}

	@Test
	public void testMultiplyTwoPositiNumbers() {
		// Arrange
		int a = 2;
		int b = 3;

		// Act
		int result = calculatorUnderTest.multiply(a, b);

		// Assert
		assertThat(result).isEqualTo(6);
	}

	@ParameterizedTest(name = "{0} x 0 doit être égal à 0")
	@ValueSource(ints = { 1, 2, 42, 1011, 5089 })
	public void multiplyShouldReturnZeroOfZeroWithMultipleInterger(int arg) {
		// Arrange - Nothing

		// Act
		int result = this.calculatorUnderTest.multiply(arg, 0);

		// Assert
		assertThat(result).isEqualTo(0);
	}

	@ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
	@CsvSource({ "1,2,3", "10,25,35", "42,57,99" })
	public void testAddMultipleInteger(int a, int b, int res) {

		// Arrange- Nothing

		// Act
		int somme = calculatorUnderTest.add(a, b);

		// Assert
		assertThat(somme).isEqualTo(res);
	}

	@Timeout(1)
	@Test
	public void longCalcul_shouldComputeInLessThan1Second() {
		// Arrange

		// Act
		calculatorUnderTest.longCalculation();

		// Assert
		// ...
	}

	@Test
	public void testMinusTwoPositiveNumbers() {
		// Given
		int a = 3;
		int b = 2;

		// When
		int result = this.calculatorUnderTest.substract(a, b);

		// Then
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	public void testDivideTwoPositiveNumbers() {
		//Given
		int a=10;
		int b = 2;
		
		//When
		int result = this.calculatorUnderTest.divide(a,b);
		
		//Then
		assertThat(result).isEqualTo(5);
	}
}
