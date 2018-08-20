package com.basis.myTest.collection;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		
//		TreeSet<Dog> treeSet = new TreeSet<>();
//		
//		treeSet.add(new Dog(8));
//		treeSet.add(new Dog(5));
//		treeSet.add(new Dog(1));
//		
//		Iterator<Dog> iterator = treeSet.iterator();
//		while (iterator.hasNext()) {
//			Dog dog = (Dog) iterator.next();
//			System.out.println(dog);
//		}
		
//		TreeSet<Integer> tree = new TreeSet<>();
//		tree.add(2);
//		tree.add(3);
//		tree.add(9);
//		tree.add(8);
//		
//		Iterator<Integer> iterator = tree.iterator();
//		while (iterator.hasNext()) {
//			 Integer next = iterator.next();
//			 System.out.println(next);
//			
//		}
		
//		HashSet<Dog> dset = new HashSet<Dog>();
//		dset.add(new Dog(2));
//		dset.add(new Dog(1));
//		dset.add(new Dog(3));
//		dset.add(new Dog(5));
//		dset.add(new Dog(4));
//		Iterator<Dog> iterator = dset.iterator();
//		while (iterator.hasNext()) {
//		   System.out.println(iterator.next() + " ");
//		}

		LinkedHashSet<Dog> dset = new LinkedHashSet<Dog>();
		dset.add(new Dog(2));
		dset.add(new Dog(1));
		dset.add(new Dog(3));
		dset.add(new Dog(5));
		dset.add(new Dog(4));
		Iterator<Dog> iterator = dset.iterator();
		while (iterator.hasNext()) {
		    System.out.println(iterator.next() + " ");
		}

	}

}
