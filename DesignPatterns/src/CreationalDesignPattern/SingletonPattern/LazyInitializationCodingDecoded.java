package CreationalDesignPattern.SingletonPattern;

public class LazyInitializationCodingDecoded {

    private static LazyInitializationCodingDecoded codingDecoded = null;

    private LazyInitializationCodingDecoded(){
        System.out.println("Object getting created lazily");
    }

    public static LazyInitializationCodingDecoded getCodingDecoded(){
        System.out.println("Returning Get Coding Decoded instance in Lazy Initialization");
        if(null == codingDecoded){
            codingDecoded = new LazyInitializationCodingDecoded();
        }
        return codingDecoded;
    }
}
