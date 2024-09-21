package mod2;

public class Main {
    public static void main(String[] args) {

        Player bot = new Player();
        Player alex = new Player(VARIANTS.SCISSORS, "Alex");

        System.out.println(bot.whoWins(bot, alex));

        // Примеры для тестов
        System.out.println(bot.getName() + " выбрал: " + bot.getChoice());
        System.out.println(alex.getName() + " выбрал: " + alex.getChoice());
    }
}
