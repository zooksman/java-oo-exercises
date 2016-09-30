package class_design;

public class Rectangle {
	public int x;
    public int y;

	public Rectangle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int area() {
		return (this.x * this.y);
	}
	
	public int perimeter() {
		return (2 * (this.x + this.y));
	}
	
	public boolean checkSize(Rectangle rec1, Rectangle rec2) {
		if (rec1.area() > rec2.area()) {
			return true;
		} else {
			return false;
		}
	}
		
	public boolean checkSquare() {
		if (this.x == this.y) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle(3, 3);
		Rectangle rec2 = new Rectangle(4, 5);
		System.out.println(rec1.area());
		System.out.println(rec2.perimeter());
		System.out.println(rec1.checkSize(rec1, rec2));
		System.out.println(rec1.checkSquare());
	}
}
