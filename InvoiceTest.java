
import org.junit.Assert;
import org.junit.Test;


public class InvoiceTest {

	@Test
	public void invoiceGeneratorCalculatesCorrectFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Assert.assertEquals(80.5, cabInvoiceGenerator.generateFare(6.5, 15.50), 0.001);
	}

	@Test
	public void invoiceGeneratorCalculatesCorrectFareforMinimumFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Assert.assertEquals(5, cabInvoiceGenerator.generateFare(0.1, 2), 0.001);

	}
	
	@Test
	public void calculatingMultipleFares_returns_expectedFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(25, 15), new Ride(15, 5) };
		double expectedTotalFare = 420;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFare, cabInvoiceGenerator.generateTotalFare(rides), epsilon);

	}
}