/**
 *
 * @author joulephicar
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {

   char nama;
   Node parent;
   int fn;
   boolean expanded;

   Node(char nama) {
      this.nama = nama;
   }
}

class Edge {

   Node from;
   Node to;
   int jarak;

   Edge(Node from, Node to, int jarak) {
      this.from = from;
      this.to = to;
      this.jarak = jarak;
   }
}

class Graf {
   // ale menyimpan seluruh hubungan edge yang ada pada graf ini
   ArrayList<Edge> ale = new ArrayList<Edge>();

   void addEdge(Node from, Node to, int jarak) {
      Edge e = new Edge(from, to, jarak);
      ale.add(e);
   }

   ArrayList traversal(Node from) {
      ArrayList<Node> cari = new ArrayList<>();
      for (int i = 0; i < ale.size(); i++) {
         if (ale.get(i).from.equals(from)) {
            cari.add(ale.get(i).to);
         }
      }
      return cari;
   }

   //fungsi untuk mencari jarak dari current ke successor
   int W(Node current, Node successor) {
      int jarak = 0;
      for (Edge e : ale) {
         if (e.from == current && e.to == successor) {
            jarak = e.jarak;
            break;
         }
      }
      return jarak;
   }

   ArrayList UCSFinding(Node from, Node to) {
      //referensi didapat dari
      //https://www.geeksforgeeks.org/a-search-algorithm/
      //http://mat.uab.cat/~alseda/MasterOpt/AStar-Algorithm.pdf
      ArrayList<Node> path = new ArrayList<Node>(); //menyimpan node2 yg dilalui dari from ke to
      ArrayList<Node> open = new ArrayList<Node>(); //terdiri dari node yg udah visited, tapi belum expanded
      ArrayList<Node> close = new ArrayList<Node>(); //terdiri dari node yg udah visited dan expanded
      open.add(from);
      Node Nmin = null;
      int fnKcl = 10000;
      while (!open.isEmpty()) {
         for (Node open1 : open) {
            if (fnKcl > open1.fn) {
               Nmin = open1;
            }
         }
         open.remove(Nmin);
         close.add(Nmin);
         if (Nmin.equals(to)) {
            // ke node tujuan
            Node curr = Nmin;
            while (curr != from) {
               path.add(curr);
               curr = curr.parent;
               //System.out.println("curr.nama = " + curr.nama);
            }
            path.add(from);
            break;
         }
         // parentnya rada error
         ArrayList<Node> lSucc = traversal(Nmin);
         Nmin.expanded = true;
         for (Node lSucc1 : lSucc) {
            if (!lSucc1.expanded) {
               if (lSucc1.parent == null) {
                  lSucc1.parent = Nmin;
               }
            }
         }
         for (Node lSucc1 : lSucc) {
            if (close.contains(lSucc1)) {
               continue;
            }
            if (open.contains(lSucc1)) {
               continue;
            }
            lSucc1.fn = Nmin.fn + W(Nmin, lSucc1);
            open.add(lSucc1);
         }
//         System.out.println("sadafasfa");
      }
      // Lengkapi!!
      return path;
   }

   void printPath(Node from, Node to) {
      ArrayList<Node> path = UCSFinding(from, to);
      Collections.reverse(path);
      for (Node n : path) {
         System.out.print(n.nama + " -> ");
      }
      System.out.println("finish");
      System.out.println(to.fn);
   }
}

public class UCS {
   public static void main(String[] args) {
      Node A = new Node('A');
      Node B = new Node('B');
      Node C = new Node('C');
      Node D = new Node('D');
      Node E = new Node('E');
      Node F = new Node('F');
      Node G = new Node('G');
      Graf g = new Graf();
      g.addEdge(A, B, 80);
      g.addEdge(A, G, 80);
      g.addEdge(A, F, 70);
      g.addEdge(B, A, 80);
      g.addEdge(B, C, 90);
      g.addEdge(B, D, 100);
      g.addEdge(B, G, 50);
      g.addEdge(C, B, 90);
      g.addEdge(C, D, 50);
      g.addEdge(D, B, 100);
      g.addEdge(D, C, 50);
      g.addEdge(D, E, 60);
      g.addEdge(D, F, 90);
      g.addEdge(E, D, 60);
      g.addEdge(E, F, 70);
      g.addEdge(F, A, 70);
      g.addEdge(F, D, 90);
      g.addEdge(F, E, 70);
      g.addEdge(F, G, 40);
      g.addEdge(G, A, 80);
      g.addEdge(G, B, 50);
      g.addEdge(G, F, 40);
      Scanner inp = new Scanner(System.in);
      String input = inp.nextLine();
      char asal = input.charAt(0);
      char tujuan = input.charAt(2);
      Node nodes[] = {A, B, C, D, E, F, G};
      Node Asal = A, Tujuan = A;
      for (int i = 0; i < nodes.length; i++) {
         if (asal == nodes[i].nama) {
            Asal = nodes[i];
         }
         if (tujuan == nodes[i].nama) {
            Tujuan = nodes[i];
         }
      }
      g.printPath(Asal, Tujuan);
   }
}
