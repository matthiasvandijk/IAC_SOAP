/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iac_soap.statsq;


import com.sun.xml.ws.developer.SchemaValidation;
import java.util.List;
import javax.jws.WebService;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.inference.TestUtils;

/**
 *
 * @author Matthias
 */

//@SchemaValidation
@WebService(endpointInterface="iac_soap.statsq.NormVerdServiceI", serviceName = "normaalVerdeling")
public class NormVerdService implements NormVerdServiceI {
    
    @Override
    public NormVerdResponse calculateNormVerd(List<Double> data) throws MyFault {

        //Service Requirements 
        if (data.isEmpty()) {
            throw new MyFault("No data is provided");
        } else if (data.size() < 2) {
            throw new MyFault("A minimum of two data elements is required.");
        }
        
        //Declaring Apache Commons DescriptiveStatistics
        DescriptiveStatistics stats = new DescriptiveStatistics();

        //Filling DescriptiveStatistics class with the provided dataset
        for (int i = 0; i < data.size(); i++) {
            stats.addValue(data.get(i));
        }
        
        //Let the DescriptiveStatistics class calculate the mean and standard deviation
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();        
        
        //Implementing the Kolmogorov–Smirnov test & calculating the kurtosis and skewness
        NormalDistribution x = new NormalDistribution(mean, std);
        double p_value = TestUtils.kolmogorovSmirnovTest(x, stats.getValues(), false);
        double kurtosis = stats.getKurtosis();
        double skewness = stats.getSkewness();
        boolean result = false;
        
        //Check if the dataset is a normal distribution:
        //Kolmogorov–Smirnov p_value should be >= 0.05
        //Both kurtosis and skewness should be between -2.0 and 2.0
        if (kurtosis < 2.0 && kurtosis > -2.0
                && skewness < 2.0 && skewness > -2.0
                && p_value >= 0.05) {
            result = true;
        }
        
        //Response message:
        NormVerdResponse nvr = new NormVerdResponse(result, p_value, kurtosis, skewness);
        
        return nvr;
    }
    
}
