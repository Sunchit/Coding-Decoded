package DIPCompliant;

public class Jio implements Network {

	public void makeCall(int stdCode, int no){
		System.out.println("Making a call via jio network on "
						                   + stdCode + "-"+ no);
	}

}
