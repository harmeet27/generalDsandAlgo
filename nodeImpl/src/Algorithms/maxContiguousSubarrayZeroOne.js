function maxContiguousSubarrayZeroOne(inputArray){
  let i = 0;
  let cumulativeSum = 0;
  let length = -1;
  // [1, 1, 1, 0, 1, 1, 1]
  while(i < inputArray.length - 1){
    cumulativeSum = inputArray[i] === 0 ? -1 : 1
    let j = i + 1;
    // csum = 1
    while(j < inputArray.length){
      if(inputArray[j] === 0){
        cumulativeSum = cumulativeSum + -1;
      } else if (inputArray[j] === 1){
        // csum = 2
        cumulativeSum = cumulativeSum + 1;
      }
      if(cumulativeSum === 0 && length < j - i + 1){
        length = j - i + 1;
      }
      j++;
    }
    i++;
  }
  return length;
}

export default maxContiguousSubarrayZeroOne;
