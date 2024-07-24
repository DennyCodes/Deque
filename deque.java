public class Deque { 
  private final int MAX;
  private int deque[]; 
  private int nextFront; //index for inserting the next front item
  private int nextBack; //index for inserting the next back item
  protected int size;
    
  public Deque(int maxSize){ 
    MAX = maxSize;
    deque = new int[MAX]; 
    nextFront = convertToIndex(0);
    nextBack = convertToIndex(1);
    size = 0;
  } 

  //Converts a number into a valid index in the circular array
  private int convertToIndex(int number){
    /*
    Examples:
      Valid indicies for an array of size 5: 
      0, 1, 2, 3, 4

      Given 5, return 0
      Given 3, return 3  
      Given 1, return 1
      Given -1, return 4
      Given -3, return 2
    */
    //HINT: Use the mod operator (%) to wrap around to the beginning if we go over the end. If the initial number is negative, add the length of the array to wrap around to the end.
    int n;
    n = number % MAX;
    if (n<0) {
      n += MAX;
    }
    return n;
    // if (number == 0) {
    //   return deque[0];
    // }
    // else if (number > size-1 ){
    //   return deque[number%size];
    // }
    // else if (number > 0 && number <= size-1) {
    //   return deque[number];
    // }
    // else if (number<0 && number*-1 <= size-1) {
    //   return deque[size-number*-1];
    // }
    // else if (number*-1>size-1) {
      
    //   return deque[((number*-1%size)-size)*-1];
    // }
    // else {return -1;}
    
  }

  // Checks whether Deque is full or not. 
  public boolean isFull(){ 
    if (MAX == size) {return true;}
    return false;
    
  } 
  
  // Checks whether Deque is empty or not. 
  public boolean isEmpty(){ 
    if (size == 0) {return true;}
    return false;
  } 
  
  // Inserts an item at the front
  public void insertFront(int item){
    if (isFull()) {
      throw new OverflowException();
    }
    else {
      deque[nextFront] = item;
      nextFront = convertToIndex(nextFront-1);
      size+=1;
    }
  } 
  
  // Inserts an item at the back
  public void insertBack(int item){ 
    if (isFull()) {
      throw new OverflowException();
    }
    else {
      deque[nextBack] = item;
      nextBack = convertToIndex(nextBack+1);
      size+=1;
    }
  } 
  
  // Deletes element at front end of Deque 
  public void removeFront(){ 
    if (isEmpty()) {
	    throw new UnderflowException();
	  }
	  nextFront = convertToIndex(nextFront+1);
	  size -=1;
	  
  } 
  
  // Delete element at back end of Deque 
  public void removeBack(){ 
    if (isEmpty()) {
	    throw new UnderflowException();
	  }
	  nextBack = convertToIndex(nextBack-1);
	  size -=1;
  } 
  
  // Returns front element of Deque 
  public int getFront(){ 
    return deque[0];
  } 
  
  // Returns the last element in the Deque 
  public int getBack(){
    return deque[size-1]; 
  } 

  
  public String toString() {
    String s = "";
    for (int i = 0; i<size; i++ ) {
      s+= deque[convertToIndex(i+nextFront+1)];
      s+= ", ";
    }
    return s;
  }
}