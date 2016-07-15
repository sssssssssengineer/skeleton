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
			if (cnt == N){ //End In processing, as remaining content in data file is non-sense
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
		int N = 5;
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);


		/** Create an animation */
		double timer = 0.0;
		double[] xForces = {0.0, 0.0, 0.0, 0.0, 0.0};//initialize the array
		double[] yForces = {0.0, 0.0, 0.0, 0.0, 0.0};
		StdAudio.play("audio/2001.mid");//Would cause a little bug, but work fine
		while (timer < T){
			timer = timer + dt;
			for (int cnt = 0; cnt < N; cnt++){//calculate the net x and y forces for each planet
				double xForce = planets[cnt].calcNetForceExertedByX(planets);
				double yForce = planets[cnt].calcNetForceExertedByY(planets);
				xForces[cnt] = xForce;
				yForces[cnt] = yForce;
			}
			for (int cnt = 0; cnt < N; cnt++){//call update on each of the planets
				planets[cnt].update(dt, xForces[cnt], yForces[cnt]);
			}

			/** Draw the starfield background */
			String backgroundImage = "./images/starfield.jpg";
			StdDraw.setScale(-radius, radius);
			StdDraw.clear();
			StdDraw.picture(0, 0, backgroundImage);

			/** Draw all planets */
			for (Planet p : planets){
				p.draw();
				StdDraw.show(10);
			}
		}
		/** The final state of the universe */
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}
}