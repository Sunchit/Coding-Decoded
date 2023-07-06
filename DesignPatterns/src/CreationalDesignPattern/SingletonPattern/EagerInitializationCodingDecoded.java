package CreationalDesignPattern.SingletonPattern;

public class EagerInitializationCodingDecoded {

    private static final EagerInitializationCodingDecoded codingDecoded
            = new EagerInitializationCodingDecoded();

    private EagerInitializationCodingDecoded(){
        System.out.println("Object getting created eagerly");
    }

    public static EagerInitializationCodingDecoded getCodingDecoded(){
        System.out.println("Returning static Coding Decoded instance in eager initialization");
        return codingDecoded;
    }
}


