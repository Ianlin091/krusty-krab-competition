package strategy;

import flyweight_observer.ConcreteSubject;
import flyweight_observer.FlyweightFactory;

interface SbKeyStrategy {
	FlyweightFactory scoreLabel = new ConcreteSubject();
	void sbKeyPress();
}
