package binarytree;

import java.util.*;
public class treeTopView {
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
	treeTopView()
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
	public void display() {
		display(this.root);
	}
	private void display(Node node) {
		String str="";
		if(node.left!=null) {
			str=str+node.left.data+"=>";
		}else {
			str=str+"END=>";
		}
		str=str+node.data;
		if(node.right!=null) {
			str=str+"<="+node.right.data;
		}else {
			str=str+"<=END";
		}
		System.out.println(str);
		if(node.left!=null)
			this.display(node.left);
		if(node.right!=null)
			this.display(node.right);
	}
	private int height(Node node) {
		if(node==null) {
			return -1;
		}
		int lheight=height(node.left);
		int rheight=height(node.right);
		int height=Math.max(lheight,rheight);
		return height+1;
	}
	public void topView() {
		topView(this.root);
	}
	private void topView(Node node) {
		 if (node == null) {
		      return;
		    }

		    TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		    Queue<Node> q = new LinkedList<Node>();
		    q.add(node);

		    while (!q.isEmpty()) {
		      Node temp = q.remove();
		      int hd =temp.height;
		      
		      if (m.get(hd) == null) {
		        m.put(hd, temp.data);
		      }

		      if (temp.left != null) {
		        temp.left.height = hd - 1;
		        q.add(temp.left);
		      }

		      if (temp.right != null) {
		        temp.right.height = hd + 1;
		        q.add(temp.right);
		      }
		    }
		    for(Map.Entry<Integer,Integer> element :m.entrySet()) {
		    	System.out.print(element.getValue()+" ");
		    }
		   /*while(!m.isEmpty()) {
		    	Map.Entry<Integer,Integer> temp=m.pollFirstEntry();
		    	System.out.println(temp);
		    }*/
		   //System.out.println(m.values());
		    
		  //  System.out.println(m.values());
	}
	public void rightView() {
		rightView(this.root,0);
	}
	private void rightView(Node node,int level) {
		if(node==null)
			return;
		if(level>=maxlevel) {
			System.out.print(node.data+" ");
			maxlevel++;
		}
		leftView(node.right,level+1);
		leftView(node.left,level+1);
	}
	public void leftView() {
		leftView(this.root,0);
	}
	int maxlevel;
	private void leftView(Node node,int level) {
		if(node==null)
			return;
		if(level>=maxlevel) {
			System.out.print(node.data+" ");
			maxlevel++;
		}
		leftView(node.left,level+1);
		leftView(node.right,level+1);
	}
	public void bottomView() {
		bottomView(this.root);
	}
	private void bottomView(Node node) {
		 if (node == null) {
		      return;
		    }

		    TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		    Queue<Node> q = new LinkedList<Node>();
		    q.add(node);

		    while (!q.isEmpty()) {
		      Node temp = q.remove();
		      int hd =temp.height;
		      
		      
		        m.put(hd, temp.data);
		      

		      if (temp.left != null) {
		        temp.left.height = hd - 1;
		        q.add(temp.left);
		      }

		      if (temp.right != null) {
		        temp.right.height = hd + 1;
		        q.add(temp.right);
		      }
		    }
		    for(Map.Entry<Integer,Integer> element :m.entrySet()) {
		    	System.out.print(element.getValue()+" ");
		    }
	}
	 public static void main(String args[]) {
	       treeTopView n=new treeTopView();
	       n.bottomView();
	    }
}
