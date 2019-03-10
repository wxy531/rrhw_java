package None.wyx;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.BeforeClass;

public class Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@org.junit.Test
	public void testMakeset() {
		readword.makeset("src\\\\main\\\\java\\\\None\\\\wyx\\\\dictionary.txt");
		readword.makeset("C:\\diinary.txt");
	}

	@org.junit.Test
	public void testChangeword() {
		StringBuilder t1=new StringBuilder("quiet");
		StringBuilder t2=new StringBuilder("pencil");
		StringBuilder t3=new StringBuilder("hit");
		readword.changeword(t1, "face");
		readword.changeword(t2, "banana");
		readword.changeword(t3, "dog");
	}

	@org.junit.Test(timeout = 1000)
	public void testOutput() {
		StringBuilder t1=new StringBuilder("outputtest1");
		StringBuilder t2=new StringBuilder("outputtest2");
		StringBuilder t3=new StringBuilder("outputtest3");
		Pair<StringBuilder,Integer>pair1=new Pair<StringBuilder, Integer>(t1, 1);
		Pair<StringBuilder,Integer>pair2=new Pair<StringBuilder, Integer>(t2, 2);
		Pair<StringBuilder,Integer>pair3=new Pair<StringBuilder, Integer>(t3, 3);
		pair2.setfather(pair3);
		readword.output(pair1,"outputtest2");
		readword.output(pair2,"outputtest2");
		pair3.setfather(pair1);
		readword.output(pair3,"outputtest3");
	}

	@org.junit.Test(timeout = 1000)
	public void testTranword() {
		StringBuilder t1=new StringBuilder("bug");
		
		Pair<StringBuilder,Integer>newpair=new Pair<StringBuilder, Integer>(t1,1 );
		Queue<Pair<StringBuilder,Integer>>queue= new LinkedList<Pair<StringBuilder,Integer>>();
		readword.tranword(newpair, t1, queue);}
		

	@org.junit.Test
	public void testMain() {
		
	}

}
