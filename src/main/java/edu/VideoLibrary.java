package edu;

public class VideoLibrary extends MediaLibrary{
    public VideoLibrary(){
        super();
    }
    public VideoLibrary(String title, int price, int count){
        super(title, price, count);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Название видеотеки: ").append(getTitle()).append('\n');
        result.append("Цена: ").append(getPrice()).append('\n');
        result.append("Общая продолжительность в минутах: ");
        result.append(getTotalDuration() / 60).append('\n');
        result.append("Всего видеофайлов: ").append(getItemsCount()).append('\n');
        result.append("-----------------\n");

        //appendArticlesInfo(result);
        return result.toString();
    }
}

