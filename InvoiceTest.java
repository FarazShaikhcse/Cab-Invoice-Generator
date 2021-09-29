
import org.junit.Assert;
import org.junit.Test;
import java.util.stream.Collectors;


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
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new Ride(1, 25, 15));
		rideRepository.addRide(new Ride(1, 15, 5));

		double expectedTotalFare = 420;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFare, cabInvoiceGenerator.generateTotalFare(rideRepository.getRides()), epsilon);

	}
	
	@Test
	public void calculatingMultipleFaresreturnsExpectedTotalRides() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new Ride(1, 25, 10));
		rideRepository.addRide(new Ride(1, 15, 14));
		rideRepository.addRide(new Ride(1, 25, 15));
		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());
		int expectedTotalRides = 3;
		Assert.assertEquals(expectedTotalRides, invoice.getTotalRides());

	}

	@Test
	public void calculatingMultipleFaresreturnsExpectedTotalFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new Ride(1, 25, 15));
		rideRepository.addRide(new Ride(1, 15, 5));
		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());
		double expectedTotalFare = 420;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFare, invoice.getTotalFare(), epsilon);

	}

	@Test
	public void calculatingMultipleFaresreturnsExpectedAverageFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new Ride(1, 25, 15));
		rideRepository.addRide(new Ride(1, 15, 5));
		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());
		double expectedAvgFare = 210;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedAvgFare, invoice.getAvgfare(), epsilon);

	}
	
	@Test
	public void givenMultipleRideOfDifferentCustomer_noOfRidesofCustomer1_matches_expectedTotalRides() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 5, 10));
		rideRepository.addRide(new Ride(2, 10, 25));
		rideRepository.addRide(new Ride(1, 12, 30));

		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserid() == 1).collect(Collectors.toList()));

		int expectedTotalRideofUser1 = 2;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalRideofUser1, invoice.getTotalRides(), epsilon);

	}

	@Test
	public void givenMultipleRideOfDifferentCustomer_matching_calculatedFare_with_ExpectedFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 25, 15));
		rideRepository.addRide(new Ride(2, 10, 25));
		rideRepository.addRide(new Ride(1, 15, 5));

		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserid() == 1).collect(Collectors.toList()));

		double expectedTotalFareofUser1 = 420;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFareofUser1, invoice.getTotalFare(), epsilon);

	}

	@Test
	public void givenMultipleRideOfDifferentPassenger_AverageFareOfCustomer1_matches_with_expectedFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 25, 15));
		rideRepository.addRide(new Ride(2, 10, 25));
		rideRepository.addRide(new Ride(1, 15, 5));

		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserid() == 1).collect(Collectors.toList()));

		double expectedAvgFareofUser1 = 210;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedAvgFareofUser1, invoice.getAvgfare(), epsilon);

	}
}