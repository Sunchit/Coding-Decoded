
// @saorav21994
// TC : O(log <base 62> (number of test cases))
// SC : O(n)

// This question is more focussed on system design.

public class Codec {
    
    String baseString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char [] base = baseString.toCharArray();
    Map<String, Integer> shortMap = new HashMap<>();
    Map<Integer, String> longMap = new HashMap<>();
    static int id = 0;
    final int MAX = 62;
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        id += 1;
        int copy = id;
        StringBuffer buffer = new StringBuffer();
        while (copy > 0) {
            buffer.append(base[copy%MAX]);
            copy /= MAX;
        }
        String shortUrl = buffer.reverse().toString();
        shortMap.put(shortUrl, id);
        longMap.put(id, longUrl);
        return shortUrl;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
     
        int id = shortMap.getOrDefault(shortUrl, 0);
        if (id == 0)
            return "";
        
        return longMap.getOrDefault(id, "");
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
