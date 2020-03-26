public class PhraseOMatic {
    public static void main(String[] args) {
        String[] wordListOne = {
                "круглосуточный" , "трех-звенный" , "30000-футовый" , "взаимный" , "обоюдный выигрыш" , "фронтэнд" , "на основе веб-технологий", "проникающий", "умный" , "шесть сигм" , "метод критического пути" , "динамичный"
        };
        String[] wordListTwo = {
                "уполномоченный" , "трудный", "чистый продукт"
        };
        String[] wordListThree = {
                "процесс" , "пункт разгузки" , "выход из положения"
        };
        //вычисляем сколько слов в каждом списке
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        //генерируем три случайных числа
        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        //теперь строим фразу
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
        // выводим фразу на экран
        System.out.println("Все, что нам нужно - это " + phrase);
     }
}
