package ukolScitaniCisel;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws InterruptedException{
        Pocitani pocitani = new Pocitani();
        long startTime = System.nanoTime();
        long soucet = pocitani.pocitej();
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("soucet je " + soucet);
        System.out.println("cas bez vlaken je " + totalTime);

        /*2 vlakna*/
        PocitaniVlakna pocitaniVlakna1 = new PocitaniVlakna(1, 500000);
        PocitaniVlakna pocitaniVlakna2 = new PocitaniVlakna(500001, 1000000);

        Thread vlakno1 = new Thread(pocitaniVlakna1);
        Thread vlakno2 = new Thread(pocitaniVlakna2);

        startTime = System.nanoTime();
        vlakno1.start();
        vlakno2.start();

        vlakno1.join();
        vlakno2.join();

        soucet = pocitaniVlakna1.getSoucet() + pocitaniVlakna2.getSoucet();


        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("soucet je " + soucet);
        System.out.println("cas je 2 vlakna " + totalTime);

        /**100 vlaken**/
        startTime = System.nanoTime();
        ArrayList<PocitaniVlakna> pocitaniList = new ArrayList<>();
        ArrayList<Thread> vlakna = new ArrayList<>();

        int rozsah = 1000000/100;
        int start = 1;
        int konec = rozsah;

        for (int i=0; i<100; i++){
            PocitaniVlakna pocitaniVlakna = new PocitaniVlakna(start, konec);
            pocitaniList.add(pocitaniVlakna);
            start = konec + 1;
            konec = konec + rozsah;
            Thread vlakno = new Thread(pocitaniVlakna);
            vlakna.add(vlakno);
            vlakno.start();
        }

        for (int i=0; i<100; i++){
            vlakna.get(i).join();
        }

        soucet = 0;
        for (int i=0; i<100; i++) {
            soucet = soucet + pocitaniList.get(i).getSoucet();
        }

        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("soucet je " + soucet);
        System.out.println("cas 100 je  vlakna " + totalTime);


    }
}
