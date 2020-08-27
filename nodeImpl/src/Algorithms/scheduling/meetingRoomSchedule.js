function priorityQueueSorted(array){
  return array.sort((entry1, entry2) => entry1 - entry2);
}

function meetingRoomSchedule(startTimeArray, endTimeArray){
  const intervalArray = [];
  for(let i = 0; i < startTimeArray.length; i++ ){
    intervalArray[i] = [ startTimeArray[i], endTimeArray[i] ];
  }
 const sortedTimeArray = intervalArray.sort((entry1, entry2) => entry1[0] - entry2[0]);
 let j = 0;
 let roomCount = 1;
 let priorityQueue = [sortedTimeArray[0][1]];
 while(j + 1 < sortedTimeArray.length){
   if(priorityQueue[0] > sortedTimeArray[j+1][0]){
     priorityQueue.push(sortedTimeArray[j+1][1]);
     priorityQueue = priorityQueueSorted(priorityQueue);
     roomCount = roomCount + 1;
   } else if(priorityQueue[0] < sortedTimeArray[j+1][0]){
     priorityQueue.shift();
     priorityQueue.push(sortedTimeArray[j+1][1]);
     priorityQueueSorted(priorityQueue);
   }
    j++;
 }
 return roomCount;
}

export default meetingRoomSchedule;
