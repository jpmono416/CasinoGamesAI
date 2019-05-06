package models;


/*
 * Class created by Harry Clarkson
 */
public class Neural {
	
	private double player, dealer, pre_tan = 0;
	
	//w1 = player weight, w2 = dealer, weight b = bias
	private static double b = Math.random()*.2-.1;
	private static double w1 = Math.random()*.2-.1;
	private static double w2 = Math.random()*.2-.1;
	
	//number returned if > 0.5 then hit
	public double prediction(double m1, double m2) {
		player = m1;
		dealer = m2;
		pre_tan = (m1 * w1) + (m2 * w2) + b;
		return tanh(pre_tan);
	}
	
	//call target = (Player hit and didn't bust 1, Player hit and bust 0) (Player Stood and lost 1, Player stood and won 0)
	public void train(double target) {
		double rate = 0.001;
		
		double dcost_dpred = 2 * (b - target);
		
		double dpred_dz = tanh(pre_tan);
		
		double dz_dw1 = dealer;
		double dz_dw2= player;
		double dz_db = 1;
		
		double dcost_dw1 = dcost_dpred * dpred_dz * dz_dw1;
		double dcost_dw2 = dcost_dpred * dpred_dz * dz_dw2;
		double dcost_db = dcost_dpred * dpred_dz * dz_db;
		
		w1 -= rate * dcost_dw1;
		w2 -= rate * dcost_dw2;
		b -= rate * dcost_db;
	}
	
	
	private double tanh(double x) {
		return (1/(1+ Math.pow(Math.E,(-1*x))));
	}
	
	
	

}
