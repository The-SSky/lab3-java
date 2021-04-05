package edu.app;

import edu.AudioLibrary;
import edu.Collectable;
import edu.VideoLibrary;

public class Main {
    public static void main(String[] args) {
        int AL_COUNT = 7;
        int VL_COUNT = 8;

        Collectable[] appLibraries = new Collectable[AL_COUNT + VL_COUNT];
        AppResources.populate(appLibraries, AL_COUNT, VL_COUNT);

        // -1й пункт
        System.out.println("*** Вывести полную информацию обо всех объектах ***");
        AppResources.print(appLibraries);

        // -2й пункт
        System.out.println("*** Найти в массиве объекты, функциональный метод " +
                "которых возвращают одинаковый результат, поместить такие объекты " +
                "в другой массив;   ***");
        appLibraries[appLibraries.length - 2] = appLibraries[appLibraries.length - 1];
        Collectable[] newLibraries = AppResources.createNewCollectionForEqualTotalDurations(appLibraries);
        System.out.println("-----------------");
        AppResources.print(newLibraries);

        // -3й пункт
        System.out.println("*** Разбить исходный массив на два массива, в которых " +
                "будут храниться однотипные элементы ***");
        System.out.println("-----------------");
        VideoLibrary vlSample = new VideoLibrary();
        AudioLibrary alSample = new AudioLibrary();
        Collectable[] videoLibraries = AppResources.createNewCollectionByType(appLibraries, vlSample.getClass());
        Collectable[] audioLibraries = AppResources.createNewCollectionByType(appLibraries, alSample.getClass());
        System.out.println("*** Видео Библиотеки ***");
        System.out.println(videoLibraries.length);
        System.out.println("-----------------");
        AppResources.print(videoLibraries);
        System.out.println("*** Аудио Библиотеки ***");
        System.out.println(audioLibraries.length);
        System.out.println("-----------------");
        AppResources.print(audioLibraries);
    }
}
