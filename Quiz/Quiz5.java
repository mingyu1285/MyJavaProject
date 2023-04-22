package Quiz;

public class Quiz5 {
    public static void main(String[] args) {
        for (int i = 2, k= 1; i <= 9 ; k++) {
            System.out.println(i+"X"+k+"="+i*k);
            if (k == 9){
                k=0;
                i++;
                System.out.println();
            }
        }
    }
}
