/**
 * Berlin Brown , berlin dot brown at gmail.com
 * 
 * Java Insertion Sort based on Haskell impl (Convert from Haskell to Java).
 * 
 */
package org.berlin.algo.basic;

import java.io.Serializable;
import java.util.List;

public class DepthFirstSearch {

  public enum VertexColor {
      White, Gray, Black      
  }
  
  public enum EdgeType {
    Tree, Backward, Forward, Cross
  }
  
  public static class Graph {
    
    
    public int getNumVerticies() {
      
    }
    public boolean isEdge(final int u, final int v) {
      
    }
    public boolean isEdge(final int u, final int v, final int weight) {
      for (VertexList::const_iterator ei = vertices_[u].begin();
      ei != vertices_[u].end(); 
      ++ei) {
   if (ei->first == v) {
     w = ei->second;
     return true;
   }
 }

 return false;
    }
    public int getEdgeWeight(final int u, final int v) {
      
    }
    
    public void addEdge(final int u, final int v) {
      
    }
    public void addEdge(final int u, final int v, final int weight) {
      if (u > n_ || v > n_) {
        throw "Graph::addEdge given vertex larger than graph size";
      }

      pair<int,int> edge(v,w);
      vertices_[u].push_front(edge);

        // undirected have both.
      if (!directed_) {
        pair<int, int> edgeR (u,w);
        vertices_[v].push_front(edgeR);
      }
    }
    public boolean hasRemoveEdge(final int u, final int v) {
      bool found = false;
      for (VertexList::const_iterator ei = vertices_[u].begin();
     ei != vertices_[u].end(); 
     ++ei) {
        if (ei->first == v) {
    vertices_[u].remove(*ei);
    found = true;
    break;
        }
      }
      
      // not found at all? return
      if (!found) return false;

      if (!directed_) {
        for (VertexList::const_iterator ei = vertices_[v].begin();
       ei != vertices_[v].end(); 
       ++ei) {
    if (ei->first == u) {
      vertices_[v].remove(*ei);
      break;
    }
        }
      }
      
      return true;
    }
   
    public void dfsVisit(final int u, final List<Integer> d, final List<Integer> f, final List<Integer> pred) {
      color[u] = Gray;
      d[u] = ++ctr;

      // process all neighbors of u.
      for (VertexList::const_iterator ci = graph.begin(u);
           ci != graph.end(u); ++ci) {
        int v = ci->first;

        // Compute edgeType and add to labelings. Default to cross
        edgeType type = Cross;
        if (color[v] == White) { type = Tree; }
        else if (color[v] == Gray) { type = Backward; }
        else { if (d[u] < d[v]) type = Forward; }
        labels.push_back(EdgeLabel (u, v, type));

        // Explore unvisited vertices immediately and record pred[].
        // Once recursive call ends, backtrack to adjacent vertices.
        if (color[v] == White) {
          pred[v] = u;
          dfs_visit (graph, v, d, f, pred, color, ctr, labels);
        }
      }

      color[u] = Black;  // our neighbors are complete; now so are we.
      f[u] = ++ctr;
    }
    
    /**
     * Perform Depth First Search starting from vertex s, and compute the
     * values d[u] (when vertex u was first discovered), f[u] (when all
     * vertices adjacent to u have been processed), pred[u] (the predecessor
     * vertex to u in resulting depth-first search forest), and label edges
     * according to their type.
     * 
     */
    void dfs_search (Graph const &graph, int s,          /* in */
        vector<int> &d, vector<int> &f,             /* out */
        vector<int> &pred, list<EdgeLabel> &labels) /* out */
     {
       // initialize d[], f[], and pred[] arrays. Mark all vertices White
       // to signify unvisited. Clear out edge labels.
       int ctr = 0;
       const int n = graph.numVertices();
       vector<vertexColor> color (n, White);
       d.assign(n, -1);
       f.assign(n, -1);
       pred.assign(n, -1);
       labels.clear();

       // Search starting at the source vertex; when done, visit any
       // vertices that remain unvisited.
       dfs_visit (graph, s, d, f, pred, color, ctr, labels);
       for (int u = 0; u < n; u++) {
         if (color[u] == White) {
           dfs_visit (graph, u, d, f, pred, color, ctr, labels);
         }
       }
    
  }
  
  public static class Pair <T, S> implements Serializable {        
    private static final long serialVersionUID = -2202117371650541073L;   
    private final T first;
    private final S second;
    public Pair(final T f, final S s) {
        first = f;
        second = s;
    }
    public T x() {
        return getFirst();
    }
    public S xs() {
        return getSecond();
    }
    public T getFirst() {
        return first;
    }     
    public S getSecond() {
        return second;
    }
    /**
     * Return String string representation of object.
     * @return String
     */
    public String toString() {
        return "(" 
            + ((first  == null) ? "" : first.toString()) + ", " 
            + ((second == null) ? "" : second.toString()) + ")";
    }
 } 
  
  public static void main(final String [] args) {
    
  }
  
}
