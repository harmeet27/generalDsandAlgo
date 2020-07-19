function dutchFlag(inputArray){
  const set = new Set(inputArray);
  const entries = set.values();
  const entriesArray = [];
  for(const entry of entries){
    entriesArray.push(entry);
  }
  let countOfFirstEntry = 0;
  let countOfSecondEntry= 0;
  let countOfThirdEntry = 0;
  const sortedEntriesArray = entriesArray.sort();
  inputArray.forEach((element) => {
    if(element === sortedEntriesArray[0]){
      countOfFirstEntry = countOfFirstEntry + 1;
    }
    else if(element === sortedEntriesArray[1]){
      countOfSecondEntry = countOfSecondEntry + 1;
    }
    else if(element === sortedEntriesArray[2]){
      countOfThirdEntry = countOfThirdEntry + 1;
    }
  })
 const fullSortedArray = [];
 while(countOfFirstEntry !== 0 || countOfSecondEntry !== 0 || countOfThirdEntry !== 0){
   if(countOfFirstEntry > 0){
     fullSortedArray.push(sortedEntriesArray[0]);
     countOfFirstEntry = countOfFirstEntry - 1;
   } else if ( countOfSecondEntry > 0){
     fullSortedArray.push(sortedEntriesArray[1]);
     countOfSecondEntry = countOfSecondEntry - 1;
   } else if ( countOfThirdEntry > 0){
     fullSortedArray.push(sortedEntriesArray[2]);
     countOfThirdEntry = countOfThirdEntry - 1;
   }
 }
 return fullSortedArray;
}

export default dutchFlag;
