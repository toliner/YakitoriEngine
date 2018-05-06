[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [TimerTickManager](./index.md)

# TimerTickManager

`abstract class TimerTickManager : `[`AbstractTickManager`](../-abstract-tick-manager/index.md)`, `[`IPausableTickManager`](../../toliner.yakitori.tick/-i-pausable-tick-manager/index.md)

[Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)を用いて、より厳密にtickの処理時間を管理する[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の実装のための抽象クラスです。
全てのtick処理はTimerによって別スレッドで実行されます。
そのため、停止・再開が可能です。
[tps](../-abstract-tick-manager/tps.md)は、tickRateで指定した回数、tick処理が行われるごとに更新されます。

### Parameters

`tickRate` - 1秒あたりの最大tick数です。tpsの上限はこの値になります。

`workerList` - [workers](workers.md)に用いる初期リストです。空のリストを用いることが推奨されます。デフォルトでは[LinkedList](http://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)が用いられます。

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TimerTickManager(tickRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, workerList: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`> = LinkedList())`<br>[Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)を用いて、より厳密にtickの処理時間を管理する[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の実装のための抽象クラスです。 全てのtick処理はTimerによって別スレッドで実行されます。 そのため、停止・再開が可能です。 [tps](../-abstract-tick-manager/tps.md)は、tickRateで指定した回数、tick処理が行われるごとに更新されます。 |

### Properties

| Name | Summary |
|---|---|
| [workers](workers.md) | `open val workers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`>`<br>Timerによって別のスレッドからアクセスされるため、コンストラクタで与えられた初期リストを用いた スレッドセーフなリストを生成します。 |

### Inherited Properties

| Name | Summary |
|---|---|
| [tps](../-abstract-tick-manager/tps.md) | `open var tps: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)で定義された[ITickManager.tps](../../toliner.yakitori.tick/-i-tick-manager/tps.md)の実装です。 動的な更新を行うために、protectedなセッターが追加で実装されています。 |

### Functions

| Name | Summary |
|---|---|
| [handle](handle.md) | `abstract fun handle(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>[task](#)から委譲されたtick処理です。 |
| [pause](pause.md) | `open fun pause(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を中断します。 |
| [run](run.md) | `open fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を開始します。 この処理によってスレッドがブロックされるか否か(処理がこのスレッドで行われるか別のスレッドで行われるか)は実装に依存します。 中断可能か否かは実装に依存します。 |
| [start](start.md) | `open fun start(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を、中断可能な形で開始します。 中断されている場合は再開します。 |

### Inherited Functions

| Name | Summary |
|---|---|
| [addWorker](../-abstract-tick-manager/add-worker.md) | `open fun addWorker(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を追加します。 |
| [minusAssign](../-abstract-tick-manager/minus-assign.md) | `open operator fun minusAssign(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象から特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を削除します。 標準実装において、これは[removeWorker](../-abstract-tick-manager/remove-worker.md)のラッパーです。 |
| [plusAssign](../-abstract-tick-manager/plus-assign.md) | `open operator fun plusAssign(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を追加する、+=演算子のオーバーロードです。 標準実装において、これは[addWorker](../-abstract-tick-manager/add-worker.md)のラッパーです。 |
| [removeWorker](../-abstract-tick-manager/remove-worker.md) | `open fun removeWorker(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>管理対象から特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を削除します。 |
| [workerContains](../-abstract-tick-manager/worker-contains.md) | `open fun workerContains(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)が管理対象に含まれているかを確認します。 |

### Inheritors

| Name | Summary |
|---|---|
| [ParallelTickManager](../-parallel-tick-manager/index.md) | `class ParallelTickManager : `[`TimerTickManager`](./index.md)<br>コルーチンを用いてtick処理を非同期的に処理する[TimerTickManager](./index.md)の実装です。 全てのtick処理は非同期的に処理されます。 同時実行数は実行環境に依存します。 実行順序は不定です。 このクラスを利用する場合、全ての管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)は非同期的に実行されることを留意して作成する必要があります。 |
| [SingleThreadTimerTickManager](../-single-thread-timer-tick-manager/index.md) | `class SingleThreadTimerTickManager : `[`TimerTickManager`](./index.md)<br>最も単純な[TimerTickManager](./index.md)の実装です。 [SingleThreadTickManager](../-single-thread-tick-manager/index.md)と同じ方法でtick処理を行います。 [SingleThreadTickManager](../-single-thread-tick-manager/index.md)と比べて、 [Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)によって生成されたスレッドで実行されるため、呼び出しスレッドをブロックしないという利点があります。 |
