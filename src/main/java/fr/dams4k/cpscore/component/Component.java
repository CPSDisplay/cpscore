package fr.dams4k.cpscore.component;

public class Component {
    private String name;

    public CPosition position = new CPosition(0, 0, 1f);
    public CText text = new CText("[{0} | {1}]", "ffffff");
    public CBackground background;

    // Used to generate file
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
