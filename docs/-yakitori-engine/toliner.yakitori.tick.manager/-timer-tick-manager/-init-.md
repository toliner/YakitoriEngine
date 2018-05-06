[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [TimerTickManager](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`TimerTickManager(tickRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, workerList: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`> = LinkedList())`

[Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)を用いて、より厳密にtickの処理時間を管理する[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の実装のための抽象クラスです。
全てのtick処理はTimerによって別スレッドで実行されます。
そのため、停止・再開が可能です。
[tps](../-abstract-tick-manager/tps.md)は、tickRateで指定した回数、tick処理が行われるごとに更新されます。

### Parameters

`tickRate` - 1秒あたりの最大tick数です。tpsの上限はこの値になります。

`workerList` - [workers](workers.md)に用いる初期リストです。空のリストを用いることが推奨されます。デフォルトでは[LinkedList](http://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)が用いられます。