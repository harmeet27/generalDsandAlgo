/*
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
*/

function findMin(inputArray){
  let i = 0;
  let currentMin = inputArray[i];
  let currentMinIndex = i;
  while(i < inputArray.length){
    if(inputArray[i] < currentMin){
      currentMin = inputArray[i];
      currentMinIndex = i;
    }
    i++;
  }
  return { minValue: currentMin, index: currentMinIndex};
}

function selectionSort(inputArray){
  let sortedArray = [];
  let i = 0;
  let input = inputArray;
  while(i < inputArray.length){
    const min = findMin(input);
    input = input.filter((el, index) => el !== min.minValue || index !== min.index);
    sortedArray.push(min.minValue);
    i++;
  }
  return sortedArray;
}

export default selectionSort;
