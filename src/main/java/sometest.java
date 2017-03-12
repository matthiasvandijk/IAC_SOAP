
import java.util.ArrayList;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.inference.TestUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class sometest {
    public static void main(String[] args) {
        ArrayList y = new ArrayList<>();
        y.add(1);
        y.add(7);
        y.add(8);
        y.add(1);
        y.add(7);
        y.add(8);
        y.add(1);
        y.add(7);
        y.add(8);
        y.add(1);
        y.add(7);
        y.add(8);
        y.add(17);
        y.add(23);
        y.add(15);
        y.add(24);
        
        
        DescriptiveStatistics stats = new DescriptiveStatistics();
        
        for (int i = 0; i < y.size(); i++) {
            stats.addValue((double)(int)y.get(i));
        }
        
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        System.out.println(stats.getKurtosis());
        System.out.println(stats.getSkewness());           
        
        NormalDistribution x = new NormalDistribution(mean, std);
        double p_value = TestUtils.kolmogorovSmirnovTest(x, stats.getValues(), false);
        System.out.println(p_value);
        
        if (stats.getKurtosis() < 2.0 && stats.getKurtosis() > -2.0
                && stats.getSkewness() < 2.0 && stats.getSkewness() > -2.0
                && p_value >= 0.05) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}

