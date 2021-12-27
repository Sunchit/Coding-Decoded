// TC : O(1)
class Solution {

     public int findComplement(int num) {
         int multi =1;
         int newNo =0;

        while(num!=0){
            int binaryRep = (num%2 ==0) ?1:0;
            num=num/2;
            newNo = binaryRep * multi +newNo;
            multi = multi*2;
        }
         return newNo;
     }

	public int findComplement(int num)
	{
		int no = 0;
		int power = 0;

		while (no < num)
		{
			no += Math.pow(2, power);
			power++;
		}

		return no - num;
	}
}

