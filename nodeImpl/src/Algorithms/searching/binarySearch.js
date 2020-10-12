/** Search a sorted array by
repeatedly dividing the search interval in half.
Begin with an interval covering the whole array.
If the value of the search key is less than the item
in the middle of the interval, narrow the interval to
the lower half. Otherwise narrow it to the upper half.
Repeatedly check until the value is found or the interval is empty.**/

function binarySearch(inputArray, query){
  let mid = parseInt(((inputArray.length / 2) + 1) - 1);
  let iMax = inputArray.length - 1;
  let i = 0;
  if(inputArray[mid] === query){
    return mid;
  }
  if(query < inputArray[mid]){
    iMax = mid;
  } else {
    i = mid;
  }

   while(i <= iMax){
     mid = i + parseInt((iMax - i) / 2 );
     if(inputArray[mid] === query){
       return mid;
     }
     if(i === iMax){
         break;
     }
     if(query < inputArray[mid]){
       iMax = mid;
     } else {
       i++;
     }

   }
   return -1;
}

export default binarySearch;
