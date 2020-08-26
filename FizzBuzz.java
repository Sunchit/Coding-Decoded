class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15==0){ // Check for state #1 => No mulitple of 15
                ans.add("FizzBuzz");
            } else if(i%5==0){  // Check for state #2 => No mulitple of 5
                ans.add("Buzz");
            } else if(i%3==-0){ // Check for state #3 => No mulitple of 3
                ans.add("Fizz");
            } else{ // Check for state #4 => None of the above
                ans.add(i+"");
            }
        }
        return ans;
    }
}