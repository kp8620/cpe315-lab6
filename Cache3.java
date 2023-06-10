
import java.util.*;

public class Cache3 {//2KB, direct mapped, 4-word blocks
    int[] data = new int[(int)Math.pow(2,7)];
    int hit = 0;
    int miss = 0;
    public Cache3()
    {
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }
    public void fill(int line)
    {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 4) & 0x7F);
        int tag = (address >>> 11) & 0x1FFFFF;
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
        System.out.println("Cache #3");
        System.out.println("Cache size: 2048B\tAssociativity: 1\tBlock size: 4");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%%s", hit, (double) hit / ((double) (hit + miss)) * 100,"\n---------------------------\n");
    }
}
