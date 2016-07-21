/**
 * Created by CYS on 2016/7/21.
 */
public class OffByN implements CharacterComparator {
    int N;
    public OffByN(int N){
        this.N = N;
    }
    public boolean equalChars(char x, char y){
        return (x + N == y);
    }
}
