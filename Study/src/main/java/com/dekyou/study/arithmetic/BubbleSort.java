package com.dekyou.study.arithmetic;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年5月10日
 * 
 */
public class BubbleSort {
	
	/**
	 * 冒泡排序
	 * @param sourceData
	 * @return
	 */
	public int[] sort_self(int[] sourceData, int length) {
		int templ;
		for (int i = 0; i < length - 1; i++) {
			if (sourceData[i] > sourceData[i+1]) {
				templ = sourceData[i];
				sourceData[i] = sourceData[i+1];
				sourceData[i+1] = templ;
			}
		}
		length -=1;
		if (length == 0) {
			return sourceData;
		}
		this.sort_self(sourceData, length);
		
		return sourceData;
	}
	
	
	   @Test
	   public void TestSort(){
	         int a[]={49,38,62,99,98,54,56,15,35,25,53,51}; 
//	         sort(a);
	         
	        int[] a1= this.sort_self(a, a.length);
	        for (int i =0; i < a1.length; i++) {
	        	System.out.print(a1[i]+" ");
	        }
	        
	    }
	    
	    public void sort(int arr[]){  
	        int temp; 
	        int len=arr.length;
	        for(int i=0;i<len-1;i++){  
	            for(int j=0;j<len-1-i;j++){  
	                if(arr[j]>arr[j+1]){  
	                    temp=arr[j];  
	                    arr[j]=arr[j+1];  
	                    arr[j+1]=temp;  
	                }  
	            }  
	        }  
	        for(int i=0;i<len;i++){
	            System.out.println(arr[i]+" ");
	        }
	    }  
}

