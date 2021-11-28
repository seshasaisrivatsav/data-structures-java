package stacksAndQueues;

import java.util.Date;
import java.util.LinkedList;

/*
        Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first
        out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
        or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
        that type). They cannot select which specific animal they would like. Create the data structures to
        maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
        and dequeueCat. You may use the built-in LinkedList data structure.

        Solution:
        One easier way is to keep one queue, but we need to iterate through the queue to find latest dog or cat

        Better Solution:
        Use separate queues for dos and cats.
        For dequeueAny, we peek at heads of both dog and cat queue and return based on timestamp

        NOTE:
            - Create abstract class Animal
            - Create two sub classes by extending Animal called Cat and Dog that implement super
            - In the AnimalShelter class - Maintain dogs, cats and createTs
            - use list.addLast = for entry
            - use poll to return the first element
 */
abstract class Animal {
    private Date createTs;
    protected String name;
    public Animal (String name) { this.name = name; }
    public void setCreateTs(Date createTs) { this.createTs = createTs; }
    public Date getCreateTs() { return this.createTs; }

    // Returns true if the given Animal A is created before this animal
    public boolean isOlderThan(Animal a) {
        return a.createTs.before(this.createTs);
    }
}

class Dog extends Animal {
    public Dog(String name) { super(name); }
}

class Cat extends Animal {
    public Cat(String name) { super(name); }
}
public class AnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private Date createTs;

    void enqueue(Animal animal) {
        animal.setCreateTs(new Date()); // Before enqueueing create animal with new date
        if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        } else {
            dogs.addLast((Dog) animal);
        }
    }

    Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }
        if (dogs.peek().isOlderThan(cats.peek())) {
            return dequeueDogs();
        }
        return dequeueCats();
    }

    Animal dequeueDogs() {
        return dogs.poll();
    }

    Animal dequeueCats() {
        return cats.poll();
    }

}
