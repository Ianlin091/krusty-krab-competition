package strategy;

import flyweight_observer.ConcreteSubject;
import flyweight_observer.FlyweightFactory;

interface PtKeyStrategy {
	FlyweightFactory scoreLabel = new ConcreteSubject();
	void ptKeyPress();
}
