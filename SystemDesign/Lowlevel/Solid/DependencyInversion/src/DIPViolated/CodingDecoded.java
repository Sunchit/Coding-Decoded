package DIPViolated;

public class CodingDecoded {

	public static void main(String[] args) {
		int stdCode  = 91;
		int no = 987654321;

		// Making a call via Jio network
		Jio jio = new Jio();
		jio.makeCall(stdCode, no);


//		Airtel airtel = new Airtel();
//		airtel.makeCall(stdCode, no);

	}
}
