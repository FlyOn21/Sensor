package entitys;

import Interfaces.ISubstance;
import config.Config;
import enums.Colors;

public class Substance implements ISubstance {
    private double temperature;
    private double wight;
    private Colors color;

    public Substance() {
    }

    public String getSubstance() {
        if (this.temperature == 0.0 && this.wight == 0.0 && this.color == null) {
            return "Substance is not defined.";
        }
        return STR."Substance: \{this.temperature}\{Config.TEMPERATURE_UNIT} \{this.wight}\{Config.WEIGHT_UNIT} \{this.color}";
    }

    public void setSubstance(Double[] substance) {
        this.wight = substance[1];
        this.temperature = substance[0];
        this.color = Colors.fromValue(substance[2]);
    }
}
