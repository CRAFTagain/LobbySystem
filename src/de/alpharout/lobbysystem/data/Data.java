package de.alpharout.lobbysystem.data;

import org.bukkit.Bukkit;

import java.util.ArrayList;

public class Data {
    private static String name = "§6System";
    private static String prefix = "§7[" + name + "§7] ";
    private static String version = "v0.0.1 DEV-ALPHA";
    private static String authors = "alphaR0ut & CRAFTagain";
    private static String news = "§aÜberarbeiteter Navigator";

    public static String getName() {
        return name;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getVersion() {
        return version;
    }

    public static String getAuthors() {
        return authors;
    }

    public static String getNews(){
        return news;
    }

    public static void log(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + msg);
    }
}
