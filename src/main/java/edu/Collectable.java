package edu;

public interface Collectable {

    String getTitle();

    int getItemsCount();

    int getPrice();

    String getItem(int index);

    int getDuration(int index);

    void setTitle(String title);

    void setPrice(int price);

    void setItem(int index, String title);

    void setDuration(int index, int duration);

    int getTotalDuration();
}
