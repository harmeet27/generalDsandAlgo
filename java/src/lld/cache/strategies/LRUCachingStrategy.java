package lld.cache.strategies;

import java.util.HashMap;

public class LRUCachingStrategy<K> implements CacheStrategy<K> {

    private DoublyLinkedList<K> dll;
    private HashMap<K, Node<K>> mapper;

    public LRUCachingStrategy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public K evict() {
        K removed = dll.head.key;
        dll.remove(dll.head);
        mapper.remove(removed);
        return removed;
    }

    @Override
    public void reshuffle(K key) {
        if (mapper.containsKey(key)) {
            Node refNode = mapper.get(key);
            dll.remove(refNode);
            dll.add(refNode);
        } else {
            Node newNode = new Node(key, null, null);
            dll.add(newNode);
            mapper.put(key, newNode);
        }
    }

    class DoublyLinkedList<K> {
        Node<K> head;
        Node<K> last;

        void add(Node node) {
//            Node<K> node = new Node(key, null, null);
            if (head == null) {
                head = node;
                last = node;
            } else {
                last.next = node;
                node.prev = last;
                node.next = null;
                last = node;
            }
        }

        public void remove(K key) {
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {
                    remove(curr);
                    break;
                }
                curr = curr.next;
            }
        }

        private void remove(Node node) {

            if (node == head) {
                Node temp = head;
                if (head != last) {
                    head = head.next;
                    temp.next = null;
                    head.prev = null;
                } else {
                    head = null;
                }
            } else if (node == last) {
                node.prev.next = null;
                last = node.prev;
                node.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    class Node<K> {
        Node prev;
        Node next;
        K key;

        Node(K key, Node prev, Node next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }
}
