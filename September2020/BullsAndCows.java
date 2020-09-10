class BullsAndCows {

    // O(n) time complexity , O(1) =>Space
    public String getHint(String secret, String guess) {
        int bulls =0;
        int cows =0;
        int[] secretFreq =new int[10];

        int[] guessFreq =new int[10];

        // O(n)
        for(int i=0;i<secret.length();i++){
            char secretChar = secret.charAt(i);

            char guessChar = guess.charAt(i);

            if(secretChar == guessChar){
                bulls++;
            } else{
                secretFreq[secretChar -'0']++;

                guessFreq[guessChar -'0']++;
            }
        }

        // O(1)
        for(int i=0;i<10;i++){
            cows += Math.min(secretFreq[i], guessFreq[i]);
        }

        return bulls +"A"+ cows +"B";
    }
}