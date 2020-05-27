package binarytree;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class printBSTkeyGivenRange {
	private class Node{
		Node left;
		Node right;
		int data;
	   }
	   private Node root;
	   void constract(int ar[]){
		    this.root=constract(ar,0,ar.length);
	   }
	   private Node constract(int ar[],int low,int high) {
		   if(low>=high)
		   {
			   return null;
		   }
		   int mid=(low + high)/2;
		   Node nn=new Node();
		   nn.data=ar[mid];
		   nn.left=constract(ar,low,mid);
		   nn.right=constract(ar,mid+1,high);
		   return nn;
}
      public void rangeElement(int k1,int k2){
		  rangeElement(this.root,k1,k2);
	  }
	  private void rangeElement(Node node,int k1,int k2){
		  if(node==null){
			  return;
		  }
		  if(k1<=node.data && k2>=node.data){
			  System.out.print(" "+node.data);
		  }
		  rangeElement(node.left,k1,k2);
		  rangeElement(node.right,k1,k2);
	  }
	  public void preOrder() {
		  preOrder(this.root);
	  }
	  private void preOrder(Node node)
	  {
		  if(node==null) {
			  return;
		  }
		  System.out.print(" "+node.data);
		  preOrder(node.left);
		  preOrder(node.right);
	  }
	   static Scanner scn=new Scanner(System.in);
	   public static void main(String[] args) {
		   printBSTkeyGivenRange BST=new printBSTkeyGivenRange();
		   int t=scn.nextInt();
		   while(t!=0) {
			   int n=scn.nextInt();
			   int ar[]=new int[n];
			   for(int i=0;i<n;i++) {
				   ar[i]=scn.nextInt();
			   }
			   Arrays.sort(ar);
			   int k1=scn.nextInt();
			   int k2=scn.nextInt();
			   BST.constract(ar);
			   System.out.print("# Preorder :");
			   BST.preOrder();
			   System.out.println();
			   System.out.print("# Nodes within range are :");
			   BST.rangeElement(k1,k2);
			   t--;
		   }
		   
	   }
}