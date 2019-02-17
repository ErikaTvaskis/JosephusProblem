
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/* **********************************************************
* Programmer:       Erika Tvaskis
* Class:            CS40S
* Assignment 3.2:   Josephus Problem
* Description:      Reads file and solves problem
* *************************************************************
*/

public class JosephusProblem { //Begin class
    
public static void main(String[] args) throws Exception { //Begin main
 
//VARIABLES
BufferedReader fin = null;  //Declaring fin as BufferedReader
String strin;               //String that reads file
String[] tokens;            //Array for splitting strings
String delim = "[ ]+";      //Delimiter string for splitting input string
Queue queue = new Queue();  //Initiating queue
int m = 0;                  //Elimination variable
int n = 0;                  //Amount of people variable

//GETTING BANNER AND PRINTING IT
ProgramInfo programInfo = new ProgramInfo(); 
System.out.println(programInfo.getBanner("Josephus Problem"));

//READING DATA FILE
try {
    fin = new BufferedReader(new FileReader("JosephusProblemValues.txt"));
} //End try statement 
catch (FileNotFoundException e) {
    System.out.println("file not found");
} //End catch statement
  
//WHILE LOOP TO GO THROUGH EACH SCENARIO
strin = fin.readLine();    
while (strin != null) {
    
    //SPLITTING AND ASSIGNING VALUES + making sure they are correct
    tokens = strin.split(delim);
    
    try {
        m = Integer.parseInt(tokens[0]);
        n = Integer.parseInt(tokens[1]);
    } //End try
    catch (NumberFormatException e) {
        System.out.println("Please enter a numerical value");
        return;
    } //End catch
    
    if (!(m >= 1 && m<= 100 && n >= 1 && n <= 100)) {
        System.out.println("Please enter a reasonable value");
        System.exit(0);
    } //Making sure numbers are reasonable, no error in file
    
    System.out.println("Josephus: " + m + " " + n);
       
    //LOADING QUEUE
    for (int i = 1; i <= n; i++)
        queue.enqueue(i);

    //ORDER OF ELIMINATION
    System.out.print("Order of Elimination: ");
    while (!queue.isEmpty()) {
        for (int i = 0; i < m-1; i++) {
            queue.enqueue(queue.dequeue());
            //First (m-1) numbers go to back of queue
            //Top element remaining = dequeued
            //Process repeats itself
        } //End for loop  
        System.out.print(queue.dequeue().toString() + " ");
    } //End while loop
    System.out.println("");

    strin = fin.readLine();
} //Closing bracket for while loop
       
System.out.println("");

} //End main

} //End of class

 
