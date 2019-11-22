package Praktikum09;

import java.util.Random;
import java.util.Scanner;

class Node {

   Character data;
   Node nodeKiri;
   Node nodeKanan;

   public Node(char dt) {
      data = dt;
      nodeKiri = nodeKanan = null;
   }

   public void addNode(char dtSisip) {
      if (dtSisip < data) {
         if (nodeKiri == null) {
            nodeKiri = new Node(dtSisip);
         } else {
            nodeKiri.addNode(dtSisip);
         }
      } else if (dtSisip > data) {
         if (nodeKanan == null) {
            nodeKanan = new Node(dtSisip);
         } else {
            nodeKanan.addNode(dtSisip);
         }
      }
   }
}

public class Tree {

   private Node root;

   public Tree() {
      root = null;
   }
   
   public void insert(char dtSisip) {
      if (root == null) {
         root = new Node(dtSisip);
      } else {
         root.addNode(dtSisip);
      }
   }

   public void preorderTraversal() {
      preorder(root);
   }

   private void preorder(Node node) {
      if (node == null) {
         return;
      }
      System.out.printf("%c ", node.data);
      preorder(node.nodeKiri);
      preorder(node.nodeKanan);
   }

   public void inorderTraversal() {
      inorder(root);
   }

   private void inorder(Node node) {
      if (node == null) {
         return;
      }
      inorder(node.nodeKiri);
      System.out.printf("%c ", node.data);
      inorder(node.nodeKanan);
   }

   public void postorderTraversal() {
      postorder(root);
   }

   private void postorder(Node node) {
      if (node == null) {
         return;
      }
      postorder(node.nodeKiri);
      postorder(node.nodeKanan);
      System.out.printf("%c ", node.data);
   }

   public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      Tree Tree = new Tree();
      String s = in.nextLine();
      s = s.toLowerCase();
      System.out.println("sisip nilai data berikut : "); // sisipDt 10 bilangan acak dari 0-99 ke dalam tree
      for (int i = 0; i < s.length(); i++) {
         System.out.printf(s.charAt(i) + " ");
         Tree.insert(s.charAt(i));
      }
      System.out.println("\n\nInorder traversal");
      Tree.inorderTraversal();
   }
}
