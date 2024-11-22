// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(3,0));   // 2 + 3
	    System.out.println(minus(7,-2));  // 7 - 2
   		System.out.println(minus(0,-5));  // 2 - 7
 		System.out.println(times(3,-4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x1 >0)
		{
			x2++;
			x1--;
		}
		while (x1<0)
		{
			x1++;
			x2--;
		}
		return x2;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		while (x2>0)
		{
			x1--;
			x2--;
		}
		while (x2<0)
		{
			x2++;
			x1++;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int t=0;
		if (x1>0 && x2>0)
		{
			for (int i=0; i<x2; i++)
			{
				t= plus(t,x1);
			}
		}
		else if (x1>0 && x2<0)
		{
			for (int i=0; i>x2; i--)
			{
				t= plus(t,x1);				
			}
			t= minus(0,t);
		}
		else if (x1<0 && x2>0)
		{
			for (int i=0; i<x2; i++)
			{
				t= plus(t,x1);				
			}
			
		}
		else if (x1<0 && x2<0)
		{
			for (int i=0; i>x2; i--)
			{
				t= minus(t,x1);				
			}
		}
		return t;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int p= 1;
		for (int i=0; i<n; i++)
		{
			p= times(x,p);
		}
		return p;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int di = 0;
		if (x1>0 && x2>0)
		{
		int m = x1;
		while (m>0)
		{
			m = minus(m,x2);
			if(m>=0)
			{
			di++;
			}
		}
		}
		else if (x1>0 && x2<0)
		{	
			int x2p = minus(0,x2);
			int m = x1;
			while (m>0)
			{
				m = minus(m,x2p);
				if(m>=0)
				{
				di++;
				}
			}
			di=minus(0,di);
		}
		else if (x1<0 && x2>0)
		{
			int x1p = minus(0,x1);
			int m = x1p;
			while (m>0)
			{
				m = minus(m,x2);
				if(m>=0)
				{
				di++;
				}
			}
			di=minus(0,di);
		}
		else if (x1<0 && x2<0)
		{
			int x1p = minus(0,x1);
			int x2p = minus(0,x2);
			int m = x1p;
		while (m>0)
		{
			m = minus(m,x2p);
			if(m>=0)
			{
			di++;
			}
		}
		}
		return di;
	
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int m = x1;
		if (x1>0 && x2>0)
		{
			do
			{
			m = minus(m,x2);
			}
			while (m>=x2);
		}
		else if (x1>0 && x2<0)
		{
			int x2p = minus(0,x2);
			do
			{
				m = minus(m,x2p);
			}
		while (m>x2p);
		}
		else if (x1<0 && x2>0)
		{
			int x1p = minus(0,x1);
			m = x1p;
			do
			{
				m = minus(m,x2);
			} 
			while (m>x2);
		}
		else if (x1<0 && x2<0)
		{
			int x1p = minus(0,x1);
			int x2p = minus(0,x2);
			m = x1p;
		do
		{
			m = minus(m,x2p);
		} 
		while (m>0);
		}
		return m;
	
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x==1)
		{
			return x;
		}
		else
		{
		int g = div(x, 2);
		int p = 1;
	
		while (true) {
			int q = div(x,g);
			int ng = div((plus(g,q)),2);
			if ((minus(g,ng) < p) && (minus(ng, g) < p))
			{
				break;
			}
			g = ng;
		}
		return g;
	}
	}	  	  
}