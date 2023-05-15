package DIPCompliant;

public class Airtel implements Network{

	public void makeCall(int stdCode, int no){
		System.out.println("Making a call via airtel network on "
						                   + stdCode + "-"+ no);
	}

}
