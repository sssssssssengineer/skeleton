/**
 * Created by CYS on 2016/7/21.
 */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y){
        return (x + 1 == y);
    }
}
