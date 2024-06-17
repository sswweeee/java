import java.util.Random;
import java.util.Scanner;

public class lwh20211489_mid2 {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] rpsChoices = {"가위", "바위", "보"};
        String[] mjpChoices = {"묵", "찌", "빠"}; 
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택하세요:");
            int userChoice = scanner.nextInt(); 
            while (userChoice < 0 || userChoice > 2) {
                System.out.println("잘못된 선택입니다. 가위(0), 바위(1), 보(2) 중 하나를 선택하세요:");
                userChoice = scanner.nextInt();
            }

            int computerChoice = random.nextInt(3);
            System.out.println("사용자 선택: " + rpsChoices[userChoice]);
            System.out.println("컴퓨터 선택: " + rpsChoices[computerChoice]);

            boolean userWinsFirstRound = (userChoice == 0 && computerChoice == 2) ||
                                         (userChoice == 1 && computerChoice == 0) ||
                                         (userChoice == 2 && computerChoice == 1);
            boolean isFirstRoundDraw = userChoice == computerChoice;
            boolean isUserTurn = !isFirstRoundDraw && userWinsFirstRound;

            System.out.println(isUserTurn ? "당신이 선공입니다." : "컴퓨터가 선공입니다.");

            boolean gameEnd = false;
            while (!gameEnd) {
                System.out.println("묵(0), 찌(1), 빠(2) 중 하나를 선택하세요:");
                int userMukJjiPpa = scanner.nextInt();
                while (userMukJjiPpa < 0 || userMukJjiPpa > 2) {
                    System.out.println("잘못된 선택입니다. 묵(0), 찌(1), 빠(2) 중 하나를 선택하세요:");
                    userMukJjiPpa = scanner.nextInt();
                }

                int computerMukJjiPpa = random.nextInt(3);
                System.out.println("사용자 선택: " + mjpChoices[userMukJjiPpa]);
                System.out.println("컴퓨터 선택: " + mjpChoices[computerMukJjiPpa]);

                if (userMukJjiPpa == computerMukJjiPpa) {
                    if (isUserTurn) {
                        System.out.println("당신이 최종 승자입니다!");
                    } else {
                        System.out.println("컴퓨터가 최종 승자입니다!");
                    }
                    gameEnd = true;
                } else {
                    isUserTurn = (userMukJjiPpa == 0 && computerMukJjiPpa == 2) ||
                                 (userMukJjiPpa == 1 && computerMukJjiPpa == 0) ||
                                 (userMukJjiPpa == 2 && computerMukJjiPpa == 1);
                    System.out.println(isUserTurn ? "당신의 턴입니다." : "컴퓨터의 턴입니다.");
                }
            }

            System.out.println("다시 하시겠습니까? (예: 1, 아니오: 0)");
            playAgain = scanner.nextInt() == 1;
        }

        scanner.close();
        System.out.println("게임을 종료합니다.");
    }
}
