package edu;

import edu.exceptions.IllegalIndexException;
import edu.exceptions.MediaIndexOutOfRangeException;

import java.util.Arrays;

public abstract class MediaLibrary implements Collectable {

    private String title;
    private int price; //numOfAbstractPages
    private String[] collection; //articles
    private int[] durations; //numsOfPages

    public MediaLibrary() {
        title = Defaults.TITLE;
        price = Defaults.PRICE;
        collection = new String[Defaults.COUNT];
        durations = new int[collection.length];
    }

    public MediaLibrary(String title, int price, int count) {
        this.title = title;
        this.price = price;
        collection = new String[count];
        durations = new int[collection.length];
    }

    // region get
    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getItemsCount() {
        return collection.length;
    }

    public String getItem(int index) {
        if (index < 0 || index >= collection.length) {
            throw new MediaIndexOutOfRangeException("Index out of range");
        }

        return collection[index];
    }

    public int getDuration(int index) {
        if (index < 0 || index >= durations.length) {
            throw new MediaIndexOutOfRangeException("Index out of range");
        }
        return durations[index];
    }
    // endregion

    // region set
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int num) {
        if (num < Seriesable.MIN_NUM_OF_START_PAGES) {
            throw new IllegalArgumentException("неверное число страниц");
        }
        if (num > Seriesable.MAX_NUM_OF_START_PAGES) {
            throw new IllegalArgumentException("слишком большое число страниц");
        }

        price = num;
    }

    public void setItem(int index, String title) {
        if (index < 0 || index >= collection.length) {
            throw new IllegalIndexException("неверный индекс");
        }

        collection[index] = title;
    }

    public void setDuration(int index, int num) {
        if (index < 0 || index >= collection.length) {
            throw new IllegalIndexException("неверный индекс");
        }
        if (num < Seriesable.MIN_NUM_OF_PAGES_OF_EL) {
            throw new IllegalArgumentException("неверное число страниц");
        }
        if (num > Seriesable.MAX_NUM_OF_PAGES_OF_EL) {
            throw new IllegalArgumentException("слишком большое число страниц");
        }

        durations[index] = num;
    }
    // endregion

    // функциональный метод
    public int getTotalDuration() {
        int sum = 0;
        for (int duration : durations) {
            sum += duration;
        }
        return sum;
    }

    // region переопределения
/*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("название сборника статей .......................... ").append(title).append('\n');
        sb.append("кол-во страниц в аннотации ........................ ").append(price).append('\n');
        sb.append("общей кол-во страниц в сборнике без аннотаций ..... ").append(getTotalDuration()).append('\n');
        sb.append("кол-во элементов .................................. ").append(collection.length).append('\n');
        sb.append("тип объекта........................................ ").append(getClass()).append('\n');
        sb.append("---------------------------------------------------\n");

        appendArticlesInfo(sb);

        return sb.toString();
    }

    private void appendArticlesInfo(StringBuilder sb) {
        int lastIndex = collection.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            sb.append(i).append(") ").
                    append(collection[i]).
                    append(" (кол-во стр. -- ").append(durations[i]).append(")").append("\n");
        }
        sb.append(lastIndex).append(") ").
                append(collection[lastIndex]).
                append(" (кол-во стр. -- ").append(durations[lastIndex]).append(")");
    }
*/
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final MediaLibrary other = (MediaLibrary) obj;

        if (!(this.title.equals(other.title)
                && this.price == other.price
                && Arrays.equals(this.collection, other.collection)
                && Arrays.equals(this.durations, other.durations))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    // endregion
}