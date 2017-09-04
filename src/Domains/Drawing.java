package Domains;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private String name;
    private List<DrawingItem> items;


    public Drawing(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DrawingItem> getItems() {
        return items;
    }

    public void addItem(DrawingItem item)
    {

        items.add(item);
    }

    public void deleteItem(DrawingItem item)
    {
        this.items.remove(item);
    }

    public void editItem(int index, DrawingItem item)
    {
        this.items.set(index,item);
    }

    public void paintUsing(IPaintable paintable)
    {

    }

}
