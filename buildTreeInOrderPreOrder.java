package binarytree;
import java.util.*;
public class buildTreeInOrderPreOrder {
	class Node{
		int  data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	private Node root;
	private int size=0;
	int preIndex;
	public void buildTree(int []InOrder,int []PreOrder) {
		this.root=buildTree(InOrder,PreOrder,0,InOrder.length-1);
	}
	private Node buildTree(int []InOrder,int []PreOrder,int start,int end) {
		if(start>end) return null;
		Node nn=new Node(PreOrder[preIndex++]);
		//System.out.println(nn.data);
		if(start==end)
	return nn;
		int inOrderIndex=getInOrderIndex(nn.data,InOrder,start,end);
		nn.left=buildTree(InOrder,PreOrder,start,inOrderIndex-1);
		nn.right=buildTree(InOrder,PreOrder,inOrderIndex+1,end);
		return nn;
	}

	private int getInOrderIndex(int val, int[] in, int start, int end) {
		int result=-1;
		for(int i=0;i<in.length;i++) {
			if(in[i]==val) {
				return i;
			}
		}
		return result;
	}
	public void display()
	{
		display(this.root);
	}
	private void display(Node node) {
		String str="";
		if(node.left!=null) {
			str=str+node.left.data+" => ";
		}else {
			str=str+"END => ";
		}
		str=str+node.data;
		if(node.right!=null) {
			str=str+" <= "+node.right.data;
		}else {
			str=str+" <= END";
		}
		System.out.println(str);
		if(node.left!=null)
			this.display(node.left);
		if(node.right!=null)
			this.display(node.right);
	}
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int preOrder[]=new int[n];
		for(int i=0;i<n;i++) {
			preOrder[i]=scn.nextInt();
		}
	//	int m=scn.nextInt();
		int InOrder[]=new int[n];
		for(int i=0;i<n;i++) {
			InOrder[i]=scn.nextInt();
		}
		buildTreeInOrderPreOrder t=new buildTreeInOrderPreOrder();
		t.buildTree(InOrder, preOrder);
       // t.display();
		t.height();
	}
 public void height() {
	 int n=height(root.left);
	 int m=height(root.right);
	 System.out.println(Math.max(n, m));}
private int height(Node node) {
	if(node==null)
		return 0;
return	Math.max(height(node.left),height(node.right))+1;
}

public static void  isBinaryTree(Node node) {
	//isBinary(node);
}
}

