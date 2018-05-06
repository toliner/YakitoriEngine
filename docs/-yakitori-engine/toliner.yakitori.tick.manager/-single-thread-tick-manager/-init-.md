[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [SingleThreadTickManager](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`SingleThreadTickManager(tickRate: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, workers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`> = ArrayList())`

最も単純な[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の実装です。
全ての処理は直列的に行われます。
tick処理間の間隔は、システム時間の差分を用いて管理されます。
runメソッドは実行されたスレッドで処理を開始します。

### Parameters

`tickRate` - 1秒あたりの最大tick数です。tpsの上限はこの値になります。

`workers` - 管理対象の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)の参照を保持する可変リストです。初期値は[ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)です。空のリストが推奨されます。