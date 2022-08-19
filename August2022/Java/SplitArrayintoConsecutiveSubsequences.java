
class Solution {
	// TC : O(n)
	// SC : O(n)
	public boolean isPossible(int[] nums) {

		HashMap<Integer,Integer> avaibilityMap = new HashMap<>();

		HashMap<Integer,Integer> vacancyMap = new HashMap<>();

		for(int i : nums) {
			avaibilityMap.put(i, avaibilityMap.getOrDefault(i,0)+1);
		}

		for(int i=0;i<nums.length;i++){
			if(avaibilityMap.get(nums[i])<=0){
				continue;
			}

			else if(vacancyMap.getOrDefault(nums[i],0)>0){
				avaibilityMap.put(nums[i], avaibilityMap.getOrDefault(nums[i],0)-1);

				vacancyMap.put(nums[i], vacancyMap.getOrDefault(nums[i],0)-1);
				//System.out.println("Vacancy found for " +  (nums[i]+1));

				vacancyMap.put(nums[i]+1, vacancyMap.getOrDefault(nums[i]+1,0)+1);
			}

			else if(avaibilityMap.getOrDefault(nums[i],0)>0 && avaibilityMap.getOrDefault(nums[i]+1,0)>0 && avaibilityMap.getOrDefault(nums[i]+2,0)>0){

				avaibilityMap.put(nums[i], avaibilityMap.getOrDefault(nums[i],0)-1);
				avaibilityMap.put(nums[i]+1, avaibilityMap.getOrDefault(nums[i]+1,0)-1);
				avaibilityMap.put(nums[i]+2, avaibilityMap.getOrDefault(nums[i]+2,0)-1);

				vacancyMap.put(nums[i]+3, vacancyMap.getOrDefault(nums[i]+3,0)+1);
			}

			else{
				return false;
			}
		}

		return true;
	}
}

// ===================================================================================================================================================================

// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public boolean isPossible(int[] nums) {
        
        /*
            For each number, we can either append it to an existing sequence, or, 
            create a new sequence.
            Pref : add it to new sequence.
            Also, for new sequence at least 3 number (i, i+1, i+2) should exist
            
        */
        
        Map<Integer, Integer> numFreq = new HashMap<>();        // how many number n is left to be placed
        Map<Integer, Integer> numSeqEndFreq = new HashMap<>();      // number of sequences ending with this number
        
        // find frequency of each number
        for (int n : nums)
            numFreq.put(n, numFreq.getOrDefault(n, 0) + 1);
        
        for (int n : nums) {
            
            if (numFreq.get(n) == 0)
                continue;       // number already placed
            
            // can the number be added to an existing sequence
            boolean addToSequence = numSeqEndFreq.getOrDefault(n-1, 0) > 0;
            
            // can a new sequence be created from this number 
            boolean createNewSequence = (numFreq.getOrDefault(n+1, 0) > 0) && (numFreq.getOrDefault(n+2, 0) > 0);
            
            if (addToSequence) {
                
                // decrease count of current number
                numFreq.put(n, numFreq.get(n)-1);
                
                // decrease count of n-1's end sequence count
                numSeqEndFreq.put(n-1, numSeqEndFreq.get(n-1)-1);
                
                // increase count of n's end sequence count
                numSeqEndFreq.put(n, numSeqEndFreq.getOrDefault(n, 0)+1);
                
            }
                
            else if (createNewSequence) {
                
                // decrease count of n, n+1, n+2 
                numFreq.put(n, numFreq.get(n)-1);
                numFreq.put(n+1, numFreq.get(n+1)-1);
                numFreq.put(n+2, numFreq.get(n+2)-1);
                
                // increase count of n+2's end sequence count
                numSeqEndFreq.put(n+2, numSeqEndFreq.getOrDefault(n+2, 0)+1);
                
            }
            
            else
                return false;
                
        }
        
        return true;
    
    }
}
