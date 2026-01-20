public class Radio implements IRadio {  

    private boolean on;
    private boolean am;
    private double amFrequence;
    private double fmFrequence;
    private double[] amButtons;
    private double[] fmButtons;

    public Radio(){
        this.on = false;
        this.am = true;
        this.amFrequence = 530;
        this.fmFrequence = 87.9;
        this.amButtons = new double[12];
        this.fmButtons = new double[12];
    }

    @Override
    public void setPower(boolean on) {
        this.on = on;
    }

    @Override
    public boolean isOn(){
        return this.on;
    }

    @Override
    public void setBand(boolean am){
        this.am = am;
    }

    @Override
    public boolean isAm(){
        return this.am;
    }

    @Override
    public void next(){
        if (this.am == true){
            this.amFrequence += 10;
            if (this.amFrequence > 1610){
                this.amFrequence = 530;
                } }
            else {
                this.fmFrequence += 0.2;
            if (this.fmFrequence > 107.9){
                this.fmFrequence = 87.9;
                }
                fmFrequence = Math.round(fmFrequence * 10.0) / 10.0;
            }   
        } 
    
    @Override
    public double getFrequence(){
        if (this.am == true){
            return this.amFrequence;
        } else {
            return this.fmFrequence;
        }
    }

    @Override
    public void save(int button){
        if (this.am){
            this.amButtons[button -1] = this.amFrequence;
        } else {
            this.fmButtons[button -1] = this.fmFrequence;
        }
    }

    @Override
    public double get(int button){
        if (this.am) {
            return this.amButtons[button -1];
        } else {
            return this.fmButtons[button -1];
        }   
    }

    @Override
    public void setFrequence(double frequence) {
        if (this.am) {
            this.amFrequence = frequence;
        } else {
            this.fmFrequence = frequence;
        }
    }
}

