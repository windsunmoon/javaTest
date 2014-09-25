package wbx;
public abstract class ReadWrite   
{   
    protected int activeReaders = 0;   
    protected int activeWriters = 0;   
       
    protected int waitingReaders = 0;   
    protected int waitingWriters = 0;   
       
    protected abstract void doRead();   
    protected abstract void doWrite();   
       
    public void read() throws InterruptedException   
     {   
         beforeRead();   
        try { doRead(); }   
        finally { afterRead(); }   
     }   
       
    public void write() throws InterruptedException   
     {   
         beforeWrite();   
        try { doWrite(); }   
        finally { afterWrite(); }   
     }   
       
    protected boolean allowReader()   
     {   
        return waitingWriters == 0 && activeWriters == 0;   
     }   
       
    protected boolean allowWriter()   
     {   
        return activeReaders == 0 && activeWriters == 0;   
     }   
       
    protected synchronized void beforeRead() throws InterruptedException   
     {   
         ++waitingReaders;   
        while(!allowReader())   
         {   
            try { wait(); }   
            catch(InterruptedException ie)   
             {   
                 --waitingReaders;   
                throw ie;   
             }   
         }   
  
         --waitingReaders;   
         ++activeReaders;   
     }   
       
    protected synchronized void afterRead()   
     {   
         --activeReaders;   
         notifyAll();   
     }   
       
    protected synchronized void beforeWrite() throws InterruptedException   
     {   
         ++waitingWriters;   
        while(!allowWriter())   
         {   
            try { wait(); }   
            catch(InterruptedException ie)   
             {   
                 --waitingWriters;   
                throw ie;   
             }   
         }   
           
         --waitingWriters;   
         ++activeWriters;   
     }   
       
    protected synchronized void afterWrite()   
     {   
         --activeWriters;   
         notifyAll();   
     }   
}  