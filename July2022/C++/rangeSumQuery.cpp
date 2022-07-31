class NumArray {
public:
    vector<int> v;
    int sum = 0;
    NumArray(vector<int>& nums) {
        for(int i=0;i<nums.size();i++)
        {
            v.push_back(nums[i]);
            sum += nums[i];
        }
    }
    
    void update(int index, int val) {
        sum += (val - v[index]);
        v[index] = val;
        
    }
    
    int sumRange(int left, int right) {
       int ans = 0;
        if(right-left<v.size()/2)
        {
            ans = accumulate(v.begin()+left,v.begin()+right+1,0);
        }
        else 
        {
            ans = sum - accumulate(v.begin(),v.begin()+left,0)-
                accumulate(v.begin()+right+1,v.end(),0);
        }
        return ans;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */
