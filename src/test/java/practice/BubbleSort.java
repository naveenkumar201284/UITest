package practice;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,21,98,9,3,88,8,5};
		int temp=0;
		int n=a.length;
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				
				if(a[j]>a[j+1]) {
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}			
			}
		}
		
		System.out.println("after sort");
		for(int k=0;k<a.length;k++) {
			System.out.print(a[k]+ " ");
			
		}

	}

}


