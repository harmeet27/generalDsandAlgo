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

  get(key){
    const node = this.hashMap[key];
    if(node === undefined){
        return -1;
    }
    if(node === this.doublyLinkedList.getTail()){
        return node.data;
    }
    const data = node.data;
    this.doublyLinkedList.remove(node);
    const newnode = this.doublyLinkedList.add(data);
    this.hashMap[key] = newnode;

    return this.hashMap[key].data;
  }

  post(key, value){
    const cacheSize = this.doublyLinkedList.getSize();
      if (this.hashMap[key]){
           const currentNode = this.hashMap[key];
           this.doublyLinkedList.remove(currentNode);
           const node = this.doublyLinkedList.add(value);
           this.hashMap[key] = node;
       } else if(cacheSize < this.size){
         const node = this.doublyLinkedList.add(value);
         this.hashMap[key] = node;
       }
       else if ( cacheSize === this.size) {
       const leastRecentlyUsed = this.doublyLinkedList.getHead();
       this.doublyLinkedList.remove(leastRecentlyUsed);
       const keyValue = Object.keys(this.hashMap).find((key) => this.hashMap[key] ===                leastRecentlyUsed);
       delete this.hashMap[keyValue];
       const node = this.doublyLinkedList.add(value);
       this.hashMap[key] = node;
     }
  }

  getCache(){
    return this.doublyLinkedList.display();
  }

}

export default LRU;
