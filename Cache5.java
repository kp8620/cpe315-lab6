import java.util.*;
public class Cache5 {//2KB, 4-way set associative, 1-word blocks
    Integer[][] data = new Integer[4][4];
    Integer hit = 0;
    Integer miss = 0;
    public Cache5()
    {
        Integer[] fill = {999,999,999,999};
        Arrays.fill(data,fill);
    }
    public void fill(Integer line) {
        fillCache(line);
    }

    public void fillCache(Integer address) {
        Integer index = ((address >>> 2) & 0x7F)& 3;
        Integer tag = (address >>> 9) & 0x3FFFFF;
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
    public void getInfo() {
        System.out.println("Cache #5");
        System.out.println("Cache size: 2048B\tAssociativity: 4\tBlock size: 1");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%", hit, (double) hit / ((double) (hit + miss)) * 100);
        System.out.println("\n---------------------------");
    }
}


