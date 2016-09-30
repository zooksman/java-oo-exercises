package class_design;

public class Fraction {
	public int num;
	public int den;
	
	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	public Fraction add(Fraction frac2) {
		int finalnum1 = this.num * (gcd(this.den, frac2.den) / this.den);
		int finalnum2 = frac2.num * (gcd(this.den, frac2.den) / frac2.den);

		int finalden = gcd(this.den, frac2.den);
		return(new Fraction((finalnum1 + finalnum2), finalden));
	}
	
	public Fraction mult(Fraction frac2) {
		int finalnum = this.num * frac2.num;
		int finalden = this.den * frac2.den;
		
		return(new Fraction(finalnum, finalden));
	}
	
	public Fraction simplify() {
		int gcd = gcd(this.num, this.den);
		if (gcd == 1) {
			return (new Fraction(this.num, this.den));
		} else {
			return (new Fraction((this.num / gcd), (this.den / gcd)));
		}
	}
	
	public Fraction recip() {
		int finalnum = this.den;
		int finalden = this.num;
		
		return(new Fraction(finalnum, finalden));
	}
	
	
	public int gcd(int p, int q) {
		while (q != 0) {
            int temp = p;
            q = p % q;
            p = temp;
        }
		return (p);
	}
}
