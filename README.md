# ciclo de vida de un hilo en java
![image](https://github.com/user-attachments/assets/c07f6b80-db06-426e-ba72-70d1d9936929)
1. When we write **MyThread t1=new MyThread()** then thread is in the **New/Born state.**  
2. When we call t.start() method then thread enters into **Ready State** or **Runnable State.**  
3. If Thread Scheduler allocates the processor to Thread then Thread enters into **Running State**.  
4. If run() method completes successfully then thread enters into **Dead State**.

above are the basic main states of the Thread. but apart from this it has some condition through that it goes into different states like waiting state,suspended state,sleeping state.the full description is below.

**1\.** If a running thread calls the ***Thread.yield()*** method then thread enters into ready state from running state to give chance to other waiting thread of same priority immediately.

**2\.** If a Thread calls the ***join()*** method then it enters into waiting state and if this thread comes out from waiting state/blocked state then it enters into Ready/Runnable state but here is some condition to come out from the waiting state is-  
                   - If thread completes its own execution.  
                   - If time expires.  
                   - If waiting thread got interrupted.

**3\.** If running thread calls the ***sleep()*** then immediately enters into sleeping state. now thread will come out of this state to ready state only when-

                   - If time expires.  
                   - If sleeping thread got interrupted.

**4\.** If thread calls the ***wait()*** method then running thread will enters into waiting state. if this thread got any notification by method notify()/notifyAll() then it enters into another waiting state to get lock.so when the thread comes out of waiting state to another waiting state to get lock is-

                   - If waiting thread got notification.  
                   - If time expires.  
                   - If waiting thread got interrupted.

Now thread which is in the another waiting state will go to ready state when it get the lock.

**5\.** If running thread calls the ***suspend()*** method now thread enters into suspended state and it will comes out form there to ready state only when it will call the ***resume()*** method.

**6\.** If running thread calls the ***stop()*** method then immediately enters into dead state.

**Note:** now the methods ***suspend(),*** ***resume(),stop()*** are deprecated and not recommended to use.   

# (Conpurrencia) Problema Productor/Consumidor
![image](https://github.com/user-attachments/assets/16b5f993-7dba-4524-abce-7fbdcb315dcc)
![image](https://github.com/user-attachments/assets/267ddbc6-1521-49d1-b475-a4bff14f6da5)
![image](https://github.com/user-attachments/assets/e92ea083-8127-4079-9997-e64cf7ce7697)
![image](https://github.com/user-attachments/assets/44b930c5-e4f6-43df-97b6-4852c7555dd6)



