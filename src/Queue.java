
/* **********************************************************
* Programmer:       Erika Tvaskis
* Class:            CS40S
* Assignment 3.2:   Data Structure Implementation
* Description:      Create Queue class with operations
* *************************************************************
*/

public class Queue {//Begin class

//VARIABLES
public static final int SIZE = 100;
private Object data[];	
private int index;
private int a;
	
/******************************************************
Purpose: Creating array of objects
In: None
Out: None
/******************************************************/ 
public Queue(){
    data = new Object[SIZE];
} //End of initialized constructor
	
/******************************************************
Purpose: To determine if queue is empty
In: None
Out: index (integer)
/******************************************************/ 
public boolean isEmpty(){
    return index == 0;
} //End of isEmpty method

/******************************************************
Purpose: Adding an object to queue
In: obj (Object)
Out: None
/******************************************************/ 
public void enqueue(Object obj) throws Exception{
    if(index == SIZE - 1){
            throw new Exception("Queue is full. Dequeue some objects");
    } //End if
    this.data[index] = obj;
    this.index++;
} //End enqueue method
	
/******************************************************
Purpose: Remove an object from queue (FIFO)
In: None
Out: obj (Object)
/******************************************************/ 
public Object dequeue() throws Exception{
    if(isEmpty())throw new Exception("Queue is empty");
    Object obj = this.data[0];
    for(int i = 0; i < this.index-1; i++){
            data[i]=data[i+1];
    }
    this.index--;
    return obj;
} //End dequeue method
        
/******************************************************
Purpose: Peek at first object
In: None
Out: data[0] (array first element)
/******************************************************/ 
public Object peek() throws Exception{
    index = 1;
    return data[0];
} //End peek method
        
/******************************************************
Purpose: toString method
In: None
Out: result (String)
/******************************************************/         
public String toString() {
    String result = "";
    for (int scan=0; scan < index; scan++) 
        result = result + data[scan].toString() + " ";
    a = index;
    return result;
   } //End toString method

} //End of class