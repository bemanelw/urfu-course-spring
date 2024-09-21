package mod2;

import java.util.Random;

enum VARIANTS {
    ROCK, PAPER, SCISSORS
}

public class Player {
    private VARIANTS choice;
    private String name;


    public Player() {
        this.name = "Bot";
        this.choice = getRandomVariant();
    }

    // Конструктор, который принимает определенный вариант из перечисления и имя для объекта
    public Player(VARIANTS choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    // Функция для получения случайного варианта из перечисления
    private VARIANTS getRandomVariant() {
        Random random = new Random();
        return VARIANTS.values()[random.nextInt(VARIANTS.values().length)];
    }

    // Функция whoWins, которая принимает два объекта и возвращает либо строку «Ничья», либо информацию про игрока, который победил
    public String whoWins(Player player1, Player player2) {
        if (player1.choice == player2.choice) {
            return "Ничья";
        }

        switch (player1.choice) {
            case ROCK:
                return (player2.choice == VARIANTS.SCISSORS) ? player1.name + " победил" : player2.name + " победил";
            case PAPER:
                return (player2.choice == VARIANTS.ROCK) ? player1.name + " победил" : player2.name + " победил";
            case SCISSORS:
                return (player2.choice == VARIANTS.PAPER) ? player1.name + " победил" : player2.name + " победил";
            default:
                return "Ничья";
        }
    }

    // Геттер для выбора (для отладки)
    public VARIANTS getChoice() {
        return choice;
    }

    // Геттер для имени (для отладки)
    public String getName() {
        return name;
    }
}
