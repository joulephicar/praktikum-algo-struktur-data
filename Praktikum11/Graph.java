/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum11;

import java.util.LinkedList;

public class Graph {

   private class Node {

      private int data;
      private Node next;
      
      public Node(int dt, Node n) {
         data = dt;
         next = n;
      }

      public int getDt() {
         return data;
      }

      public Node getNext() {
         return next;
      }
   }
   private Node[] node;
   private int jNode;

   public Graph(int n) {
      jNode = n;
      node = new Node[jNode];
   }

   public void addAdj(int head, int adj) {
      Node n = new Node(adj, node[head]);
      node[head] = n;
   }

   public void cetak(String komentar) {
      System.out.println(komentar);
      for (int i = 0; i < jNode; i++) {
         System.out.print("[" + i + "]");
         Node n = node[i];
         while (n != null) {
            System.out.print("->" + n.getDt());
            n = n.getNext();
         }
         System.out.println();
      }
   }

   public void BFS(int s) {
      boolean[] flag = new boolean[jNode];
      LinkedList<Integer> q = new LinkedList<>();
      flag[s] = true;
      q.add(s);
      while (!q.isEmpty()) {
         s = q.poll();
         System.out.print(s + " ");
         Node curr = node[s];
         while (curr != null) {
            //System.out.println("curr.data = "+ curr.getDt());
            if (!flag[curr.getDt()]) {
               flag[curr.getDt()] = true;
               q.add(curr.getDt());
            }
            curr = curr.next;
         }
      }
   }
   public void DFSrec(int v, boolean flag[]){
      flag[v] = true;
      Node curr = node[v];
      System.out.print(v+" ");
      if (flag[v] == false) {
         return;
      }
      while (curr != null) {
         if (!flag[curr.getDt()]) {
            DFSrec(curr.getDt(), flag);
            //flag[curr.getDt()] = true;
         }
         curr = curr.next;
      }
   }
   public void DFS(int v){
      boolean flag[] = new boolean[jNode];
      DFSrec(v, flag);
   }

   public static void main(String args[]) {
      Graph g = new Graph(5);
      g.addAdj(0, 1);
      g.addAdj(0, 2);
      g.addAdj(1, 2);
      g.addAdj(2, 0);
      g.addAdj(2, 3);
      g.addAdj(3, 3);
//      g.addAdj(0, 3);
//      g.addAdj(0, 1);
//      g.addAdj(1, 4);
//      g.addAdj(1, 2);
//      g.addAdj(2, 4);
//      g.addAdj(2, 1);
//      g.addAdj(4, 3);
      g.cetak("Kondisi awal");
      g.BFS(2);
      System.out.println("");
      g.DFS(2);
   }
}
