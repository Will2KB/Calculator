package Testing;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public double add(double a, double b) {
		return a + b;
	}

	public double multiply(double a, double b) {
		return a * b;
	}

	public void longCalculation() {
		try {
			// Attendre 0.5 secondes
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int substract(int a, int b) {
		return a - b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

}
