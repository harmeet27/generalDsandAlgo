function sortTimeArray(array){
  return array.sort((entry1, entry2) => entry1 - entry2);
}

function arrivalDepartureScheduling(startTimeArray, endTimeArray){
  const sortedStartTimeArray = sortTimeArray(startTimeArray);
  const sortedEndTimeArray = sortTimeArray(endTimeArray);
  let currentStart = 0;
  let currentEnd = 0;
  let roomCount = 0
  let maxroomCount = roomCount;
  while(currentStart < sortedStartTimeArray.length){
    if(roomCount > maxroomCount){
      maxroomCount = roomCount;
    }
    while(currentEnd < sortedEndTimeArray.length){
      if(sortedStartTimeArray[currentStart] < sortedEndTimeArray[currentEnd]){
        roomCount = roomCount + 1;
        break;
      } else if (sortedStartTimeArray[currentStart] > sortedEndTimeArray[currentEnd]) {
        roomCount = roomCount - 1;
      }
      currentEnd = currentEnd + 1
    }
    currentStart = currentStart + 1;
  }
  return maxroomCount;
}

export default arrivalDepartureScheduling;
