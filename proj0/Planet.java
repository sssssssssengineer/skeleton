/*
* @Author: CYS
* @Date:   2016-07-15 11:13:28
* @Last Modified by:   Evan
* @Last Modified time: 2016-07-15 11:40:08
*/

public class Planet {

    //constant
    public static double G = 6.67e-11;

	//Instance variables
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    //First constructor
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
    	xxPos = xP;
    	yyPos = yP;
    	xxVel = xV;
    	yyVel = yV;
    	mass = m;
    	imgFileName = img;
    }

    //Second constructor
    public Planet(Planet p){
    	xxPos = p.xxPos;
    	yyPos = p.yyPos;
    	xxVel = p.xxVel;
    	yyVel = p.yyVel;
    	mass = p.mass;
    	imgFileName = p.imgFileName;
    }

    //r
    public double calcDistance(Planet p){
    	double dx = xxPos - p.xxPos;
    	double dy = yyPos - p.yyPos;
    	return Math.sqrt(dx * dx + dy * dy);
    }

    //F
    public double calcForceExertedBy(Planet p){
        return G * mass * p.mass / (calcDistance(p) * calcDistance(p));
    }

    //Fx
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - xxPos;
        return calcForceExertedBy(p) * dx / calcDistance(p);
    }

    //Fy
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - yyPos;
        return calcForceExertedBy(p) * dy / calcDistance(p);
    }

    //FnetX
    public double calcNetForceExertedByX(Planet[] ps){
        double res = 0.0;
        for (Planet p : ps){
            if (p == this){
                continue;
            }
            res = res + calcForceExertedByX(p);
        }
        return res;
    }

    //FnetY
    public double calcNetForceExertedByY(Planet[] ps) {
        double res = 0.0;
        for (Planet p : ps) {
            if (p == this) {
                continue;
            }
            res = res + calcForceExertedByY(p);
        }
        return res;
    }

    //update the planet's position
    public void update(double dt, double Fx, double Fy){
        double ax = Fx / mass;
        double ay = Fy / mass;
        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }
}	