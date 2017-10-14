# JavaMultithread
## Java核心编程技术
这本书所做的笔记，其中src下的note.txt是一个粗略的总结，Java多线程核心编程技术这本书比较基础，是一本多线程入门书籍

### 第一章 Java多线程技能(2017年3月3日）
#### t12
thread.interrupt()中断的是thread线程

thread.interruptted()判断的是当前的线程，而不是指thread本身（静态方法），该方法执行后会清除中断标志位

当前线程，既然是在main中执行的该语句，则当前线程就是main线程，主要是看该语句在哪执行

使用Thread.currentThread().interrupt()中断的是当前的线程

使用thread.isinterruptted()判断的是thread线程本身，（不是静态方法），该方法执行后不会清除中断标志位


t15
在沉睡中停止
在当前线程中执行sleep时，如果中断标志位为true，则会抛中断异常，不管是在sleep前，还是sleep时

中断后，该线程不会停止工作，只是将标志位置true，如果想让其停止，需要利用这个标志位来跳出
有如下几种停止线程的方法：
暴力停止线程的方法：Thread.stop(),此方法已经作废，因为如果直接终止线程，有可能一些清理过程不能够完成，
                  或者是没有对锁定的对象进行解锁，导致数据得不到同步处理
使用抛异常的方法：对标志位判断（使用thread.isinterrupted()），如果为true，则抛异常
使用return：在判断中，为true时，return

线程的暂停和恢复：suspend()和resume() （作废）
使用可能使得锁未被释放，书中提到当线程执行到同步代码块时，线程被执行suspend()后，锁未得到释放，导致该锁的方法不能被调用

t17
Thread.yield() 表示的是当线程获取CPU时，立刻释放CPU，再次竞争CPU

t18
线程的优先级具有继承性
线程优先级的规则性：CPU会尽量将执行资源让给优先级比较高的线程
优先级的随机性：优先级高的线程不一定每次都先执行完成

t19
线程分为用户线程和守护线程
当用户线程没有时，守护线程也会停止
设置守护线程测方法是thread.setDaemon(true)

### 第二章 对象及变量的并发访问（2017年3月4日）
非线程问题存在于实例变量中，方法内部的私有变量不存在非线程安全问题
多线程访问同一对象，只有一个锁，但是多线程访问多个对象，则有多个锁；
当多线程访问同一对象的不同方法（方法前面均加有synchronized），则需要排队。而访问非synchronized方法则不需要排队
同步（synchronized） 异步（asynchronized）
共享资源才有同步的问题

synLockIn
可重入锁：自己可以再次获取自己内部的锁，支持父子类继承的环境中
重点在于一个对象一把锁，子类继承父类的synchronized方法，便意味着该方法和子类的synchronized方法竞争同一把锁

出现异常，锁自动释放

synNotExtends
该Demo中实现的是重写父类的synchronized方法，将synchronized去掉后，子类访问该方法的非同步性
严格来说synchronized方法是具有继承性的

synchronized同步代码块：对于调用通过的方法执行一个长任务，为了不让其他线程等待太久，便可使用同步代码块

doubleSynBlockOneTwo
同步代码块的使用，可以在一个类中不同地方多次使用同步代码块（synchronized(this),如果不是this，另说），它们之间会产生竞争
同步代码块中的锁是当前对象的锁（也就是用如果方法前加了synchronized，会与同步代码快产生竞争）

使用同步代码块锁非this对象，不予锁为this的同步方法争抢this锁，则个大大提高运行效率

t9
创建只能放一个元素的自定义集合工具类

当其他线程执行x对象中synchronized同步方法时呈现同步效果（即同为对象锁）
当其他线程执行x对象里面的synchronized(this)代码块时呈现同步效果（该this为对象锁）

静态的方法前加上synchronized表示持有的是类锁，和对象锁是不同的。类锁不管new多少个对象，均只有一个
在代码块中声明类锁：
    synchronized(Service.class){
    //
    }

数据类型String的常量池特性
例如：String a="a"
     String b="a"
则a==b返回为true

同步块解决同步方法造成死锁的问题：一个同步方法中含有死循环，导致其他线程不能访问该对象的其他同步方法，解决办法是将同步方法改为同步代码块，使用不同的锁

死锁：双方持有自己的锁，同时又等待获取对方的锁

synchronized和volatile
关键字volatile是线程同步的轻量级实现，
多线程访问volatile时不会发生阻塞，而synchronized会出现阻塞
volatile能保证数据的可见性，但是不能保证原子性；而synchronized可以保证原子性，也可以间接保证可见性，因为它会将私有内存和公共内存中的数据做同步化


### 第三章 线程间通信
wait_notify_size5
对于wait()和notify()来说，必须是在同步中用对象锁进行调用，不然会报IllegalMonitorStateException的错误
notify()只能唤醒一个处于wait()状态的线程，notifyAll()可以唤醒全部处于wait()状态的线程
其过程是，在线程A的同步中，对象锁调用wait()方法释放对象锁，线程A处于暂停状态，其他线程竞争对象锁，
当被有notify()方法的线程B获取同步锁时，在同步中调用notify()，线程A便恢复到竞争状态，
直到线程B执行完同步中的代码，释放对象锁后，线程A才会和其他线程一次竞争对象锁

每个锁对象都有两个队列，一个是就绪队列，一个是阻塞队列，就绪队列存储了将要获得锁的线程，阻塞队列存储了呗阻塞的线程；
一个线程被唤醒后，就会进入到就绪队列，等待CPU的调度；一个线程被wait后，就会进入到阻塞队列，等待下一次被唤醒

waitInterruptException
wait()方法可能出现的异常就是InterruptException
一个处于wait中的线程如果执行中断操作（即:thread.interrupt()），则会抛出异常,产生的效果是该线程会和其他线程一样竞争当前的对象锁，而不是处于阻塞状态

wait(long)表示的是等待long后，如果没有被notify唤醒，会自动唤醒，处于竞争对象锁的状态

stackpc
生产者/消费者模式

pipeStream 用于在不同线程间直接传送数据

wait_notify_insert_test
有20个线程，10个线程将数据备份到A中，10个线程将数据备份到B中，且为交叉进行，即a1->A,b1->B;a2->A,b2->B;...

thread.join :表示线程thread正常运行，而当前线程处于无限阻塞状态，直到线程thraed运行完成，当前线程才继续执行；
如上，如果当前线程出现中断，会抛异常，但是线程thread不会
可以得出的结论是：当线程处在阻塞状态时，如果产生了中断，则该线程会自动抛出中断异常
thread.join(long) :表示当前线程停止long时间后再执行，和Thread.sleep(long)的区别在于join(long)会释放对象锁，而sleep(long)并不会释放锁
注意：thread.join()的执行必须是在获取thread的对象锁的前提下

ThreadLock11
ThreadLocal类用来实现各个线程绑定自己的值，使用set方法，get方法会获取该线程最近存放的值


### 第四章
使用ReentrantLock类也能实现同步的效果
Lock lock=new ReentrantLock()//在lock.lock()和lock.unlock()之间实现同步

reentranttest
等待/通知的实现
同样是在同步你实现，即在lock.lock()和lock.unlock()之间加入await()和signal()
可以实现通知部分线程：创建多个condition，使用不同的condition对线程进行等待，然后使用不同的condition对线程进行通知

Lock分为公平锁和非公平锁，公平锁表示线程获取锁的顺序是按照线程加锁的顺序来分配的，即先进先出，非公平锁中线程获取锁的机制是随机的

Lock方法
getHoldCount()：从创建对象开始，lock对象调用lock()方法的次数
getQueueLength():正在竞争该锁的线程数//这个方法说明当线程A在使用锁的时候，线程B等会先判断是否有锁对象被占用，此时lock会记录这个线程（即进入竞争状态），
                  这样该方法才能计算出竞争该锁的线程，比如线程中没有lock.lock()这条语句，就不会被检测到
getWaitQueueLength():await的线程数

ReentrantReadWriteLock类
为了加快各线程工作效率，使用该类，其中读读操作是异步的（lock.readLock().lock()），读写，写写是互斥的（lock.writeLock().lock()）

### 第五章 定时器
Timer类：设置计划任务
TimerTask类：封装任务
而对于多个TimerTask，其被执行顺序是有先后的，需要前一个执行完后，后一个才能执行，导致的结果是不能在规定的时间内执行任务

RunTimerDemo
定时器的创建于使用

Timer.schedule(TimerTask timertask,Date date,Long long):从date开始每隔long执行timertask的任务
这个里面要注意的是如果timertask中执行时间大于long的时间，则执行的周期变为timertask执行的时间


