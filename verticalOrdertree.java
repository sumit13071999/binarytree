package binarytree;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class verticalOrdertree {
	private class Node{
		 private	int data=0;
			private Node left=null;
			private Node right=null;
			public int height;
			Node(int data,Node left,Node right){
				this.data=data;
				this.left=left;
				this.right=right;
				
			}
		}
	private Node root=null;
	private int size=0;
	 verticalOrdertree()
	{
		Scanner s=new Scanner(System.in);
		takeInput(s);
	}
	private void takeInput(Scanner s) {
		Queue<Node> q=new LinkedList<Node>();
		int newnn=s.nextInt();
		Node nn=new Node(newnn,null,null);
		if(newnn!=-1) {
	    if(root==null)
	    	this.root=nn;
	        q.add(nn);
	        while(!q.isEmpty()) {
	        	Node temp=q.poll();
	        if(temp.left==null) {
	        	int value=s.nextInt();
	        	if(value!=-1) {
	        		Node n=new Node(value,null,null);
	        		temp.left=n;
	        		q.add(n);
	        }}
	        if(temp.right==null) {
	        	int value=s.nextInt();
	        	if(value!=-1) {
	        		Node n=new Node(value,null,null);
	        		temp.right=n;
	        		q.add(n);
	        	}
	        }
	    
	        }
	        }
	}
public void	verticalOrder() {
	HashMap<Integer,String> map=new HashMap<Integer,String>();
	verticalOrder(this.root,map,0);
	int max=findMax(map.keySet());
	while(!map.isEmpty()) {
		System.out.println(map.remove(max));
		max--;
	}
	//System.out.println(map.keySet());
	//PriorityQueue<Integer> minheap=new PriorityQueue<>(Collections.reverseOrder());
	//for(Integer i:map.keySet()) {
	//	minheap.add(i);
	//}
	//while(!minheap.isEmpty())
	//System.out.println(map.get(minheap.remove()));
	
}
private int findMax(Set<Integer> keySet) {
	int max=Integer.MIN_VALUE;
	for(int i:keySet) {
		if(max<i) {
			max=i;
		}
	}
	return max;
}
private void verticalOrder(Node node,HashMap<Integer,String> map,int level) {
	if(node==null) {
		return;
	}
	if(map.containsKey(level)) {
		String str=map.get(level)+node.data+" ";
		map.put(level, str);
		//System.out.println(str);
	}else {
		map.put(level, node.data+" ");
	}
	verticalOrder(node.left,map,level+1);
	verticalOrder(node.right,map,level-1);
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int l=sc.nextInt();
		verticalOrdertree v=new verticalOrdertree();
		v.verticalOrder();

	}

}
