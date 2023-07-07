package course.concurrency.m2_async.executors.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class AsyncClassTest {

    @Autowired
    public ApplicationContext context;


    @Autowired
    ApplicationConfiguration configuration;

    SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();

    public void runTasksWithExecutor() {
        simpleAsyncTaskExecutor.execute(() -> runAsyncTask());
    }

    public void runAsyncTask() {
        System.out.println("runAsyncTask: " + Thread.currentThread().getName());
        simpleAsyncTaskExecutor.execute(() -> internalTask());
    }

    public void internalTask() {
        System.out.println("internalTask: " + Thread.currentThread().getName());
    }
}
