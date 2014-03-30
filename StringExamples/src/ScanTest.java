import java.util.Comparator;
import java.util.Scanner;

public class ScanTest {

	public static void main(String[] args) {
		System.out.print("input: ");
		System.out.flush();
		String pattern = "\\d\\d";
		try {
			Scanner s = new Scanner(System.in);
			String token;
			do {
				token = s.findInLine(pattern);
				System.out.println("found " + token);
			} while (token != null);
		} catch (Exception e) {
			System.out.println("scan exc");
		}
	}

}

class Moof {
	private int moofValue;

	Moof(int val) {
		moofValue = val;
	}

	public int getMoofValue() {
		return moofValue;
	}

	public boolean equals(Object o) {
		if ((o instanceof Moof)
				&& (((Moof) o).getMoofValue() == this.moofValue)) {
			return true;
		} else {
			return false;
		}
	}
}


