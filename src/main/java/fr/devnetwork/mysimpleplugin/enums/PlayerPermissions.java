package fr.devnetwork.mysimpleplugin.enums;

public enum PlayerPermissions {
    ADMINISTRATOR(1, 100, "[§cADMINISTRATEUR§r] ", " >> "),
    PLAYER(0, 1, "[§aPLAYER§r] ", " : ");

    private final int id;
    private final int power;
    private final String prefix;
    private final String chatPrefix;

    PlayerPermissions(int id, int power, String prefix, String chatPrefix) {
        this.id = id;
        this.power = power;
        this.prefix = prefix;
        this.chatPrefix = chatPrefix;
    }

    public int getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getChatPrefix() {
        return chatPrefix;
    }

    public String getName() {
        return this.toString();
    }
}
