// max sum Contiguous array
function kandane(inputArray){
  let i = 0;
  let cumSum = inputArray[0] < 0 ? 0 : inputArray[0];
  let maxSum = cumSum;
  if(inputArray.findIndex((el) => el > 0) === -1){
     maxSum = inputArray.sort((a,b) => a - b)[inputArray.length - 1];
  } else {
  while ( i < inputArray.length - 1){
    let j = i + 1;
    cumSum = inputArray[i] < 0 ? 0 : inputArray[i]; //1// 1
    while(j < inputArray.length){
      cumSum = cumSum + inputArray[j]; // 0
      if(maxSum < cumSum){
        maxSum = cumSum;
      }
      j++;
    }
    i++;
  }
  }
  return maxSum;
}

export default kandane;
