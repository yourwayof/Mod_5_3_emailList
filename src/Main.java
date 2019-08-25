import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static HashSet<String> addCorrectFormat (String str, HashSet<String> hashSet){
        String [] inputLineWords = str.split("\\s+");
        hashSet.add(inputLineWords[1]);
        System.out.println("Добавлен е-мейл адрес: " + inputLineWords[1]);
        System.out.println("Для добавления е-мейла введите 'ADD адрес'. Для вывода списка введенных адресов введите 'LIST'. Для выхода введите 'STOP'.");
        return hashSet;
    }

    public static void printList(HashSet<String> hashSet){
        System.out.println("Ваш список адресов:");
        int index = 1;
        for (String element : hashSet)
        {
            System.out.println(index + ". " + element);
            index++;
        }
        System.out.println("Для добавления е-мейла введите 'ADD адрес'. Для вывода списка введенных адресов введите 'LIST'. Для выхода введите 'STOP'.");

    }

    public static void main(String[] args) {

        String regexAdd = "ADD\\s+.+";
        String regexAddCorrectFormat = "ADD\\s+[A-Za-z0-9]+\\S[A-Za-z0-9]+[@][A-Za-z0-9]+[.][a-zA-Z]{2,5}$";
        String regexList = "LIST$";
        String regexStop = "STOP$";

        System.out.println("ДЗ 5.3");
        System.out.println("Написать программу, в которой будет храниться перечень e-mail-ов. E-mail’ы  можно добавлять через консоль командой ADD и печатать весь список командой LIST.");
        System.out.println("* Проверять корректность вводимых e-mail’ов и в случае необходимости печатать сообщение об ошибке.");

        System.out.println("Для добавления е-мейла введите 'ADD адрес'. Для вывода списка введенных адресов введите 'LIST'. Для выхода введите 'STOP'.");
        HashSet<String> emailList = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true){
            String inputLine = scanner.nextLine();
            inputLine = inputLine.trim();

            if (inputLine.matches(regexAddCorrectFormat)){
                addCorrectFormat(inputLine, emailList);
            }
            else if (inputLine.matches(regexAdd)){
                System.out.println("Допущена ошибка при введении е-мейла. Повторите ввод адреса");
            }
            else if (inputLine.matches(regexList)){
                printList(emailList);
            }
            else if (inputLine.matches(regexStop)){
                break;
            }
            else {
                System.out.println("Ошибка введения команды.");
                System.out.println("Для добавления е-мейла введите 'ADD адрес'. Для вывода списка введенных адресов введите 'LIST'. Для выхода введите 'STOP'.");
            }
        }
    }
}
