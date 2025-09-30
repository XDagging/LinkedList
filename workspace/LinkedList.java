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
      current.getNext().getValue().compareToIgnoreCase(line) < 0
      
    ) {
      current = current.getNext();
    }

    if (current.getValue() == null) {
      current.setValue(line);
      return current;
    }



    // if (current.getValue().compareToIgnoreCase(line) == 0) {
      
    //   return current;
    // }




    ListNode newNode = new ListNode(line, current.getNext());
    current.setNext(newNode);
    return newNode;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null


  // I need to fix null;  
  public ListNode deleteAValue(String line)
  {
    ListNode current = head;
    ListNode prev = null;
    // Special case: head node contains the value
    if (current != null && line != null && line.equals(current.getValue())) {
      head = current.getNext();
      return current;
    }
    while (current != null && current.getNext() != null) {
      if (line != null && line.equals(current.getNext().getValue())) {
        ListNode toDelete = current.getNext();
        current.setNext(toDelete.getNext());
        return toDelete;
      }
      current = current.getNext();
    }

  return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
   {
    String allTog = "";
    ListNode tempHead = head;
    while (tempHead != null) {
      allTog += tempHead.getValue() + " ";
      tempHead = tempHead.getNext(); 
    }


    return allTog;

  }
  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = new ListNode(null, null);
  }

  public void reverse() {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
      ListNode next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }
    head = prev;
  }

  public ListNode reverseX(ListNode x) {
    ListNode prev = null;
    ListNode current = x;
    while (current != null) {
      ListNode next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }

    return prev;
  }




  public void nReverse(int reverseAmt) {
    if (reverseAmt <= 1 || head == null || head.getNext() == null) {
        return;
    }
    ListNode current = head;

    ListNode tailOfPrevChunk = null; 

    while (current != null) {
        ListNode headOfCurrentChunk = current;
        ListNode tailOfCurrentChunk = current;

        int count = 1;
        while (count < reverseAmt && tailOfCurrentChunk.getNext() != null) {
            tailOfCurrentChunk = tailOfCurrentChunk.getNext();
            count++;
        }
        if (count < reverseAmt) {
            if (tailOfPrevChunk != null) {
                tailOfPrevChunk.setNext(current);
            } else {
              break;
            }
           
        }

        ListNode headOfNextChunk = tailOfCurrentChunk.getNext();

        tailOfCurrentChunk.setNext(null);

        ListNode reversedChunkHead = reverseX(headOfCurrentChunk);

        if (tailOfPrevChunk == null) {
            head = reversedChunkHead;
        } else {
            tailOfPrevChunk.setNext(reversedChunkHead);
        }
        tailOfPrevChunk = headOfCurrentChunk; 
        current = headOfNextChunk;
    }
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