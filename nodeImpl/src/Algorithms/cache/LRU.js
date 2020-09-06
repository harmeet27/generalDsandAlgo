import DoublyLinkedList from '../../DoublyLinkedList/DoublyLinkedList.js';

class LRU {
  constructor(size){
    this.size = size;
    this.doublyLinkedList = new DoublyLinkedList();
    this.hashMap = {};
  }

  getSize(){
    return this.size;
  }

  get(input){
    const value = this.hashMap[input];
    const data = value.data;
    this.doublyLinkedList.remove(value);
    this.doublyLinkedList.add(value.data);
    return data;
  }
  post(input){
      const cacheSize = this.doublyLinkedList.getSize();
      if(cacheSize < this.size){
      const node = this.doublyLinkedList.add(input);
      this.hashMap[input] = node;
       } else {
       const leastRecentlyUsed = this.doublyLinkedList.getHead();
       this.doublyLinkedList.remove(leastRecentlyUsed);
       const node = this.doublyLinkedList.add(input);
       this.hashMap[input] = node;
     }
  }

  getCache(){
    return this.doublyLinkedList.display();
  }

}

export default LRU;
