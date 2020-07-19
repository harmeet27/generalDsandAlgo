import LinkedList from './LinkedListImpl/LinkedList.js';
import preFetchProduct from  './Algorithms/preFetchProduct.js';
import dutchFlag from './Algorithms/dutchFlag.js';

let list = new LinkedList();
list.add('2');
list.add('3');
list.add('4');
list.add('5');
list.add('1', 1);
list.add('6', 0);
list.add('8', 3);
list.removeAtIndex(1);
// list.createLoop(2);

function detectLoop(removeLoop = false){
  console.log('with loop:', list);
  const head = list.getHead();
  let fast = head;
  let slow = head;
  let flag = 0;
  while(fast !== null &&  slow !== null && fast.next !== null){
    slow = slow.next;
    fast = fast.next.next;
    if(slow === fast){
      flag = 1;
      if(removeLoop){
        fast.next = null;
        return head;
      }
      break;
    }
  }
  if(flag === 1){
    console.log('loop found');
    return true;
  } else {
    console.log('loop not found');
    return false;
  }
};

// detectLoop();

function removeLoop(){
  detectLoop(true);
  console.log('after loop removed :', list);
}

// removeLoop();

function nodeAtKindexFromLast(k){
  const head = list.getHead();
  console.log(list);
  let slow = head;
  let fast = head;
  let i = 1;
  while(i <= k){
    fast = fast.next;
    i++;
  }
  while(fast !== null){
    slow = slow.next;
    fast = fast.next;
  }
  return slow.data;
}

// const nodeAtK = nodeAtKindexFromLast(4);
// console.log(nodeAtK);

const newList = new LinkedList();
newList.add(1);
newList.add(2);
newList.add(3);
newList.add(4);
newList.add(5);

const preFetchResultArray = [preFetchProduct(newList, 1, 2), preFetchProduct(newList, 0, 4), preFetchProduct(newList, 1, 3)];
// console.log(preFetchResultArray);

const sortedNumberArray = dutchFlag([0, 1, 2, 1, 0]);
const sortedCharArray = dutchFlag(['a', 'b', 'c', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'a', 'c']);
console.log(sortedNumberArray, sortedCharArray);
