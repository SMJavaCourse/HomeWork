package org.course;

public class ServicesImpl implements Services{
    private boolean grillMeat;
    private boolean balcony;
    private boolean internet;
    private boolean conditioner;
    private boolean cleaning;

    @Override
    public Services addBalcony() {
        this.balcony = true;
        return this;
    }

    @Override
    public boolean isBalcony() {
        return this.balcony;
    }

    @Override
    public Services addGrillMeat() {
        this.grillMeat = true;
        return this;
    }

    @Override
    public boolean isGrillMeat() {
        return this.grillMeat;
    }

    @Override
    public Services addInternet() {
        this.internet = true;
        return this;
    }

    @Override
    public boolean isInternet() {
        return this.internet;
    }

    @Override
    public Services addConditioner() {
        this.conditioner = true;
        return this;
    }

    @Override
    public boolean isConditioner() {
        return this.conditioner;
    }

    @Override
    public Services addCleaning() {
        this.cleaning = true;
        return this;
    }

    @Override
    public boolean isCleaning() {
        return this.cleaning;
    }

    @Override
    public String toString() {
        var b = isBalcony() ? "\"балкон\" " : "";
        var cl = isCleaning() ? "\"уборка\" " : "";
        var cn = isConditioner() ? "\"кондиционер\" " : "";
        var i = isInternet() ? "\"интернет\" " : "";
        var gm = isGrillMeat() ? "\"шашлычок в номер\" " : "";
        return (b + cl + cn + i + gm).strip().replaceAll("\"\\s", "\", ");
    }
}
