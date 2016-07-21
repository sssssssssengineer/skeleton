/**
 * Created by CYS on 2016/7/21.
 */
public class Palindrome {
    public static Deque<Character> wortToDeque(String word){
        //recursively
        if (word.length() == 0){
            return new LinkedListDequeSolution<Character>();
        }
        Deque<Character> lld = wortToDeque(word.substring(1));
        lld.addFirst(word.charAt(0));
        return lld;
    }
    public static boolean isPalindrome(String word){
        Deque<Character> d = wortToDeque(word);
        while (d.size() > 1){
            if (d.removeLast() != d.removeFirst()){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d = wortToDeque(word);
        while (d.size() > 1){
            if (cc.equalChars(d.removeLast(), d.removeFirst()) == false){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "hello";
        Deque<Character> d = wortToDeque(s);
        d.printDeque();
        System.out.println(isPalindrome("flake", new OffByOne()));
    }


}
