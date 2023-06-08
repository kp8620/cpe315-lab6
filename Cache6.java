
import java.util.*;
public class Cache6 {//2KB, 4-way set associative, 4-word blocks
    int[][] data = new int[(int)Math.pow(2,5)][4];
    int hit = 0;
    int miss = 0;
    public Cache6()
    {
        int[] fill = new int[32];
        Arrays.fill(fill,999);
        Arrays.fill(data,fill);
    }
    public void fill(int line) {
        fillCache(line);
    }

    public void fillCache(int address) {
        int index = ((address >>> 4) & 0x1F);
        int tag = (address >>> 9) & 0x7FFFFF;
        if (data[index][0] == tag || data[index][1] == tag || data[index][2] == tag || data[index][3] == tag)
        {
            hit++;
        }
        else
        {
            if (data[index][0] == 999)
            {
                miss++;
                data[index][0] = tag;
            }
            else if (data[index][1] == 999)
            {
                miss++;
                data[index][1] = tag;
            }
            else if (data[index][2] == 999)
            {
                miss++;
                data[index][2] = tag;
            }
            else if (data[index][3] == 999)
            {
                miss++;
                data[index][3] = tag;
            }
            else
            {
                miss++;
                for (int i = 0; i < 3; i++)
                {
                    data[index][i] = data[index][i+1];
                }
                data[index][3] = tag;
            }
        }
    }
    public void getInfo() {
        System.out.println("Cache #6");
        System.out.println("Cache size: 2048B\tAssociativity: 4\tBlock size: 4");
        System.out.printf("Hits: %d\tHit Rate: %.2f%%", hit, (double) hit / ((double) (hit + miss)) * 100);
        System.out.println("\n---------------------------");
    }
}



