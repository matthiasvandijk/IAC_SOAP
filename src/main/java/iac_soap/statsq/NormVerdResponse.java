/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iac_soap.statsq;

/**
 *
 * @author Matthias
 */
public class NormVerdResponse {
    private boolean result;
    private double smirnov_p_value;
    private double kurtosis;
    private double skewness;

    public NormVerdResponse(boolean result, double smirnov_p_value, double kurtosis, double skewness) {
        this.result = result;
        this.smirnov_p_value = smirnov_p_value;
        this.kurtosis = kurtosis;
        this.skewness = skewness;
    }

    public NormVerdResponse() {
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public double getSmirnov_p_value() {
        return smirnov_p_value;
    }

    public void setSmirnov_p_value(double smirnov_p_value) {
        this.smirnov_p_value = smirnov_p_value;
    }

    public double getKurtosis() {
        return kurtosis;
    }

    public void setKurtosis(double kurtosis) {
        this.kurtosis = kurtosis;
    }

    public double getSkewness() {
        return skewness;
    }

    public void setSkewness(double skewness) {
        this.skewness = skewness;
    }
      
}
