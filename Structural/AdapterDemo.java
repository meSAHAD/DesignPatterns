/*
Scenario:
In Bangladesh, electrical devices use 220V plugs, but imported Japanese devices use 110V.
An Adapter converts the Japanese device’s interface to work with Bangladeshi plugs.
This avoids changing existing device or socket classes, enabling compatibility.
*/

interface BangladeshPlug {
    void connect220V();
}

class JapaneseDevice {
    void connect110V() {
        System.out.println("Connected to 110V Japanese outlet.");
    }
}

class VoltageAdapter implements BangladeshPlug {
    private JapaneseDevice device;

    public VoltageAdapter(JapaneseDevice device) {
        this.device = device;
    }

    public void connect220V() {
        System.out.println("Adapter converts 220V to 110V.");
        device.connect110V();
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        JapaneseDevice japDevice = new JapaneseDevice();
        BangladeshPlug adapter = new VoltageAdapter(japDevice);
        adapter.connect220V();
    }
}
