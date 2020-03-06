public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result=new LinkedListDeque<>();
        for(int i=0;i<word.length();i++){
            result.addLast(word.charAt(i));
        }
        return result;
    }
    public boolean isPalindrome(String word){
        Deque mid=wordToDeque(word);
        if(mid.size()==1) return true;
        for(int i=0;i<mid.size()/2;i++){
            if(mid.get(i)!=mid.get(mid.size()-1-i)){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque mid=wordToDeque(word);
        if(mid.size()==1) return false;
        for(int i=0;i<mid.size()/2;i++){
            if(!cc.equalChars((char) mid.get(i),(char) mid.get(mid.size()-1-i))){
                return false;
            }
        }
        return true;
    }
}
