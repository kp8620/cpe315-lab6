
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Cache3 {//2KB, direct mapped, 4-word blocks
    Integer[][] data = new Integer[4][4];
    Integer hit = 0;
    Integer miss = 0;
    public Cache3()
    {
        Integer[] fill = {999,999,999,999};
        Arrays.fill(data,fill);
    }
    public void fill(int line)
    {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 4) & 0x7F) & 3;
        int tag = (address >>> 11) & 0x1FFFFF;
        List<Integer> x = Arrays.asList(data[index]);
        if (x.contains(999))
        {
            if (Arrays.asList(data[index]).contains(tag))
            {
                miss++;
            }
            else
            {
                hit++;
                data[index][tag % 3] = tag;
            }
        }
        else
        {
            miss++;
            data[index][tag % 3] = tag;
        }
    }
    public void getInfo()
    {
        System.out.println("Cache #3");
        System.out.println("Cache size: 2048B\tAssociativity: 1\tBlock size: 4");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%", hit, (double) hit / ((double) (hit + miss)) * 100);
        System.out.println("\n---------------------------");
    }
}
