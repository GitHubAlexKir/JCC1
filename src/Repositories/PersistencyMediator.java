package Repositories;

import Domains.Drawing;

import java.util.Properties;

public class PersistencyMediator implements SerializationMediator {
    @Override
    public Drawing load(String nameDrawing) {
        return null;
    }

    @Override
    public boolean save(Drawing drawing) {
        return false;
    }

    @Override
    public boolean init(Properties props) {
        return false;
    }


}
