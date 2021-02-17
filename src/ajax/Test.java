package ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {		
		String[] arr = new String[3];
		arr[0] = "고양이";
		arr[1] = "강아지";
		arr[2] = "고슴도치";
		arr[3] = "우하하하";
		
		for(String str:arr) {
			System.out.println(str);
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
