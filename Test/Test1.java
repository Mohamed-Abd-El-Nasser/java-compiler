package Test;

public class Test1 {
    public static void main(String[] args) {
        int x=1;
        if (x>=0)
            System.out.println("If Block");
        if (x==1) {
            System.out.println("If Block");
        }
        else {
            if (x>=0)
                System.out.println("If Block");
            System.out.println("ELSE Block");
        }
    }
}