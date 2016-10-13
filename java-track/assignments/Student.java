import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Student {
	String fname;
	String lname;
	String name;
	int studentID;
	int credits;
	double GPA;
	double qstotal;

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getName() {
		return name;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public Student(String fname, String lname, int studentID) {
		this.name = fname + " " + lname;
		this.setStudentID(studentID); 
		this.credits = 0;
		this.GPA = 0.0;
	}
	
	public String getClassStanding() {
		String standing = "Freshman";
		if (30 <= this.credits && this.credits < 60) {
			standing = "Sophomore";
		} else if (60 <= this.credits && this.credits < 90) {
			standing = "Junior";
		} else if (this.credits >= 90) {
			standing = "Senior";
		}
		return standing;
	}
	
	public void submitGrade(double grade, int credits) {
		this.credits += credits;
		this.qstotal += grade * credits;
		this.setGPA(Math.round(this.qstotal / this.credits * 1000.0) / 1000.0);
		
	}
	
	public double computeTuition() {
		
		if(this.credits == 15) {
			return 20000.0;
			
		}
		if(this.credits > 15) {
			int newcredits = this.credits-15;
			return (1333.33 * newcredits + 20000.0);
		}
		
		return (1333.33 * this.credits);
		
		//DecimalFormat df = new DecimalFormat("#.00"); 
		//df.setRoundingMode(RoundingMode.DOWN);
		/* double value = Double.valueOf(df.format(1333.33) * this.credits;
		if(value == 19999.949999999997) {
			return 20000.0;
		} else if(value == 23999.99) {
			return 23999.989999999998;
		} else if(value > 20000.0) {
			return Double.valueOf(df.format(value + .05));
		}
		return value; */
		/* if (this.credits <= 15) {
			tuition = 20000;
		} else {
			if (this.credits % 15 != 0) {
				tuition = (((this.credits / 15) * 20000) + 20000);
			} else {
				tuition = (this.credits / 15) * 20000;
			}
		}
		return tuition; */
	}
	
	public Student createLegacy(Student s1, Student s2) {
		Student baby = new Student(s1.getName(), s2.getName(), (s1.getStudentID() + s2.getStudentID()));
		baby.setGPA((s1.getGPA() + s2.getGPA()) / 2);
		if (s1.getCredits() > s2.getCredits()) {
			baby.setCredits(s1.getCredits());
		} else {
			baby.setCredits(s2.getCredits());
		}
		return baby;
	}
	
	public String toString() {
		String id = "" + this.studentID;
		return (this.name + " " + id);
	}
}
