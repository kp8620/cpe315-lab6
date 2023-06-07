import java.io.File;
import java.io.FileNotFoundException;
import java.util.*; // Import the Scanner class to read text files

public class lab6 {
    public static Cache cache1 = new Cache(2048, 1);
    public static Cache cache2 = new Cache(2048, 2);
    public static Cache cache3 = new Cache(2048, 4);

    public static Cache cache7 = new Cache(4096, 1);
    public static int total_addresses = 0;
    public static void main(String[] args) throws FileNotFoundException {
        
        
        parse_formatter(args[0]);










    }

    public static void parse_formatter(String file_name) throws FileNotFoundException {
        File file = new File(file_name);
        Scanner myScanner = null; //CHECK IF correct
        try {
           myScanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(myScanner.hasNextLine()){
            total_addresses ++;
            String addr = myScanner.nextLine();
            int address = Integer.parseInt(addr, 16);

            parse_direct(address, cache1, 1);
            parse_direct(address, cache2, 2);
            parse_direct(address, cache3, 3);
            parse_direct(address, cache7, 7);


        }
        //System.out.println("TOTAL COUNT" + total_addresses);
       cache1.hit_percentage =  100 * (((double)cache1.hit_count)/((double)total_addresses));
       cache2.hit_percentage = 100  *((double)cache2.hit_count/(double)total_addresses);
       cache3.hit_percentage = 100  * ((double)cache3.hit_count/(double)total_addresses);
       cache7.hit_percentage = 100  * ((double)cache7.hit_count/(double)total_addresses);

        System.out.printf("Cache #1\nCache size: 2048B\tAssociativity: 1\tBlock size: 1\n\"Hits: %d\tHit Rate: %.2f%%\n---------------------------\n", cache1.hit_count, cache1.hit_percentage);
        System.out.printf("Cache #2\nCache size: 2048B\tAssociativity: 1\tBlock size: 2\n\"Hits: %d\tHit Rate: %.2f%%\n---------------------------\n", cache2.hit_count, cache2.hit_percentage);
        System.out.printf("Cache #3\nCache size: 2048B\tAssociativity: 1\tBlock size: 4\n\"Hits: %d\tHit Rate: %.2f%%\n---------------------------\n", cache3.hit_count, cache3.hit_percentage);
        System.out.printf("Cache #7\nCache size: 4096B\tAssociativity: 1\tBlock size: 1\n\"Hits: %d\tHit Rate: %.2f%%\n---------------------------\n", cache7.hit_count, cache7.hit_percentage);

    }
    
    public static void parse_direct(int address, Cache cache, int cache_number){
        int index = index_finder(address, cache_number);
        int tag = tag_finder(address, cache_number);

            if (cache.cache_list[index] == tag) {
                cache.hit_count++;
                //implement way to update latest index
            } else {
                cache.miss_count++;
                cache.cache_list[index] = tag;
                //store line number in seperate array
                //implement way to replace lowest index.
            }

    }
    
    
    
    
    

    public static int index_finder(int address, int cache_number){
        int index = 0;
        if(cache_number == 1){

            index = (address >> 2) & 0x1ff;

        }

        if(cache_number == 2){
            index = (address >> 3) & 0xff;
        }

        if(cache_number == 3){
            index = (address >> 4) & 0x7f;
        }

        if(cache_number == 7){
            index = (address >> 2) & 0x3ff;
        }
        return index;
    }

    public static int tag_finder(int address, int cache_number){
        int tag = (address >> 11) & 0x1fffff; //fix tag

        if(cache_number ==7){
            tag = (address >> 10) & 0xfffff;
        }

        return tag;
    }


}