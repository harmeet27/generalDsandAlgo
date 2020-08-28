import LinkedList from './LinkedListImpl/LinkedList.js';
import preFetchProduct from  './Algorithms/prefetch/preFetchProduct.js';
import dutchFlag from './Algorithms/sorting/dutchFlag.js';
import dutchFlagConstantSpace from './Algorithms/sorting/dutchFlagConstantSpace.js';
import sortZeroOne from './Algorithms/pointers/sortZeroOne.js';
import moveAllZerosToFront from './Algorithms/pointers/moveAllZerosToFront.js';
import meetingRoomSchedule from './Algorithms/scheduling/meetingRoomSchedule.js';
import arrivalDepartureScheduling from './Algorithms/scheduling/arrivalDepartureScheduling.js';
import maxContiguousSubarrayZeroOne from './Algorithms/subarrays/maxContiguousSubarrayZeroOne';
import maxContiguousSubarrayZeroOneHashMap from './Algorithms/subarrays/maxContiguousSubarrayZeroOneHashMap';
import kandane from './Algorithms/subarrays/kandane';
import trappingRainWater from './Algorithms/trappingRainWater';
import countOfSubarraysWithSumK from './Algorithms/prefetch/countOfSubarraysWithSumK';
import binarySearch from './Algorithms/searching/binarySearch';

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
  if(head === null){
    throw new Error('List not created yet');
  }
  let fastNode = head;
  let slowNode = head;
  let flag = 0;
  while(fastNode !== null && fastNode.next !== null){
    slowNode = slowNode.next;
    fastNode = fastNode.next.next;
    if(slowNode === fastNode){
      flag = 1;
      if(removeLoop){
        fastNode.next = null;
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
  if(head === null){
    throw new Error('List not created yet');
  }
  if(k > list.size()){
    throw new Error('index out of bound');
  }
  let slowNode = head;
  let fastNode = head;
  let currentIndex = 1;

  while(currentIndex <= k){
    fastNode = fastNode.next;
    i++;
  }
  while(fastNode !== null){
    slowNode = slowNode.next;
    fastNode = fastNode.next;
  }
  return slowNode.data;
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
const zeroOneTwoSorted = dutchFlagConstantSpace([2,0,2,1,1,0]);
const zeroOneSorted = sortZeroOne([0,1,0,1,1,0,0,1,0,1]);
const allZerosAtFront = moveAllZerosToFront([2, 3, 4, 5, 0, 1, 0, 9, 0, 0, 7]);
// console.log(sortedNumberArray, sortedCharArray, zeroOneTwoSorted, zeroOneSorted, allZerosAtFront);

// const numberOfRoomsRequired = meetingRoomSchedule([1,3,5,6], [2,6,6,7]);
// const numberOfRoomsRequired2 = meetingRoomSchedule([9.00,9.40], [9.10,12.00]);
const numberOfRoomsRequired1 = meetingRoomSchedule([9.00,18.00,9.40,9.50,11.00,15.00], [9.10,20.00,12.00,11.20,11.30,19.00]);
const aDnoOfRoomsRequired = arrivalDepartureScheduling([9.00,18.00,9.40,9.50,11.00,15.00], [9.10,20.00,12.00,11.20,11.30,19.00]);
// console.log('Rooms Required:', numberOfRoomsRequired);
// console.log('Rooms Required:', numberOfRoomsRequired1);
// console.log('Rooms Required:', aDnoOfRoomsRequired);
// // console.log('Rooms Required:', numberOfRoomsRequired2);
// console.log(maxContiguousSubarrayZeroOne([1, 1, 1, 0, 1, 1, 1]));
// console.log(maxContiguousSubarrayZeroOne([1, 0, 1, 0, 1, 1, 1, 0]));
// console.log(maxContiguousSubarrayZeroOneHashMap([1, 1, 1, 0, 1, 1, 1]));
// console.log(maxContiguousSubarrayZeroOneHashMap([1, 0, 1, 0, 1, 1, 1, 0]));
// console.log(kandane([-2, -3, 4, -1, -2, 1, 5, -3]), 'kandane');
// console.log(kandane([1, -1, -2]), 'kandane negative')
//
// console.log('water stored', trappingRainWater([2,0,2]));
// console.log('count', countOfSubarraysWithSumK([0,0,0,0,0,0,0,0,0,0], 0));

console.log(binarySearch([-1, 0, 2, 3, 7, 8], 0));
