function dutchFlag(inputArray){
  const set = new Set(inputArray);
  const entries = set.values();
  const entriesArray = [];
  const entryCountArray = [];
  const fullSortedArray = [];
  for(const entry of entries){
    entriesArray.push(entry);
    entryCountArray.push(0);
  }

  const sortedEntriesArray = entriesArray.sort();
  inputArray.forEach((element) => {
    if(element === sortedEntriesArray[0]){
      entryCountArray[0] = entryCountArray[0] + 1;
    }
    else if(element === sortedEntriesArray[1]){
      entryCountArray[1] = entryCountArray[1] + 1;
    }
    else if(element === sortedEntriesArray[2]){
      entryCountArray[2] = entryCountArray[2] + 1;
    }
  })
 while(entryCountArray[0] !== 0 || entryCountArray[1] !== 0 || entryCountArray[2] !== 0){
   if(entryCountArray[0] > 0){
     fullSortedArray.push(sortedEntriesArray[0]);
     entryCountArray[0] = entryCountArray[0] - 1;
   } else if ( entryCountArray[1] > 0){
     fullSortedArray.push(sortedEntriesArray[1]);
     entryCountArray[1] = entryCountArray[1] - 1;
   } else if ( entryCountArray[2] > 0){
     fullSortedArray.push(sortedEntriesArray[2]);
     entryCountArray[2] = entryCountArray[2] - 1;
   }
 }
 // console.log(entryCountArray, fullSortedArray);
 return fullSortedArray;
}

export default dutchFlag;
