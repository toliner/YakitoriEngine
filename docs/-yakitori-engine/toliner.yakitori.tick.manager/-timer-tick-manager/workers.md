[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [TimerTickManager](index.md) / [workers](./workers.md)

# workers

`protected open val workers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`>`

Overrides [AbstractTickManager.workers](../-abstract-tick-manager/workers.md)

Timerによって別のスレッドからアクセスされるため、コンストラクタで与えられた初期リストを用いた
スレッドセーフなリストを生成します。

