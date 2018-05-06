[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [AbstractTickManager](./index.md)

# AbstractTickManager

`abstract class AbstractTickManager : `[`ITickManager`](../../toliner.yakitori.tick/-i-tick-manager/index.md)

全ての[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の標準実装の基底となる抽象クラスです。

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractTickManager()`<br>全ての[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の標準実装の基底となる抽象クラスです。 |

### Properties

| Name | Summary |
|---|---|
| [tps](tps.md) | `open var tps: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)で定義された[ITickManager.tps](../../toliner.yakitori.tick/-i-tick-manager/tps.md)の実装です。 動的な更新を行うために、protectedなセッターが追加で実装されています。 |
| [workers](workers.md) | `abstract val workers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`>`<br>管理対象の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)の参照を保持する可変リストです。 |

### Functions

| Name | Summary |
|---|---|
| [addWorker](add-worker.md) | `open fun addWorker(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を追加します。 |
| [minusAssign](minus-assign.md) | `open operator fun minusAssign(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象から特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を削除します。 標準実装において、これは[removeWorker](remove-worker.md)のラッパーです。 |
| [plusAssign](plus-assign.md) | `open operator fun plusAssign(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を追加する、+=演算子のオーバーロードです。 標準実装において、これは[addWorker](add-worker.md)のラッパーです。 |
| [removeWorker](remove-worker.md) | `open fun removeWorker(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>管理対象から特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を削除します。 |
| [workerContains](worker-contains.md) | `open fun workerContains(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)が管理対象に含まれているかを確認します。 |

### Inherited Functions

| Name | Summary |
|---|---|
| [run](../../toliner.yakitori.tick/-i-tick-manager/run.md) | `abstract fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を開始します。 この処理によってスレッドがブロックされるか否か(処理がこのスレッドで行われるか別のスレッドで行われるか)は実装に依存します。 中断可能か否かは実装に依存します。 |

### Inheritors

| Name | Summary |
|---|---|
| [SingleThreadTickManager](../-single-thread-tick-manager/index.md) | `class SingleThreadTickManager : `[`AbstractTickManager`](./index.md)<br>最も単純な[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の実装です。 全ての処理は直列的に行われます。 tick処理間の間隔は、システム時間の差分を用いて管理されます。 runメソッドは実行されたスレッドで処理を開始します。 |
| [TimerTickManager](../-timer-tick-manager/index.md) | `abstract class TimerTickManager : `[`AbstractTickManager`](./index.md)`, `[`IPausableTickManager`](../../toliner.yakitori.tick/-i-pausable-tick-manager/index.md)<br>[Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)を用いて、より厳密にtickの処理時間を管理する[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の実装のための抽象クラスです。 全てのtick処理はTimerによって別スレッドで実行されます。 そのため、停止・再開が可能です。 [tps](tps.md)は、tickRateで指定した回数、tick処理が行われるごとに更新されます。 |
