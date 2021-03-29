package edu;

import edu.exceptions.IllegalIndexException;

public class BooksSet implements Seriesable {
    private String title;
    private int numOfPrefacePages;
    private String[] books;
    private int[] numsOfPages;

    public BooksSet() {
        title = "без названия";
        numOfPrefacePages = Seriesable.MIN_NUM_OF_START_PAGES;
        books = new String[Seriesable.MIN_NUM_OF_ELS_OF_SERIES];
        numsOfPages = new int[books.length];
    }

    public BooksSet(String title, int numOfPrefacePages, int numOfBooks) {
        this.title = title;
        this.numOfPrefacePages = numOfPrefacePages;
        books = new String[numOfBooks];
        numsOfPages = new int[books.length];
    }

    // region get
    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return numOfPrefacePages;
    }

    public int getItemsCount() {
        return books.length;
    }

    public String getItem(int index) {
        if (index < 0 || index >= books.length) {
            throw new IllegalIndexException("неверный индекс");
        }

        return books[index];
    }

    public int getDuration(int index) {
        if (index < 0 || index >= numsOfPages.length) {
            throw new IllegalIndexException("неверный индекс");
        }

        return numsOfPages[index];
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

        numOfPrefacePages = num;
    }

    public void setItem(int index, String title) {
        if (index < 0 || index >= books.length) {
            throw new IllegalIndexException("неверный индекс");
        }

        books[index] = title;
    }

    public void setDuration(int index, int num) {
        if (index < 0 || index >= books.length) {
            throw new IllegalIndexException("неверный индекс");
        }
        if (num < Seriesable.MIN_NUM_OF_PAGES_OF_EL) {
            throw new IllegalIndexException("неверное число страниц");
        }
        if (num > Seriesable.MAX_NUM_OF_PAGES_OF_EL) {
            throw new IllegalIndexException("слишком большое число страниц");
        }

        numsOfPages[index] = num;
    }
    // endregion

    // функциональный метод
    public int getTotalDuration() {
        int sum = 0;
        for (int num : numsOfPages) {
            sum += num;
        }

        return sum;
    }

    // region переопределения
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("название сборника книг............................. ").append(title).append('\n');
        sb.append("кол-во страниц в предисловии ...................... ").append(numOfPrefacePages).append('\n');
        sb.append("общей кол-во страниц в сборнике без предисловий ... ").append(getTotalDuration()).append('\n');
        sb.append("кол-во элементов .................................. ").append(books.length).append('\n');
        sb.append("тип объекта........................................ ").append(getClass()).append('\n');
        sb.append("---------------------------------------------------\n");

        appendBooksInfo(sb);

        return sb.toString();
    }

    private void appendBooksInfo(StringBuilder sb) {
        int lastIndex = books.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            sb.append(i).append(") ").
                    append(books[i]).
                    append(" (кол-во стр. -- ").append(numsOfPages[i]).append(")").append("\n");
        }
        sb.append(lastIndex).append(") ").
                append(books[lastIndex]).
                append(" (кол-во стр. -- ").append(numsOfPages[lastIndex]).append(")");
    }

    @Override
    public boolean equals(Object obj) {
        boolean isSeriesable = obj instanceof Seriesable;

        if (isSeriesable) {
            Seriesable anotherSeries = (Seriesable) obj;

            if (this.title.equals(anotherSeries.getTitle()))
                return areElsEqual(anotherSeries);
        }

        return false;
    }

    private boolean areElsEqual(Seriesable anotherSeries) {
        if (!areNumOfStartPagesAndElsEqual(anotherSeries)) {
            return false;
        }

        for (int i = 0; i < books.length; i++) {
            if (!isElEqual(i, anotherSeries))
                return false;
        }

        return true;
    }

    private boolean areNumOfStartPagesAndElsEqual(Seriesable anotherSeries) {
        return this.getPrice() == anotherSeries.getPrice() &&
                this.books.length == anotherSeries.getItemsCount();
    }

    private boolean isElEqual(int index, Seriesable anotherSeries) {
        return books[index].equals(anotherSeries.getItem(index)) &&
                numsOfPages[index] == anotherSeries.getDuration(index);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    // endregion
}