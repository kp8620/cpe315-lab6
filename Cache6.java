
import java.util.*;
public class Cache6 {//2KB, 4-way set associative, 4-word blocks
    int[][] data = new int[(int)Math.pow(2,5)][4];
    int[][] line = new int[(int)Math.pow(2,5)][4];
    int hit = 0;
    int miss = 0;
    public Cache6()
    {
        for (int i = 0; i < data.length; i++) {
            data[i][0] = 0;
            data[i][1] = 0;
            data[i][2] = 0;
            data[i][3] = 0;
            line[i][0] = 0;
            line[i][1] = 0;
            line[i][2] = 0;
            line[i][3] = 0;
        }
    }
    public void fill(int line) {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 4) & 0x1F);
        int tag = (address >>> 9) & 0x7FFFFF;
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
        else if (data[index][2] == tag)
        {
            line[index][2] = hit+miss;
            hit++;
        }
        else if (data[index][3] == tag)
        {
            line[index][3] = hit+miss;
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
            else if (data[index][2] == 0)
            {
                data[index][2] = tag;
                line[index][2] = hit+miss;
            }
            else if (data[index][3] == 0)
            {
                data[index][3] = tag;
                line[index][3] = hit+miss;
            }
            else
            {//have LRU counter
                int LRU = line[index][0]; // Assume the first element is the minimum
                int LRUindex = 0;
                for (int i = 1; i < 4; i++) {
                    if (line[index][i] < LRU) {
                        LRU = line[index][i];
                        LRUindex = i;
                    }
                }
                data[index][LRUindex] = tag;
                line[index][LRUindex] = hit+miss;
            }
            miss++;
        }
    }
    public void getInfo() {
        System.out.println("Cache #6");
        System.out.println("Cache size: 2048B\tAssociativity: 4\tBlock size: 4");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%%s", hit, (double) hit / ((double) (hit + miss)) * 100,"\n---------------------------\n");
    }
}



