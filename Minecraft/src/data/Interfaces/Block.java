package data.Interfaces;

public interface Block extends InventoryBlock {

    char display();
    boolean get_falls_with_gravity();
    boolean get_fall_through();
    boolean is_pickable();
    boolean isNull();
}