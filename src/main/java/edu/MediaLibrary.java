package edu;

import edu.exceptions.MediaIndexOutOfRangeException;

import java.util.Arrays;

public abstract class MediaLibrary implements Collectable {

    private String title;
    private int price;
    private String[] collection;
    private int[] durations;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setItem(int index, String title) {
        if (index < 0 || index >= collection.length) {
            throw new MediaIndexOutOfRangeException("illegal index");
        }

        collection[index] = title;
    }

    public void setDuration(int index, int duration) {
        if (index < 0 || index >= collection.length) {
            throw new MediaIndexOutOfRangeException("illegal index");
        }
        durations[index] = duration;
    }

    // функциональный метод
    public int getTotalDuration() {
        int sum = 0;
        for (int duration : durations) {
            sum += duration;
        }
        return sum;
    }

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
}