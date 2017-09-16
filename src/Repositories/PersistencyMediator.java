package Repositories;

import Domains.Drawing;

import java.io.*;
import java.util.Properties;

public class PersistencyMediator implements SerializationMediator {
    @Override
    public Drawing load(String nameDrawing) {

        try(
            InputStream file = new FileInputStream(nameDrawing+".ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);

        )
        {
            return (Drawing) input.readObject();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Drawing drawing) {
        try (
            OutputStream file = new FileOutputStream(drawing.getName() +".ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            )
        {
            output.writeObject(drawing);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean init(Properties props) {
        return false;
    }


}
