package com.dekyou.study.arraylist.array;

/**
 * @author GaoJing
 * @date 2018年4月10日
 * 
 */
public class VariableArray {
	
	private static final String prefix = "[";
	
	private static final String postfix = "]";
	
	private static final String comma = ",";
	
	private static String[] array_1;
	
	private static int length;
	
	private static int capacity;
	
	public VariableArray() {
		 array_1 = new String[10];
		 length = 0;
		 capacity = 10;
	}
	
	
	public int getCapacity() {
		return capacity;
	}
	public int getLength() {
		return length;
	}
	
	/**
	 * 添加元素
	 * @param arg
	 */
	public void add(String arg) {
		
		this.checkCapacity();
		
		array_1[length] = arg;
		
		length ++;
	}
	
	/**
	 * 删除元素
	 * @param i
	 */
	public void del(int i) {
		array_1[i] = null;
	}
	
	/**
	 * 获取元素
	 * @param i
	 * @return
	 */
	public String get(int i) {
		return array_1[i];
	}
	
	/**
	 * 修改元素
	 * @param i
	 * @param arg
	 */
	public void modefy(int i, String arg) {
		array_1[i] = arg; 
	}
	
	/**
	 * 指定序号添加元素
	 * @throws Exception 
	 */
	public void add(int i, String arg){
		this.checkCapacity();
		
		if (i < 0) {
			throw new IllegalArgumentException("添加需要不能小于0");
		}
		
		if (i >= capacity - 1) {
			int j = i%10;
			j = 10 -j;
			int newCapacity = i +j;
			this.addCapacity(newCapacity);
			array_1[i] = arg;
			length = i + 1;
		}
		
		if (array_1[i] != null) {
			
			String[] array_new = new String[capacity];
			for (int j = 0; j < length; j++) {
				
				if (i == j) {
					array_new[j] = arg;
				}else if (i < j) {
					array_new[j+1] = array_1[j];
				}else {
					array_new[j] = array_1[j];
				}
				
			}
			
		}else {
			array_1[i] = arg;
		}
		
		
	}
	
	/**
	 * 检查容量
	 */
	private void checkCapacity() {
		if (length == capacity-1) {
			this.addCapacity();
		}
	}
	/**
	 * 添加数组容量
	 */
	private void addCapacity() {
		capacity += 10;
		String[] array_add = new String[capacity];
//		 System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
		System.arraycopy(array_1, 0, array_add, 0, array_1.length);
		
//		System.out.println("new String array is:" + array_add);
		
		array_1 = array_add;
		
//		System.out.println("new array_1 array is:" + array_1);
	}
	
	
	private void addCapacity(int i) {
		
		capacity = i;
		
		String[] array_add = new String[i];
		
		System.arraycopy(array_1, 0, array_add, 0, array_1.length);
		
//		System.out.println("new String array is:" + array_add);
		
		array_1 = array_add;
		
//		System.out.println("new array_1 array is:" + array_1.length);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		for (int i = 0; i < length; i ++) {
			if (i == length-1) {
				sb.append(array_1[i]);
			}else {
				sb.append(array_1[i]).append(comma);
			}
			
		}
		sb.append(postfix);
		return sb.toString();
	}
	
	
}

