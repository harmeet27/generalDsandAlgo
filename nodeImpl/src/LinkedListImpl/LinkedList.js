import Node from './Node.js';

class LinkedList{
constructor(){
  this.head = null;
}

 add(data, index = null){
   if(index !== null){
     return this._addAtIndex(data, index);
   }
   if(this.head === null){
     this.head = new Node(data, null);
   }
   else{
   let temp = this.head;
   while(temp !== null){
     if(temp.next === null){
       const node = new Node(data, null);
       temp.next = node;
       break;
     }
     temp = temp.next;
   }
  }
   return this.head;
 }

 _addAtFront(data){
   const node = new Node(data, this.head);
   this.head = node;
   return this.head;
 }

 _addAtIndex(data, index){
   let temp = this.head;
   let previous = null;
   let count = 0
   while(temp !== null){
     if(count === index){
       const node = new Node(data, null);
       if(index === 0){
         return this._addAtFront(data);
       }
       previous.next = node;
       node.next = temp;
     }
     count = count + 1;
     previous = temp;
     temp = temp.next;
   }

   if(temp === null && index === count){
     return this.add(data);
   }

   if(temp === null && index >= count){
     throw new Error('index out of bound');
   }
   return this.head;
 }

 remove(data, index = null){
   if(this.head.data === data || index === 0){
     this.head = this.head.next;
     return this.head;
   }
   let temp = this.head;
   let previous = temp;
   while(temp !== null){
     if(temp.data === data){
         previous.next = temp.next;
     }
     previous = temp;
     temp = temp.next;
   }
   return this.head;
 }

 removeAtIndex(index){
     if(index === 0){
       this.remove(data, index);
     }
     let temp = this.head;
     let previous = null;
     let count = 0;
     while(temp !== null){
       if(index === count){
         previous.next = temp.next;
         break;
       }
       previous = temp;
       temp = temp.next;
       count++;
     }
     return this.head;
 }

 reverse(){
   let current = this.head;
   let previous = null;
   let next = null;
   while(current !== null){
     next = current.next;
     current.next = previous;
     previous = current;
     current = next;
   }
   this.head = previous;
   return this.head;
 }

 display(){
   let temp = this.head;
   let string = "";
   while(temp !== null){
     string = string + " " + temp.data;
     temp =  temp.next;
   }
   console.log(string);
 }

 size(){
   let count = 0;
   let temp = this.head;
   while(temp !== null){
     count = count + 1;
     temp = temp.next;
   }
   return count;
 }

 createLoop(index){
   let temp = this.head;
   let kthNode = null;
   let count = 0;
   while(temp !== null){
     if(count === index){
       kthNode = temp;
       break;
     }
     temp = temp.next;
     count = count + 1;
   }
   temp.next = kthNode;
   return this.head;
 }
}

export default LinkedList;
