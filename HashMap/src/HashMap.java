

public  class HashMap<K,V> {
    // for better re-sizing is taken as 2^4
    private static final int SIZE = 16;

    private Entry<K,V>[] table = new Entry[SIZE];

    /**
     * To store the Map data in key and value pair.
     * Used linked list approach to avoid the collisions
     */
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

    /**
     * Returns the entry mapped to key in the HashMap.
     */
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

    /**
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    public void put(K k, V v) {
        int hash = k.hashCode() % SIZE;
        Entry<K,V> e = table[hash];

        if(e != null) {
            // If we will insert duplicate key-value pair,
            // Old value will be replaced by new one.
            if(e.key.equals(k)) {
                e.value = v;
            } else {
                // Collision: insert new element at the end of list
                // in the same bucket
                while(e.next != null) {
                    e = e.next;
                }
                Entry<K,V> entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
            }
        } else {
            // create new bucket for new element in the map.
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

        System.out.println(myHashMap.get("roi").getValue());
    }
}