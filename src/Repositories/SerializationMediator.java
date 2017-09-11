package Repositories;

import Domains.Drawing;

import java.util.Properties;

public interface SerializationMediator {
    Drawing load(String nameDrawing);
    boolean save(Drawing drawing);
    boolean init(Properties props);
}
