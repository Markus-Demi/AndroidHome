package com.gmail.demidovich.domain.usecases;

import com.gmail.demidovich.domain.executor.PostExecutionThread;
import com.gmail.demidovich.domain.executor.ThreadExecution;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUsecase {

    protected Scheduler mPostExecutionThread;
    protected Scheduler mThreadExecution;

    public BaseUsecase(PostExecutionThread postExecutionThread, ThreadExecution threadExecution) {
        this.mPostExecutionThread = postExecutionThread.getScheduler();
        this.mThreadExecution = Schedulers.from(threadExecution);
    }

    public BaseUsecase(PostExecutionThread postExecutionThread) {
        this.mPostExecutionThread = postExecutionThread.getScheduler();
        this.mThreadExecution = Schedulers.io();
    }

}
