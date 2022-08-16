package com.iu.start.di;

public class Car {

	//Car는 Engine이 없으면 x
	//Car는 Engine에 의존적이다
	//1. private Engine engine = new Engine();
	//2.
	//Car car = new Car();
	//car.engine = new Engine();
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel; 
	//3.
	//public Car(){
//		this.engine = new Engine();
//	}
	public Car(LeftWheel leftWheel, RightWheel rightWheel) {
		this.engine = engine;
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}
	// Engine engine = new Engine();
	// Car car = new Car(engine);
	
	//4.
//	{
//		this.engine = new Engine();
//	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	//5.
	//Car car = new Car();
	//Engine engine = new Engine();
	//car.setEngine(engine);
	
	
}
