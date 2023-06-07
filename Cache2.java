import java.util.*;
public class Cache2 {//2KB, direct mapped, 2-word blocks
    Integer[][] data = new Integer[4][2];
    Integer hit = 0;
    Integer miss = 0;
    int LRU = 0;
    public Cache2()
    {
        Integer[] fill = new Integer[2];
        Arrays.fill(fill,999);
        Arrays.fill(data,fill);
    }
    public void fill(int line) {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 3) & 0xFF)&3;
        int tag = (address >>> 10) & 0x1FFFFF;
        List<Integer> x = Arrays.asList(data[index]);
        if (!Arrays.asList(data[index]).contains(999))
        {
            if (Arrays.asList(data[index]).contains(tag))
            {
                miss++;
            }
            else
            {
                hit++;
                data[index][tag % 1] = tag;
            }

//            LRU = index;
        }
        else
        {
            miss++;
            data[index][tag % 1] = tag;
//            LRU = index;
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