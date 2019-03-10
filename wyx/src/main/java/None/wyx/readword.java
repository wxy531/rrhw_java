package None.wyx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;






public class readword {
	static HashSet<String>words=new HashSet<>();
	/*name:makeset(String args)
	 * argument for:the dict path
	 * purpose:open a file to make a wordslist
	 */
	public static void makeset(String args) {	
        File file = new File(args); 

          
            try {  
                FileReader fileReader = new FileReader(file);  
                BufferedReader br = new BufferedReader(fileReader);  
                String lineContent = null;  
                while((lineContent = br.readLine())!=null){
                    words.add(lineContent);
                }  
                br.close();  
                fileReader.close();    
            } catch (FileNotFoundException e) {  
                System.out.println("no this file");  
                e.printStackTrace();  
            } catch (IOException e) {  
                System.out.println("io exception");  
                e.printStackTrace();  
            }  
        }

	
	
	
	/*name:changeword
	 * argument:stringbuilder beginword to string endword
	 * purpose:change bw every charactor to match dic , eventually matching ew
	 * especially annotation:String can not be changed, so i use StringBuilder
	 * */
	public static Integer changeword(StringBuilder bw,String ew) {
		if(bw.length()==ew.length()) {
		Pair<StringBuilder,Integer>pair=new Pair<StringBuilder, Integer>(bw, 1);//new one pair//
		Queue<Pair<StringBuilder,Integer>>queue= new LinkedList<Pair<StringBuilder,Integer>>();
		queue.add(pair);
		words.remove(bw.toString());//remove the begin word from dictionary escape loop //
		
		while(!queue.isEmpty()) {/*bfs*/
			Pair<StringBuilder, Integer> temp=queue.peek();
			StringBuilder tempStr=new StringBuilder(temp.getFirst());
		    //output//
			if(temp.getFirst().toString().equals(ew)) {
			output(temp,ew);
			return temp.getSecond();
			}
			//change word//
			tranword(temp,tempStr,queue);
			queue.poll();
			
		}
		}
		else {
			System.out.println("the word size should be same");
			return null;
		}
		System.out.println("not  wordladder!");
		return null;
	}
	
	
	/*name:output
	 * argument:pair<StringBuilder,integer>
	 * purpose:out put the result
	 * */
	public static void output(Pair<StringBuilder,Integer>result,String ew) {
			System.out.println(result.getFirst()+" "+result.getSecond());
			while(!(result.father==null)) {
				result=result.father;
			System.out.println(result.getFirst()+" "+result.getSecond());
			}
	}
	
	
	/*name:transfer word
	 * argument:pair<StringBuilder,Integer>,queue,StringBuilder
	 * purpose:tansformation worf
	 * */
	public static void tranword(Pair<StringBuilder,Integer>temp,StringBuilder 
			tempStr,Queue<Pair<StringBuilder,Integer>> queue) {
		
		for(int i=0;i<tempStr.length();i++) {
			tempStr=new StringBuilder(temp.getFirst());
			for(int j=0;j<26;j++) {
				char c=(char)(97+j);
			tempStr.setCharAt(i, c);
		//word match dic,throw in queue and delete in dic//
			if(words.contains(tempStr.toString())) {
				
				StringBuilder newword=new StringBuilder(tempStr);
				Pair<StringBuilder,Integer>newpair=new Pair<StringBuilder, Integer>(newword,temp.getSecond()+1 );
				newpair.setfather(temp);
				queue.add(newpair);
				words.remove(tempStr.toString());
			}
			}
		}
	}
	
	
	/*name:main
	 * argument:none
	 * purpose:main function
	 * 
	 * */
	public static void main(String[] args) {
	String path="src\\main\\java\\None\\wyx\\dictionary.txt";
	makeset(path);
	 Scanner sc = new Scanner(System.in); 
     System.out.println("input beginword"); 
     String bw = sc.next();
     while(isNumEric(bw)) {
         System.out.println("input beginword  no number"); 
         bw = sc.next();
     }
     System.out.println("input endword"); 
     String ew = sc.next(); 
     while(isNumEric(ew)) {
     System.out.println("input endword not number"); 
     ew = sc.next(); }
	StringBuilder beginword=new StringBuilder(bw);
	changeword(beginword,ew);
}


/*
 * input correct,no number
 * */

	private static boolean isNumEric(String b) {
		// TODO Auto-generated method stub

		  for (int i = b.length(); --i >= 0;) {   
		   if (!Character.isDigit(b.charAt(i))) {
		    return false;
		   }
		  }
		   return true;

	}

}




