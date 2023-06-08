import java.util.*;

public class Cache4 {//2KB, 2-way set associative, 1-word blocks
    int[][] data = new int[(int)Math.pow(2,8)][2];
    int hit = 0;
    int miss = 0;
    public Cache4()
    {
        int[] fill = {999,999};
        Arrays.fill(data, fill);
    }
    public void fill(int line) {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = (address >>> 2) & 0xFF;
        int tag = (address >>> 10) & 0x7FFFF;
        if (data[index][0] == tag || data[index][1] == tag)
        {
            hit++;
        }
        else
        {
            if (data[index][0] == 999 && data[index][1] == 999)
            {
                data[index][0] = tag;
            }
            else if (data[index][0] == 999)
            {
                data[index][0] = tag;
            }
            else if (data[index][1] == 999)
            {
                data[index][1] = tag;
            }
            else
            {
                data[index][0] = data[index][1];
                data[index][1] = tag;
            }
            miss++;
        }
    }
    public void getInfo() {
        System.out.println("Cache #4");
        System.out.println("Cache size: 2048B\tAssociativity: 2\tBlock size: 1");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%", hit, (double) hit / ((double) (hit + miss)) * 100);
        System.out.println("\n---------------------------");
    }
}

