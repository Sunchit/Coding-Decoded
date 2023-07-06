package CreationalDesignPattern.SingletonPattern;

public class BillPughCodingDecoded {

    private BillPughCodingDecoded(){
        System.out.println("Creating instance of Coding Decoded");
    }

    // Static inner class 
    private static class SingletonHelper {
        private static final BillPughCodingDecoded INSTANCE = new BillPughCodingDecoded();
    }

    public static BillPughCodingDecoded getCodingDecoded() {
        System.out.println("Returning instance of Coding Decoded");
        return SingletonHelper.INSTANCE;
    }
}


