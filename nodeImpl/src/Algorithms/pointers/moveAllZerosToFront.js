function moveAllZerosToFront(inputArray){
  let zeroPointer = 0;
  while(inputArray[zeroPointer] === 0){
    zeroPointer  = zeroPointer + 1;
  }
  let currentPointer = zeroPointer;
  while(currentPointer < inputArray.length){
    if(inputArray[currentPointer] === 0){
      let temp = inputArray[currentPointer];
      inputArray[currentPointer] = inputArray[zeroPointer];
      inputArray[zeroPointer] = temp;
      zeroPointer = zeroPointer + 1;
    }
    currentPointer = currentPointer + 1;
  }
  return inputArray;
}

export default moveAllZerosToFront;
