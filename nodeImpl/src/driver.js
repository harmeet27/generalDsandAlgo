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
// console.log('list', list);

// list.reverse()

// console.log('reverse', list);

// list.display();

list.createLoop(2);

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

detectLoop();

function removeLoop(){
  detectLoop(true);
  console.log('after loop removed :', list);
}

removeLoop();
// const size = list.size();
// console.log(size);
