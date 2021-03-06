package Domains;

import drawing.javafx.IPaintable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Drawing implements Serializable {
    private String name;
    private final List<DrawingItem> items;


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
        for (DrawingItem t: this.items) {
            System.out.println();
            System.out.println(t.getClass());
            if (t instanceof PaintedText){paintable.paint((PaintedText) t);}
            if (t instanceof Image){paintable.paint((Image) t);}
            if (t instanceof Oval){paintable.paint((Oval) t);}
            if (t instanceof Polygon) {paintable.paint((Polygon) t);}
        }
    }


}
