//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            int k=Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Solution ob=new Solution();
                int ans=ob.goodSubtrees(root,k);
                out.println(ans);
                    t--;
            
            }
            out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int goodSubtrees(Node root,int k)
    {
         int[] count = new int[1];
        Set<Integer> set = helper(root, k, count);
        return count[0];
    }
    
    public static Set<Integer> helper(Node node, int k, int[] count) {
        if (node == null) {
            return new HashSet<>();
        }
        Set<Integer> left = helper(node.left, k, count);
        Set<Integer> right = helper(node.right, k, count);
        Set<Integer> set = new HashSet<>(left);
        set.addAll(right);
        set.add(node.data);
        if (set.size() <= k) {
            count[0]++;
        }
        return set;
    }
}