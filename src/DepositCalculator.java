import java.util.Scanner;

public class DepositCalculator {

    double calculatePercentComplex(double contribution, double year, int depositType) {
        double profit;

        profit = contribution * Math.pow((1 + year / 12), 12 * depositType);
        return roundValue(profit, 2);
    }

    double calculatePercentSimple(double contribution, double yearRate, int depositTime) {
        double profit;

        profit = contribution + contribution * yearRate * depositTime;
        return roundValue(profit, 2);
    }

    double roundValue(double value, int places) {
        double scale;

        scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateProfit() {
        int contributionTime;
        int contributionType;

        Scanner inputUser = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int contributionInput = inputUser.nextInt();
        System.out.println("Введите срок вклада в годах:");
        contributionTime = inputUser.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        contributionType = inputUser.nextInt();

        double profit = 0;

        if (contributionType == 1)
            profit = calculatePercentSimple(contributionInput, 0.06, contributionTime);
        else if (contributionType == 2) {
            profit = calculatePercentComplex(contributionInput, 0.06, contributionTime);
        }
        System.out.println("Результат вклада: "
                + contributionInput + " за " + contributionTime + " лет превратятся в " + profit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateProfit();
    }
}