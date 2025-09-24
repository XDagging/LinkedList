// Name: Sebastian Hernandez-Tavares

/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/



// This was the test I did


// show 

// add cat

// add dog

// show

// clear

// exit

public class LinkedList {

  //instance varialbes go here (think about what you need to keep track of!)
  private ListNode head;
  //constructors go here

  public LinkedList() {
    head = new ListNode(null,null);
  }

  public LinkedList(String line, ListNode next) {
    head = new ListNode(line, next);
  }

  

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    ListNode current = head;
    

    while (current.getNext() != null &&
         current.getNext().getValue().compareToIgnoreCase(line) < 0) {
      current = current.getNext();
    }

    if (current.getValue() == null) {
      current.setValue(line);
      return current;
    }

    ListNode newNode = new ListNode(line, current.getNext());
    current.setNext(newNode);
    return newNode;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    ListNode current = head;
    // List<String> alphabet = List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");

    while (current.getValue() != line) {
      current = current.getNext();
    } 

    

    ListNode temp = current;

    temp.setNext(current.getNext().getNext());
    current.setNext(temp.getNext());


    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
   {
    String allTog = "";

    while (head != null) {
      allTog += head.getValue() + " ";
      head = head.getNext(); 
    }


    return allTog;

  }
  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = new ListNode(null, null);
  }
}


// public static void main(String[] args) {
//   LinkedList list = new LinkedList();
//   list.addAValue("cat");
//   list.addAValue("dog");
//   list.addAValue("ant");
//   System.out.println(list.showValues());
//   list.deleteAValue("dog");
//   System.out.println(list.showValues());
//   list.clear();
//   System.out.println(list.showValues());



// }