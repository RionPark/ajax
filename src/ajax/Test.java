package ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {		
		List<Map<String,Object>> persons = new ArrayList<>();
		Map<String,Object> person = new HashMap<>();
		person.put("name", "김철수");
		person.put("age", 22);
		persons.add(person);
		person = new HashMap<>();
		person.put("name", "이순희");
		person.put("age", 33);
		persons.add(person);
		System.out.println(persons);
	}
}
