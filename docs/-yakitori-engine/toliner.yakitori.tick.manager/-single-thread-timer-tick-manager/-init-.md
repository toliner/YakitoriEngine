[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [SingleThreadTimerTickManager](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`SingleThreadTimerTickManager(tickRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, workerList: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`> = LinkedList())`

最も単純な[TimerTickManager](../-timer-tick-manager/index.md)の実装です。
[SingleThreadTickManager](../-single-thread-tick-manager/index.md)と同じ方法でtick処理を行います。
[SingleThreadTickManager](../-single-thread-tick-manager/index.md)と比べて、
[Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)によって生成されたスレッドで実行されるため、呼び出しスレッドをブロックしないという利点があります。

### Parameters

`tickRate` - 1秒あたりの最大tick数です。tpsの上限はこの値になります。

`workerList` - 管理対象の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)の参照を保持する可変リストです。初期値は[LinkedList](http://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)です。空のリストが推奨されます。