package com.vanniktech.rxriddles

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object Riddle101 {
  /**
   * Create an Observable that acts as a countdown. Counting down from number of [seconds] to 0
   * while emitting the number of seconds remaining each time.
   *
   * Use case: You have some countdown functionality and want to display how many seconds are left.
   */
  fun solve(seconds: Long): Observable<Long> {
      return Observable.interval(0, 1, TimeUnit.SECONDS)
              .map { seconds - it }
              .takeUntil { it == 0L }
  }
}
