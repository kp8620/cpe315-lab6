import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab7 {

    lab7(String arg)
    {
        Cache1 cache1 = new Cache1();
        Cache2 cache2 = new Cache2();
        Cache3 cache3 = new Cache3();
        Cache4 cache4 = new Cache4();
        Cache5 cache5 = new Cache5();
        Cache6 cache6 = new Cache6();
        Cache7 cache7 = new Cache7();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(arg));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            cache1.fill(Integer.parseInt(line,16));
            cache2.fill(Integer.parseInt(line,16));
            cache3.fill(Integer.parseInt(line,16));
            cache4.fill(Integer.parseInt(line,16));
            cache5.fill(Integer.parseInt(line,16));
            cache6.fill(Integer.parseInt(line,16));
            cache7.fill(Integer.parseInt(line,16));
        }
        cache1.getInfo();
        cache2.getInfo();
        cache3.getInfo();
        cache4.getInfo();
        cache5.getInfo();
        cache6.getInfo();
        cache7.getInfo();
        scanner.close();
    }

    public static void main(String[] args)
    {
        lab7 lab = new lab7(args[0]);
    }
}
