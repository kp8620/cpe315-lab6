
import java.util.*;
public class Cache7 {//4KB, direct mapped, 1-word blocks
    int[] data = new int[(int)Math.pow(2,10)];
    int hit = 0;
    int miss = 0;
    public Cache7()
    {
        Arrays.fill(data,999);
    }
    public void fill(int line)
    {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 2) & 0x3FF);
        int tag = (address >>> 12) & 0xFFFFF;
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
    public void getInfo() {
        System.out.println("Cache #7");
        System.out.println("Cache size: 4096B\tAssociativity: 1\tBlock size: 1");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%%s", hit, (double) hit / ((double) (hit + miss)) * 100,"\n---------------------------\n");
    }
}




