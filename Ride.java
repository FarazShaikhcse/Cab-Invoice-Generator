
public class Ride {

	int userid;
	double distance, time;
	String rideType;
	public Ride(int userid, double distance, double time, String rideType) {
		this.distance = distance;
		this.time = time;
		this.userid = userid;
		this.rideType = rideType;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getRideType() {
		return rideType;
	}

	public void setRideType(String rideType) {
		this.rideType = rideType;
	}
	
	
}
