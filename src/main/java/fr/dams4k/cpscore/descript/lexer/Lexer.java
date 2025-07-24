package fr.dams4k.cpscore.descript.lexer;

public class Lexer {
    public String source;
    public int position;

    public Lexer(String source) {
        this.source = source;
    }

    public void advance(int n) {
        this.position += n;
    }

    public String remaining() {
        return source.substring(position);
    }

    public boolean at_eof() {
        return this.position >= source.length();
    }
}
