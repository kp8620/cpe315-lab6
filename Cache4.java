import java.util.*;

public class Cache4 {//2KB, 2-way set associative, 1-word blocks
    int[][] data = new int[(int)Math.pow(2,8)][2];
    int[][] line = new int[(int)Math.pow(2,8)][2];
    int hit = 0;
    int miss = 0;
    public Cache4()
    {
        for (int i = 0; i < data.length; i++) {
            data[i][0] = 0;
            data[i][1] = 0;
            line[i][0] = 0;
            line[i][1] = 0;
        }
    }
    public void fill(int line) {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = (address >>> 2) & 0xFF;
        int tag = (address >>> 10) & 0x3FFFFF;
        if (data[index][0] == tag)
        {
            line[index][0] = hit+miss;
            hit++;
        }
        else if (data[index][1] == tag)
        {
            line[index][1] = hit+miss;
            hit++;
        }
        else
        {
            if (data[index][0] == 0)
            {
                data[index][0] = tag;
                line[index][0] = hit+miss;
            }
            else if (data[index][1] == 0)
            {
                data[index][1] = tag;
                line[index][1] = hit+miss;
            }
            else
            {//have LRU counter
                if (line[index][0] > line[index][1])
                {
                    data[index][1] = tag;
                    line[index][1] = hit+miss;
                }
                else
                {
                    data[index][0] = tag;
                    line[index][0] = hit+miss;
                }
            }
            miss++;
        }
    }
    public void getInfo() {
        System.out.println("Cache #4");
        System.out.println("Cache size: 2048B\tAssociativity: 2\tBlock size: 1");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%%s", hit, (double) hit / ((double) (hit + miss)) * 100,"\n---------------------------\n");
    }
}

