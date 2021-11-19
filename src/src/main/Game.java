package src.main;

import src.main.player.Player;

public class Game {
	Player player1;
	Player player2;

	public Game() {
		player1 = new Player("A");
		player2 = new Player("B");
	}

	public void playGame() throws InterruptedException {
		Player playerwin = null;
		imprimirPuntajes();
		do {

			double n = (Math.random());
			if (n > 0.5) {
				player1.setPoints(player1.getPoints() + 1);
			} else {
				player2.setPoints(player2.getPoints() + 1);
			}

			validateTie();
			validateAdvantage();
			imprimirPuntajes();
			playerwin = validateWin();
			Thread.sleep(3000);
		} while (playerwin == null);
	}

	public void imprimirPuntajes() {
		String message = validateTie();
		if (!message.isEmpty()) {
			System.out.println(player1.getName() + ":" + player1.getPoints() + " ********* " + player2.getName() + ":"
					+ player2.getPoints() + " ***Resultado*** " + message);
		}
		message = validateAdvantage();
		if (!message.isEmpty()) {
			System.out.println(player1.getName() + ":" + player1.getPoints() + " ********* " + player2.getName() + ":"
					+ player2.getPoints() + " ***Resultado*** " + message);
		}
		Player win = validateWin();
		if (win != null) {
			System.out.println(player1.getName() + ":" + player1.getPoints() + " ********* " + player2.getName() + ":"
					+ player2.getPoints() + " ***Resultado*** Player " + win.getName() + " wins");
		} else {
			System.out.println(player1.getName() + ":" + player1.getPoints() + " ********* " + player2.getName() + ":"
					+ player2.getPoints());
		}

	}

	private String validateAdvantage() {
		String message = "";
		if ((player2.getPoints() >= 3 && player1.getPoints() >= 3)
				&& (player1.getPoints() - player2.getPoints()) == 1) {
			System.out.println("Advantage player 1");
			message = "Advantage player 2";
		}

		if ((player2.getPoints() >= 3 && player1.getPoints() >= 3)
				&& (player2.getPoints() - player1.getPoints()) == 1) {
			System.out.println("Advantage player 2");
			message = "Advantage player 2";
		}
		return message;
	}

	private String validateTie() {
		String message = "";
		if ((player2.getPoints() >= 3 || player1.getPoints() >= 3) && (player1.getPoints() == player2.getPoints())) {
			System.out.println("Deuce");
			message = "Deuce";
		}
		return message;
	}

	private Player validateWin() {

		if (player1.getPoints() >= 3 && (player1.getPoints() - player2.getPoints()) >= 2) {

			return player1;
		}
		if (player2.getPoints() >= 3 && (player2.getPoints() - player1.getPoints()) >= 2) {

			return player2;
		}

		return null;
	}

}
