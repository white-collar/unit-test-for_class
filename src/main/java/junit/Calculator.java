package junit;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static java.lang.Math.*;

public class Calculator {
    DecimalFormat decimalFormat;
    String outputLog;

    double sectionFrom;
    double sectionTo;

    double degrees;

    public String getSin(double radians) {
        return outputLog = decimalFormat.format(sin(radians));
    }

    public String getCos(double radians) {
        return outputLog = decimalFormat.format(cos(radians));
    }

    public String getTan(double radians) {
        return outputLog = decimalFormat.format(tan(radians));
    }

    public String getCtg(double radians) {
        return outputLog = decimalFormat.format(1.0 / tan(radians));
    }

    public void setCut(double sectionFrom, double sectionTo) {
        this.sectionFrom = sectionFrom;
        this.sectionTo = sectionTo;
    }

    public void setRadians(double redias) {
        this.degrees = Math.toDegrees(redias);
    }

    public double getDegrees() {
        return degrees;
    }

    public void initializeOutputWriter() {
        DecimalFormatSymbols dc = new DecimalFormatSymbols();
        dc.setDecimalSeparator('.');
        this.decimalFormat = new DecimalFormat("#0.00", dc);
    }

    public void clear() {
        this.outputLog = "";
    }
}