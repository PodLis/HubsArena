package ru.hubsmc.hubsarena;

public class Permissions {

    public enum Perm {

        HELP("hubsarena.help"),
        RELOAD("hubsarena.reload");

        private final String perm;

        Perm(String perm) {
            this.perm = perm;
        }

        public String getPerm() {
            return perm;
        }

    }

}
