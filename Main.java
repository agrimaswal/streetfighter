import java.util.Scanner;

class StreetFighter {
    private static final int MAX_HEALTH = 100;

    private String player1;
    private String player2;
    private int player1Health;
    private int player2Health;

    public StreetFighter(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Health = MAX_HEALTH;
        this.player2Health = MAX_HEALTH;
    }

    public void startGame() {
        System.out.println("Street Fighter - " + player1 + " vs " + player2);
        System.out.println("Fight!");

        while (player1Health > 0 && player2Health > 0) {
            System.out.println("\n" + player1 + "'s turn");
            attack(player1, player2);
            if (player2Health <= 0)
                break;

            System.out.println("\n" + player2 + "'s turn");
            attack(player2, player1);
        }

        System.out.println("\nGame Over!");
        if (player1Health > player2Health) {
            System.out.println(player1 + " wins!");
        } else if (player2Health > player1Health) {
            System.out.println(player2 + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void attack(String attacker, String defender) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your move: (1) Punch, (2) Kick, (3) Special Attack");
        int move = scanner.nextInt();

        int damage = 0;
        switch (move) {
            case 1:
                damage = 10;
                break;
            case 2:
                damage = 15;
                break;
            case 3:
                damage = 25;
                break;
            default:
                System.out.println("Invalid move! You missed your turn.");
        }

        System.out.println(attacker + " attacked with a move of " + move + " and caused " + damage + " damage.");
        applyDamage(defender, damage);
    }

    private void applyDamage(String player, int damage) {
        if (player.equals(player1)) {
            player2Health -= damage;
            System.out.println(player2 + "'s health: " + player2Health);
        } else {
            player1Health -= damage;
            System.out.println(player1 + "'s health: " + player1Health);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player 1 name: ");
        String player1 = scanner.nextLine();

        System.out.print("Enter Player 2 name: ");
        String player2 = scanner.nextLine();

        StreetFighter game = new StreetFighter(player1, player2);
        game.startGame();
    }
}
