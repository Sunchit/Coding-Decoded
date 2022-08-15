class Solution {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int no = 0;
		for(int i = s.length()-1;i>=0;i--){
			char c = s.charAt(i);
			int currNo = map.get(c);
			//   System.out.println(currNo);
			if(i!=s.length()-1) {
				char charNext = s.charAt(i+1);

				if(c=='I' && ((charNext=='V')||(charNext=='X'))){
					no = no - currNo;
					//System.out.println(currNo+" here" + no);
				} else if(c=='X' && ((charNext=='L')||(charNext=='C'))){
					no = no - currNo;
				} else if(c=='C' && ((charNext=='M')||(charNext=='D'))){
					no = no - currNo;
				}  else{
					// System.out.println(currNo);
					no = no+currNo;
				}
			}  else {

				no = no+currNo;
				// System.out.println("first "+no);
			}
		}
		//System.out.println("no is " +no);
		return no;
	}
}