import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию и введите ее номер: ");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогооблажения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStrEarn = scanner.nextLine();
                    int money = Integer.parseInt(moneyStrEarn);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStrSpend = scanner.nextLine();
                    int moneySpend = Integer.parseInt(moneyStrSpend);
                    spendings += moneySpend;
                    break;
                case 3:
                    int tax1 = taxEarnings(earnings);
                    int tax2 = taxEarningsMinusSpendings(earnings, spendings);
                    if (tax2 > tax1){
                    System.out.println("Мы советуем вам УСН доходы");
                    System.out.println("Ваш налог составит: " + tax1 + "рублей");
                    System.out.println("Налог на другой системе: " + tax2 + "рублей");
                    System.out.println("Экономия: " + (tax2 - tax1) + "рублей");
                } else if (tax2 < tax1) {
                    System.out.println("Мы советуем вам УСН доходы минус расходы");
                    System.out.println("Ваш налог составит: " + tax2 + "рублей");
                    System.out.println("Налог на другой системе: " + tax1 + "рублей");
                    System.out.println("Экономия: " + (tax1 - tax2) + "рублей");
                } else {
                    System.out.println("Вы можете выбрать любую систему налогооблажения");
                    System.out.println("Ваш налог составит: " + tax2 + "рублей");
                }
                break;
                default:
                    System.out.println("Такой операции нет");
                    break;
            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int taxEarn = earnings * 6 / 100;
        return taxEarn;
    }
}
