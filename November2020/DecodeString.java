class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> freqStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int k =0;
        for(char c :  s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + (c-'0');
            } else if (Character.isLetter(c)){
                currStr.append(c);
            } else if(c == '['){
                freqStack.push(k);
                strStack.push(currStr);
                k =0;
                currStr = new StringBuilder();
            } else if(c == ']'){
                StringBuilder temp = currStr;
                int freq = freqStack.pop();
                currStr = strStack.pop();
                while(freq-->0){
                    currStr.append(temp);

                }
                k = 0;
            }
        }
        return currStr.toString();
    }
}