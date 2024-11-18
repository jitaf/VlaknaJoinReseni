package ukolScitaniCisel;

public class Pocitani {

    public long pocitej(){
        long soucet = 0;
        for (int i=1; i<=1000000; i++){
            soucet = soucet + i;
        }
        return soucet;
    }
}
