package calculator;

import java.util.Scanner;

public class StringCalculator {
    /*
    사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
    */

    // 외부 입력을 받는 경우에 테스트 코드 작성은 어떻게 ?
    public static final Scanner CONSOLE = new Scanner(System.in);

    public int calculate(String[] input) {
        int result = Integer.parseInt(input[0]);
        String operator;
        for (int i = 1 ; i < input.length ; i++) {
            operator = input[i];
            int next = Integer.parseInt(input[i+1]);
            result = operate(operator, result, next);
        }
        return result;
    }

    public String[] getInputValue(){
        String consoleValue = CONSOLE.nextLine();
        return consoleValue.split(" ");
    }

    public int operate(String operator, int result, int nextvalue) {
        switch (operator) {
            case "+" :
                result = add(result, nextvalue);
                break;
            case "-" :
                result = subtract(result, nextvalue);
                break;
            case "*" :
                result = multiply(result, nextvalue);
                break;
            case "/" :
                if (nextvalue == 0) throw new ArithmeticException();
                result = divide(result, nextvalue);
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자 입니다");
        }
        return result;
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
