package Test;
import java.io.FileWriter;
public class genCodeTest1{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int x=1;
        int y=2;
        if (x>0) {
			System.out.println("1\n");
			fileWriter.append("1\n");

            if (x == 2){
                
			System.out.println("2\n");
			fileWriter.append("2\n");
			System.out.println("IF Block");
		}
        }
        else
                if (y==2){
                    
			System.out.println("4\n");
			fileWriter.append("4\n");
			System.out.println("IF Block");
		}
        switch(x) {
            case 5:
			System.out.println("5\n");
			fileWriter.append("5\n");

                System.out.println("This is a 5");
                break;
            case 1:
			System.out.println("6\n");
			fileWriter.append("6\n");

                System.out.println("This is a 10");
                break;
        }
        for(int i = 0 ; i<5;i++) {
			System.out.println("7\n");
			fileWriter.append("7\n");

            for (int j = 0; j < 5; j++){
                
			System.out.println("8\n");
			fileWriter.append("8\n");
if (x > 0){
                    
			System.out.println("9\n");
			fileWriter.append("9\n");
System.out.println("If operations");
		}
                else {
			System.out.println("10\n");
			fileWriter.append("10\n");

                    System.out.println("Else block");
                }
		break;
		}
        
		break;}
        int z = 0;
        while (z < 5) {
			System.out.println("11\n");
			fileWriter.append("11\n");

            if(y==5){
                
			System.out.println("12\n");
			fileWriter.append("12\n");
System.out.println("While loop");
		}
            z++;
        
		break;}
    	fileWriter.close();
	}
}