public class CreateComplex {

    public static void main(String[] args) {

        CreateComplex createComplex = new CreateComplex();
        Complex c1 = createComplex.createComplex(1, 1);
        Complex c2 = createComplex.createComplex(7, -3.321);

        System.out.println(c1.equals(c2));

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        System.out.println(c1.sum(c2));
        System.out.println(c1.mul(c2));

    }

    Complex createComplex(double real, double image) {

        return new ComplexNumber(real, image);
    }

}


class ComplexNumber implements Complex {

    double real;
    double image;

    public ComplexNumber(double real, double image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {

        return String.format("%.2f", real) + " + " + String.format("%.2f", image) + "i";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        double delta = 0.01;
        if (Math.abs(real - that.real) <= delta && Math.abs(image - that.image) <= delta) {
            return true;
        }

        if (this.toString().equals(that.toString())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public Complex sum(Complex other) {

        return new ComplexNumber(this.real + other.getReal(), this.image + other.getImage());
    }

    @Override
    public Complex sub(Complex other) {
        return new ComplexNumber(this.real - other.getReal(), this.image - other.getImage());
    }

    @Override
    public Complex mul(Complex other) {
        return new ComplexNumber(this.real * other.getReal() - this.image * other.getImage(), this.real * other.getImage() + this.image * other.getReal());
    }

    @Override
    public double getReal() {
        return this.real;
    }

    @Override
    public double getImage() {
        return this.image;
    }
}


interface Complex {

    Complex sum(Complex other);

    Complex sub(Complex other);

    Complex mul(Complex other);

    double getReal();

    double getImage();
}
