
public class Course {
	String name;
	int credits;
	int seats;
	Student[] roster;
	int counter = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getRemainingSeats() {
		return seats;
	}
	public void setRemainingSeats(int seats) {
		this.seats = seats;
	}
	public Student[] getRoster() {
		return roster;
	}
	public void setRoster(Student[] roster) {
		this.roster = roster;
	}
	
	public Course(String name, int credits, int seats) {
		this.setName(name);
		this.setCredits(credits);
		this.setRemainingSeats(seats);
		this.roster = new Student[seats];
	}
	
	public boolean addStudent(Student student) {
		String name = student.name;
		
		//check if already enrolled
		if(counter != 0) {
			for(int i = 0; i < counter; i++) {
				if(name == this.roster[i].name) {
				return false;
				} else if(this.seats == 0) {
				return false;
				}
			}
		}
		
		this.seats -= 1;
		this.roster[counter] = student;
		this.counter += 1;
		return true;
	}
	
	public String generateRoster(Student[] roster) {
		String rosterstr = "";
		
		for(int i = 0; i < counter; i++) {
				rosterstr += roster[i].name;
			}
		
		return rosterstr;
	}
	
	public double averageGPA() {
		int gpacount = 0;
		double gpasum = 0.0;
		if(counter != 0) {
			for(int i = 0; i < counter; i++) {
					gpacount += 1;
					gpasum += this.roster[i].GPA;
			}
			
		return gpasum / gpacount;
		} else {
			return gpasum;
		}
	}
	
	public String toString() {
		String credits = "" + this.credits;
		return (this.name + "" + credits);
	}
}
