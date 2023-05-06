import java.util.Scanner;  //импортировали сканнер
class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputNoTrim = scanner.nextLine(); //скан строки
        String input = inputNoTrim.trim(); //удаление пробелов по краям у сканированной строки
        checkInput(input);
        System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {
        int a;
        int b;
        String znak;
        String result;
        String[] operands = input.split("[+\\-*/]"); //создаём массив чисел, взяв строку input и поделив её знаками (+,-,*,/)
        if (operands.length != 2) throw new Exception("throws Exception"); // если длина массива не равна двум, то выдаём исключение
        znak = poiskZnaka(input); // возвоащаем знак, полученный из метода poiskZnaka
        if (znak == null) throw new Exception("throws Exception"); //если знак не +-*/, то выдаём исключение
        a = Integer.parseInt(operands[0]);  // берём String из массива под индексом 0 и переводим в Integer
        b = Integer.parseInt(operands[1]);
        if (!(a >= 1 && a <= 10 && b >= 1 && b <= 10)) throw new Exception("throws Exception"); //  если числа меньше 1 или больше 10, выдаём исключение
        int resultInt = calcInt(a, b, znak); // возвращаем интовый результат вычисления из метода calcInt
        result = String.valueOf(resultInt); //преобразовали результат в String
        return result;
    }

    static void checkInput(String input) throws Exception {
        if (!input.matches("^\\d+\\s*[+\\-*/]\\s*\\d+$")) {
            throw new Exception("throws Exception");
        }
    }
    static String poiskZnaka(String input){
        if (input.contains("+")) return "+"; // если в строке input содержится знак +, то возвращаем плюс
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }
    static int calcInt(int a, int b, String znak) {
        return switch (znak) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
