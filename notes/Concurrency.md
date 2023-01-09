# Concurrency

## Concurrency by implementing Runnable
```java

class ConcurrencyLesson {
  public static void main(String[] args) {
    TaskTest task = new TaskTest();
    Thread thread = new Thread(task); // Thread scheduler won't guarantee consistency
    thread.start(); // at this state, there are 2 non daemon threads. one for meain and one we start
    System.out.println("1 inside main thread");
    /*
    sometimes the output can be fuzzy
      2 Inside Run where business logic goes
      3 Inside random
      4 Inside random 2
      1 inside main thread
     */
  }


}
class TaskTest implements Runnable {
  @Override
  public void run() {
    System.out.println("2 Inside Run where business logic goes");
    randomMethod();
  }

  private void randomMethod() {
    System.out.println("3 Inside random");
    randomMethod2();
  }

  private void randomMethod2() {
    System.out.println("4 Inside random 2");
  }

}
```

## Concurrency by extending Thread
```java

class ConcurrencyLesson {
  public static void main(String[] args) {
    /*
    sometimes the output can be fuzzy
      2 Inside Run where business logic goes
      3 Inside random
      4 Inside random 2
      1 inside main thread
     */
    Thread extendThreadTest = new ThreadTest2();
    extendThreadTest.run();
    System.out.println("1 inside main thread");
  }
}

class ThreadTest2 extends Thread {
  public void run() {
    System.out.println("2 Inside Run where business logic goes");
    randomMethod();
  }
  private void randomMethod() {
    System.out.println("3 Inside random");
    randomMethod2();
  }
  private void randomMethod2() {System.out.println("4 Inside random 2");  }
}

```
