
public class HashMap<K,V> {

    private static final int SIZE = 16;

    private Entry<K,V>[] table = new Entry[SIZE];


    class Entry<K,V> {
        final K key;
        V value;
        Entry<K,V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }
    }


    public Entry<K,V> get(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K,V> e = table[hash];

        // Bucket is identified by hashCode and traversed the bucket
        // till element is not found.

            if (e == null) {
                System.out.println("There is not such an element!");
            }
            while (e != null) {
                if (e.key.equals(key)) {
                    return e;
                }
                e = e.next;
            }
        return null;
    }

    //If the map previously contained a mapping for the key, the old
    public void put(K k, V v) {
        int hash = k.hashCode() % SIZE;
        Entry<K,V> e = table[hash];

        if(e != null) {
            if(e.key.equals(k)) {
                e.value = v;
            } else {
                while(e.next != null) {
                    e = e.next;
                }
                Entry<K,V> entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
            }
        } else {
            Entry<K,V> entryInNewBucket = new Entry(k, v);
            table[hash] = entryInNewBucket;
        }
    }

    public static void main(String[] args) {
        HashMap<String ,String > myHashMap = new HashMap<>();

        myHashMap.put("aws", "om");
        myHashMap.put("roi", "se");
        myHashMap.put("mio", "nop");
        myHashMap.put("fof", "fifo");
        myHashMap.put("ver", "SE");
        myHashMap.put("adae", "idk");

        System.out.println(myHashMap.get("mio").hashCode());
    }
}