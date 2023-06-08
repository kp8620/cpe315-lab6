import java.util.*;
public class Cache2 {//2KB, direct mapped, 2-word blocks
    Integer[] data = new Integer[(int)Math.pow(2,8)];
    Integer hit = 0;
    Integer miss = 0;
    public Cache2()
    {
        Arrays.fill(data,999);
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
        System.out.printf("Hits: %d\tHit Rate: %.2f%%", hit, (double) hit / ((double) (hit + miss)) * 100);
        System.out.println("\n---------------------------");
    }
}