import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static int getInputInt(){
        int inputInt;
        Logger logger = Logger.getInstance();
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                String arrSizeStr = scanner.nextLine();
                inputInt = Integer.parseInt(arrSizeStr);
                break;
            }
            catch (NumberFormatException e){
                logger.log("Неверный формат числа");
            }
        }
        return inputInt;
    }
    public static void main(String[] args) {
        int arrSize, arrTopValue, arrThreshold;
        ArrayList<Integer> arr;

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        arrSize = getInputInt();
        System.out.print("Введите верхнюю границу для значений: ");
        arrTopValue = getInputInt();
        logger.log("Создаём и наполняем список");
        arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < arrSize; i++) {
            arr.add(random.nextInt(arrTopValue));
        }
        System.out.print("Вот случайный список: ");
        System.out.println(arr.stream().map(Object::toString).collect(Collectors.joining(", ")));
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");
        arrThreshold = getInputInt();
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(arrThreshold);
        List<Integer> filteredArr = filter.filterOut(arr);
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        System.out.println(filteredArr.stream().map(Object::toString).collect(Collectors.joining(", ")));
        logger.log("Завершаем программу");
    }
}