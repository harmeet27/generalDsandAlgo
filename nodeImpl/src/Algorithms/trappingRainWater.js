function trappingRainWater(inputHeights){
  let storedWater = 0;
  let i = 0;
  let lmax = [];
  let rmax = [];
  while(i < inputHeights.length){
    let k = i + 1;
    let currentRightMax = inputHeights[k];
    while(k < inputHeights.length){
      if(inputHeights[k] > currentRightMax){
        currentRightMax = inputHeights[k];
      }
      k++;
    }
    rmax.push(currentRightMax);
    let currentLeftMax = inputHeights[i];
    let j = i
    while(j >= 0){
      if(inputHeights[j] > currentLeftMax){
        currentLeftMax = inputHeights[j];
      }
      j--;
  }
  lmax.push(currentLeftMax);
  let water =  (Math.min(lmax[i], rmax[i]) - inputHeights[i]);
  if(water > 0){
  storedWater = storedWater + water ;
}
  i++;
  }
  return Math.abs(storedWater);
}

export default trappingRainWater;
