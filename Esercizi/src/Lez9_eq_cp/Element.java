package Lez9_eq_cp;

import java.util.Objects;

public class Element {

    private int x;

    public Element()      { this.x = 0; }
    public Element(int x) { this.x = x; }

    @Override
    public String toString() { return this.x + ""; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true;  }
        if (!(obj instanceof Element))  { return false; }
        if (this.x != ((Element)obj).x) { return false; }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x);
    }
}
