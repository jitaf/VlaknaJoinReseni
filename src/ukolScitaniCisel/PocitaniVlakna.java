package ukolScitaniCisel;

public class PocitaniVlakna implements Runnable{
    private long soucet;
    private int start;
    private int konec;

    public PocitaniVlakna(int start, int konec){
        this.start = start;
        this.konec = konec;
    }
    @Override
    public void run(){
        for (int i=start; i<=konec; i++){
            soucet = soucet + i;
        }
    }
    public long getSoucet() {
        return soucet;
    }
}
