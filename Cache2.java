import java.util.*;
public class Cache2 {//2KB, direct mapped, 2-word blocks
    int[] data = new int[(int)Math.pow(2,8)];
    int hit = 0;
    int miss = 0;
    public Cache2()
    {
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }
    public void fill(int line) {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 3) & 0xFF);
        int tag = (address >>> 10) & 0x1FFFFF;
        if (data[index] == tag)
        {
            hit++;
        }
        else
        {
            miss++;
            data[index] = tag;
        }
    }
    public void getInfo()
    {
        System.out.println("Cache #2");
        System.out.println("Cache size: 2048B\tAssociativity: 1\tBlock size: 2");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%%s", hit, (double) hit / ((double) (hit + miss)) * 100,"\n---------------------------\n");
    }
}