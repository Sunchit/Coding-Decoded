
class Solution {
	public char findTheDifference(String s, String t) {
		char ans ='0';
		for(char c : s.toCharArray()){
			ans ^= c;
		}
		for(char c : t.toCharArray()){
			ans ^= c;
		}

		ans ^= '0';
		return ans;
	}
}

//Author: Shobhit Behl (LeetCode:shobhitbruh)

//HashMap Solution (naive approach)

public class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> hs=new HashMap<>();
        char[] arr=s.toCharArray();
        for(char x:arr){
            hs.put(x,hs.getOrDefault(x,0)+1);
        }
        
        char[] abc=t.toCharArray();
        char ans='&';
        for(char x:abc){
          if(hs.containsKey(x)){
              hs.put(x,hs.get(x)-1);
              if(hs.get(x)==0){
                  hs.remove(x);
              }
          }else{
              ans=x;
              break;
          }  
        }
        
        return ans;
    }
}


// (Optimized) Bit-Manipulation Solution T:O(n+m), where n is s.length() and m is t.length();

public class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
	for (int i = 0; i < s.length(); ++i) {
		c ^= s.charAt(i);
	}
	for (int i = 0; i < t.length(); ++i) {
		c ^= t.charAt(i);
	}
	return c;
    }
}
