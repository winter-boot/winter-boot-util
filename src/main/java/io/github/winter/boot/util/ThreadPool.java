package io.github.winter.boot.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 标准线程池
 *
 * @author changebooks@qq.com
 */
public final class ThreadPool {
    /**
     * 处理器数量，>= 1
     */
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    /**
     * 线程池核心线程数
     */
    public static final int CORE_POOL_SIZE = CPU_COUNT + 1;

    /**
     * 线程池最大线程数
     */
    public static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;

    /**
     * 多余的空闲线程生存时间
     */
    public static final long KEEP_ALIVE_TIME = 1L;

    /**
     * 阻塞队列
     */
    public static final BlockingQueue<Runnable> WORK_QUEUE = new SynchronousQueue<>();

    /**
     * 崩溃处理
     */
    public static final ThreadPoolExecutor.AbortPolicy ABORT_POLICY = new ThreadPoolExecutor.AbortPolicy();

    private ThreadPool() {
        // ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("ThreadPool-%d").build();
        // ExecutorService EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, WORK_QUEUE, THREAD_FACTORY, ABORT_POLICY);
    }

}
