function preFetchProduct(newlist, startIndex, endIndex){
  const head = newlist.getHead();
  let temp = head;
  const preFetchArray = [];
  let index = 0;
  while(temp !== null){
    const calculatedProduct =  preFetchArray.length > 0 ? preFetchArray[index - 1] * temp.data : temp.data;
    preFetchArray.push(calculatedProduct);
    temp = temp.next;
    index = index + 1;
  }
  let startIndexValue = startIndex - 1;;
  if(startIndex === 0){
    startIndexValue = startIndex;
  }
  return preFetchArray[endIndex] / preFetchArray[startIndexValue];
}

export default preFetchProduct;
