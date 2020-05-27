package binarytree;

import java.util.LinkedList;
import java.util.Queue;

class node
{
	node left,right;
	int data;
}
class binarytreee
{
node createnode(int d)
{
	node a=new node();
	a.data=d;
	a.left=null;
	a.right=null;;
	return a;
	
}
 node deletepostorder(node node)
 {
	 if(node==null)
	 {
		 return null;
	 }
	node.left= deletepostorder(node.left);
	 node.right=deletepostorder(node.right);
	 System.out.print(" "+node.data);
	 node=null;
	 return node;
 }
void levelorder(node t)
{
	Queue<node> queue=new LinkedList<node>();
	queue.add(t); 
	while(!queue.isEmpty())
	{
		t=queue.poll();
		System.out.print(" "+t.data);
		if(t.left!=null)
			queue.add(t.left);
		if(t.right!=null)
			queue.add(t.right);
	}
	System.out.println();
}
void postorder(node t)
{
	if(t==null)
		return;
	postorder(t.left);
	postorder(t.right);
	System.out.print(" "+t.data);
}
void preorder(node t)
{
	if(t==null)
		return;
	System.out.print(" "+t.data);
	preorder(t.left);
	preorder(t.right);
}
void inorder(node t)
{
	if(t==null)
		return;
	inorder(t.left);
	System.out.print(" "+t.data);
	inorder(t.right);
}
}
public class binarytree {
static node root;
public static void main(String[] args) {
	binarytreee a=new binarytreee();
root= a.createnode(1);
root.left=a.createnode(2);
root.right=a.createnode(3);
root.left.left=a.createnode(4);
root.left.right=a.createnode(5);
root.right.left=a.createnode(6);
root.right.right=a.createnode(7);
root.left.left.left=a.createnode(8);
root.left.left.right=a.createnode(9);
root.left.right.left=a.createnode(10);					
root.left.right.right=a.createnode(11);
root.right.left.left=a.createnode(12);
root.right.left.right=a.createnode(13);
root.right.right.left=a.createnode(14);
root.right.right.right=a.createnode(15);
a.inorder(root);
System.out.println();
a.preorder(root);
System.out.println();
a.postorder(root);
System.out.println();
a.levelorder(root);
a.deletepostorder(root);
System.out.println();
a.levelorder(root);
System.out.println("all element are deleted ");
}

}

