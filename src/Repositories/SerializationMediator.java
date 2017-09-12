package Repositories;

import Domains.Drawing;

import java.util.Properties;

public interface SerializationMediator {
    Drawing load(String nameDrawing) throws Exception;
    boolean save(Drawing drawing) throws Exception;
    boolean init(Properties props);
}
