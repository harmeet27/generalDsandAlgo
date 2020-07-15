import LinkedList from './LinkedListImpl/LinkedList.js';

let list = new LinkedList();
list.add('2');
list.add('3');
list.add('4');
list.add('5');
list.add('1', 1);
list.add('6', 0);
list.add('8', 3);
list.removeAtIndex(1);
// list.remove('2');
console.log('list', list);

// list.reverse()

// console.log('reverse', list);

list.display();

list.createLoop(2);

console.log('list', list);
// const size = list.size();
// console.log(size);
