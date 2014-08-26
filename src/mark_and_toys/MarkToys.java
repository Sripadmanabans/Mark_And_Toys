package mark_and_toys;

import java.util.Scanner;

public class MarkToys 
{
	public static void swap(int ar[], int i, int j) 
	{
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	public static int partition(int ar[], int left, int right)
	{
		int pivotValue = ar[left];
		int pivotIndex = left;
		swap(ar, pivotIndex, right);
		int index = left;
		for(int i = left; i < right; i++)
		{
			if(ar[i] < pivotValue)
			{
				swap(ar, index, i);
				index++;
			}
		}
		swap(ar, index, right);
		return index;
	}
	
	public static void sort(int ar[], int l, int u) 
	{
		if(l < u)
		{
			int pivot = partition(ar, l, u);
			sort(ar, l, pivot - 1);
			sort(ar, pivot + 1, u);
		}
	}
	
	public static void maxToys(int ar[], int k) 
	{
		int count = 0;
		if(ar[0] > k)
		{
			System.out.println(count);
		}
		else
		{
			int total = ar[0];
			int i = 1;
			count++;
			while(total <= k && i < ar.length)
			{
				total += ar[i];
				if(total <= k)
				{
					count++;
				}
				i++;
			}
			System.out.println(count);
		}
		
	}
	
	public static void main(String args[]) 
	{
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int k = sr.nextInt();
		
		int ar[] = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			ar[i] = sr.nextInt();
		}
		
		sort(ar, 0, ar.length - 1);
		
		maxToys(ar, k);
		
		sr.close();
	}
}
