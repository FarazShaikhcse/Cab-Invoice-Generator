
public class Ride {

	int userid;
	double distance, time;

	public Ride(int userid, double distance, double time) {
		this.distance = distance;
		this.time = time;
		this.userid = userid;
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

}
