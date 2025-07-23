package fr.dams4k.cpscore;

import java.nio.file.Path;

public class CPSCore {
    public static Path modFolder;

    public static void init(Path modFolder) {
        CPSCore.modFolder = modFolder;
    }
}
