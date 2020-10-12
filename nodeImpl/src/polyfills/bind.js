function.prototype.bind = function(...args){
  let obj = this;
  let params = args.slice(1);
  return function(...args2){
    obj.apply(args[0], [...args2, params]);
  }
}
