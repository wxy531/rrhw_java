package None.wyx;


import java.util.HashSet;

import org.junit.Test;

import junit.framework.TestCase;

public class readwordTest extends TestCase {
	static HashSet<String>words=new HashSet<>();
	@Test
	public void testMakeset() {
		readword.makeset("src\\\\main\\\\java\\\\None\\\\wyx\\\\dictionary.txt");
		readword.makeset("dictinary.txt");
		
		
	}
	@Test
	public void testMain() {

	
		
	}
	@Test
	public void testChangeword() {
		StringBuilder t1=new StringBuilder("quiet");
		StringBuilder t2=new StringBuilder("pencil");
		StringBuilder t3=new StringBuilder("hit");
		readword.changeword(t1, "face");
		readword.changeword(t2, "banana");
		readword.changeword(t3, "dog");
		
	}

}
