package Quiz;

import java.util.Scanner;

public class Quiz3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();

        if (a % 3 == 0 && a % 5 == 0){
            System.out.println("3과5의 배수를 모두 만족합니다");
        } else if (a%3 == 0) {
            System.out.println("3의 배수입니다.");
        } else if (a%5 == 0) {
            System.out.println("5의 배수입니다.");
        }
    }
}
