/**
 * Simulate a universe specified in one of the data files
 */

public class NBody{

	public static double readRadius(String filename){
		/** Read radius of the universe from data file */
		In in = new In(filename);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename){
		/** Return an array of planets */
		In in = new In(filename);
		int N = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[5];
		int cnt = 0;
		while (!in.isEmpty()){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[cnt] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
			cnt = cnt + 1;
			if (cnt == 5){ //End In processing, as remaining content in data file is non-sense
				break;
			}
		}
		return planets;
	}

	public static void main(String[] args){
		/** Collecting All Needed Input */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
	}
}