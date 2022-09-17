class Solution {
	 public int countEven(int num) {
	     int i=1;
	     int count = 0;
	     while(i<=num){
	         if(sumOfDigits(i)%2==0){
	             count++;
	         }
	         i++;
	     }
	     return count;
	 }




	private int sumOfDigits(int no) {
		String s = no +"";
		int sum = 0;
		for(char c: s.toCharArray()){
			sum += (c - '0');
		}
		return sum;
	}

	public int countEven(int num) {
		int temp = num;
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum % 2 == 0 ? temp / 2 : (temp - 1) / 2;
	}

}

