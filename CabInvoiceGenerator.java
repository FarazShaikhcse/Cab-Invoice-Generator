import java.util.List;

public class CabInvoiceGenerator {
	private final int NORMAL_MINIMUM_FARE = 5;
	private final int PREMIUM_MINIMUM_FARE = 20;
	private final int CHARGE_PER_MINUTE_NORMAL = 1;
	private final int CHARGE_PER_MINUTE_PREMIUM = 2;
	private final int CHARGE_PER_KM_PREMIUM = 15;
	private final int CHARGE_PER_KM_NORMAL = 10;

	/**
	 * @param type of the fare
	 * @param distance travelled in fare
	 * @param time taken for the fare
	 * @return total fare cost
	 * this method calculates the fare based on the params
	 */
	public double generateFare(String type, double distance, double time) {
		double cost;
		if (type.equalsIgnoreCase("premium")) {
			cost = (distance * CHARGE_PER_KM_PREMIUM) + (CHARGE_PER_MINUTE_PREMIUM * time);
			return cost > PREMIUM_MINIMUM_FARE ? cost : PREMIUM_MINIMUM_FARE;
		} else {
			cost = (distance * CHARGE_PER_KM_NORMAL) + (CHARGE_PER_MINUTE_NORMAL * time);
			return cost > NORMAL_MINIMUM_FARE ? cost : NORMAL_MINIMUM_FARE;
		}

	}

	/**
	 * @param rides is the list of rides of the user
	 * @return the total fare of the user
	 */
	public double generateTotalFare(List<Ride> rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += generateFare(ride.getRideType(), ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	/**
	 * @param rides is the list of rides
	 * @return invoice object
	 */
	public Invoice getEnhancedInvoice(List<Ride> rides) {
		double totalFare = generateTotalFare(rides);
		Invoice invoice = new Invoice(rides.size(), totalFare);

		return invoice;

	}
}