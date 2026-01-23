class Solution {
    public String reversePrefix(String word, char ch) {
        if(word.indexOf(ch)==-1)
        return word;
        StringBuilder prefix=new StringBuilder(word.substring(0,word.indexOf(ch)+1));
        prefix.reverse();
        String ans=prefix.toString();
        return ans+word.substring(word.indexOf(ch)+1);
    }
}