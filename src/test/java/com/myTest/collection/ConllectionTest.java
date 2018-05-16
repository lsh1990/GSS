package com.myTest.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 集和测试
 * @author-lsh
 * @date 2018年5月15日 下午12:18:52
 */
public class ConllectionTest {
	
	public static void main(String[] args) {
		
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		//首先插入100000条数据
		  for(int i=0;i<300000;i++){    
			  arrayList.add(i);    
			  linkedList.add(i);    
	        } 
	      //获得两者随机访问的时间  
	      System.out.println("array time:" + getTime(arrayList));    
	      System.out.println("linked time:" + getTime(linkedList)); 
	      //获取两者的插入时间
		  System.out.println("arrayList insert time:" + insertTime(arrayList));
		  System.out.println("linkedList insert time:" + insertTime(linkedList));
		
	}
	
	/**
	 * @Description: 插入数据时间
	 * @param list
	 * @return 
	 */
	public static long insertTime(List<Integer> list) {
	    /* 
         * 插入的数据量和插入的位置是决定两者性能的主要方面， 
         * 我们可以通过修改这两个数据，来测试两者的性能 
         */  
		long num = 10000; //表示要插入的数据量  
	    int index = 30; //表示从哪个位置插入 
		long lastTime = System.currentTimeMillis();
		for (int i = 0; i < num; i++) {
			list.add(index, i);
		}
		return System.currentTimeMillis() - lastTime;
	}
	
	/**
	 * @Description: 查询数据时间
	 * @param list
	 * @return 
	 */
	public static long getTime(List<Integer> list) {
		long time = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			//使用二分搜索法搜索指定列表，以获得指定对象。在进行此调用之前，必须根据列表元素的自然顺序对列表进行升序排序
			int index = Collections.binarySearch(list, list.get(i));
			if(index != i){    
				System.out.println("ERROR!");    
			}  
		}
		return System.currentTimeMillis() - time;
		
	}
	
	
	
}
