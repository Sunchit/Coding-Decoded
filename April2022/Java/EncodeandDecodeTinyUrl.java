// Author: Shobhit Behl (LC: shobhitbruh)
public class Codec {

    // Encodes a URL to a shortened URL.

    /*
    
    Here i have decoded the string by taking the int value of its each character 
    and by adding '.' in front of it.

    For e.g in string = "add" the encoded string would be "97.100.100."
    
    
    */

    public String encode(String longUrl) {
        char[] l=longUrl.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<l.length;i++){
            int k=(int)l[i];
            sb.append(k);
            sb.append('.');
        }
        return sb.toString();
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] y=shortUrl.split("\\.");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<y.length;i++){
            int k=Integer.parseInt(y[i]);
            char p=(char)k;
            sb.append(p);
        }
        
        return sb.toString();
    }
}