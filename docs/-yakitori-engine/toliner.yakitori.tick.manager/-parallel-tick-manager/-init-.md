[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [ParallelTickManager](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`ParallelTickManager(tickRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, workerList: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`> = LinkedList())`

コルーチンを用いてtick処理を非同期的に処理する[TimerTickManager](../-timer-tick-manager/index.md)の実装です。
全てのtick処理は非同期的に処理されます。
同時実行数は実行環境に依存します。
実行順序は不定です。
このクラスを利用する場合、全ての管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)は非同期的に実行されることを留意して作成する必要があります。

### Parameters

`tickRate` - 1秒あたりの最大tick数です。tpsの上限はこの値になります。

`workerList` - 管理対象の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)の参照を保持する可変リストです。初期値は[LinkedList](http://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)です。空のリストが推奨されます。