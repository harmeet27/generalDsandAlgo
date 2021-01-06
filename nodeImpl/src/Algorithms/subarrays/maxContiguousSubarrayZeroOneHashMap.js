function maxContiguousSubarrayZeroOneHashMap(inputArray){
  let i = 0;
let sumTrackObject = { '0': -1};
let cumulativeSum = 0;
// let startIndex = 0;
// let endIndex = 0;  // 1 1 1 0 1 1 1
let length = 0;
while(i < inputArray.length){
cumulativeSum = inputArray[i] === 0 ? cumulativeSum - 1 : cumulativeSum + inputArray[i];
if(sumTrackObject[cumulativeSum] !== undefined){
 // startIndex = sumTrackObject[cumulativeSum] + 1;
 // endIndex = i;
 // if(length < endIndex - startIndex + 1){
 // length = endIndex - startIndex + 1;
 // }
 length = Math.max(length, i - sumTrackObject[cumulativeSum])
} else {
sumTrackObject[cumulativeSum] = i;
}
i++;
}

return length;
}

export default maxContiguousSubarrayZeroOneHashMap;
