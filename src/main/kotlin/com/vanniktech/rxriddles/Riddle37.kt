package com.vanniktech.rxriddles

import io.reactivex.Observable
import java.io.IOException

object Riddle37 {
  /**
   * Return an Observable that emits 'false' when the [source] emits an IOException.
   *
   * Use case: You want to recover from an expected error and map them to a particular result.
   */
  fun solve(source: Observable<Boolean>): Observable<Boolean> {
      return source.onErrorResumeNext { it: Throwable ->
          when (it) {
              is IOException -> Observable.just(false)
              else -> Observable.error(it)
          }
      }
  }
}
