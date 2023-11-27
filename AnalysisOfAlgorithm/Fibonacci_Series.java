package AnalysisOfAlgorithm;


public class Fibonacci_Series {
	//non recursive
	  static void fibboNo()
	  {
		  System.out.print("Recursive: ");
	  	int n=10;
	  	int n1=0,n2=1,n3;
	  	System.out.print(n1+" "+n2);
	  	for(int i=2;i<n;i++)
	  	{
	  		n3=n1+n2;
	  		System.out.print(" "+n3);
	  		n1=n2;
	  		n2=n3;
	  		
	  	}
	  	
	  }
	  
// recursive 
	  static int fibbo_No(int no)
	  {
	  
	  	if(no<=1)
	  		return no;
	  	
	  	return fibbo_No(no-1)+ fibbo_No(no-2);
	    
	  	 
	  }  
	public static void main(String[] args) {
		int no=10;
		fibboNo();
		System.out.println();
		 System.out.print(" Non- Recursive: ");
		for(int i=0;i<no;i++)
		{
			 System.out.print(" "+fibbo_No(i));
		}
	}

}
