
public class SeperatezeroAndone {
	
	
	public static void main(String[] args) {
		int a[]= {1,0,1,0,1,0};
		int b[]=new int [a.length];
		int j=0;
		int k=a.length-1;
		for (int i=0 ;i<a.length;i++){
			if(a[i]==0)
			{
				b[j]=a[i];
				j++;
			}
			else
			{
				b[k]=a[i];
				k--;
			}
		}
		
	}

}
