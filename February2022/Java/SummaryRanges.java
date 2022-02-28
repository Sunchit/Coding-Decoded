

// @saorav21994
// TC : O(n)


class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<String>();
        StringBuffer str = new StringBuffer("");
        if (n == 0) {
            return res;
        }
        str.append(String.valueOf(nums[0]));
        int last = nums[0];
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i-1]) != 1) {
                if (last != nums[i-1]) {
                    str.append("->");
                    str.append(String.valueOf(nums[i-1]));
                }
                res.add(String.valueOf(str));
                str = new StringBuffer("");
                str.append(String.valueOf(nums[i]));
                last = nums[i];
            }
        }
        if (last != nums[n-1]) {
            str.append("->");
            str.append(String.valueOf(nums[n-1]));
        }
        res.add(String.valueOf(str));
        return res;
    }
}

//Author : Shobhit Behl (LC : shobhitbruh)
class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> ans=new ArrayList<>();
        if(arr.length==0){
            return ans;
        }
        
        int i=0,j=0;
        while(i<arr.length){
            if(arr[i]-arr[j]!=i-j){
                StringBuilder sb=new StringBuilder();
                if(i-1==j){
                    sb.append(arr[j]);
                    ans.add(sb.toString());
                }else{
                    sb.append(arr[j]+"->"+arr[i-1]);
                    ans.add(sb.toString());
                }
                j=i;
            }
            i++;
        }
        StringBuilder sb=new StringBuilder();
       if(i-1==j){
                    sb.append(arr[j]);
                    ans.add(sb.toString());
                }else{
                    sb.append(arr[j]+"->"+arr[i-1]);
                    ans.add(sb.toString());
                }
        return ans;
    }
}
