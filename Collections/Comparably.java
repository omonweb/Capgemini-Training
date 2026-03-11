package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

	class Comparably implements Comparable<Comparably>{

		private Integer priority;
		private String title;
		private double salary;
		
		Comparably(Integer priority, String title, double salary) {
			this.priority = priority;
			this.title = title;
			this.salary = salary;
		}
		
		@Override
		public int compareTo(Comparably o) {
			
			return o.priority.compareTo(this.priority);
			
		}
		
		@Override
		public String toString() {
			return priority + " , " + title + " , " + salary;
		}
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Comparably> list = new ArrayList<>();
		
		list.add(new Comparably(1,"dev",25000.25));
		list.add(new Comparably(2,"devops",27000.25));
		list.add(new Comparably(4,"data analyst",35000.25));
		
		Collections.sort(list);
		
		/*list.sort((a,b) -> {
			return a.title.compareTo(b.title);
		});*/
		
		for(Comparably job : list) {
			System.out.println(job);
		}
		}
}
