import LinkedList from './LinkedList.js';

let list = new LinkedList();
list.add('2');
list.add('3');
list.add('4');
list.add('5');
list.add('1', 1);
list.add('6', 0);
list.add('8', 3);
// list.remove('2');
console.log('list', list);
