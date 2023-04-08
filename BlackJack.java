package MyProject;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random random = new Random();
        int Mycard[] = new int[10];
        int Aicard[] = new int[2];
        int MycardHap = 0;
        //04.08


        System.out.println("게임을 시작하겠습니까? y/n");
        String answer = s.nextLine();
        switch (answer){
            case "y" :
                System.out.println("게임을 시작하겠습니다.");

                //ai카드 받기
                for (int i = 0; i < 2; i++) {
                    Aicard[i] = random.nextInt(13)+1;
                }
                //ai카드 랜덤으로 출력되는지 확인
//                System.out.println(Arrays.toString(Aicard));

                //내가 카드 받기
                for (int i = 0; i < 2; i++) {
                    Mycard[i] = random.nextInt(13)+1;

                }
                System.out.println("카드 부여중..");
                System.out.println(Arrays.toString(Mycard)); //내가 받은 카드 출력

                MycardHap = Mycard[0]+Mycard[1]; // 첫 번째 카드와 두 번째 카드의 합을 합 변수의 저장

                for (int i = 2; i < Mycard.length; i++) {
                    if(MycardHap< 22){ //내가 받은 카드의 합이 22이하일 때 카드를 더 받을건지 물어봄
                        System.out.println("카드를 더 받으시겠습니까? y/n");
                        answer = s.nextLine();
                        switch (answer){
                            case "y":
                                Mycard[i] = random.nextInt(13)+1;
                                MycardHap = MycardHap+Mycard[i];
                                System.out.println(Arrays.toString(Mycard)); // 내 카드 출력

                            case "n":

                                //04.07

                        }

                    }

                }








































            case "n" :
                System.out.printf("게임을 종료하겠습니다");
                break;
        }






    }
}
