学习笔记

- 分治模板

  ```python
  # recursion terminator
  if problem is None
      print result
      return
  
  # prepare data
  data = prepare_data(problem)
  subproblems = split_problem(problem, data)
  
  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0],p1,...)
  subresult2 = self.divide_conquer(subproblems[1],p1,...)
  subresult3 = self.divide_conquer(subproblems[2],p1,...)
  ...
  
  # process and generate the final result
  result = process_result(subresult1,subresult2,subresult3,...)
  
  # revert the current level states
  ```

  

- 动态规划

  ```java
  public void recur(int level, int param){
      //terminator
      if(level > MAX_LEVEL){
          //process result
          return;
      }
      
      //process current logic
      process(level,param);
      
      // drill down
      recur(level+1,newParam);
      
      //restore current status
      
  }
  ```

  

- 