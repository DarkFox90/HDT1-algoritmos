public interface IRadio {
    public void setPowerOn(boolean on);

    public boolean isOn();

    public void setBand(boolean am);

    public boolean isAm();

    public void next();

    public double getFrequence();
    
    public void save(int button);

    public double get(int button);
}