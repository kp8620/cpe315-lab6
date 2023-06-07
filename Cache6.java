
import java.util.*;
public class Cache6 {//2KB, 4-way set associative, 4-word blocks
    Integer[][] data = new Integer[8][32];
    Integer hit = 0;
    Integer miss = 0;
    public Cache6()
    {
        Integer[] fill = new Integer[32];
        Arrays.fill(fill,999);
        Arrays.fill(data,fill);
    }
    public void fill(Integer line) {
        fillCache(line);
    }

    public void fillCache(Integer address) {
        Integer index = ((address >>> 4) & 0x1F) & 3;
        Integer tag = (address >>> 9) & 0x7FFFFF;
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
                data[index][tag % 31] = tag;
            }
        }
        else
        {
            miss++;
            data[index][tag % 31] = tag;
        }

    }
    public void getInfo() {
        System.out.println("Cache #6");
        System.out.println("Cache size: 2048B\tAssociativity: 4\tBlock size: 4");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%", hit, (double) hit / ((double) (hit + miss)) * 100);
        System.out.println("\n---------------------------");
    }
}



