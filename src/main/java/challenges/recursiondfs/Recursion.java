package challenges.recursiondfs;

import java.util.Collection;

public class Recursion {
    class Menu {
        String name;
        Collection<MenuGroup> groups;
        Double price;
    }

    class MenuGroup {
        String name;
        Collection<MenuGroup> groups;
        Collection<MenuItem> items;
        Double price;
    }

    class MenuItem {
        String name;
        Double price;
    }


    /**
     * Details: https://docs.google.com/document/d/1wGZx_0a85VRq30FXDmc9CjLwI13fKs2Lxnp9EHCE4Mo/edit
     *  Compute the price of MenuItem provided in collection of Menu
     *  Price should be most specific non null price in ite's menu ancestry
     * @param menus Collection<Menu>
     * @param item Menu Item
     * @return Double price
     */
    public static Double getMenuItemPriceInMenu(Collection<Menu> menus, MenuItem item) {
        return 2.0;
    }

}
