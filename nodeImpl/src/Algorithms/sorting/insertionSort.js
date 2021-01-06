/*
Insertion Sort
*/

function insertionSort(inputArray){
  let i = 0;
  for(let i = 0; i < inputArray.length; i++){
    let j = i - 1;
    let key = inputArray[i];
    while (j >= 0 && inputArray[j] > key) {
                inputArray[j + 1] = inputArray[j];
                j = j - 1;
            }
            inputArray[j + 1] = key;
  }
  return inputArray;
}

export default insertionSort;
