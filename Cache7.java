
import java.util.*;
public class Cache7 {//4KB, direct mapped, 1-word blocks
    int[] data = new int[4];
    Integer hit = 0;
    Integer miss = 0;
    public Cache7()
    {
        Arrays.fill(data,999);
    }
    public void fill(int line)
    {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 2) & 0x3FF) & 3;
        int tag = (address >>> 12) & 0xFFFFF;
        if (data[index] != 999)
        {
            hit++;
            data[index] = tag;
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
        System.out.printf("Hits: %d\tHit Rate: %.2f%%", hit, (double) hit / ((double) (hit + miss)) * 100);
        System.out.println("\n---------------------------");
    }
}




