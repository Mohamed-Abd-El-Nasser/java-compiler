package Test;
import java.io.FileWriter;
public class genCodeTest1{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int x=1;
        if (x>=0){
            
			System.out.println("IF Block number: 1 at line number 5\n");
			fileWriter.append("IF Block number: 1 at line number 5\n");
if(x==2){
            
			System.out.println("IF Block number: 2 at line number 6\n");
			fileWriter.append("IF Block number: 2 at line number 6\n");
System.out.println("If Block");
		}
		}
        if (x==1) {
			System.out.println("IF Block number: 3 at line number 8\n");
			fileWriter.append("IF Block number: 3 at line number 8\n");

            System.out.println("If Block");
        }
        else {
			System.out.println("ELSE Block number: 1 at line number 11\n");
			fileWriter.append("ELSE Block number: 1 at line number 11\n");

            if (x>=0){
                
			System.out.println("IF Block number: 4 at line number 12\n");
			fileWriter.append("IF Block number: 4 at line number 12\n");
System.out.println("If Block");
		}
            System.out.println("ELSE Block");
        }
    	fileWriter.close();
	}
}