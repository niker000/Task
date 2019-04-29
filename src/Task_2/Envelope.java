package Task_2;

public class Envelope {
    final private double height;
    final private double width;
    final private String ENVELOPE_INSTRUCRION = "1. Enter envelope parameters" + '\n' +
                                                "2. Enter \"y\" if you want to continue or \"n\" to end the program";

    public Envelope(double height, double width) {
        if (height < 0) {
            this.height = height * (-1);
        } else {
            this.height = height;
        }
        if (width < 0) {
            this.width = width * (-1);
        } else {
            this.width = width;
        }

    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }


}
