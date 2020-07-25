function _swap(index1, index2, inputArray){
  const temp = inputArray[index1];
  inputArray[index1] = inputArray[index2];
  inputArray[index2] = temp;
}

function sortZeroOne(inputArray){
  let zeroPointer = 0;
  let onePointer = inputArray.length - 1;
  while(inputArray[zeroPointer]==0){
  zeroPointer = zeroPointer + 1;
}
  while(inputArray[onePointer]==1){
   onePointer = onePointer - 1;
  }
  let currentPointer = zeroPointer;
  while(zeroPointer <= onePointer){
    if(inputArray[currentPointer] === 0){
      _swap(zeroPointer, currentPointer, inputArray)
      zeroPointer = zeroPointer + 1;
      currentPointer = zeroPointer;
    }
     else if(inputArray[currentPointer] === 1){
      _swap(onePointer, currentPointer, inputArray)
      onePointer = onePointer - 1;
    }
    if(inputArray[currentPointer] === 0 || inputArray[currentPointer] === 2 ){
      continue;
    }
      currentPointer = currentPointer + 1;
  }
  return inputArray;
}

export default sortZeroOne;
