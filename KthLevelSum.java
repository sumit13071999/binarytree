package binarytree;
import java.util.*;
public class KthLevelSum {
 public class Node{
	 int data;
	 Node left;
	 Node right;
	 Node(int data){
		 this.data=data;
		 this.left=null;
		 this.right=null;
	 }
 }
 Scanner s=new Scanner(System.in);
 Node root;
 public KthLevelSum() {
	 this.root=takeInput(null,0);
 }
	private Node takeInput( Node node, int child) {
		int value=s.nextInt();
	Node nn=new Node(value);
	if(node==null) {
		node=nn;
	}
	 child=s.nextInt();
	 if(child>=1)
	node.left= takeInput(node.left,child);
	 if(child==2)
	node.right= takeInput(node.right,child);
	return node;
}
	int sum;
	public void sum(int k) {
		this.sum(this.root,0,k);
		System.out.println(sum);
	}
	private void sum(Node node,int level,int k) {
		if(node==null)
			return ;
		if(k==level) {
			sum+=node.data;
		}
		sum(node.left,level+1,k);
		sum(node.right,level+1,k);
		return ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
KthLevelSum t=new KthLevelSum();
int k=t.s.nextInt();
t.sum(k);
	}

}
