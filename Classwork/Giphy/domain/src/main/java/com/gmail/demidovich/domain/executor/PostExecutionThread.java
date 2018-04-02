package com.gmail.demidovich.domain.executor;

import io.reactivex.Scheduler;

// this needs to release in presentation (app)
public interface PostExecutionThread {
    Scheduler getScheduler();
}
