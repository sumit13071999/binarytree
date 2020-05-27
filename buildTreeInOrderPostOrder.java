package binarytree;
import java.util.Scanner;
public class buildTreeInOrderPostOrder {
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
	public void buildTree(int []InOrder) {
		this.root=buildTree(InOrder,0,InOrder.length-1);
	}
	private Node buildTree(int []InOrder,int start,int end) {
		if(start>end) return null;
		Node nn=new Node(postOrder[postIndex--]);
		System.out.println(nn.data);
		if(start==end)
	return nn;
		int inOrderIndex=getInOrderIndex(nn.data,InOrder,start,end);
			nn.right=buildTree(InOrder,inOrderIndex+1,end);
		nn.left=buildTree(InOrder,start,inOrderIndex-1);
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
	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		if (node.left != null) {
			str += node.left.data;
		} else {
			str += "END";
		}

		str += " => " + node.data + " <= ";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += "END";
		}

		System.out.println(str);

		this.display(node.left);
		this.display(node.right);
	}
	static int postOrder[];
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		 postOrder=new int[n];
		for(int i=0;i<n;i++) {
			postOrder[i]=scn.nextInt();
		}
		int m=scn.nextInt();
		int InOrder[]=new int[m];
		for(int i=0;i<m;i++) {
			InOrder[i]=scn.nextInt();
		}
		buildTreeInOrderPostOrder t=new buildTreeInOrderPostOrder();
		t.buildTree(InOrder);
        t.display();
	}
	int postIndex=postOrder.length-1;

}
