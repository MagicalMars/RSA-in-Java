import java.math.BigInteger;
import java.util.Scanner;
public class RSA{
    public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("-----It's an RSA calculator!!! For all of your simple RSA calculating needs!-----\n");
		System.out.println("Please input message (m1)"); //Must be less than n
		BigInteger m1 = scnr.nextBigInteger();
		System.out.println("Please input p");
		BigInteger p = scnr.nextBigInteger();
		System.out.println("Please input q");
		BigInteger q = scnr.nextBigInteger(); 
		System.out.println("Please input e (coprime to phi(n))");
		BigInteger e = scnr.nextBigInteger();
		
		//---------------------------- encryption ----------------------------

		//n = p*q
		BigInteger n = p.multiply(q);

		//phi(n) = (p-1) * (q-1)
		BigInteger phiN = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); //All that effort to subtract 1 from two numbers being multiplied together, yikes
		
		//d = e^-1 mod phi(n)
		BigInteger d = e.modInverse(phiN);
		
        // c = m^e mod n
		BigInteger c = m1.modPow(e, n);
		
		//---------------------------- decryption ----------------------------

		
        // m' = c^e mod n
		BigInteger m2 = c.modPow(d, n);
		
		System.out.println("\nFormulas:");
		System.out.println("Encryption");
		
		System.out.println("\nn = p*q");
		System.out.println(n + " = " + p + "*" + q);
		
		
		System.out.println("\nphi(n) = (p-1)*(q-1)");
		System.out.println(phiN + " = (" + p + "-1) * (" + q + "-1)");
		
		System.out.println("\nd = e^-1 mod phi(n)");
		System.out.println(d + " = " + e + "^-1 mod " + phiN);
		
		System.out.println("\nc = m^e mod n");
		System.out.println(c  + " = " + m1 + "^" + e + " mod " + n);
		
		
		
		System.out.println("\n\nPublic key (n,e):");
		System.out.println("n = " + n);
		System.out.println("e = " + e);

		System.out.println("\nPrivate/secret key (d):");
		System.out.println("d = " + d);
		
		
		System.out.println("\n\nDecryption");
		
		System.out.println("m2 = c^d mod n");
		System.out.println(m2 + " = " + c + "^" + d + " mod " + n);
		
		
		
		System.out.println("\nAll values:");
		System.out.println("m1:\t" + m1);
		System.out.println("n:\t" + n);
		System.out.println("phi(n):\t" + phiN); //Is the totient, I prefer calling it phi(N), get over it
		System.out.println("d:\t" + d);
		System.out.println("c:\t" + c);
		System.out.println("m2:\t" + m2);

		if(m1.compareTo(m2) == 0) {
			System.out.println("m1 (initial message) and m2 (decrypted message) match\n");
		} else {
			System.out.println("Invalid inputs. Please try again\n");//hopefully not my fault
		}
        scnr.close();
	}

}
