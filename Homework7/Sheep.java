package Homework07;
public class Sheep implements Comparable<Sheep> {


	public String name;
	public int sheerTime;
	public int arrivalTime;
	public int compare = 0;

	// Default constructor
	public Sheep() {
		this.setName("No Name");
	}

	// Parameterized constructor
	public Sheep(String name,int sheerTime, int arrivalTime) {
		this.setName(name);
		this.setSheerTime(sheerTime);
		this.setArrivalTime(arrivalTime);
	}
	
	// Gets the sheer time
	public int getSheerTime() {
		return sheerTime;
	}

	// Sets the sheer time
	public void setSheerTime(int sheerTime) {
		this.sheerTime = sheerTime;
	}

	// Gets the arrival time
	public int getArrivalTime() {
		return arrivalTime;
	}

	// Sets the arrival time
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	// Gets the sheep's name
	public String getName() {
		return name;
	}

	// Sets the sheep's name
	public void setName(String name) {
		this.name = name;
	}
	
	public void change() {
		compare++;
	}

	// Has two different compareTo 's
	public int compareTo(Sheep s) {
		if(compare ==0) {
			if(arrivalTime < s.getArrivalTime()) {
				return -1;
			}
			else if(this.arrivalTime == s.getArrivalTime()) {
				return 0;
			}
			return 1;
		} else {
			if (this.sheerTime < s.getSheerTime()) {
				return -1;
			} 
			else if (this.sheerTime == s.getSheerTime()) {
				if (this.name.compareTo(s.getName()) > 1) {
					return 1;
				} else if (this.name.compareTo(s.getName()) < 1) {
					return -1;
				} else {
					return 0;
				}
			} else {
				return 1;
			}
		}
	}
	
	public String toString() {
		return "Name: " + getName() + ", Sheer Time: " + getSheerTime() + ", Arrival Time: " + getArrivalTime();
	}
}