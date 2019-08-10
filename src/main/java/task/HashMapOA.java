package task;

/**
     The HashMapOA class implements a Hash map data structure with opening addressing.
     For keys uses an integer type. Keys must be positive numbers.
     For values uses a long type.
     If the load factor equal to or greater than 70 percent than the hash map increases the size.
     Methods 'put' and 'get' use a quadratic probing algorithm.
**/
public class HashMapOA {

    private int MAX_SIZE;
    private Entry[] table;
    private double loadFactor;
    private int size;

    public HashMapOA() {
        this(97);
    }

    public HashMapOA(int size) {
        MAX_SIZE = findPrimeNumber(size);
        this.table = new Entry[MAX_SIZE];
    }

    public void put(int k, long v) {

        if(loadFactor >= 0.7) {
            increaseMapSize();
        }

        int index = k % MAX_SIZE;
        int attemptCount = 1;

        while (table[index] != null) {
            if (table[index].getKey() == k) {
                table[index].setValue(v);
                return;
            }
            index = quadraticProbing(k, attemptCount++);
        }

        table[index] = new Entry(k, v);
        loadFactor = ++size / (double)MAX_SIZE;
    }

    public long get(int k) {
        int index = k % MAX_SIZE;
        int attemptCount = 1;

        while (table[index] != null) {
            Entry entry = table[index];
            if (entry.getKey() == k) {
                return entry.getValue();
            }
            index = quadraticProbing(k, attemptCount++);
        }

        return -1;
    }
    public int size(){return size; }

    private int quadraticProbing(int hash, int attempt) {
        return (hash + attempt * attempt) % MAX_SIZE;
    }

    private void increaseMapSize() {
        Entry[] old = table;
        MAX_SIZE = findPrimeNumber(MAX_SIZE * 2);
        table = new Entry[MAX_SIZE];
        loadFactor = size = 0;

        for(Entry e : old) {
            if (e != null) {
                put(e.getKey(), e.getValue());
            }
        }
    }

    private int findPrimeNumber(int input){
        int counter;

        while(true){
            int root = (int) Math.sqrt(input);
            counter = 0;

            for(int i = 2; i <= root; i++){
                if(input % i == 0) counter++;
            }

            if(counter == 0)
                return input;
            else{
                input++;
            }
        }
    }
}

class Entry {
    private int key;
    private long value;

    public Entry(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
