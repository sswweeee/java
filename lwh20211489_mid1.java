import java.util.Random; //무작위 숫자를 생성하기 위해 사용
import java.util.Scanner; //사용자 입력을 받기 위해 사용

public class lwh20211489_mid1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //사용자 입력을 받기 위한 Scanner 객체 생성
        Random random = new Random(); //무작위 숫자를 생성하기 위한 Random 객체를 생성
        String[] choices = {"가위", "바위", "보"}; //가위 바위 보 선택지를 배열로 저장
        boolean playAgain = true; // 재시작 여부를 저장하는 변수

        while (playAgain) { // true인 동안 게임 반복
            System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택하세요:");
            int userChoice = scanner.nextInt(); // 사용자가 입력한 숫자를 읽어 userChoice 변수에 저장
            while (userChoice < 0 || userChoice > 2) { //사용자가 0,1,2 외의 숫자를 입력하면 다시 입력 받고록 함
                System.out.println("잘못된 선택입니다. 가위(0), 바위(1), 보(2) 중 하나를 선택하세요:"); 
                userChoice = scanner.nextInt();
            }

            int computerChoice = random.nextInt(3); //0부터 2까지 무작위 숫자를 생성해서 computerChoice 변수에 저장
            System.out.println("사용자 선택: " + choices[userChoice]);
            System.out.println("컴퓨터 선택: " + choices[computerChoice]);

            if (userChoice == computerChoice) {
                System.out.println("비겼습니다.");
            } else {
                switch (userChoice) {
                    case 0: // 사용자가 가위를 선택하고 컴퓨터가 보를 선택하면 사용자가 이김 그렇지 않으면 컴퓨터가 이김
                        System.out.println((computerChoice == 2) ? "당신이 이겼습니다." : "컴퓨터가 이겼습니다.");
                        break;
                    case 1: //사용자가 바위를 선택하고 컴퓨터가 가위를 선택하면 사용자가 이김 그렇지 않으면 컴퓨터가 이김
                        System.out.println((computerChoice == 0) ? "당신이 이겼습니다." : "컴퓨터가 이겼습니다.");
                        break;
                    case 2: //사용자가 보를 선택하고 컴퓨터가 바위를 선택하면 사용자가 이김 그렇지 않으면 컴퓨터가 이김
                        System.out.println((computerChoice == 1) ? "당신이 이겼습니다." : "컴퓨터가 이겼습니다.");
                        break;
                }
            }

            System.out.println("다시 하시겠습니까? (예: 1, 아니오: 0)");
            playAgain = scanner.nextInt() == 1;
        }

        scanner.close();
        System.out.println("게임을 종료합니다.");
    }
}