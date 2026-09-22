public class BulbAdapter implements SmartDevice {
    private LegacyBulb bulb;
    private int k = 3;
    public BulbAdapter(LegacyBulb bulb) {
        if (bulb == null) {
            throw new IllegalArgumentException("not can be null");
        }
        this.bulb = bulb;
    }
    public void turnOn() {
        bulb.setBrightness(255);
    }
    public void turnOff() {
        bulb.setBrightness(0);
    }
    public boolean isOn() {
        if (bulb.hasPower() == false) {
            return false;
        }
        if (bulb.readBrightness() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public int getPowerPercent() {
        if (bulb.hasPower() == false||bulb.readBrightness() == 0) {
            return 0;
        }
        int raw = bulb.readBrightness();
        int rawPercent = (raw * 100) / 255;
        int finalPercent = rawPercent + k;
        if (finalPercent > 100) {
            return 100;
        } else {
            return finalPercent;
        }
    }
}
