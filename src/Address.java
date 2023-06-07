public class Address {

    private int tag;
    private int index;
    private int add_index;


    public Address(int address){
        this.index = index_finder(address);
        this.tag = tag_finder(address);
        this.add_index = add_index;

    }


    public static int index_finder(int address){
        int index = (address >> 4) & 0x7f;
        return index;

    }

    public static int tag_finder(int address){
        int tag = (address >> 11) & 0x1fffff; //fix tag
        return tag;
    }



}
