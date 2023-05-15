package DIPCompliant;

public class CodingDecoded {

//

	public static void main(String[] args) {
		int stdCode  = 91;
		int no = 987654321;

		// Making a call via Jio network
		Network network = new Airtel();
		network.makeCall(stdCode, no);

	}
}
