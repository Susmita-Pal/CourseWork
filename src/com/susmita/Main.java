package com.susmita;

import java.util.*;

import static java.lang.System.*;

class Node {
    int data;
    Node next;

}

public class Main {
    static Node head = null, tail = null;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int pos, n, ch, p;
        do {
            out.println("\nlinked list menu");
            out.println("\n1.Create\n2.Insert at a position\n3.Delete\n4.Delete at a position\n5.Display from front\n6.Display from rear\n7.Exit");
            out.println("Enter your choice");
            ch = in.nextInt();
            if (ch == 1) {
                out.println("ENTER NUMBER OF NODES YOU WANT TO CREATE");
                n = in.nextInt();
                create(n);
            } else if (ch == 2) {
                out.println("Enter position to be entered");
                pos = in.nextInt();
                out.println("Enter number to be inserted ");
                n = in.nextInt();
                insertPos(pos, n);
            } else if (ch == 3)
                delete();
            else if (ch == 4) {
                out.println("Enter position from which you want to delete the node");
                p = in.nextInt();
                deletePos(p);
            } else if (ch == 5)
                display();

            else if (ch == 6)
                displayRear(head);

            else if (ch > 7)
                out.println("Invalid Choice");
        } while (ch != 7);
    }


    static void create(int n1) //creation of a node n number of times
    {
        int nn;
        for (int i = 0; i < n1; i++) {
            Node temp = new Node();
            out.println("Enter the data");
            nn = in.nextInt();
            temp.next = null;
            temp.data = nn;
            if (head == null)
                head = tail = temp;
            else {
                tail.next = temp;
                tail = temp;
            }
        }
    }

    static void delete() {
        Node temp = head, prev = null;
        if (head == null)
            out.println("No elements left in the Linked list to be deleted");
        else if (head != tail) {
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            tail = prev;
            tail.next = null;
            temp = null;
        } else
            head = tail = null;
    }

    static void deletePos(int p) {
        Node temp1 = head, prev = null;
        int c = 1, j = 0;
        if (p > 1) {
            while (c < p) {
                prev = temp1;
                if (prev.next == null) {
                    j++;
                    break;
                }
                temp1 = temp1.next;
                c++;
            }
            if (temp1.next != null && j == 0)
                prev.next = temp1.next;

            else if (temp1.next == null && j == 0) {
                prev.next = null;
                tail = prev;
            } else if (j != 0)
                out.println("Invalid Position");
        } else
            head = head.next;
    }

    static void display() {
        Node temp = head;
        while (temp != null) {
            out.println(temp.data);
            temp = temp.next;
        }
    }

    static void insertPos(int p, int n) {
        Node temp = new Node();
        Node temp1 = head, prev = null;
        int c = 1, j = 0;
        if (p > 1) {
            while (c < p) {
                prev = temp1;
                if (prev == null) {
                    j++;
                    break;
                }
                temp1 = temp1.next;
                c++;
            }
            if (j != 0)
                out.println("Invalid Position");
            else if (temp1 == null && j == 0) {
                prev.next = temp;
                temp.next = temp1;
                temp.data = n;
                tail = temp;
            } else if (j == 0 && temp1 != null) {
                prev.next = temp;
                temp.next = temp1;
                temp.data = n;
            }
        } else {
            temp.next = head;
            head = temp;
            temp.data = n;
        }
    }

    static void displayRear(Node head) {
        if (head == null)
            return;
        else
            displayRear(head.next);

        System.out.println(head.data + " ");
    }
}