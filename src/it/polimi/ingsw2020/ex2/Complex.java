package it.polimi.ingsw2019.ex2;

public class Complex {

    private double real, imaginary;

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    public double abs(){
        return Math.sqrt(real*real
                +imaginary*imaginary);
    }

    public double phase(){
        if (real > 0)
            return Math.atan(imaginary/real);
        else if (real < 0 && imaginary >= 0)
            return Math.atan(imaginary/real) + Math.PI;
        else if (real < 0 && imaginary < 0)
            return Math.atan(imaginary/real) - Math.PI;
        else if (real == 0 && imaginary > 0)
            return Math.PI/2;
        else if (real == 0 && imaginary < 0)
            return -Math.PI/2;
        else
            return Integer.MIN_VALUE;
    }

    /*
    public void add(Complex other){
        real += other.real;
        imaginary += other.imaginary;
    }
    */

    public Complex add(Complex other){
        return new Complex(real+other.real,
                imaginary+other.imaginary);
    }

    public Complex sub(Complex other){
        return new Complex(real-other.real,
                imaginary-other.imaginary);
    }

    public Complex mult(Complex other){
        return new Complex(real * other.real - imaginary*other.imaginary,
                real*other.imaginary+imaginary*other.real);
    }

    public boolean approximatelyEquals(Complex other,
                                       double precision){

        return this.sub(other).abs() < precision;
    }


    public String toString(){
        return real + "+" + imaginary + "i";
    }


    public static void main(String[] args){
        Complex a = new Complex(5, 6);
        Complex b = new Complex(4, 0);
        Complex c = a.add(b);
        Complex d = a.sub(b);
        Complex e = a.mult(b);
        double m = a.abs();
        double f = a.phase();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(m);
        System.out.println(f);
        System.out.println(
                a.approximatelyEquals(
                        new Complex(4.9999, 6.0001),
                        0.1));

    }

}
