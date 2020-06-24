学习笔记

1. 递归模板

   ```java
   public void test(level){
       //recursion terminator
       if(level > MAX_LEVEL){
           process_result;
           return;
       }
       
       //process logic in current level
       
       //#drill down
       self.recursion(level+1,p1,..)
       
       //reverse the current level status if needed
       
   }
   ```

   

2. 