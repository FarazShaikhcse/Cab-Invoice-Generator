
import org.junit.Assert;
import org.junit.Test;


public class InvoiceTest {

	@Test
	public void givenJourney_withCorrectExpectedFare_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Assert.assertEquals(80.5, cabInvoiceGenerator.generateFare(6.5, 15.50), 0.001);
	}

	@Test
	public void givenJourney_withMiniMumFare_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Assert.assertEquals(5, cabInvoiceGenerator.generateFare(0.1, 2), 0.001);

	}
}