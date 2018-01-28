package code.List;

import java.util.Scanner;


public class SinglyLinkedList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.println("Singly Linked List Test\n");
        char ch;
       
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            //Append can be done at multiple positions.
            System.out.println("1. append at beginning");
            System.out.println("2. append at end");
            System.out.println("3. append at position");
            System.out.println("4. remove at tail");
            System.out.println("5. remove elements greater than target value");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    list.appendAtStart( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter integer element to insert");
                    list.appendAtEnd( scan.nextInt() );
                    break;
                case 3 :
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt() ;
                    System.out.println("Enter position");
                    int pos = scan.nextInt() ;
                    if (pos <= 1 || pos > list.getListSize() )
                        System.out.println("Invalid position\n");
                    else
                        list.appendAtPos(num, pos);
                    break;
                case 4 :
                    if(list.getListSize()>0)
                        list.removeTail();
                    else
                        System.out.println("List is empty, nothing to remove.");
                    break;
                case 5 :
                    System.out.println("Enter the target value");
                    int target = scan.nextInt();
                    if(list.getListSize()>0)
                        list.removeGreater(target);
                    else
                        System.out.println("List is empty, nothing to remove.");
                    break;

                default :
                    System.out.println("Invalid Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');

    }

}