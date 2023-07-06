package CreationalDesignPattern.SingletonPattern;

public class StaticBlockInitializationCodingDecoded {

    private static StaticBlockInitializationCodingDecoded codingDecoded = null;

    static {
        try {
            codingDecoded = new StaticBlockInitializationCodingDecoded();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }


    private StaticBlockInitializationCodingDecoded(){
        System.out.println("Object getting created in static block initialization");
    }

    public static StaticBlockInitializationCodingDecoded getCodingDecoded(){
        System.out.println("Returning Get Coding Decoded instance in static block initialization");
        return codingDecoded;
    }

}