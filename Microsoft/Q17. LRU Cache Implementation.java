/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class LRUCache{
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
    }
    
    private Hashtable<Integer,Node>cache = new Hashtable<Integer,Node>();
    private int count, capacity;
    private Node head, tail;
    
    public LRUCache(int capacity){
        this.count=0;
        this.capacity=capacity;
        head = new Node();
        head.prev=null;
        
        tail = new Node();
        tail.next=null;
        
        head.next=tail;
        tail.prev=head;
    }
    
    private void addNode(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }
    
    private Node popTail(){
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
    
    public int get(int key){
        Node node = cache.get(key);
        
        if(node ==null)
        return -1;
        
        moveToHead(node);
        return node.value;
    }
    
    
    public void put(int key, int value){
        
        Node node = cache.get(key);
        if(node==null){
            
            Node newNode = new Node();
            newNode.key=key;
            newNode.value=value;
            
            addNode(newNode);
            cache.put(key,newNode);
            count++;
            
            if(count>capacity){
                Node tailNode = popTail();
                cache.remove(tailNode.key);
                count--;
            }
        }
        else{
               node.value = value;
               moveToHead(node);
        }
    }
    

    
    public  static void main(String args[]){
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println("Value for key 1: " + lruCache.get(1));
        lruCache.put(3,3);
        lruCache.put(4,4);
        System.out.println("Value for key 2: " + lruCache.get(2));
        System.out.println("Value for key 5: " + lruCache.get(5));
        System.out.println("Value for key 4: " + lruCache.get(4));
    
}
}
