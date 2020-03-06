public class OffByOne implements CharacterComparator{


    @Override
    public boolean equalChars(char x, char y) {
        int dif=Math.abs(x-y);
        return dif==1;
    }
}
