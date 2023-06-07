public class Cache {

    int cache_list[];
    int cache_size;

    int index_size;
    int byte_offset;
    int tag_size;
    int block_offset;
    int word_blocks;
    int hit_count;
    int miss_count;
    int tracker_array[];
    double hit_percentage;


    public Cache(int cache_size, int word_blocks){
        this.cache_size = (cache_size*256)/word_blocks;
        this.cache_list = new int[cache_size];
        this.tracker_array = new int[cache_size];
        this.word_blocks = word_blocks;
        this.tag_size = tag_size;
        this.block_offset = block_offset;
        this.byte_offset = byte_offset;
        this.hit_percentage = 0;
        this.index_size = 21-byte_offset-block_offset;


        this.hit_count = 0;
        this.miss_count = 0;

    }









}
