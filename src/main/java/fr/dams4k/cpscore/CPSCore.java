package fr.dams4k.cpscore;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class CPSCore {
    public void test() {
        Yaml yaml = new Yaml();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("test.yaml");
        Map<String, Object> data = yaml.load(is);
        System.out.println(data);
    }
}
