import java.util.Arrays;
public class Cache1 {// 2KB, direct mapped, 1-word blocks
    Integer[] data = new Integer[(int)Math.pow(2,9)];
    Integer hit = 0;
    Integer miss = 0;
    public Cache1()
    {
        Arrays.fill(data,999);
    }
    public void fill(int line) {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 2) & 0x1FF);
        int tag = (address >>> 9) & 0x7FFFFF;
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
        System.out.println("Cache #1");
        System.out.println("Cache size: 2048B\tAssociativity: 1\tBlock size: 1");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%", hit, (double) hit / ((double) (hit + miss)) * 100);
        System.out.println("\n---------------------------");
    }
}