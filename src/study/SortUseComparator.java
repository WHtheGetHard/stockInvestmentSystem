package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUseComparator {
	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		Person person1 = new Person(); person1.setName("Tanaka"); person1.setAge(50);
		Person person2 = new Person(); person2.setName("Nakagawa"); person2.setAge(20);
		Person person3 = new Person(); person3.setName("Akai"); person3.setAge(100);
		Person person4 = new Person(); person4.setName("Takeda"); person4.setAge(1);
		personList.add(person1); personList.add(person2); personList.add(person3); personList.add(person4);

		System.out.println("-----------------元の並び-----------------");
		for (int i = 0; i < personList.size(); i++) {
			System.out.println("名前 : " + personList.get(i).getName() + " : 年齢　: " + personList.get(i).getAge());
		}

		CompPersonsAge compPersonsAge = new CompPersonsAge();
		Collections.sort(personList, compPersonsAge);

		System.out.println("-----------------ソート後の並び-----------------");
		for (int i = 0; i < personList.size(); i++) {
			System.out.println("名前 : " + personList.get(i).getName() + " : 年齢　: " + personList.get(i).getAge());
		}

	}
}

class Person {
	private String name;

	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
}

//　自作クラスの比較結果を返すクラスを定義
class CompPersonsAge implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}
}