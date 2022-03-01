public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue){
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }
    public String toHex(){
        String result = String.format("#%02x%02x%02x", red, green, blue);
                return result;
    }
    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Override
    public String toString(){
        String result=String.format("%s RGB(%d, %d, %d)",toHex(), red, green, blue);
        return result;
    }

   }
