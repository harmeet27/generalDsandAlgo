class Node{
  constructor(data, prev = null, next = null){
    this.data = data;
    this.next = next;
    this.prev = prev;
  }
}

export default Node;
