function countOfSubarraysWithSumK(inputArray, k){
  let prefetchSumCount = { 0 : 1 }
  let i = 0;
  let count = 0;
  let cumSum = 0;
  while(i < inputArray.length){
    cumSum = cumSum + inputArray[i];
    if(prefetchSumCount[cumSum - k]){
      count = count + prefetchSumCount[cumSum - k];
    }
    prefetchSumCount[cumSum] = prefetchSumCount[cumSum] ? prefetchSumCount[cumSum] + 1 : 0 + 1;
    i++;
  }
  return count;
}

export default countOfSubarraysWithSumK;
