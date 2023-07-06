package CreationalDesignPattern.SingletonPattern;

//public class ThreadSafeCodingDecoded {
//
//    private static ThreadSafeCodingDecoded codingDecoded = null;
//
//    private ThreadSafeCodingDecoded(){
//        System.out.println("Object getting created inside thread safe");
//    }
//
//    public synchronized static ThreadSafeCodingDecoded getCodingDecoded(){
//        System.out.println("Returning Get Coding Decoded instance in Thread safe class");
//        if(null == codingDecoded){
//            codingDecoded = new ThreadSafeCodingDecoded();
//        }
//        return codingDecoded;
//    }
//}


public class ThreadSafeCodingDecoded {

    private static ThreadSafeCodingDecoded codingDecoded = null;

    private ThreadSafeCodingDecoded(){
        System.out.println("Object getting created inside thread safe");
    }

    public static ThreadSafeCodingDecoded getCodingDecoded(){
        System.out.println("Returning Get Coding Decoded instance in Thread safe class");
        if(null == codingDecoded) {
            synchronized (ThreadSafeCodingDecoded.class) {
                codingDecoded = new ThreadSafeCodingDecoded();
            }
        }
        return codingDecoded;
    }
}
