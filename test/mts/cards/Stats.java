package mts.cards;

public class Stats {
	public static double getMean(int[] data) {
		double sum = 0;
		for(int n : data) {
			sum += n;
		}
		return sum / data.length;
	}
	
	public static double getVariance(int[] data) {
		double mean = getMean(data);
		
		double sum = 0;
		for(int n : data) {
			sum += Math.pow((n - mean), 2); 
		}		
		return sum / data.length;
	}
}
