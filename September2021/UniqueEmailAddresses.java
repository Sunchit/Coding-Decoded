class Solution {

    // O(Len(emails)* max(Len(Email))
    public int numUniqueEmails(String[] emails) {
        Set<String> sanitizedEmails = new HashSet<>();
        for(String email : emails){
            String updatedEmail =  getSanitizeEmail(email);
            sanitizedEmails.add(updatedEmail);
        }
        return sanitizedEmails.size();

    }

    private String getSanitizeEmail(String email){
        String localName ="";

        int i = 0;
        while(i<email.length() && email.charAt(i) !='@'){
            if(email.charAt(i) == '.'){
                i++;
            } else if(email.charAt(i) == '+'){
                while(i<email.length() && email.charAt(i) !='@'){
                    i++;
                }
            } else {
                localName += email.charAt(i);
                i++;
            }
        }
        // skip one char for @
        i++;
        String domain = "";
        while(i<email.length()){
            System.out.println(i);
            domain +=email.charAt(i);
            i++;
        }
        return localName + "@" + domain;

    }
}