package Test;

public class Test3 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            for(int j = 0;j<5;j++)
                System.out.println("test");

            i++;
        }
        while (i < 5)
            if(i<5)
              System.out.println(i);
            else {
                if (i < 1)
                    System.out.println(i);
            }
    }
}