package binarytree;


public class r {

	public static void main(String[] args) {
		
			recursion1 obj=new recursion1();
			int i=5;
		obj.fact(i);
		
		}

	}
	class recursion1
	{ 
	 void  fact(int i)
		{
			if(i<1)
			{
			
			return;
		
		}
			System.out.print(i);
			fact(i-1);
			System.out.println(i);
		}
	}


	
