package Commands;

import LabStuff.LabCollection;

import java.io.IOException;


public interface Commandable {
    LabCollection labcollection = new LabCollection();

    void execute(Object o);
    String getDescription();
    String getName();

}
