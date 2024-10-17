import java.util.Scanner;

public class Calc_Lv1 {
    public static void main(String[] args) {

        // 변수 선언 및 초기화
        long save_num1 = 0;
        long save_num2 = 0;
        char operator;
        long total = 0L;
        boolean exit = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("계산기를 시작합니다. exit 입력전까지 무한 계산기루프가 돌게됩니다.");

        OutLoop:
        while (exit) {

            // 첫번째 정수 입력받기 : 숫자가 아닐 경우 다시 입력받기
            System.out.println("계산할 첫번째 정수를 입력해주세요.");
            boolean num1_tf = true;
            while (num1_tf) {
                if (sc.hasNextLong()) {
                    save_num1 = sc.nextLong();
                    num1_tf = false;
                } else if (sc.next().equals("exit")) {
                    System.out.println("종료합니다");
                    num1_tf = false;
                    System.out.println(num1_tf);
                    exit = false;
                    break OutLoop;
                } else {
                    System.out.println("숫자가 아닙니다. 다시 입력해주세요");
                }
            }


            // 두번째 사칙 연산 입력받기 : char 타입이 아닐경우 -> 다시 입력
            System.out.println("계산할 사칙 연산을 입력해주세요 ex) +, -, *, /");
            boolean op_true = false;
            char op_input = '+';
            while (!op_true) {
                String s = sc.next();
                op_input = s.charAt(0); // next()로 char일 경우 입력받음
                if (s.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    op_true = true;
                    exit = true;
                    break OutLoop;
                } else if (op_input == '+' || op_input == '-' || op_input == '*' || op_input == '/') {
                    op_true = true;
                    break;
                } else {
                    System.out.println("잘못입력되었습니다. 사칙연산을 다시 입력해주세요. ex) +, -, *, / ");
                }
            }
            operator = op_input;


            // 두번재 값 입력받기 : 숫자가 아니면 다시 입력받기
            System.out.println("계산할 두번째 정수를 입력해주세요.");
            while (!sc.hasNextLong()) {
                if (sc.next().equals("exit")) {  //
                    System.out.println("종료합니다");
                    exit = true;
                    break OutLoop;
                } else {
                    System.out.println("숫자가 아닙니다. 다시 입력해주세요");
                }
            }
            save_num2 = sc.nextLong();

            // 연산
            switch (operator) {
                case '+':
                    total = save_num1 + save_num2;
                    System.out.println("계산된 값은  " + save_num1 + operator + save_num2 + " = " + total);
                    break;
                case '-':
                    total = save_num1 - save_num2;
                    System.out.println("계산된 값은  " + save_num1 + operator + save_num2 + " = " + total);
                    break;
                case '*':
                    total = save_num1 * save_num2;
                    System.out.println("계산된 값은  " + save_num1 + operator + save_num2 + " = " + total);
                    break;
                case '/':
                    total = save_num1 / save_num2;
                    long remain = save_num1 % save_num2;
                    System.out.println("계산된 값은  " + save_num1 + operator + save_num2 + " = " + total + " 나머지는 : " + remain);
                    break;
            }
        }
        sc.close();
        System.out.println("while 종료 ! ");
    }

}
