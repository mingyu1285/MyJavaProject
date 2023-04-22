package Quiz;

import java.util.Scanner;

public class Quiz2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();

            if (a%3==0){
                System.out.println(a+"(은)는 3의 배수입니다.");
            }else {
                System.out.println("3의 배수가 아닙니다.");
            }

    }
}
