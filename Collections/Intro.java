package collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Intro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		List<Integer> copyList = new CopyOnWriteArrayList<>();
		
		copyList.add(1);
		copyList.add(2);
		copyList.add(3);
		
		for(Integer it : copyList) {
			if(it.equals(1)) copyList.remove(it);
		}
		System.out.print(copyList);
	}

}
