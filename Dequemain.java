class Main {
  public static void main(String[] args) {
   // TODO: Test your Deque implementation here!
   Deque d = new Deque(5);
   d.insertFront(0);
   d.insertFront(1);
   d.insertFront(2);
   d.insertFront(3);
   d.insertFront(4);
   //d.insertFront(5);
   System.out.println(d);
   System.out.println("InsertFront");
   d.removeFront();
   
   System.out.println(d);
   System.out.println("Remove Front");
   d.removeBack();
   
   System.out.println(d);
   System.out.println("Remove Back");
   d.insertBack(10);
   
   System.out.println(d);
   System.out.println("Insert Back");
  }
}