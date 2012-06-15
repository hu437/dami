package org.dami.classification.common;

import java.util.Properties;

import org.dami.common.DataStorage;
import org.dami.common.Sample;

public interface Classifier {
	public void loadData(DataStorage data) throws Exception;
	
	public void train() throws Exception;
		
	public void setProperties(Properties prop);
	
	public Properties getProperties();
	
	/**
	 * while implementing this function, you must inform the user that the label from training set should be the same from testing set
	 * Be careful that the Sample.label within the testing-data instance  should be the same as  the training-data
	 * you should carefully transform the testing data. 
	 * And let the "DATASET_INFO" attribute has the same label info in the training and testing dataset.  
	 * we suggest you not to use this function for prediction. Instead, implement and use {@link #predict(String, String, Evaluator...)}
	 * @param data 
	 * @param resultPath 
	 * @param evaluators 
	 * @throws Exception
	 */
	public void predict(DataStorage data, String resultPath, Evaluator... evaluators) throws Exception;
	
	public void predict(String predictFile, String resultPath, Evaluator... evaluators) throws Exception;
	
	public void predict(Sample sample, double[] probabilities) throws Exception;
	
	public void saveModel(String filePath) throws Exception;
	
	public void loadModel(String modelPath) throws Exception;
	
	public void crossValidation(int fold, Evaluator... evaluators) throws Exception;
}
